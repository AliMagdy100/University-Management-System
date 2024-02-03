package DTO;

public class Grade {

    private Long NationalID; 
    private Integer CourseID;
    private String Year;
    private String Semester;
    private Integer Grade;

    public Grade(Long NationalID, Integer CourseID, String Year, String Semester, Integer Grade) {
        this.NationalID = NationalID;
        this.CourseID = CourseID;
        this.Year = Year;
        this.Semester = Semester;
        this.Grade = Grade;
    }

    public Long getNationalID() {
        return NationalID;
    }

    public void setNationalID(Long NationalID) {
        this.NationalID = NationalID;
    }

    public Integer getCourseID() {
        return CourseID;
    }

    public void setCourseID(Integer CourseID) {
        this.CourseID = CourseID;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public Integer getGrade() {
        return Grade;
    }

    public void setGrade(Integer Grade) {
        this.Grade = Grade;
    }
}
