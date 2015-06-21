/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttable.dao;

import com.ttable.model.Course;
import com.ttable.model.Department;
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
public class LecturerDAO extends DAO<Lecturer> {

    public LecturerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean insert(Lecturer obj) {
        //put null in place of the department attribute in order not to make obj hod
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("INSERT INTO lecturer(user_id, "
                            + "faculty_id, position, first_name, last_name, email, "
                            + "phone_number, password) VALUES(?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, obj.getLecturerId());
            preparedStatement.setString(2, (obj.getFaculty().getFacultyId()));
            preparedStatement.setInt(3, obj.getPosition());
            preparedStatement.setString(4, obj.getFirstName());
            preparedStatement.setString(5, obj.getLastName());
            //preparedStatement.setString(6, obj.getEmail());
            
            if (obj.getEmail()==null) {
                preparedStatement.setNull(6, 1);
            }
            else {
                preparedStatement.setString(6, obj.getEmail());
            }
            
            if (obj.getPhoneNumber()==null) {
                preparedStatement.setNull(7, 1);
            }
            else {
                preparedStatement.setString(7, obj.getPhoneNumber());
            }
            
            preparedStatement.setString(8, obj.getPassword());
            
            preparedStatement.executeUpdate();
            
            DepartmentDAO dptDAO = new DepartmentDAO(this.connection);
            LecturerDAO lDAO = new LecturerDAO(this.connection);
            
            if (obj.getDepartment()!=null) {
                Department d = new Department(obj.getDepartment().getDptId(), obj.getDepartment().getDptName(), obj.getFaculty(),lDAO.getById(obj.getLecturerId()));
                dptDAO.update(d);
            }
            
            //handle course list
            //for (Course course : obj.getListCourse()) {
            LecturerDAO lecturerDAO = new LecturerDAO(this.connection);
            CourseDAO courseDAO = new CourseDAO(this.connection);
            
            Lecturer l = lecturerDAO.getById(obj.getLecturerId());
            
            
            for (int i=0; i< obj.getListCourse().size(); i++) {
                Course c = new Course(obj.getListCourse().get(i).getCourseCode(), 
                        obj.getListCourse().get(i).getCourseName(), 
                        obj.getListCourse().get(i).getLevel(),
                        l,
                        obj.getListCourse().get(i).getDepartment());
                courseDAO.update(c);
            }
            
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return true;
    }

    @Override
    public boolean delete(Lecturer obj) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM lecturer where user_id=?");
            preparedStatement.setString(1, obj.getLecturerId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Lecturer obj) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("UPDATE lecturer SET "
                            + "faculty_id=?, position=?, first_name=?, last_name=?, email=?, "
                            + "phone_number=?, password=? WHERE user_id=?");
            preparedStatement.setString(1, (obj.getFaculty().getFacultyId()));
            preparedStatement.setInt(2, obj.getPosition());
            preparedStatement.setString(3, obj.getFirstName());
            preparedStatement.setString(4, obj.getLastName());
            preparedStatement.setString(5, obj.getEmail());
            preparedStatement.setString(6, obj.getPhoneNumber());
            preparedStatement.setString(7, obj.getPassword());
            preparedStatement.setString(8, obj.getLecturerId());
            preparedStatement.executeUpdate();
            
            DepartmentDAO dptDAO = new DepartmentDAO(this.connection);
            LecturerDAO lDAO = new LecturerDAO(this.connection);
            
            if (obj.getDepartment()==null) {
                Department d2 = dptDAO.getByUserId(obj.getLecturerId());
                Department d3 = new Department(d2.getDptId(), d2.getDptName(), d2.getFaculty(), null);
                dptDAO.update(d3);
            }
            else 
            /*if (obj.getDepartment()!=null)*/ {
                Department d = new Department(obj.getDepartment().getDptId(), obj.getDepartment().getDptName(), obj.getFaculty(),lDAO.getById(obj.getLecturerId()));
                dptDAO.update(d);
            }
            
            // remain to handle course list
            LecturerDAO lecturerDAO = new LecturerDAO(this.connection);
            CourseDAO courseDAO = new CourseDAO(this.connection);
            
            Lecturer l = lecturerDAO.getById(obj.getLecturerId());
            
            
            for (int i=0; i< obj.getListCourse().size(); i++) {
                Course c = new Course(obj.getListCourse().get(i).getCourseCode(), 
                        obj.getListCourse().get(i).getCourseName(), 
                        obj.getListCourse().get(i).getLevel(),
                        l,
                        obj.getListCourse().get(i).getDepartment());
                courseDAO.update(c);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Lecturer getById(String id) {
        Lecturer lecturer = new Lecturer();
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("SELECT * FROM lecturer WHERE user_id=?");
            preparedStatement.setString(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                lecturer.setLecturerId(rs.getString("user_id"));
                lecturer.setFirstName(rs.getString("first_name"));
                lecturer.setLastName(rs.getString("last_name"));
                lecturer.setEmail(rs.getString("email"));
                lecturer.setPhoneNumber(rs.getString("phone_number"));
                lecturer.setPassword(rs.getString("password"));
                lecturer.setPosition(rs.getInt("position"));
                
                // set faculty attribute
                FacultyDAO facultyDAO = new FacultyDAO(this.connection);
                lecturer.setFaculty(facultyDAO.getById(rs.getString("faculty_id")));
                
                // set department attribute
                DepartmentDAO dptDAO = new DepartmentDAO(this.connection);
                lecturer.setDepartment(dptDAO.getByUserId(rs.getString("user_id")));
            }
            
            //handle course
            PreparedStatement preparedStatement1 = 
                    connection.prepareStatement("SELECT * FROM course WHERE user_id=?");
            preparedStatement1.setString(1, id);
            
            ResultSet rs1 = preparedStatement1.executeQuery();
            
            LevelDAO levelDAO = new LevelDAO(this.connection);
            LecturerDAO lecturerDAO = new LecturerDAO(this.connection);
            DepartmentDAO departmentDAO = new DepartmentDAO(this.connection);
            
            while (rs1.next()) {
                Course c = new Course(rs1.getString("course_code"),
                        rs1.getString("course_name"), 
                        levelDAO.getById(rs1.getString("level_id")),
                        //lecturerDAO.getById(rs1.getString("user_id")),
                        //departmentDAO.getById(rs1.getString("department_id")));
                        null, null);
                
                lecturer.addCourse(c);
            }
            // end handle course     
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lecturer;
    }

    @Override
    public Lecturer getById(int id) {
        return null;
    }

    @Override
    public List<Lecturer> getAll() {
        List<Lecturer> lecturers = new ArrayList<Lecturer>();
        try {
            Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM lecturer");
            while (rs.next()) {
                Lecturer lecturer = new Lecturer();
                
                lecturer.setLecturerId(rs.getString("user_id"));
                lecturer.setFirstName(rs.getString("first_name"));
                lecturer.setLastName(rs.getString("last_name"));
                lecturer.setEmail(rs.getString("email"));
                lecturer.setPhoneNumber(rs.getString("phone_number"));
                lecturer.setPassword(rs.getString("password"));
                lecturer.setPosition(rs.getInt("position"));
                
                // set faculty attribute
                FacultyDAO facultyDAO = new FacultyDAO(this.connection);
                lecturer.setFaculty(facultyDAO.getById(rs.getString("faculty_id")));
                
                // set department attribute
                DepartmentDAO dptDAO = new DepartmentDAO(this.connection);
                lecturer.setDepartment(dptDAO.getByUserId(rs.getString("user_id")));
                
                
                //handle course
            PreparedStatement preparedStatement1 = 
                    connection.prepareStatement("SELECT * FROM course WHERE user_id=?");
            preparedStatement1.setString(1, rs.getString("user_id"));
            
            ResultSet rs1 = preparedStatement1.executeQuery();
            
            LevelDAO levelDAO = new LevelDAO(this.connection);
            //LecturerDAO lecturerDAO = new LecturerDAO(this.connection);
            //DepartmentDAO departmentDAO = new DepartmentDAO(this.connection);
            
            while (rs1.next()) {
                Course c = new Course(rs1.getString("course_code"),
                        rs1.getString("course_name"), 
                        levelDAO.getById(rs1.getString("level_id")),
                        //lecturerDAO.getById(rs1.getString("user_id")),
                        //departmentDAO.getById(rs1.getString("department_id")));
                        null, null);
                
                lecturer.addCourse(c);
            }
            // end handle course    
                lecturers.add(lecturer);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lecturers;
    }
/**
 * Used to authenticate the user
 * @param email authentication parameter
 * @param password authentication parameter
 * @param pos authentication parameter
 * @return authenticated user
 */
    public Lecturer getByEmailAndPassword(String email, String password, int pos) {
        Lecturer lecturer = new Lecturer(email, password, pos);
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("SELECT * FROM lecturer WHERE email=? AND password=? AND position=?");
            preparedStatement.setString(1, email); //changed from id to email
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, pos);
            
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                lecturer.setLecturerId(rs.getString("user_id"));
                lecturer.setFirstName(rs.getString("first_name"));
                lecturer.setLastName(rs.getString("last_name"));
               // lecturer.setEmail(rs.getString("email"));
                lecturer.setPhoneNumber(rs.getString("phone_number"));
               // lecturer.setPassword(rs.getString("password"));
               // lecturer.setPosition(rs.getInt("position"));
                
                // set faculty attribute
                FacultyDAO facultyDAO = new FacultyDAO(this.connection);
                lecturer.setFaculty(facultyDAO.getById(rs.getString("faculty_id")));
                
                // set department attribute
                DepartmentDAO dptDAO = new DepartmentDAO(this.connection);
                lecturer.setDepartment(dptDAO.getByUserId(rs.getString("user_id")));
            }
            
            //handle course
            PreparedStatement preparedStatement1 = 
                    connection.prepareStatement("SELECT * FROM course WHERE user_id=?");
            preparedStatement1.setString(1, email); //changed from id to email
            
            ResultSet rs1 = preparedStatement1.executeQuery();
            
            LevelDAO levelDAO = new LevelDAO(this.connection);
            LecturerDAO lecturerDAO = new LecturerDAO(this.connection);
            DepartmentDAO departmentDAO = new DepartmentDAO(this.connection);
            
            while (rs1.next()) {
                Course c = new Course(rs1.getString("course_code"),
                        rs1.getString("course_name"), 
                        levelDAO.getById(rs1.getString("level_id")),
                        //lecturerDAO.getById(rs1.getString("user_id")),
                        //departmentDAO.getById(rs1.getString("department_id")));
                        null, null);
                
                lecturer.addCourse(c);
            }
            return lecturer;
            // end handle course     
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lecturer;
    }

    @Override
    public Lecturer getByEmailAndPassword(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
