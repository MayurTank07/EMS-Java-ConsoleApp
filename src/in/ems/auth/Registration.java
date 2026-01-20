package in.ems.auth;

import java.util.ArrayList;

public class Registration {

	private String name;
	private String username;
	private String email;
	private String password;
	
	private static ArrayList<Registration> regList = new ArrayList<Registration>();
	
	public Registration(String name, String username, String email, String password) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		
		regList.add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	 public static void displayAll() 
	 {
	     System.out.println("\n\t\t REGISTERED USERS");
	        System.out.println("\t---------------------------------");
	        for (Registration r : regList) {
	            System.out.println(
	                "Name: " + r.name +
	                ", Username: " + r.username +
	                ", Email: " + r.email
	            );
	 }
	
}
}
