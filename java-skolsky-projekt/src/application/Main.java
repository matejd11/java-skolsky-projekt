package application;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@FXML
	private Stage	primaryStage;

	@Override
	public void start(Stage stage) {
		try {

			// SKUSKA MATEJ oprava
			primaryStage = stage;

			Parent root = FXMLLoader.load(getClass().getResource(
					"MainWindow.fxml"));
			root.getStylesheets().add("MainWindow.css");

			Scene scene = new Scene(root, 300, 275);
			primaryStage.setResizable(false);

			primaryStage.setTitle("Selfienator");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
