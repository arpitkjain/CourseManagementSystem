/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arpit
 */
public class CourseTest {
    
    private static Course instance;
    public CourseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Course("ExampleCourse");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createAssignment method, of class Course.
     */
    @Test
    public void testCreateAssignment1_Empty() {
        System.out.println("createAssignment");
        String s = "";
        instance.createAssignment(s);
        assertEquals("Empty Assignment",instance.assignments.get(instance.assignments.size()-1).problemStatement,s);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testCreateAssignment2_NonEmpty() {
        System.out.println("createAssignment");
        String s = "Solve Problems 2,3 and 4 of Kohavi";
        instance.createAssignment(s);
        assertEquals("Non-Empty Assignment",instance.assignments.get(instance.assignments.size()-1).problemStatement,s);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testCreateAssignment3_NonEmpty() {
        System.out.println("createAssignment");
        String s = "!@#$%^&*()!@#$%^&*()";
        instance.createAssignment(s);
        assertEquals("Non-Empty Assignment",instance.assignments.get(instance.assignments.size()-1).problemStatement,s);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of submitAssignment method, of class Course.
     */
    @Test
    public void testSubmitAssignment1() {
        System.out.println("submitAssignment");
        instance.createAssignment("Solve Problems 2,3 and 4 of Kohavi");
        String s = "E=mc^2";
        int i = instance.assignments.size() -1;
        instance.submitAssignment(s, i);
        assertEquals("First Submission",instance.assignments.get(instance.assignments.size()-1).submission,s);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testSubmitAssignment2() {
        System.out.println("submitAssignment");
        instance.createAssignment("Solve Problems 1,2,3 and 4 of Sipser");
        String s = "E=h*(lambda)";
        int i = instance.assignments.size() -1;
        instance.submitAssignment(s, i);
        assertEquals("Second Submission",instance.assignments.get(instance.assignments.size()-1).submission,s);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testSubmitAssignment3() {
        System.out.println("submitAssignment");
        instance.createAssignment("Solve Problems 1, 2 and 3 of Pressman");
        String s = "DelX*DelP>=h/(4*pi)";
        int i = instance.assignments.size() -1;
        instance.submitAssignment(s, i);
        assertEquals("Third Submission",instance.assignments.get(instance.assignments.size()-1).submission,s);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of viewSubmission method, of class Course.
     */
    @Test
    public void testViewSubmission1() {
        testSubmitAssignment1();
        System.out.println("viewSubmission");
        int i = instance.assignments.size()-1;
        String expResult = "E=mc^2";
        String result = instance.viewSubmission(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testViewSubmission2() {
        testSubmitAssignment2();
        System.out.println("viewSubmission");
        int i = instance.assignments.size()-1;
        String expResult = "E=h*(lambda)";
        String result = instance.viewSubmission(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testViewSubmission3() {
        testSubmitAssignment3();
        System.out.println("viewSubmission");
        int i = instance.assignments.size()-1;
        String expResult = "DelX*DelP>=h/(4*pi)";
        String result = instance.viewSubmission(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of assignGrade method, of class Course.
     */
    @Test
    public void testAssignGrade1() {
        testSubmitAssignment1();
        System.out.println("assignGrade");
        String ch = "A";
        int i = instance.assignments.size()-1;
        instance.assignGrade(ch, i);
        assertEquals("First Grade",ch,instance.assignments.get(instance.assignments.size()-1).grade);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testAssignGrade2() {
        testSubmitAssignment3();
        System.out.println("assignGrade");
        String ch = "B";
        int i = instance.assignments.size()-1;
        instance.assignGrade(ch, i);
        assertEquals("Second Grade",ch,instance.assignments.get(instance.assignments.size()-1).grade);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testAssignGrade3() {
        testSubmitAssignment3();
        System.out.println("assignGrade");
        String ch = "C";
        int i = instance.assignments.size()-1;
        instance.assignGrade(ch, i);
        assertEquals("Third Grade",ch,instance.assignments.get(instance.assignments.size()-1).grade);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of viewGrade method, of class Course.
     */
    @Test
    public void testViewGrade1() {
        testAssignGrade1();
        System.out.println("viewGrade");
        int i = instance.assignments.size()-1;
        String expResult = "A";
        String result = instance.viewGrade(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testViewGrade2() {
        testAssignGrade2();
        System.out.println("viewGrade");
        int i = instance.assignments.size()-1;
        String expResult = "B";
        String result = instance.viewGrade(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testViewGrade3() {
        testAssignGrade3();
        System.out.println("viewGrade");
        int i = instance.assignments.size()-1;
        String expResult = "C";
        String result = instance.viewGrade(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addReply method, of class Course.
     */
    @Test
    public void testAddReply1() {
        System.out.println("addReply");
        String name = "Arpit";
        String s = "Hi";
        instance.addReply(name, s);
        assertEquals("First Reply",name+": "+s,instance.forum.get(instance.forum.size()-1));
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testAddReply2() {
        System.out.println("addReply");
        String name = "Sudip Misra";
        String s = "Hello";
        instance.addReply(name, s);
        assertEquals("Second Reply",name+": "+s,instance.forum.get(instance.forum.size()-1));
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testAddReply3() {
        System.out.println("addReply");
        String name = "Mark Anthony";
        String s = "Friends, Romans, Countrymen";
        instance.addReply(name, s);
        assertEquals("Third Reply",name+": "+s,instance.forum.get(instance.forum.size()-1));
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of giveAttendance method, of class Course.
     */
    @Test
    public void testGiveAttendance1_Present() {
        System.out.println("giveAttendance");
        Boolean b = true;
        instance.giveAttendance(b);
        assertEquals("Present Attendance",b,instance.attendance.get(instance.attendance.size()-1));
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testGiveAttendance2_Absent() {
        System.out.println("giveAttendance");
        Boolean b = false;
        instance.giveAttendance(b);
        assertEquals("Absent Attendance",b,instance.attendance.get(instance.attendance.size()-1));
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
