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
public class Classroom {
    String classroomId;
    String classroomName;

    // constructor
    public Classroom(String classroomId, String classroomName) {
        this.classroomId = classroomId;
        this.classroomName = classroomName;
    }

    public Classroom() { }
    
    // getter and setter method
    public String getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }
    
    
}
