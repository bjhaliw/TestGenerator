package model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Creates a question object.
 * 
 * @author Brenton Haliw
 *
 */
public class Question {
	
	private static AtomicInteger uniqueID = new AtomicInteger();

	private int questionID; // What question number this is
	private String question; // Will display the question to the user
	private ArrayList<String> choices = new ArrayList<>(); // Multiple choice, T/F questions
	private String correctAnswer; // The supplied answer to the question to be checked
	private double points;

	/**
	 * Creating a brand new question that needs an ID to go along with it.
	 * @param question
	 * @param choices
	 * @param correctAnswer
	 * @param points
	 */
	public Question(String question, ArrayList<String> choices, String correctAnswer, double points) {
		super();
		this.questionID = uniqueID.incrementAndGet();
		this.question = question;
		this.choices = choices;
		this.setCorrectAnswer(correctAnswer);
		this.points = points;
	}
	
	/**
	 * Creating a question that already has an ID to go along with it.
	 * @param questionID
	 * @param question
	 * @param choices
	 * @param correctAnswer
	 * @param points
	 */
	public Question(int questionID, String question, ArrayList<String> choices, String correctAnswer, double points) {
		super();
		this.questionID = questionID;
		this.question = question;
		this.choices = choices;
		this.setCorrectAnswer(correctAnswer);
		this.points = points;
	}

	/**
	 * Returns the number assigned to the question.
	 * 
	 * @return an int containing the number of the question
	 */
	public int getQuestionID() {
		return this.questionID;
	}

	/**
	 * Allows the user to set a new number for the question.
	 * 
	 * @param num
	 */
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ArrayList<String> getChoices() {
		return this.choices;
	}

	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}

	public String getCorrectAnswer() {
		return this.correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public double getPoints() {
		return this.points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public String toString() {
		String output = "";
		
		output += "Question ID: " + this.questionID + "\n";
		output += "Question Points: " + this.points + "\n";
		output += "Question Text: " + this.question + "\n";
		
		if (this.choices == null) {
			output += "Question Choices: None\n";
		} else {
			output += "Question Choices: " + this.choices.toString() + "\n";
		}
		
		output += "Question Answer: " + this.correctAnswer + "\n";
		
		return output;
	}
}
