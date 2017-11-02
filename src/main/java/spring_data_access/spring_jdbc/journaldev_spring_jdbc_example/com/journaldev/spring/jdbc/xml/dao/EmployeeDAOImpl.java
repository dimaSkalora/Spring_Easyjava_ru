package spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.xml.dao;

import spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.xml.model.Employee2;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Employee2 employee) {
		String query = "insert into Employee2 (id, nameE, role) values (?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getNameE());
			ps.setString(3, employee.getRole());
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Employee2 saved with id="+employee.getId());
			}else System.out.println("Employee2 save failed with id="+employee.getId());
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Employee2 getById(int id) {
		String query = "select nameE, role from Employee2 where id = ?";
		Employee2 emp = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				emp = new Employee2();
				emp.setId(id);
				emp.setNameE(rs.getString("nameE"));
				emp.setRole(rs.getString("role"));
				System.out.println("Employee2 Found::"+emp);
			}else{
				System.out.println("No Employee2 found with id="+id);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	@Override
	public void update(Employee2 employee) {
		String query = "update Employee2 set nameE=?, role=? where id=?";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, employee.getNameE());
			ps.setString(2, employee.getRole());
			ps.setInt(3, employee.getId());
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Employee2 updated with id="+employee.getId());
			}else System.out.println("No Employee2 found with id="+employee.getId());
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteById(int id) {
		String query = "delete from Employee2 where id=?";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Employee2 deleted with id="+id);
			}else System.out.println("No Employee2 found with id="+id);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Employee2> getAll() {
		String query = "select id, nameE, role from Employee2";
		List<Employee2> empList = new ArrayList<Employee2>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				Employee2 emp = new Employee2();
				emp.setId(rs.getInt("id"));
				emp.setNameE(rs.getString("nameE"));
				emp.setRole(rs.getString("role"));
				empList.add(emp);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empList;
	}

}
