
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arpit
 */
public class Course implements java.io.Serializable {
    public String courseName;
    public List<Assignment> assignments;
    public List<String> forum;
    public List<Boolean> attendance;
    public Course(String courseName) {
        this.courseName = courseName;
        assignments = new ArrayList<>();
        forum = new ArrayList<>();
        attendance = new ArrayList<>();
    }
    public void createAssignment(String s) {
        assignments.add(new Assignment(s));
    }
    public void submitAssignment(String s, int i) {
        assignments.get(i).submit(s);
    }
    public String viewSubmission(int i) {
        return assignments.get(i).submission;
    }
    public void assignGrade(String ch, int i) {
        assignments.get(i).grade = ch;
    }
    public String viewGrade(int i) {
        return assignments.get(i).grade;
    }
    // Course Materials and Announcements;
    public void addCMaA(String s) {
        // TODO: To be added later
    }
    public void addReply(String name, String s) {
        forum.add(name+": "+s);
    }
    public List<Boolean> viewAttendance(){
        return attendance;
    }
    public void giveAttendance(Boolean b) {
        attendance.add(b);
    }
}

class Assignment implements java.io.Serializable{
    public String problemStatement;
    public String submission;
    public String grade;
    public Assignment(String s) {
        problemStatement = s;
    }
    public void submit(String s) {
        submission = s;
    }
}