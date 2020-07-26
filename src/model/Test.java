package model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class creates a quiz for the user to take.
 * 
 * @author Brenton Haliw
 *
 */
public class Test {
	
	private static AtomicInteger uniqueID = new AtomicInteger();

	private int quizID; // The number of the quiz
	private double totalPoints; // Amount of points total for the quiz
	private double earnedPoints; // The amount of points the user got
	private ArrayList<Question> questions = new ArrayList<>(); // List of questions for the quiz
	private String quizName; // The name of the quiz
	private String userName; // Name of the quiz taker

	public Test(double totalPoints, double earnedPoints, ArrayList<Question> questions, String quizName,
			String userName) {
		super();
		this.quizID = uniqueID.incrementAndGet();
		this.totalPoints = totalPoints;
		this.earnedPoints = earnedPoints;
		this.questions = questions;
		this.quizName = quizName;
		this.userName = userName;
	}

	public int getQuizNum() {
		return quizID;
	}

	public void setQuizNum(int quizNum) {
		this.quizID = quizNum;
	}

	public double getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(double totalPoints) {
		this.totalPoints = totalPoints;
	}

	public double getEarnedPoints() {
		return earnedPoints;
	}

	public void setEarnedPoints(double earnedPoints) {
		this.earnedPoints = earnedPoints;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
