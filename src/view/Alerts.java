package view;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

@SuppressWarnings("restriction")
public class Alerts {

	protected Alert exitProgramAlert() {
		Alert alert = new Alert(AlertType.INFORMATION, "Are you sure that you want to quit?", ButtonType.YES,
				ButtonType.CANCEL);
		alert.setTitle("Closing Program");
		alert.setHeaderText("Information will not be saved automatically!");
		Optional<ButtonType> result = alert.showAndWait();

		if (result.get() == ButtonType.YES) {
			System.exit(0);
		}

		return alert;
	}
	
	protected Alert loginFailedAlert() {
		Alert alert = new Alert(AlertType.INFORMATION, "Login information was not correct.\nPlease verify user login details.", ButtonType.OK,
				ButtonType.CANCEL);
		alert.setTitle("Incorrect Login");
		alert.setHeaderText("Login failed");
		Optional<ButtonType> result = alert.showAndWait();

		if (result.get() == ButtonType.OK) {
			alert.close();
		}

		return alert;
	}
	

	protected Alert directoryPathNotFound() {
		Alert alert = new Alert(AlertType.INFORMATION, "Unable to find the directory containing the testing files"
				+ "\nPlease select the directory containing the files, or create a new directory.", ButtonType.OK,
				ButtonType.CANCEL);
		alert.setTitle("No Directory Path");
		alert.setHeaderText("Unable to locate Test Generator directory");
		Optional<ButtonType> result = alert.showAndWait();

		if (result.get() == ButtonType.CANCEL) {			
			 alert = new Alert(AlertType.INFORMATION, "Unable to start program. Please select a directory.");
			 alert.setTitle("Closing Program");
			 alert.setHeaderText("Directory Required");
			 alert.showAndWait();
			System.exit(0);
		}

		return alert;
	}
}
