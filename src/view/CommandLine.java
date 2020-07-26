package view;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import controller.UserController;
import model.User;

public class CommandLine {

	public static void main(String[] args) throws UnsupportedEncodingException {
		UserController userController = new UserController(new HashMap<String, User>(), null);
		ArrayList<String> roles = new ArrayList<>();
		roles.add("User");
		userController.createUser("Brenton", "Pancakes", roles);
		
		System.out.println("Username: " + userController.getUser("Brenton").getUserName());
		System.out.println("Password: " + userController.getUser("Brenton").getPassword());
		System.out.println("Roles: " + userController.getUser("Brenton").getRoles().toString());
		
		userController.removeUser("Test User");
		
		userController.authenticateUserLogin("Brenton", "Pancakes", "Administrator");
		userController.authenticateUserLogin("Brenton", "Pancakess", "User");
		userController.authenticateUserLogin("Brentons", "Pancakes", "User");
		userController.authenticateUserLogin("Brenton", "Pancakes", "User");
		
	}
}
