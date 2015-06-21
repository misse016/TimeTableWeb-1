/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttable.model;

import com.ttable.dao.LecturerDAO;
import com.ttable.util.DbUtil;
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
    int position;
    Faculty faculty;
    Department department;
    public static enum ACL{NORMAL, MASTER, ADMIN};
    List<Course> listCourse =  new ArrayList<Course>();

    // constructor

    public Lecturer(String lecturerId, String firstName, String lastName, String email, String phoneNumber, String password, int position, Faculty faculty, Department department, List<Course> listCourse) {
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
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
//instantiated mostly when trying to authenticate the user
    public Lecturer(String email, String password,int pos) {
        this.email = email;
        this.password = password;
        this.position = pos;
    }
    //identify the user's access level
    public ACL getACL(){
        switch(getPosition()){
            case 0:
                return ACL.NORMAL; //simple lecturer
            case 1:
                return ACL.MASTER; //emulating the hod
            case 2:
                return ACL.ADMIN; //emulating the dean
            default:
                return ACL.NORMAL;
        }
    }

    public Lecturer isAuthenticated(){
        LecturerDAO ldao = new LecturerDAO(DbUtil.getConnection());
        
        Lecturer lect = ldao.getByEmailAndPassword(email, password, position);
        
        return lect;  
    }
}
