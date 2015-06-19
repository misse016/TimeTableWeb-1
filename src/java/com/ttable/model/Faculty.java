/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttable.model;

/**
 *
 * @author MIS
 */
public class Faculty {
    String facultyId;
    String facultyName;
    Lecturer dean;
    
    // constructors
    //They have the same name but different parameters
    public Faculty(String facultyId, String facultyName) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
    }

    public Faculty(String facultyId, String facultyName, Lecturer dean) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.dean = dean;
    }

    public Faculty() {}
    
    
    // getter and setter method
    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Lecturer getDean() {
        return dean;
    }

    public void setDean(Lecturer dean) {
        this.dean = dean;
    }
      
}
