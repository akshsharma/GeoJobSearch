import com.example.cis4900.spring.template.jobs.models.Employer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployerTest {

    private Employer employer;

    @BeforeEach
    void setUp() {
        // This method is called before each test
        employer = new Employer(); // Using the no-argument constructor
    }

    @Test
    void testNoArgsConstructor() {
        // Test the no-argument constructor
        assertEquals(null, employer.getId(), "Id should be null");
        assertEquals(null, employer.getName(), "Name should be null");
    }

    @Test
    void testAllArgsConstructor() {
        // Test the parameterized constructor
        Employer paramEmployer = new Employer(1, "Test Employer");
        assertEquals(1, paramEmployer.getId(), "Id should be 1");
        assertEquals("Test Employer", paramEmployer.getName(), "Name should be Test Employer");
    }

    @Test
    void testSetAndGetId() {
        // Test the setId and getId methods
        employer.setId(2);
        assertEquals(2, employer.getId(), "Id should be 2");
    }

    @Test
    void testSetAndGetName() {
        // Test the setName and getName methods
        employer.setName("Another Test Employer");
        assertEquals("Another Test Employer", employer.getName(), "Name should be Another Test Employer");
    }

}
