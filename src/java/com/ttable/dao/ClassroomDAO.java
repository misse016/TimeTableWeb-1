/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttable.dao;

import com.ttable.model.Classroom;
import com.ttable.model.Day;
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
public class ClassroomDAO extends DAO<Classroom>{

    public ClassroomDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean insert(Classroom obj) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("INSERT INTO classroom(classroom_id, name) VALUES(?,?)");
            preparedStatement.setString(1, obj.getClassroomId());
            preparedStatement.setString(2, obj.getClassroomName());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return true;
    }

    @Override
    public boolean delete(Classroom obj) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM classroom WHERE classroom_id=?");
            preparedStatement.setString(1, obj.getClassroomId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Classroom obj) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("UPDATE classroom SET name=? WHERE classroom_id=?");
            preparedStatement.setString(1, obj.getClassroomName());
            preparedStatement.setString(2, obj.getClassroomId());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Classroom getById(String id) {
       Classroom classroom = new Classroom();
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("SELECT * FROM classroom WHERE classroom_id=?");
            preparedStatement.setString(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                classroom.setClassroomId(rs.getString("classroom_id"));
                classroom.setClassroomName(rs.getString("name"));
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classroom; 
    }

    @Override
    public Classroom getById(int id) {
        return null;
    }

    @Override
    public List<Classroom> getAll() {
        List<Classroom> classrooms = new ArrayList<Classroom>();
        try {
            Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM classroom");
            while (rs.next()) {
                Classroom classroom = new Classroom();
                classroom.setClassroomId(rs.getString("classroom_id"));
                classroom.setClassroomName(rs.getString("name"));
                classrooms.add(classroom);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classrooms;
    }
    
}
