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
public class Program {
    
    private Integer ProgramID;
    private String ProgramName;
    private Integer DepartmentID;

    public Program(Integer ProgramID, String ProgramName, Integer DepartmentID) {
        this.ProgramID = ProgramID;
        this.ProgramName = ProgramName;
        this.DepartmentID = DepartmentID;
    }

    public Integer getProgramID() {
        return ProgramID;
    }

    public void setProgramID(Integer ProgramID) {
        this.ProgramID = ProgramID;
    }

    public String getProgramName() {
        return ProgramName;
    }

    public void setProgramName(String DepartmentName) {
        this.ProgramName = DepartmentName;
    }

    public Integer getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(Integer DepartmentID) {
        this.DepartmentID = DepartmentID;
    }
    
    
    
}
