/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttable.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MIS
 */
public class Lecturer {
    String lecturerId;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String password;
    String position;
    Faculty faculty;
    Department department;
    List<Course> listCourse =  new ArrayList<Course>();

    // constructor

    public Lecturer(String lecturerId, String firstName, String lastName, String email, String phoneNumber, String password, String position, Faculty faculty, Department department, List<Course> listCourse) {
        this.lecturerId = lecturerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.position = position;
        this.faculty = faculty;
        this.department = department;
        this.listCourse = listCourse;
    }
    

    public Lecturer() {}
    
    // getter and setter method
    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Course> getListCourse() {
        return listCourse;
    }

    public void setListCourse(List<Course> listCourse) {
        this.listCourse = listCourse;
    }
    
    public void addCourse(Course course) {
        this.listCourse.add(course);
    }
    
    public void removeCourse(Course course) {
        this.listCourse.remove(course);
    }
    
    public boolean validatePassword(String password) {
        if (this.password == password) {
            return true;
        }
        else
            return false;
    }    
}
