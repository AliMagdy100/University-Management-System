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
public class Course {
    private Integer CourseID;
    private String CourseName;
    private Integer ProgramID;

    public Course(Integer CourseID, String CourseName, Integer ProgramID) {
        this.CourseID = CourseID;
        this.CourseName = CourseName;
        this.ProgramID = ProgramID;
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

    public Integer getProgramID() {
        return ProgramID;
    }

    public void setProgramID(Integer ProgramID) {
        this.ProgramID = ProgramID;
    }
    
}
