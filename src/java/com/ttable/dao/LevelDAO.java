/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttable.dao;

import com.ttable.model.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MIS
 */
public class LevelDAO extends DAO<Level>{

    public LevelDAO(Connection connection) {
        super(connection);
    }
    
    @Override
    public boolean insert(Level obj) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("INSERT INTO level(level_id, level_name) VALUES(?,?)");
            preparedStatement.setInt(1, obj.getLevelId());
            preparedStatement.setInt(2, obj.getLevelName());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return true;
    }

    @Override
    public boolean delete(Level obj) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM level where level_id=?");
            preparedStatement.setInt(1, obj.getLevelId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Level obj) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("UPDATE level SET level_name=? WHERE level_id=?");
            preparedStatement.setInt(1, obj.getLevelName());
            preparedStatement.setInt(2, obj.getLevelId());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Level getById(String id) {
        return null; 
    }

    @Override
    public Level getById(int id) {
       Level level = new Level();
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("SELECT * FROM level WHERE level_id=?");
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                level.setLevelId(rs.getInt("level_id"));
                level.setLevelName(rs.getInt("level_name"));
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return level; 
    }

    @Override
    public List<Level> getAll() {
        List<Level> levels = new ArrayList<Level>();
        try {
            Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM level");
            while (rs.next()) {
                Level level = new Level();
                level.setLevelId(rs.getInt("level_id"));
                level.setLevelName(rs.getInt("level_name"));
                levels.add(level);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return levels;
    }
    
}
