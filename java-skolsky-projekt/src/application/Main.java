package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
	@FXML
	private Button	BSwitch;
	@FXML
	private Button	BRouter;
	@FXML
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

	void switchScene(int param, ActionEvent event) throws IOException {
		if (param == 1) {

			Parent root = FXMLLoader.load(getClass().getResource(
					"RouterWindow.fxml"));

			root.getStylesheets().add("RouterWindow.css");

			Scene scene = new Scene(root);

			Stage stage = (Stage) ((Node) event.getSource()).getScene()
					.getWindow();

			stage.hide();
			stage.setScene(scene);
			stage.show();
		}
		if (param == 2) {

			Parent root = FXMLLoader.load(getClass().getResource(
					"SwitchWindow.fxml"));

			root.getStylesheets().add("SwitchWindow.css");

			Scene scene = new Scene(root);

			Stage stage = (Stage) ((Node) event.getSource()).getScene()
					.getWindow();

			stage.hide();
			stage.setScene(scene);
			stage.show();

		}
	}

	@FXML
	void buttonRouterPressed(ActionEvent event) throws IOException {
		switchScene(1, event);
	}

	@FXML
	void buttonSwitchPressed(ActionEvent event) throws IOException {
		switchScene(2, event);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
