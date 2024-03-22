package test.java.com.example.cis4900.spring.template.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.cis4900.spring.template.jobs.JobsService;
import com.example.cis4900.spring.template.jobs.JobsServiceImpl;
import com.example.cis4900.spring.template.jobs.models.Job;
import com.example.cis4900.spring.template.controllers.JobsController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;


public class SimpleIntegrationTest {

    @Autowired
    private JobsService jobsService;

    private List<Job> targetJobs = Arrays.asList(
        new Job(1, "Software Engineer", "Develop and maintain software applications", "New York", 60000.00f, 80000.00f, 1, "https://en.wikipedia.org/wiki/Placeholder_name", "https://en.wikipedia.org/wiki/Lorem_ipsum"),
        new Job(2, "Marketing Manager", "Plan and execute marketing campaigns", "Los Angeles", 50000.00f, 70000.00f, 1, "https://en.wikipedia.org/wiki/Placeholder_name", "https://en.wikipedia.org/wiki/Lorem_ipsum"),
        new Job(3, "Financial Analyst", "Analyze financial data and prepare reports", "Chicago", 55000.00f, 75000.00f, 1, "https://en.wikipedia.org/wiki/Placeholder_name", "https://en.wikipedia.org/wiki/Lorem_ipsum"),
        new Job(4, "Data Analyst", "Collect and analyze data to inform business decisions", "San Francisco", 55000.00f, 75000.00f, 1, "https://en.wikipedia.org/wiki/Placeholder_name", "https://en.wikipedia.org/wiki/Lorem_ipsum"),
        new Job(5, "Sales Representative", "Sell company products and services to potential customers", "Houston", 45000.00f, 65000.00f, 1, "https://en.wikipedia.org/wiki/Placeholder_name", "https://en.wikipedia.org/wiki/Lorem_ipsum")
    );

    @Test
    public void SimpleTest(){
        assertEquals(1,1);
    }

    // @Test
    // public void WrongTest(){
    //     assertEquals(1,2);
    // }

    @Test
    public void NumJobsEndpointTest() throws Exception {
        // Iterable<Job> databaseJobs = jobsService.allJobs();
        try (
            Connection connection = DriverManager.getConnection("jdbc:mysql://mysql:3306/template_db",
                "root", "pwd");
            Statement statement = connection.createStatement()
        ){
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM job");
            resultSet.next();
            int count = resultSet.getInt(1);
            assertEquals(5, count, "Expected 5 job postings in the database");
        }

        assertEquals(1, 1);
    }

    @Test
    public void JobValuesEndpointTest() throws Exception {
        // Iterable<Job> databaseJobs = jobsService.allJobs();
        try (
            Connection connection = DriverManager.getConnection("jdbc:mysql://mysql:3306/template_db",
                "root", "pwd");
            Statement statement = connection.createStatement()
        ){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM job");
            
            for(int i = 0; i < 5; i++){
                resultSet.next();
                int id = resultSet.getInt("job_id");
                String title = resultSet.getString("job_title");
                String description = resultSet.getString("job_description");
                String location = resultSet.getString("job_location");
                float salary_min = resultSet.getFloat("job_salary_min");
                float salary_max = resultSet.getFloat("job_salary_max");
                int employer_id = resultSet.getInt("employer_id");
                String website_link = resultSet.getString("job_website_link");
                String application_link = resultSet.getString("job_application_link");
                
                Job resultJob = new Job(id, title, description, location, salary_min, salary_max, employer_id, website_link, application_link);

                assertEquals(targetJobs.get(i), resultJob, "Should match the test jobs I created");
            }
            
        }

        assertEquals(1, 1);
    }
    
}
