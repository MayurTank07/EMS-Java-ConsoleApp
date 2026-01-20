package in.ems.auth;

import in.ems.Db.DBLogin;

public class Login {

	private String username;
	private String password;
	
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public boolean validateLogin()
	{
		
		boolean dbCheck = false;
		
		 // 1. Username must be minimum 5 characters
        if (username == null || username.length() < 5) {
            System.out.println("Username must be at least 5 characters long");
            return false;
        }

        // 2. Password must be alphanumeric (letters + numbers)
        boolean hasLetter = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isLetter(ch)) {
                hasLetter = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        if (!hasLetter || !hasDigit) {
            System.out.println("Password must contain both letters and digits");
            return false;
        }

        DBLogin dbLogin = new DBLogin();
        if (dbLogin.checkLogin(username, password)) {
        	dbCheck = true;
        }
        
        // If all conditions pass
        return dbCheck;
		
	}
	
	
	
	
	
}
