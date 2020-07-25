package controller;

import java.util.HashSet;

import model.Question;

public class CreateQuiz {

	HashSet<Question> questions;
	String quizName;
	int quizNum;
	double totalPoints;
	
	public CreateQuiz() {
		this.questions = new HashSet<>();
	}
	
	public void addQuestion(Question question) {
		this.questions.add(question);
	}
	
	public void removeQuestion(Question question) {
		this.questions.remove(question);
	}
	
	
}
