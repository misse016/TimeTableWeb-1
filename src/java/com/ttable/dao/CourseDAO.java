/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttable.dao;

import com.ttable.model.Course;
import com.ttable.model.Day;
import com.ttable.model.Department;
import com.ttable.model.Faculty;
import com.ttable.model.Lecturer;
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
public class CourseDAO extends DAO<Course>{

    public CourseDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean insert(Course obj) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("INSERT INTO course(course_code, "
                            + "course_name, level_id, user_id,department_id) VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, obj.getCourseCode());
            preparedStatement.setString(2, obj.getCourseName());
            preparedStatement.setObject(3, obj.getLevel().getLevelId());
            
            if (obj.getLecturer()==null)
                preparedStatement.setNull(4,1);
            else
                preparedStatement.setObject(4, obj.getLecturer().getLecturerId());
            preparedStatement.setObject(5, obj.getDepartment().getDptId());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return true;
    }

    @Override
    public boolean delete(Course obj) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM course WHERE course_code=?");
            preparedStatement.setString(1, obj.getCourseCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Course obj) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("UPDATE course SET course_name=?, "
                            + "level_id=?, user_id=?, department_id=?  WHERE course_code=?");
            preparedStatement.setString(1, obj.getCourseName());
            preparedStatement.setInt(2, (obj.getLevel().getLevelId()));
            
            if (obj.getLecturer()==null)
                preparedStatement.setNull(3,1);
            else
                preparedStatement.setString(3, obj.getLecturer().getLecturerId() );
            preparedStatement.setString(4, obj.getDepartment().getDptId());
            preparedStatement.setString(5, obj.getCourseCode());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Course getById(String id) {
        Course course = new Course();
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("SELECT * FROM course WHERE course_code=?");
            preparedStatement.setString(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseName(rs.getString("course_name"));
                
                LevelDAO levelDAO = new LevelDAO(this.connection);
                course.setLevel(levelDAO.getById(rs.getInt("level_id")));
                
                LecturerDAO lecturerDAO = new LecturerDAO(this.connection);
                course.setLecturer(lecturerDAO.getById(rs.getString("user_id")));
                
                DepartmentDAO departmentDAO = new DepartmentDAO(this.connection);
                course.setDepartment(departmentDAO.getById(rs.getString("department_id")));
                
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public Course getById(int id) {
        return null;
    }

    @Override
    public List<Course> getAll() {
        List<Course> courses = new ArrayList<Course>();
        try {
            Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM course");
            while (rs.next()) {
                Course course = new Course();
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseName(rs.getString("course_name"));
                
                LevelDAO levelDAO = new LevelDAO(this.connection);
                course.setLevel(levelDAO.getById(rs.getInt("level_id")));
                
                LecturerDAO lecturerDAO = new LecturerDAO(this.connection);
                course.setLecturer(lecturerDAO.getById(rs.getString("user_id")));
                
                DepartmentDAO departmentDAO = new DepartmentDAO(this.connection);
                course.setDepartment(departmentDAO.getById(rs.getString("department_id")));
                
                courses.add(course);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public Course getByEmailAndPassword(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
