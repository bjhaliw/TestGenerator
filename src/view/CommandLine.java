package view;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import controller.ReadAndWrite;
import controller.UserController;

public class CommandLine {

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		UserController userController = new UserController();
		ReadAndWrite readAndWrite = new ReadAndWrite(userController);
		readAndWrite.setMainPath("C:\\Users\\bjhal\\Desktop\\TestGenerator Files");
		System.out.println(ReadAndWrite.directoryPath);
		readAndWrite.loadUserDatabase();
		
		System.out.println("Username: " + userController.getUser("Brenton").getUserName());
		System.out.println("Password: " + userController.getUser("Brenton").getPassword());
		System.out.println("Roles: " + userController.getUser("Brenton").getRoles().toString());
		System.out.println("Test password: " + userController.getUser("test").getPassword());
		
		userController.authenticateUserLogin("Brenton", "DankMemes", "User");
		userController.authenticateUserLogin("Brenton", "DankMemes", "Administrator");	
	}
}
