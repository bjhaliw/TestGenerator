package model;

import java.util.ArrayList;

public class User {

	private String userName; 
	private ArrayList<Quiz> quizzes; // Quizzes the user has taken
	private ArrayList<String> roles;
	
	public User(String userName, ArrayList<Quiz> quizzes, ArrayList<String> roles) {
		super();
		this.userName = userName;
		this.quizzes = quizzes;
		this.setRoles(roles);
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public ArrayList<Quiz> getQuizzes() {
		return quizzes;
	}
	public void setQuizzes(ArrayList<Quiz> quizzes) {
		this.quizzes = quizzes;
	}
	public ArrayList<String> getRoles() {
		return roles;
	}
	public void setRoles(ArrayList<String> roles) {
		this.roles = roles;
	}
	
	public void updateRole(String role) {
		if (!this.roles.contains(role)) {
			this.roles.add(role);
		} else {
			System.out.println(userName + " already has the role " + role);
		}
	}
	
}
