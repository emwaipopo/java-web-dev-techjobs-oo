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
        job5 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
    @After
    public void resetNextId(){
        job1.resetNextId();
    }
    @Test
    public void testSettingJobId() {
        assertEquals(1,job1.getId());
        assertEquals(1,job2.getId() - job1.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job3 instanceof Job);
        assertEquals(3,job3.getId());
        assertEquals("Product tester",job3.getName());
        assertEquals("ACME",job3.getEmployer().getValue());
        assertEquals("Desert",job3.getLocation().getValue());
        assertEquals("Quality control",job3.getPositionType().getValue());
        assertEquals("Persistence",job3.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        System.out.println(job3.getLocation().equals(job4.getLocation()));
        System.out.println(job3.getLocation().hashCode() + " - " + job4.getLocation().hashCode());
        assertFalse(job3.equals(job4));
        assertFalse(job3.getId() == job4.getId());
        assertTrue(job3.getName().equals(job4.getName()));
        assertFalse(job3.getEmployer().hashCode() == job4.getEmployer().hashCode());
        assertFalse(job3.getLocation().hashCode() == job4.getLocation().hashCode());
        assertFalse(job3.getPositionType().hashCode() == job4.getPositionType().hashCode());
        assertFalse(job3.getCoreCompetency().hashCode() == job4.getCoreCompetency().hashCode());
    }
    @Test
    public void testForFirstAndLastBlankLinesInToString(){
        String newString = job3.toString();
        assertTrue(newString.charAt(0) == '\n');
        assertTrue(newString.charAt(newString.length()-1) == '\n');
    }
    @Test
    public void testForToString(){
        String newString = job3.toString();
        String testString =
                        "\nID: 3" +
                        "\nName: Product tester" +
                        "\nEmployer: ACME" +
                        "\nLocation: Desert" +
                        "\nPosition Type: Quality control" +
                        "\nCore Competency: Persistence" +
                        "\n";
        assertTrue(newString.equals(testString));
    }
    @Test
    public void testForMissingDataInToString(){
        String newString = job5.toString();
        String testString =
                        "\nID: 5" +
                        "\nName: Product tester" +
                        "\nEmployer: Data not available" +
                        "\nLocation: Desert" +
                        "\nPosition Type: Quality control" +
                        "\nCore Competency: Persistence" +
                        "\n";
        assertTrue(newString.equals(testString));
    }
}
