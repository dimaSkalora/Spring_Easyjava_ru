package spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.java_config.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.java_config.model.Employee2;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class EmployeeDAOJDBCTemplateImpl implements EmployeeDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Employee2 employee) {
		String query = "insert into Employee2 (id, nameE, role) values (?,?,?)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = new Object[] {employee.getId(), employee.getNameE(), employee.getRole()};
		
		int out = jdbcTemplate.update(query, args);
		
		if(out !=0){
			System.out.println("Employee2 saved with id="+employee.getId());
		}else System.out.println("Employee2 save failed with id="+employee.getId());
	}

	@Override
	public Employee2 getById(int id) {
		String query = "select id, nameE, role from Employee2 where id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//using RowMapper anonymous class, we can create a separate RowMapper for reuse
		Employee2 emp = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Employee2>(){

			@Override
			public Employee2 mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Employee2 emp = new Employee2();
				emp.setId(rs.getInt("id"));
				emp.setNameE(rs.getString("nameE"));
				emp.setRole(rs.getString("role"));
				return emp;
			}});
		
		return emp;
	}

	@Override
	public void update(Employee2 employee) {
		String query = "update Employee2 set nameE=?, role=? where id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] {employee.getNameE(), employee.getRole(), employee.getId()};
		
		int out = jdbcTemplate.update(query, args);
		if(out !=0){
			System.out.println("Employee2 updated with id="+employee.getId());
		}else System.out.println("No Employee2 found with id="+employee.getId());
	}

	@Override
	public void deleteById(int id) {

		String query = "delete from Employee2 where id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		int out = jdbcTemplate.update(query, id);
		if(out !=0){
			System.out.println("Employee2 deleted with id="+id);
		}else System.out.println("No Employee2 found with id="+id);
	}

	@Override
	public List<Employee2> getAll() {
		String query = "select id, nameE, role from Employee2";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Employee2> empList = new ArrayList<Employee2>();

		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);
		
		for(Map<String,Object> empRow : empRows){
			Employee2 emp = new Employee2();
			emp.setId(Integer.parseInt(String.valueOf(empRow.get("id"))));
			emp.setNameE(String.valueOf(empRow.get("nameE")));
			emp.setRole(String.valueOf(empRow.get("role")));
			empList.add(emp);
		}
		return empList;
	}

}
