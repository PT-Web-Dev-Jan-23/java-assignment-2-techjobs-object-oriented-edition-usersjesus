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

        assertEquals("ACME", job.getEmployer());

        assertEquals("Desert", job.getLocation());

        assertEquals("Quality control", job.getPositionType());

        assertEquals("Persistence", job.getCoreCompetency());
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
         String printJob = "\n" +
                 "ID: " + job.getId() + "\n" +
                 "Name: " + job.getName() + "\n" +
                 "Employer: " + job.getEmployer() + "\n" +
                 "Location: " + job.getLocation() + "\n" +
                 "Position Type: " + job.getPositionType() + "\n" +
                 "Core Competency: " + job.getCoreCompetency() + "\n" +
                 "\n";
        assertEquals("\n", printJob.charAt(0));
        assertEquals("\n", printJob.charAt(118));
     }

     @Test
    public void testToStringContainsCorrectLabelsAndData() {

     }

}
