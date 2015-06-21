/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttable.dao;

import com.ttable.model.Period;
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
public class PeriodDAO extends DAO<Period> {

    public PeriodDAO(Connection connection) {
        super(connection);
    }
    
    @Override
    public boolean insert(Period obj) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("INSERT INTO period(period_id, start_time, end_time) VALUES(?,?,?)");
            preparedStatement.setInt(1, obj.getPeriodId());
            preparedStatement.setTime(2, obj.getStartTime());
            preparedStatement.setTime(3, obj.getEndTime());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return true;
    }

    @Override
    public boolean delete(Period obj) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM period where period_id=?");
            preparedStatement.setInt(1, obj.getPeriodId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Period obj) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("UPDATE period SET start_time=?, end_time=? WHERE period_id=?");
            preparedStatement.setTime(1, obj.getStartTime());
            preparedStatement.setTime(2, obj.getEndTime());
            preparedStatement.setInt(3, obj.getPeriodId());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Period getById(String id) {
        return null;
    }

    @Override
    public Period getById(int id) {
        Period period = new Period();
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("SELECT * FROM period WHERE period_id=?");
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                period.setPeriodId(rs.getInt("period_id"));
                period.setStartTime(rs.getTime("start_time"));
                period.setEndTime(rs.getTime("end_time"));
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return period;
    }

    @Override
    public List<Period> getAll() {
        List<Period> periods = new ArrayList<Period>();
        try {
            Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM period");
            while (rs.next()) {
                Period period = new Period();
                period.setPeriodId(rs.getInt("period_id"));
                period.setStartTime(rs.getTime("start_time"));
                period.setEndTime(rs.getTime("end_time"));
                periods.add(period);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return periods;
    }

    @Override
    public Period getByEmailAndPassword(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
