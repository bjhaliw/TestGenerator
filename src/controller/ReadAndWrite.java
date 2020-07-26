package controller;

import java.util.HashMap;

import model.Question;
import model.Test;
import model.User;
import view.MainGUI;

public class ReadAndWrite {

	public static String directoryPath = MainGUI.directoryPath; // The main directory containing all the required files
	public static String userDatabase = directoryPath + "/users.xls";  // The file containing user information
	public static String testDatabase = directoryPath + "/tests.xls"; // The file containing test information
	public static String questionDatabase = directoryPath + "/questions.xls"; // The file containing question information
	
	private HashMap<String, User> users;
	private HashMap<Integer, Test> tests;
	private HashMap<Integer, Question> questions;
	
	
	public void saveUserDatabase() {
		
	}
	
	public HashMap<String, User> loadUserDatabase() {
		return users;
	}
	
	public void saveTestDatabase() {
		
	}
	
	public HashMap<Integer, Test> loadTestDatabase() {
		return tests;
	}
	
	public void saveQuestionDatabase() {
		
	}
	
	public HashMap<Integer, Question> loadQuestionDatabase() {
		return questions;
	}
}
