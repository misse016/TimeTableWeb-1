/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttable.dao;

import com.ttable.model.Faculty;
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
public class FacultyDAO extends DAO<Faculty> {

    public FacultyDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean insert(Faculty obj) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("INSERT INTO faculty(faculty_id, faculty_name, user_id) VALUES(?,?,?)");
            preparedStatement.setString(1, obj.getFacultyId());
            preparedStatement.setString(2, obj.getFacultyName());
            // set user_id(dean) to null if no dean provided
            if (obj.getDean()==null) {
                preparedStatement.setNull(3, 1);
            }
            else {
                preparedStatement.setString(3, (obj.getDean().getLecturerId()));
            }
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return true;
    }

    @Override
    public boolean delete(Faculty obj) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM faculty WHERE faculty_id=?");
            preparedStatement.setString(1, obj.getFacultyId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Faculty obj) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("UPDATE faculty SET faculty_name=?, "
                            + "user_id=? WHERE faculty_id=?");
            preparedStatement.setString(1, obj.getFacultyName());
            if (obj.getDean()==null) {
                preparedStatement.setNull(2, 1);
            }
            else {
                preparedStatement.setString(2, (obj.getDean().getLecturerId()));
            }
            preparedStatement.setString(3, obj.getFacultyId());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Faculty getById(String id) {
        Faculty faculty = new Faculty();
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("SELECT * FROM faculty WHERE faculty_id=?");
            preparedStatement.setString(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                // do  the change here
                faculty.setFacultyId(rs.getString("faculty_id"));
                faculty.setFacultyName(rs.getString("faculty_name"));
                
                LecturerDAO lDAO = new LecturerDAO(this.connection);
                faculty.setDean(lDAO.getById(rs.getString("user_id")));
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return faculty;
    }

    @Override
    public Faculty getById(int id) {
        return null;
    }

    @Override
    public List<Faculty> getAll() {
        List<Faculty> faculties = new ArrayList<Faculty>();
        try {
            Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM faculty");
            while (rs.next()) {
                Faculty faculty = new Faculty();
                faculty.setFacultyId(rs.getString("faculty_id"));
                faculty.setFacultyName(rs.getString("faculty_name"));
                
                LecturerDAO lDAO = new LecturerDAO(this.connection);
                faculty.setDean(lDAO.getById(rs.getString("user_id")));
                
                faculties.add(faculty);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return faculties;
    }   
}
