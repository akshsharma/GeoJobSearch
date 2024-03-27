# This code relies on 3 packages
#
#  1) beautifulsoup4
#  2) selenium
#  3) webdriver-manager
#
#   These packages can be installed locally using pip or pip3
#
#   Locally:
#   python3 -m pip install beautifulsoup4
#   python3 -m pip install selenium
#   python3 -m pip install webdriver-manager
#
#   based on code provided on these websites:
#   https://realpython.com/beautiful-soup-web-scraper-python/
#   https://brightdata.com/blog/how-tos/scrape-dynamic-websites-python
#
#   Notes:
#   Because Indeed uses React, all the webcontent is dynamically created
#   at run time. We cannot scrape with beautifulsoup4 as it basically only
#   reads static web content. We will use Selenium to grab the dynamically
#   created web-data and then parse it statically with beutiful soup.

import time
import json
import random
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

def setup_options():
    # Generated with help by ChatGPT4.0
    options = webdriver.ChromeOptions()

    # Adjusting for Chromium and enabling headless mode
    options.binary_location = "/usr/bin/chromium"  # Path to chromium
    options.add_argument("--headless")  # Important for Docker environments
    options.add_argument("--no-sandbox")  # Bypass OS security model, required in Docker
    options.add_argument("--disable-dev-shm-usage")  # Overcome limited resource problems
    options.add_argument("start-maximized")  # Start maximized (optional)
    options.add_argument("disable-infobars")  # Disable the infobars (optional)
    options.add_argument("--disable-extensions")  # Disable extensions (optional)
    options.add_argument("--disable-gpu")  # Chrome's GPU hardware acceleration can cause issues

    # User-agent string
    options.add_argument("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64)" \
                        "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
    
    return options

def setup_driver(options):
        
    # Note: The ChromeDriverManager might not be necessary if chromedriver is installed system-wide.
    service = Service("/usr/bin/chromedriver")  # Path to chromedriver

    # Now you can initialize the driver with the options
    driver = webdriver.Chrome(service=service, options=options)

    # # Setting us our web-driver, basically a bare-bones web browser without GUI
    # options = webdriver.ChromeOptions()

    # #Adds user agent artifact to mimic actual browser connection (Generated with help by ChatGPT4.0)
    # options.add_argument("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64)" \
    #                      "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
    # # options.add_argument('--headless')  # Won't create a GUI.
    # service = Service(ChromeDriverManager().install())

    return driver

def scrape(driver, page_data, MAX_PAGES):
    for i in range(MAX_PAGES):
        # Try and find clickable card outlines
        driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
        WebDriverWait(driver, 10).until(EC.element_to_be_clickable\
                                        ((By.CLASS_NAME, "cardOutline")))
        try:
            li_button_elements = driver.find_elements\
                (By.CLASS_NAME, "cardOutline") #cardOutline is class name of clickable <li>
        except Exception as e:
            print("Could not find clickable <li> elements on the page. Closing search.")
            break

        if len(li_button_elements) == 0:
            print("No clickable items were found. Closing search.")
            break

        # Sift through clickable <li> items and grab page new page data
        for clickable in li_button_elements:
            try:
                clickable.click()
                time.sleep(random.randint(2, 6))
                scroll_string = random.randint(500,1000)
                driver.execute_script(f"window.scrollBy(0, {scroll_string});")
                page_data.append(driver.page_source)
                print("page saved...")
            except Exception as e:
                print("Could not click card item")

        # Find next page button and start process again
        try:
            #next_page = driver.find_element(By.CLASS_NAME, "css-akkh0a")
            next_page = driver.find_element(By.CSS_SELECTOR, '[data-testid="pagination-page-next"]')
            next_page.click()
            time.sleep(random.randint(3,5))
            print("Loading new webpage!")
        except Exception as e:
            print("Could not open new webpage. Closing search.")
            print(e)
            break

        try:
            close_modal = driver.find_element(By.CLASS_NAME, "css-yi9ndv") #css-yi9ndv e8ju0x51
            if  close_modal :
                close_modal.click()
                time.sleep(random.randint(2,3))
        except Exception as e:
            print('No modal, contuining.')

    print('Scraping complete!' + str(len(page_data)) + " pages scraped")

def extract_job_listings(job_listings):
    for data in page_data:
        job_data = {"job_title"        : " Check Description ",
                    "job_location"     : " Check Description ",
                    "job_salary"       : " Check Description ",
                    "job_description"  : " Check Description "}

        soup = BeautifulSoup(data, 'html.parser')

        job_title = soup.find('h2', class_="jobsearch-JobInfoHeader-title")
        if job_title:
            if '- job post' in job_title.text:
                job_data['job_title'] = job_title.text[:-11] # remove trailing '- job post'
            else:
                job_data['job_title'] = job_title.text

        #Completely random class name, but it gets the location
        job_location = soup.find('div', class_="css-1ikmi61")
        if job_location:
            job_data['job_location'] = job_location.text

        job_salary = soup.find('div', class_="js-match-insights-provider-tvvxwd")
        if job_salary:
            job_data['job_salary'] = job_salary.text

        job_desc = soup.find('div', id="jobDescriptionText")
        if job_desc:
            job_data['job_description'] = job_desc.text

        job_listings.append(job_data)

        return job_listings

options = setup_options()
driver = setup_driver(options)

#Page data list
page_data = []

#This is our web 'driver', our bare-bones web browser
# driver = webdriver.Remote("http://127.0.0.1:4444",\
#                             options=options, service=service)

# Indeed webpage with 'part time' key-word and 'Guelph ON' location
URL = \
    "https://ca.indeed.com/jobs?q=part+time&l=Guelph%2C+ON&from=searchOnHP&vjk=3c411ee1f098fae1"

# Driver is used to get the URL, think of it like opening a webpage
# with Chrome without the visual stuff
driver.get(URL)

# Sleep the program for a few seconds so that the
# content can be dynamically created by the web-server
time.sleep(3)

#How many pages you want to scrape from --> Takes about 17s per page.
MAX_PAGES = 10

print("Scraping data from Indeed.com. time estimate: " \
      + str(MAX_PAGES * 17)  + " seconds.")

scrape(driver, page_data, MAX_PAGES)

driver.quit()

job_listings = []

with open('indeed_job_listings.json', 'w', encoding='utf-8') as file:
    json.dump(job_listings, file, ensure_ascii=False, indent=4)

print('Data converted to JSON file and saved to drive. (job_listings.json)')
