package employee.model;

//Model class for Employee
public class Employee {
	private int id;
	private String name;
	private String email;
	private String country;
	private String role;
	public Employee(int id, String name, String email, String country,String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.role=role;
	}

	public Employee(String name, String email, String country,String role) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
		this.role=role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role=role;
	}

}
