package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job instanceof Job);

        assertEquals("Product tester", job.getName());
        assertTrue( job.getName() instanceof String);

        assertEquals("ACME", job.getEmployer().getValue());
        assertTrue( job.getEmployer() instanceof Employer);

        assertEquals("Desert", job.getLocation().getValue());
        assertTrue( job.getLocation() instanceof Location);

        assertEquals("Quality control", job.getPositionType().getValue());
        assertTrue( job.getPositionType() instanceof PositionType);
        assertTrue( job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

     @Test
    public void testToStringStartsAndEndsWithNewLine() {
         Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                 new PositionType("Quality control"), new CoreCompetency("Persistence"));
         char firstChar = job.toString().charAt(0);
         char lastChar = job.toString().charAt(job.toString().length()-1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
     }

     @Test
    public void testToStringContainsCorrectLabelsAndData() {
         Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                 new PositionType("Quality control"), new CoreCompetency("Persistence"));
         String output = "\n" +
                 "ID: " + job.getId() + "\n" +
                 "Name: " + job.getName() + "\n" +
                 "Employer: " + job.getEmployer() + "\n" +
                 "Location: " + job.getLocation() + "\n" +
                 "Position Type: " + job.getPositionType() + "\n" +
                 "Core Competency: " + job.getCoreCompetency() +
                 "\n";
        assertEquals(output, job.toString());
     }

     @Test
    public void testToStringHandlesEmptyField() {
         Job job = new Job("Product tester", new Employer(""), new Location("Desert"),
                 new PositionType("Quality control"), new CoreCompetency("Persistence"));
         String output = "\n" +
                 "ID: " + job.getId() + "\n" +
                 "Name: " + job.getName() + "\n" +
                 "Employer: Data not available" + "\n" +
                 "Location: " + job.getLocation() + "\n" +
                 "Position Type: " + job.getPositionType() + "\n" +
                 "Core Competency: " + job.getCoreCompetency() + "\n";
         assertEquals(output, job.toString());
     }

}
