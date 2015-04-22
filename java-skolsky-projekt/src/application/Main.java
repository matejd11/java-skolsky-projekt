package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import Serial.SerialPortHelper;

public class Main extends Application {
	@FXML
	private Stage	primaryStage;

	@Override
	public void start(Stage stage) {
		try {

			primaryStage = stage;

			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent e) {
					SerialPortHelper.disconnect();
					Platform.exit();
					System.exit(0);
				}
			});

			// Parent root =
			// FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			// root.getStylesheets().add("MainWindow.css");
			/*
			 * Parent root =
			 * FXMLLoader.load(getClass().getResource("LoadingWindow.fxml"));
			 * 
			 * Scene scene = new Scene(root); primaryStage.setResizable(false);
			 * 
			 * primaryStage.setTitle("Selfienator");
			 * primaryStage.setScene(scene); primaryStage.show();
			 */
			/*
			 * FXMLLoader myLoader = new
			 * FXMLLoader(getClass().getResource("createProduct.fxml"));
			 * 
			 * Pane myPane = (Pane) myLoader.load();
			 */
			// CreateProductController controller = (CreateProductController)
			// myLoader.getController();

			// controller.setPrevStage(primaryStage);

			Parent root = FXMLLoader.load(getClass().getResource("LoadingWindow.fxml"));
			Scene myScene = new Scene(root);
			primaryStage.setTitle("Loading");
			primaryStage.setResizable(false);
			primaryStage.setScene(myScene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void close() {
		Platform.exit();
		System.exit(0);
	}

}
