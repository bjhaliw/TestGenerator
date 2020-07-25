package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.User;

public class UserController {

	private static String userDatabase;
	private HashMap<String, User> users;
	
	public void createUser(String name, String password, ArrayList<String> roles) {
		
	}
	
	public boolean authenticateUserLogin(String username, String password, String role) {
		
		return false;
	}
}
