package view;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import controller.QuestionController;
import controller.QuizController;
import controller.ReadAndWrite;
import controller.UserController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.geometry.HPos;
import javafx.geometry.Insets;


@SuppressWarnings("restriction")
public class MainGUI extends Application {

	public static final int SCENE_WIDTH = 1280;
	public static final int SCENE_HEIGHT = 800;
	public static String directoryPath;
	
	Stage stage;
	BorderPane pane;
	Alerts alert;
	QuizController quizController;
	QuestionController questionController;
	UserController userController;
	ReadAndWrite readAndWrite;
	
	public MainGUI() {
		stage = new Stage();
		pane = new BorderPane();
		alert = new Alerts();
		quizController = new QuizController();
		questionController = new QuestionController();
		userController = new UserController();
		readAndWrite = new ReadAndWrite();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		if (directoryPath == null) {
			this.alert.directoryPathNotFound();
			launchDirectoryChooser();

		}
		
		if (showLoginScreen()) {
			this.stage = primaryStage;
			VBox box = new VBox(10);
			box.getChildren().addAll(createMenuBar());
			Label label = new Label();
			label.setText("Testing Application\nBrentonHaliw\nbrenton.haliw@gmail.com\nVersion 1.0\nJuly 24, 2020");
			this.pane.setTop(box);
			this.pane.setCenter(label);

			Scene scene = new Scene(this.pane, SCENE_WIDTH, SCENE_HEIGHT);
			stage.setTitle("Test Generator");
			stage.setScene(scene);
			stage.show();
		}


	}	

	public MenuBar createMenuBar() {
		MenuBar menuBar = new MenuBar();

		Menu file = new Menu("File");
		MenuItem save = new MenuItem("Save");
		MenuItem saveAs = new MenuItem("Save As...");
		
		Menu edit = new Menu("Edit");
		MenuItem exit = new MenuItem("Exit");
		MenuItem editGUI = new MenuItem("Edit GUI");

		Menu credits = new Menu("Credits");

		menuBar.getMenus().addAll(file, edit, credits);
		file.getItems().addAll(save, saveAs, exit);
		edit.getItems().addAll(editGUI);

		save.setOnAction(e -> {
			if (directoryPath == null) {
				launchDirectoryChooser();
			}
		});

		saveAs.setOnAction(e -> {

		});

		exit.setOnAction(e -> {
			this.alert.exitProgramAlert();

		});

		return menuBar;
	}
	
	/**
	 * The login screen is the first screen to appear to the user. The user will enter
	 * their login information, select their role (user or administrator) and then 
	 * click login. Their credentials will then be verified against the database.
	 * @return true if user login information is authenticated, false if not
	 */
	private boolean showLoginScreen() {
		Stage loginStage = new Stage();
		GridPane gp = new GridPane();
		gp.setPadding(new Insets(20));
		gp.setHgap(25);
		gp.setVgap(15);
		
		
		Label enterInfoLabel = new Label("Please enter your username and password.");
		Label userNameLabel = new Label("Username");
		TextField usernameField = new TextField();
		Label passwordLabel = new Label("Password");
		PasswordField passwordField = new PasswordField();
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().addAll("User", "Administrator");
		choiceBox.getSelectionModel().selectFirst();
		Button loginButton = new Button("Login");
		Button createAccount = new Button("Create New Account");
		Button forgotAccount = new Button("Forgot Account Info");
		HBox loginBox = new HBox(10);
		loginBox.getChildren().addAll(choiceBox, loginButton);
		
		gp.add(enterInfoLabel, 0, 0, 2, 1);
		
		GridPane.setHalignment(userNameLabel, HPos.RIGHT);
		GridPane.setHalignment(passwordLabel, HPos.RIGHT);
		GridPane.setHalignment(usernameField, HPos.LEFT);
		GridPane.setHalignment(passwordField, HPos.LEFT);
		GridPane.setHalignment(loginBox, HPos.RIGHT);
		
		gp.add(userNameLabel, 0, 1);
		gp.add(passwordLabel, 0, 2);
		gp.add(usernameField, 1, 1);
		gp.add(passwordField, 1, 2);
		gp.add(loginBox, 1, 3);
		
		Scene scene = new Scene(gp, 400, 200);
		loginStage.setScene(scene);
		loginStage.setTitle("Login");
		loginStage.show();
		return true;
	}

	public void launchDirectoryChooser() {
		Stage stage = new Stage();

		DirectoryChooser chooser = new DirectoryChooser();
		chooser.setTitle("Select or create a folder");
		stage.setAlwaysOnTop(true);

		File directory = chooser.showDialog(stage);

		if (directory == null) {
			System.out.println("User backed out without selecting a directory");
			return;
		}

		File filePath = new File(directory.getAbsolutePath());
		directoryPath = filePath.getAbsolutePath();
		if (!filePath.exists()) {
			try {
				Files.createDirectories(Paths.get(directoryPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public VBox loginScreen() {
		VBox mainVBox = new VBox(10);
		mainVBox.setAlignment(Pos.CENTER);
		
		HBox userNameBox = new HBox(10);
		Label userNameLabel = new Label("User Name:");
		TextField userNameField = new TextField();
		userNameBox.getChildren().addAll(userNameLabel, userNameField);
		userNameBox.setAlignment(Pos.CENTER);
		
		HBox passwordBox = new HBox(10);
		Label passwordLabel = new Label("Password:");
		PasswordField passwordField = new PasswordField();
		passwordBox.getChildren().addAll(passwordLabel, passwordField);
		passwordBox.setAlignment(Pos.CENTER);
		
		HBox choiceAndLogin = new HBox(10);
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().addAll("User", "Administrator");
		choiceBox.getSelectionModel().selectFirst();
		Button loginButton = new Button("Login");
		choiceAndLogin.getChildren().addAll(choiceBox, loginButton);
		choiceAndLogin.setAlignment(Pos.CENTER);
		
		HBox accountInfoBox = new HBox(10);
		Button createAccount = new Button("Create New Account");
		Button forgotAccount = new Button("Forgot Account Info");
		accountInfoBox.getChildren().addAll(createAccount, forgotAccount);
		accountInfoBox.setAlignment(Pos.CENTER);
		
		mainVBox.getChildren().addAll(userNameBox, passwordBox, choiceAndLogin, accountInfoBox);
		
		return mainVBox;
		
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
}
