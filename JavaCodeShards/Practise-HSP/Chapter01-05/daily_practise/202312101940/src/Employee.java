import java.io.Serializable;

public abstract class Employee implements Serializable,Comparable<Employee>{
	
	private String name;
	private String dept;
	private static int number = 1;
	private int id;
	
	public Employee() {
		this.name = null;
		this.dept = null;
		this.id = 0;
	}
	public Employee(String name,String dept) {
		this.name = name;
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getID() {
		return id;
	}
	public String toString() {
		return "name is " + name + "id is " + "Pay is" ;
	};
	public abstract double calculatePay(double hours);

	public int compareTo(Employee e) {
		return this.getName().compareTo(e.getName());
	}
}
