package edu.ucsb.cs56.GauchoGains;

public class User {
	private String valid;
	private String email;
	private String firstName;
	private String lastName;
	private String password;

	public User (String email, String firstName, String lastName,
			String password) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		checkValidUser();
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getPassword() {
		return this.password;
	}
	public String getEmail() {
		return this.email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	private void checkValidUser() {
		if(this.email.length() == 0 || this.firstName.length() == 0 || this.lastName.length() == 0 || this.password.length() == 0)
			this.valid = "Please fill in all forms";
		else if(!this.email.contains("@") || this.email.length() < 5 || this.email.charAt(email.length()-4) != '.' ||
				this.email.charAt(email.indexOf("@")+1) == '.')
			this.valid = "Invalid Email";
		else if(this.password.length() < 6)
			this.valid = "Please enter a password with length greater than 6";
		else 
			this.valid = "valid";
	}
	
	public String getValidUserCheck() {
		return this.valid;
	}

	@Override
	public String toString() {
		return this.email + " " + this.firstName + " " + this.lastName;
	}

}
