package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage	primaryStage;

	@Override
	public void start(Stage stage) {
		try {
			primaryStage = stage;

			Parent root = FXMLLoader.load(getClass().getResource(
					"MainWindow.fxml"));
			root.getStylesheets().add("MainWindow.css");

			Scene scene = new Scene(root, 300, 275);

			primaryStage.setTitle("Selfienator");
			primaryStage.setScene(scene);

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void switchScene(int param) {
		if (param == 1) {

			try {
				Parent root = FXMLLoader.load(getClass().getResource(
						"RouterWindow.fxml"));

				root.getStylesheets().add("RouterWindow.css");

				Scene scene = new Scene(root, 300, 275);

				primaryStage.setScene(scene);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (param == 2) {

			try {
				Parent root = FXMLLoader.load(getClass().getResource(
						"SwitchWindow.fxml"));

				root.getStylesheets().add("SwitchWindow.css");

				Scene scene = new Scene(root, 300, 275);

				primaryStage.setScene(scene);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void ButtonRouterPressed() {
		switchScene(1);
	}

	void ButtonSwitchPressed() {
		switchScene(2);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
