package spring_data_access.spring_jdbc.w3ii_com_jdbc_example.com.tutorialspoint.java_config.dao;

import org.springframework.jdbc.core.RowMapper;
import spring_data_access.spring_jdbc.w3ii_com_jdbc_example.com.tutorialspoint.java_config.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setAge(rs.getInt("age"));
        return student;
    }
}
