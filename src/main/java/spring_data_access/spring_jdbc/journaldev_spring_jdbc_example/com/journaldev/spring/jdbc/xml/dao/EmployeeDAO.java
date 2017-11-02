package spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.xml.dao;

import spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.xml.model.Employee2;

import java.util.List;


//CRUD operations
public interface EmployeeDAO {
	
	//Create
	public void save(Employee2 employee);
	//Read
	public Employee2 getById(int id);
	//Update
	public void update(Employee2 employee);
	//Delete
	public void deleteById(int id);
	//Get All
	public List<Employee2> getAll();
}
