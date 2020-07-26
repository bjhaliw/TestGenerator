package model;

import java.util.ArrayList;

public class User {

	private String userName;
	private String password;
	private ArrayList<Test> quizzes; // Quizzes the user has taken
	private ArrayList<String> roles;

	public User(String userName, String password, ArrayList<Test> quizzes, ArrayList<String> roles) {
		super();
		this.userName = userName;
		this.quizzes = quizzes;
		this.setRoles(roles);
		this.setPassword(password);

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ArrayList<Test> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(ArrayList<Test> quizzes) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
