package Tests;

import org.junit.After;
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
    private Job job1, job2, job3, job4, job5;

    @Before
    public void createJobObject() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }
    @After
    public void resetNextId(){
        job1.resetNextId();
    }
    @Test
    public void testSettingJobId() {
        assertEquals(1,job1.getId(), 0.000);
        assertEquals(2,job2.getId(), 0.000);
        assertEquals(1,job2.getId() - job1.getId(), 0.000);
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job3 instanceof Job);
        assertEquals(3,job3.getId(), 0.000);
        assertEquals("Product tester",job3.getName());
        assertEquals("ACME",job3.getEmployer().getValue());
        assertEquals("Desert",job3.getLocation().getValue());
        assertEquals("Quality control",job3.getPositionType().getValue());
        assertEquals("Persistence",job3.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        assertFalse(job3.getId() == job4.getId());
    }
    @Test
    public void testForFirstAndLastBlankLinesInToString(){
        String newString = job3.toString();
        assertTrue(newString.charAt(0) == ' ');
        assertTrue(newString.charAt(newString.length()-1) == ' ');
    }
    @Test
    public void testForToString(){
        String newString = job3.toString();
        String testString =
                " \nID: 3" +
                        "\nName: Product tester" +
                        "\nEmployer: ACME" +
                        "\nLocation: Desert" +
                        "\nPosition Type: Quality control" +
                        "\nCore Competency: Persistence" +
                        "\n ";
        assertTrue(newString.equals(testString));
    }
}
