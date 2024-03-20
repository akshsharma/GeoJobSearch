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
import com.example.cis4900.spring.template.jobs.models.Job;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimpleIntegrationTest {
    @Test
    public void SimpleTest(){
        assertEquals(1,1);
    }

    @Test
    public void WrongTest(){
        assertEquals(1,2);
    }
    
}
