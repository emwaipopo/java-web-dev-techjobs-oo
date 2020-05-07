package Tests;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.CoreCompetency;
import org.launchcode.techjobs_oo.PositionType;
import org.launchcode.techjobs_oo.Location;

public class JobTest {
    Job job1, job2;

    @Before
    public void createJobObject() {
        job1 = new Job();
        job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
    @Test
    public void testSettingJobId() {
        assertEquals(7,job1.getId(), 0.000);
        assertEquals(8,job2.getId(), 0.000);
        assertEquals(1,job2.getId() - job1.getId(), 0.000);
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job2 instanceof Job);
        assertEquals(6,job2.getId(), 0.000);
        assertEquals("Product tester",job2.getName());
        assertEquals("ACME",job2.getEmployer().getValue());
        assertEquals("Desert",job2.getLocation().getValue());
        assertEquals("Quality control",job2.getPositionType().getValue());
        assertEquals("Persistence",job2.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
    Job job3 = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Taste"));
    Job job4 = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Taste"));
    assertFalse(job3.getId() == job4.getId());
    }
}
