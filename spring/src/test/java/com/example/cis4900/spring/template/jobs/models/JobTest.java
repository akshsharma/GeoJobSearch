import com.example.cis4900.spring.template.jobs.models.Job;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobTest {

    private Job job;

    @BeforeEach
    void setUp() {
        job = new Job(); 
    }

    @Test
    public void testParameterizedConstructor() {
        Integer jobId = 1;
        String jobTitle = "Software Engineer";
        String jobDescription = "Develop and maintain software applications.";
        String jobLocation = "Ontario, CA";
        float jobSalaryMin = 50000.0f;
        float jobSalaryMax = 100000.0f;
        Integer employerId = 2;
        String jobWebsiteLink = "https://en.wikipedia.org/wiki/Placeholder_name";
        String jobApplicationLink = "https://en.wikipedia.org/wiki/Lorem_ipsum";

        Job job = new Job(jobId, jobTitle, jobDescription, jobLocation, jobSalaryMin, jobSalaryMax, employerId, jobWebsiteLink, jobApplicationLink);

        assertEquals(jobId, job.getId());
        assertEquals(jobTitle, job.getTitle());
        assertEquals(jobDescription, job.getDescription());
        assertEquals(jobLocation, job.getLocation());
        assertEquals(jobSalaryMin, job.getSalaryMin());
        assertEquals(jobSalaryMax, job.getSalaryMax());
        assertEquals(employerId, job.getEmployerId());
        assertEquals(jobWebsiteLink, job.getWebsiteLink());
        assertEquals(jobApplicationLink, job.getApplicationLink());
    }
    
    @Test
    public void testSetAndGetId() {
        Integer id = 1;
        job.setId(id);
        assertEquals(id, job.getId());
    }

    @Test
    public void testSetAndGetTitle() {
        String title = "Software Engineer";
        job.setTitle(title);
        assertEquals(title, job.getTitle());
    }

    @Test
    public void testSetAndGetDescription() {
        String description = "Develop and maintain software applications.";
        job.setDescription(description);
        assertEquals(description, job.getDescription());
    }

    @Test
    public void testSetAndGetLocation() {
        String location = "Ontario, CA";
        job.setLocation(location);
        assertEquals(location, job.getLocation());
    }

    @Test
    public void testSetAndGetSalaryMin() {
        float salaryMin = 50000.0f;
        job.setSalaryMin(salaryMin);
        assertEquals(salaryMin, job.getSalaryMin(), 0.01);
    }

    @Test
    public void testSetAndGetSalaryMax() {
        float salaryMax = 100000.0f;
        job.setSalaryMax(salaryMax);
        assertEquals(salaryMax, job.getSalaryMax(), 0.01);
    }

    @Test
    public void testSetAndGetEmployerId() {
        Integer employerId = 2;
        job.setEmployerId(employerId);
        assertEquals(employerId, job.getEmployerId());
    }

    @Test
    public void testSetAndGetWebsiteLink() {
        String jobWebsiteLink = "www.google.com";
        job.setWebsiteLink(jobWebsiteLink);
        assertEquals(jobWebsiteLink, job.getWebsiteLink());
    }

    @Test
    public void testSetAndGetApplicationLink() {
        String jobApplicatinLink = "www.apple.com";
        job.setApplicationLink(jobApplicatinLink);
        assertEquals(jobApplicatinLink, job.getApplicationLink());
    }
}

