/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Ali Magdy
 */
public class Report {
    
    private Integer CourseID; 
    private String CourseName;
    private Integer EnrolledStudent;
    private float GPA;

    public Report(Integer CourseID, String CourseName, Integer EnrolledStudent, float GPA) {
        this.CourseID = CourseID;
        this.CourseName = CourseName;
        this.EnrolledStudent = EnrolledStudent;
        this.GPA = GPA;
    }

    public Integer getCourseID() {
        return CourseID;
    }

    public void setCourseID(Integer CourseID) {
        this.CourseID = CourseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public Integer getEnrolledStudent() {
        return EnrolledStudent;
    }

    public void setEnrolledStudent(Integer EnrolledStudent) {
        this.EnrolledStudent = EnrolledStudent;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }
    
    
    
}
