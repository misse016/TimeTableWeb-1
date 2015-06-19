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
public class Course {
    String courseCode;
    String courseName;
    Level level;
    Lecturer lecturer;
    Department department;
    
    // constructors
    public Course(String courseCode, String courseName, Level level, Department department) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.level = level;
        this.department = department;
    }

    public Course(String courseCode, String courseName, Level level, Lecturer lecturer, Department department) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.level = level;
        this.lecturer = lecturer;
        this.department = department;
    }
    
    public Course () {}

    // getter and setter method
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
}
