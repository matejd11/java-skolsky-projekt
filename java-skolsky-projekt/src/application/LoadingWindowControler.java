package application;

import gnu.io.CommPortIdentifier;

import java.io.IOException;
import java.util.Enumeration;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import Serial.SerialPortHelper;

public class LoadingWindowControler {
	@FXML
	ComboBox<String>	ListOfCom;

	@FXML
	protected void initialize() {
		ButtonRefreshClicked(null);
	}

	@FXML
	void ButtonRefreshClicked(ActionEvent event) {
		ListOfCom.getItems().remove(0, ListOfCom.getItems().size());
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		// First, Find an instance of serial port as set in PORT_NAMES.
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			ListOfCom.getItems().add(currPortId.getName());
		}
		ListOfCom.getSelectionModel().select(0);
	}

	@FXML
	void ButtonConnectClicked(ActionEvent event) throws IOException {
		SerialPortHelper.getInstance().openPort(ListOfCom.getSelectionModel().getSelectedItem().toString());

		if (SerialPortHelper.opened()) {
			System.out.println("yes");

			Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));

			root.getStylesheets().add("MainWindow.css");

			Scene scene = new Scene(root);

			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();

		}
	}

	@FXML
	void closeCommand(ActionEvent event) throws IOException {
		Main.close();
	}
}
