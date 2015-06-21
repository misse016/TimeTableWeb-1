/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttable.dao;

import com.ttable.model.Day;
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
public class DayDAO extends DAO<Day> {

    public DayDAO(Connection connection) {
        super(connection);
    }
    
    @Override
    public boolean insert(Day obj) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("INSERT INTO day(day_name, day_id) VALUES(?,?)");
            preparedStatement.setString(1, obj.getDayName());
            preparedStatement.setInt(2, obj.getDayNumber());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return true;
    }

    @Override
    public boolean delete(Day obj) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM day where day_name=?");
            preparedStatement.setString(1, obj.getDayName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Day obj) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("UPDATE day SET day_id=? WHERE day_name=?");
            preparedStatement.setInt(1, obj.getDayNumber());
            preparedStatement.setString(2, obj.getDayName());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Day getById(String id) {
        Day day = new Day();
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("SELECT * FROM day WHERE day_name=?");
            preparedStatement.setString(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                day.setDayName(rs.getString("day_name"));
                day.setDayNumber(rs.getInt("day_id"));
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return day;
    }

    @Override
    public Day getById(int id) {
        return null;  
    }

    @Override
    public List<Day> getAll() {
        List<Day> days = new ArrayList<Day>();
        try {
            Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM day");
            while (rs.next()) {
                Day day = new Day();
                day.setDayName(rs.getString("day_name"));
                day.setDayNumber(rs.getInt("day_id"));
                days.add(day);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return days;
    }

    @Override
    public Day getByEmailAndPassword(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
