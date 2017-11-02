package spring_data_access.spring_jdbc.journaldev_spring_jdbc_example.com.journaldev.spring.jdbc.xml.model;

public class Employee2 {

	private int id;
	private String nameE;
	private String role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameE() {
		return nameE;
	}
	public void setNameE(String nameE) {
		this.nameE = nameE;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString(){
		return "{ID="+id+",NameE="+ nameE +",Role="+role+"}";
	}
}
