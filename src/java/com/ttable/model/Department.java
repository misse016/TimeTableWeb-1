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
public class Department {
    String dptId;
    String dptName;
    Faculty faculty;
    Lecturer hod;

    // constructor
    public Department(String dptId, String dptName, Faculty faculty) {
        this.dptId = dptId;
        this.dptName = dptName;
        this.faculty = faculty;
    }

    public Department(String dptId, String dptName, Faculty faculty, Lecturer hod) {
        this.dptId = dptId;
        this.dptName = dptName;
        this.faculty = faculty;
        this.hod = hod;
    }

    public Department() {}
    
    
    
    // getter and setter

    public String getDptId() {
        return dptId;
    }

    public void setDptId(String dptId) {
        this.dptId = dptId;
    }

    public String getDptName() {
        return dptName;
    }

    public void setDptName(String dptName) {
        this.dptName = dptName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Lecturer getHod() {
        return hod;
    }

    public void setHod(Lecturer hod) {
        this.hod = hod;
    }
    
    
}
