package example_JSON;

public class Parent_POJO 
{
	private String name;
	private String job;
	private double salary;
	private String location;
	private Child_POJO child_pojo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Child_POJO getChild_pojo() {
		return child_pojo;
	}
	public void setChild_pojo(Child_POJO child_pojo) {
		this.child_pojo = child_pojo;
	}

}
