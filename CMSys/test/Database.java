/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
public class Database {
    
    Connection conn=null;
    public Database() {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            String user="dummy";
            String pass="password";
            String DB_URL = "jdbc:mysql://"+"localhost"+"/rrts";
            conn = DriverManager.getConnection(DB_URL,user,pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testRetriveCourses() {
        String[] xcourseNames = {"Algorithms - I Lab", "Visual Communication", "Soft Eng", "Soft Eng Lab"};
        List<String> courseNames = Arrays.asList(xcourseNames);
        String sql="SELECT courseId from CourseList";
        Statement stmt1=null;
        try {stmt1=conn.createStatement();
            ResultSet rs=stmt1.executeQuery(sql);
            while(rs.next()) {
                Boolean b = false;
                String courseName = rs.getString("courseId");
                if(courseNames.contains(courseName))
                    b = true;
                assertTrue("Contains course",b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Instructor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testSelectCourse1() throws Exception {
        String courseId = "Visual Communication";
        String sql="SELECT courseId from CourseList where courseId=\""+courseId+"\"";
        Statement stmt1=null;
        stmt1=conn.createStatement();
        ResultSet rs=stmt1.executeQuery(sql);
        if(rs.next())
        {
            assertEquals("Course",courseId,rs.getString("courseId"));
        }
    }
    @Test
    public void testSelectCourse2() throws Exception {
        String courseId = "Algorithms - I Lab";
        String sql="SELECT courseId from CourseList where courseId=\""+courseId+"\"";
        Statement stmt1=null;
        stmt1=conn.createStatement();
        ResultSet rs=stmt1.executeQuery(sql);
        if(rs.next())
        {
            assertEquals("Course",courseId,rs.getString("courseId"));
        }
    }
    @Test
    public void testSelectCourse3() throws Exception {
        String courseId = "Soft Eng";
        String sql="SELECT courseId from CourseList where courseId=\""+courseId+"\"";
        Statement stmt1=null;
        stmt1=conn.createStatement();
        ResultSet rs=stmt1.executeQuery(sql);
        if(rs.next())
        {
            assertEquals("Course",courseId,rs.getString("courseId"));
        }
    }
    @Test
    public void testSelectCourse4() throws Exception {
        String courseId = "Soft Eng Lab";
        String sql="SELECT courseId from CourseList where courseId=\""+courseId+"\"";
        Statement stmt1=null;
        stmt1=conn.createStatement();
        ResultSet rs=stmt1.executeQuery(sql);
        if(rs.next())
        {
            assertEquals("Course",courseId,rs.getString("courseId"));
        }
    }
    @Test
    public void testSelectCourse5() throws Exception {
        String courseId = "Algorithms - I";
        String sql="SELECT courseId from CourseList where courseId=\""+courseId+"\"";
        Statement stmt1=null;
        stmt1=conn.createStatement();
        ResultSet rs=stmt1.executeQuery(sql);
        if(rs.next())
        {
            assertEquals("Course",courseId,rs.getString("courseId"));
        }
    }
}
