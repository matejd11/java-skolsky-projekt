package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindowControler {

	@FXML
	private Button	BSwitch;
	@FXML
	private Button	BRouter;

	void switchScene(int param, ActionEvent event) throws IOException {
		if (param == 1) {
			/*
			 * Parent root =
			 * FXMLLoader.load(getClass().getResource("RouterWindow.fxml"));
			 * 
			 * root.getStylesheets().add("RouterWindow.css");
			 * 
			 * Scene scene = new Scene(root);
			 * 
			 * Stage stage = (Stage) ((Node)
			 * event.getSource()).getScene().getWindow();
			 * 
			 * stage.setResizable(false); stage.hide(); stage.setScene(scene);
			 * stage.show();
			 */

			Stage stage = new Stage();
			stage.setTitle("Router");
			Pane myPane = FXMLLoader.load(getClass().getResource("RouterWindow.fxml"));
			myPane.getStylesheets().add("RouterWindow.css");
			Scene scene = new Scene(myPane);
			stage.setScene(scene);

			stage.show();
		}
		if (param == 2) {

			/*
			 * Parent root =
			 * FXMLLoader.load(getClass().getResource("SwitchWindow.fxml"));
			 * 
			 * root.getStylesheets().add("SwitchWindow.css");
			 * 
			 * Scene scene = new Scene(root);
			 * 
			 * Stage stage = (Stage) ((Node)
			 * event.getSource()).getScene().getWindow();
			 * 
			 * stage.setResizable(false); stage.hide(); stage.setScene(scene);
			 * stage.show();
			 */

			Stage stage = new Stage();
			stage.setTitle("Switch");
			Pane myPane = null;
			myPane = FXMLLoader.load(getClass().getResource("SwitchWindow.fxml"));
			Scene scene = new Scene(myPane);
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

	@FXML
	void closeCommand(ActionEvent event) throws IOException {
		Main.close();
	}

}
