package model;

import java.util.ArrayList;
import java.util.HashMap;

public class TestBank {

	private HashMap<String, Test> quizzes;
	
	public TestBank(ArrayList<Test> quizzes) {
		for (Test test : quizzes) {
			addQuizToBank(test);
		}
	}
	
	public TestBank() {
		quizzes = new HashMap<>();
	}

	public HashMap<String, Test> getQuizzes() {
		return quizzes;
	}

	public void addQuizToBank(Test test) {
		String quizName = test.getQuizName();
		this.quizzes.put(quizName, test);

	}

	public Test getQuiz(String quizName) {
		if (this.quizzes.containsKey(quizName)) {
			return this.quizzes.get(quizName);
		} else {
			System.out.println("Test Name was not found");
			return null;
		}
	}

	public void setQuizzes(HashMap<String, Test> quizzes) {
		this.quizzes = quizzes;
	}

}
