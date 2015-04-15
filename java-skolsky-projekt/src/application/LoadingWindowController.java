package application;

import gnu.io.CommPortIdentifier;

import java.util.Enumeration;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class LoadingWindowController {
	@FXML
	ComboBox<String>	ListOfCom;

	@FXML
	void ButtonRefreshClicked(ActionEvent event) {
		ListOfCom.getItems().remove(0, ListOfCom.getItems().size() - 1);
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		// First, Find an instance of serial port as set in PORT_NAMES.
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum
					.nextElement();
			ListOfCom.getItems().add(currPortId.getName());
		}
	}

	@FXML
	void ButtonConnectClicked(ActionEvent event) {

	}
}
