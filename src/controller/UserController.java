package controller;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

import model.Test;
import model.User;

public class UserController {

	public static String userDatabase;
	private HashMap<String, User> users;

	public UserController(HashMap<String, User> users, String path) {
		this.users = users;
		userDatabase = path;
	}
	
	public User getUser(String name) {
		if (users.containsKey(name)) {
			return users.get(name);
		} else {
			System.out.println(name + " is not in the database.");
			return null;
		}
	} 

	/**
	 * Creates a user to be added to the database.
	 * @param name
	 * @param password
	 * @param roles
	 * @return true if successfully added, false if already exists
	 * @throws UnsupportedEncodingException
	 */
	public boolean createUser(String name, String password, ArrayList<String> roles)
			throws UnsupportedEncodingException {

		String encryptedPassword = encryptThisString(password);
		User user = new User(name, encryptedPassword, new ArrayList<Test>(), roles);
		if (users.containsKey(name)) {
			System.out.println(name + " already exists in the database.");
			return false;
		} else {
			users.put(name, user);
			return true;
		}
	}

	/**
	 * Removes a user from the database.
	 * @param name
	 * @return true if successfully removed, false if user didn't exist
	 */
	public boolean removeUser(String name) {
		if (users.containsKey(name)) {
			users.remove(name);
			return true;
		} else {
			System.out.println(name + " is not in the database.");
			return false;
		}
	}

	/**
	 * Utilizes SHA-1 hashing to encrypt the user's password.
	 * @param input
	 * @return encrypted string
	 * @throws UnsupportedEncodingException
	 */
	private String encryptThisString(String input) throws UnsupportedEncodingException {
		try {
			// getInstance() method is called with algorithm SHA-1
			MessageDigest md = MessageDigest.getInstance("SHA-1");

			// digest() method is called
			// to calculate message digest of the input string
			// returned as array of byte
			byte[] messageDigest = md.digest(input.getBytes("UTF-8"));

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			String hashtext = no.toString(16);

			// Add preceding 0s to make it 32 bit
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

			// return the HashText
			return hashtext;
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Checks to see if the given username, password, and role match what's in the
	 * database.
	 * 
	 * @param username
	 * @param password
	 * @param role
	 * @return true if successfully authenticated, false if something didn't match
	 * @throws UnsupportedEncodingException
	 */
	public boolean authenticateUserLogin(String username, String password, String role)
			throws UnsupportedEncodingException {
		if (users.containsKey(username)) {
			User user = users.get(username);
			String encryptedString = encryptThisString(password);
			if (encryptedString.equals(user.getPassword())) {
				if (user.getRoles().contains(role)) {
					System.out.println("Login successful!");
					return true;
				} else {
					System.out.println(user.getUserName() + " does not have the role: " + role);
					return false;
				}
			} else {
				System.out.println("Username/Password combination is incorrect.");
				return false;
			}
		} else {
			System.out.println("Username/Password combination is incorrect.");
			return false;
		}
	}
}
