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
public class Day {
    String dayName;
    int dayNumber;
    
    // constructor
    public Day(String dayName, int dayNumber) {
        this.dayName = dayName;
        this.dayNumber = dayNumber;
    }

    public Day() {}
    
    // getter and setter method
    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }
    
    
}
