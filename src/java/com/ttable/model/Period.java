/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttable.model;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author MIS
 */
public class Period {
    int periodId;
    Time startTime;
    Time endTime;

    // constructor

    public Period(int periodId, Time startTime, Time endTime) {
        this.periodId = periodId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Period() {}
    

    // getter and setter method

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
    
    
}
