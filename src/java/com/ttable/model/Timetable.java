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
public class Timetable {
    int id;
    Course course;
    Period period;
    Classroom classroom;
    Day day;

    // constructors
    public Timetable() {}

    public Timetable(int id, Course course, Period period, Classroom classroom, Day day) {
        this.id = id;
        this.course = course;
        this.period = period;
        this.classroom = classroom;
        this.day = day;
    }

    public Timetable(Course course, Period period, Classroom classroom, Day day) {
        this.course = course;
        this.period = period;
        this.classroom = classroom;
        this.day = day;
    }
    
    // getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }  
}
