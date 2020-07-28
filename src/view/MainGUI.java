package view;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import controller.QuestionController;
import controller.TestController;
import controller.ReadAndWrite;
import controller.UserController;
import javafx.application.Application;
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
	TestController testController;
	QuestionController questionController;
	UserController userController;
	ReadAndWrite readAndWrite;

	public MainGUI() {
		stage = new Stage();
		pane = new BorderPane();
		alert = new Alerts();
		testController = new TestController();
		questionController = new QuestionController();
		userController = new UserController();
		readAndWrite = new ReadAndWrite(userController);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		if (directoryPath == null) {
			this.alert.directoryPathNotFound();
			launchDirectoryChooser();

		}
		
		readAndWrite.setMainPath(directoryPath);
		readAndWrite.loadUserDatabase();

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
		showLoginScreen();
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
	 * The login screen is the first screen to appear to the user. The user will
	 * enter their login information, select their role (user or administrator) and
	 * then click login. Their credentials will then be verified against the
	 * database.
	 * 
	 * @return true if user login information is authenticated, false if not
	 */
	private void showLoginScreen() {
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

		
		loginButton.setOnAction(e -> {
			String username = usernameField.getText();
			String password = passwordField.getText();
			String role = choiceBox.getValue();

			try {
				if (userController.authenticateUserLogin(username, password, role)) {
					loginStage.close();
				} else {
					alert.loginFailedAlert();
				}
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		Scene scene = new Scene(gp, 400, 200);
		loginStage.setScene(scene);
		loginStage.setTitle("Login");
		loginStage.show();
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

	public static void main(String[] args) {
		Application.launch(args);

	}
}
