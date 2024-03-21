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

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimpleIntegrationTest {

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
    public void JobsEndpointTest(){
        JobsService jobsService = new JobsServiceImpl();
        Iterable<Job> databaseJobs = jobsService.allJobs();
        assertEquals(databaseJobs, targetJobs);
    }
    
}
