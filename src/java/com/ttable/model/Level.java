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
public class Level {
    int levelId;
    int levelName;

    // constructor
    public Level(int levelId, int levelName) {
        this.levelId = levelId;
        this.levelName = levelName;
    }

    public Level() {}
    
    // getter and setter method
    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getLevelName() {
        return levelName;
    }

    public void setLevelName(int levelName) {
        this.levelName = levelName;
    }
}
