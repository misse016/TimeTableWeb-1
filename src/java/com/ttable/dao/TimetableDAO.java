/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttable.dao;

import com.ttable.model.Day;
import com.ttable.model.Timetable;
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
public class TimetableDAO extends DAO<Timetable> {

    public TimetableDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean insert(Timetable obj) {
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("INSERT INTO timetable(course_code, "
                            + "period_id, classroom_id, day_name) VALUES(?,?,?,?)");
            
            if (obj.getCourse()==null)
                preparedStatement.setNull(1,1);
            else
                preparedStatement.setString(1, obj.getCourse().getCourseCode());
            preparedStatement.setInt(2, obj.getPeriod().getPeriodId());
            preparedStatement.setString(3, obj.getClassroom().getClassroomId());
            preparedStatement.setString(4, obj.getDay().getDayName());
            
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
           e.printStackTrace(); 
        }
        return true;   
    }

    @Override
    public boolean delete(Timetable obj) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM timetable WHERE course_code=?"
                            + "and period_id=? and classroom_id=? and day_name=?");
            preparedStatement.setString(1, obj.getCourse().getCourseCode());
            preparedStatement.setInt(2, obj.getPeriod().getPeriodId());
            preparedStatement.setString(3, obj.getClassroom().getClassroomId());
            preparedStatement.setString(4, obj.getDay().getDayName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Timetable obj) {
        return false;
    }

    @Override
    public Timetable getById(String id) {
        return null;
    }

    @Override
    public Timetable getById(int id) {
        return null;
    }

    @Override
    public List<Timetable> getAll() {
        List<Timetable> timetables = new ArrayList<Timetable>();
        try {
            Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM timetable");
            while (rs.next()) {
                Timetable timetable = new Timetable();
                
                timetable.setId(rs.getInt("timetable_id"));
                
                CourseDAO courseDAO = new CourseDAO(this.connection);
                timetable.setCourse(courseDAO.getById(rs.getString("course_code")));
                
                PeriodDAO periodDAO = new PeriodDAO(this.connection);
                timetable.setPeriod(periodDAO.getById(rs.getInt("period_id")));
                
                ClassroomDAO classroomDAO = new ClassroomDAO(this.connection);
                timetable.setClassroom(classroomDAO.getById(rs.getString("classroom_id")));
                
                DayDAO dayDAO = new DayDAO(this.connection);
                timetable.setDay(dayDAO.getById(rs.getString("day_name")));
                
                timetables.add(timetable);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timetables;
    } 

    @Override
    public Timetable getByEmailAndPassword(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
