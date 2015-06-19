/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttable.dao;

import com.ttable.model.Department;
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
public class DepartmentDAO extends DAO<Department> {

    public DepartmentDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean insert(Department obj) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("INSERT INTO department(department_id, "
                            + "department_name, faculty_id, user_id) VALUES(?,?,?,?)");
            preparedStatement.setString(1, obj.getDptId());
            preparedStatement.setString(2, obj.getDptName());
            preparedStatement.setString(3, (obj.getFaculty().getFacultyId()));
            if (obj.getHod()==null)
                preparedStatement.setNull(4, 1);
                else
            preparedStatement.setString(4, (obj.getHod().getLecturerId()));
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return true;
    }

    @Override
    public boolean delete(Department obj) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM department WHERE department_id=?");
            preparedStatement.setString(1, obj.getDptId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Department obj) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("UPDATE department SET department_name=?, "
                            + "faculty_id=?, user_id=? WHERE department_id=?");
            preparedStatement.setString(1, obj.getDptName());
            preparedStatement.setString(2, (obj.getFaculty().getFacultyId()));
            if (obj.getHod()==null)
            preparedStatement.setNull(3, 1);   
                else
            preparedStatement.setString(3, (obj.getHod().getLecturerId()));
            preparedStatement.setString(4, obj.getDptId());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Department getById(String id) {
        Department department = new Department();
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("SELECT * FROM department WHERE department_id=?");
            preparedStatement.setString(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                // do  the change here
                department.setDptId(rs.getString("department_id"));
                department.setDptName(rs.getString("department_name"));
                
                // get a faculty from the database and assign it to the faculty 
                // attribute of department
                FacultyDAO facultyDAO = new FacultyDAO(this.connection);
                department.setFaculty(facultyDAO.getById(rs.getString("faculty_id")));
                
                // get the hod from database and assign it to the lecturer
                // attribute of department
                LecturerDAO lecturerDAO = new LecturerDAO(this.connection);
                department.setHod(lecturerDAO.getById(rs.getString("user_id")));
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public Department getById(int id) {
        return null;
    }
    
    // not correct
    public Department getByUserId(String id) {
        Department department = new Department();
        
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("SELECT * FROM department WHERE user_id=?");
            preparedStatement.setString(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) { 
                department.setDptId(rs.getString("department_id"));
                department.setDptName(rs.getString("department_name"));
                
                // get a faculty from the database and assign it to the faculty 
                // attribute of department
                FacultyDAO facultyDAO = new FacultyDAO(this.connection);
                department.setFaculty(facultyDAO.getById(rs.getString("faculty_id")));
                
                // get the hod from database and assign it to the lecturer
                // attribute of department
                LecturerDAO lecturerDAO = new LecturerDAO(this.connection);
                //department.setHod(lecturerDAO.getById(rs.getString("user_id")));
            } 
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public List<Department> getAll() {
        List<Department> departments = new ArrayList<Department>();
        try {
            Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM department");
            while (rs.next()) {
                Department department = new Department();
                
                department.setDptId(rs.getString("department_id"));
                department.setDptName(rs.getString("department_name"));
                
                // get a faculty from the database and assign it to the faculty 
                // attribute of department
                FacultyDAO facultyDAO = new FacultyDAO(this.connection);
                department.setFaculty(facultyDAO.getById(rs.getString("faculty_id")));
                
                // get the hod from database and assign it to the lecturer
                // attribute of department
                LecturerDAO lecturerDAO = new LecturerDAO(this.connection);
                department.setHod(lecturerDAO.getById(rs.getString("user_id"))); 
                
                
                departments.add(department);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }
    
}
