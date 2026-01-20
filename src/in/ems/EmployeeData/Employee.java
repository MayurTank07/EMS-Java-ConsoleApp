package in.ems.EmployeeData;

public class Employee {
	
	private int eId;
	private String eName;
	private double eSalary;
	private String eDept;
	private double eExperience;
	
	public Employee(int eId, String eName, double eSalary, String eDept, double eExperience) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eSalary = eSalary;
		this.eDept = eDept;
		this.eExperience = eExperience;
	}
	
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public double geteSalary() {
		return eSalary;
	}
	public void seteSalary(double eSalary) {
		this.eSalary = eSalary;
	}
	public String geteDept() {
		return eDept;
	}
	public void seteDept(String eDept) {
		this.eDept = eDept;
	}
	public double geteExperience() {
		return eExperience;
	}
	public void seteExperience(double eExperience) {
		this.eExperience = eExperience;
	}
	
	
	
	
}
