package model;

import java.util.ArrayList;
import java.util.HashMap;

public class QuizBank {

	private HashMap<String, Quiz> quizzes;
	
	public QuizBank(ArrayList<Quiz> quizzes) {
		for (Quiz quiz : quizzes) {
			addQuizToBank(quiz);
		}
	}
	
	public QuizBank() {
		quizzes = new HashMap<>();
	}

	public HashMap<String, Quiz> getQuizzes() {
		return quizzes;
	}

	public void addQuizToBank(Quiz quiz) {
		String quizName = quiz.getQuizName();
		this.quizzes.put(quizName, quiz);

	}

	public Quiz getQuiz(String quizName) {
		if (this.quizzes.containsKey(quizName)) {
			return this.quizzes.get(quizName);
		} else {
			System.out.println("Quiz Name was not found");
			return null;
		}
	}

	public void setQuizzes(HashMap<String, Quiz> quizzes) {
		this.quizzes = quizzes;
	}

}
