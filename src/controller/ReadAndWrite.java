package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Question;
import model.Test;
import model.User;
import view.MainGUI;

public class ReadAndWrite {

	public static String directoryPath = MainGUI.directoryPath; // The main directory containing all the required files
	public static String userDatabase = directoryPath + "\\users.txt";  // The file containing user information
	public static String testDatabase = directoryPath + "\\tests.xls"; // The file containing test information
	public static String questionDatabase = directoryPath + "\\questions.xls"; // The file containing question information
	
	private UserController userController;
	private TestController testController;
	private QuestionController questionController;
	
	public ReadAndWrite(UserController userController) {
		this.userController = userController;
	}
	
	public void saveUserDatabase() throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(userDatabase, "UTF-8");
		
	}
	
	public void loadUserDatabase() throws FileNotFoundException, UnsupportedEncodingException {
		File file = new File(userDatabase);
		Scanner scanner = new Scanner(file);
		String line = "", name = "", password = "";

		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			
			if (line.matches("Username: (\\w+)")) {
				name  = line.replaceAll("Username: (\\w+)", "$1");
			} else if (line.matches("Password: (\\w+)")) {
				password = line.replaceAll("Password: (\\w+)", "$1");
			} else if (line.matches("Roles: (User|Administrator),?\\s?(Administrator)?")) {
				ArrayList<String> roles = new ArrayList<>();
				String roleString = line.replaceAll("Roles: (User|Administrator),?\\s?(Administrator)?", "$1 $2");
				String[] roleArray = roleString.split(" ");
				for (String curr : roleArray) {
					roles.add(curr);
				}
				
				userController.createUser(name, password, roles);
				name = "";
				password = "";
			}
		}
		
		scanner.close();
	}
	
	public void saveTestDatabase() {
		
	}
	
	public void loadTestDatabase() {

	}
	
	public void saveQuestionDatabase() {
		
	}
	
	public void loadQuestionDatabase() {

	}
	
	public void setMainPath(String path) {
		directoryPath = path;
		userDatabase = directoryPath + "\\users.txt";  // The file containing user information
		testDatabase = directoryPath + "\\tests.xls"; // The file containing test information
		questionDatabase = directoryPath + "\\questions.xls";
	}
}
