package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.Question;

public class QuestionController {

	private HashMap<Integer, Question> questionMap;
	
	public QuestionController() {
		questionMap = new HashMap<>();
	}
	
	public void createQuestion(String question, ArrayList<String> choices, String correctAnswer, double points) {
		Question newQuestion = new Question(question, choices, correctAnswer, points);
		questionMap.put(newQuestion.getQuestionID(), newQuestion);
	}
	
	public Question getQuestion(int questionID) {
		if (questionMap.containsKey(questionID)) {
			return questionMap.get(questionID);
		} else {
			System.out.println("Question ID does not match a question in the database.");
			return null;
		}
	}
	
	public String printQuestionMap() {
		String output = "";
		
		if (questionMap.size() == 0) {
			return "Question Bank does not contain any questions.";
		} else {
			int counter = 1;
			
			while (counter < this.questionMap.size()) {
				counter++;
			}
		}
		
		return output;
	}
}
