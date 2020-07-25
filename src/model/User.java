package model;

import java.util.ArrayList;

public class User {

	private String userName; 
	private ArrayList<Quiz> quizzes; // Quizzes the user has taken
	
	public User(String userName, ArrayList<Quiz> quizzes) {
		super();
		this.userName = userName;
		this.quizzes = quizzes;
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
	
	
}
