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
		ListOfCom.getItems().remove(0, ListOfCom.getItems().size());
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		// First, Find an instance of serial port as set in PORT_NAMES.
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			ListOfCom.getItems().add(currPortId.getName());
		}
	}

	@FXML
	void ButtonConnectClicked(ActionEvent event) {
		/*
		 * try { CommPortIdentifier portId = null;
		 * 
		 * Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
		 * 
		 * // First, Find an instance of serial port as set in PORT_NAMES. while
		 * (portEnum.hasMoreElements()) { CommPortIdentifier currPortId =
		 * (CommPortIdentifier) portEnum .nextElement(); if
		 * (currPortId.getName() == ListOfCom.getSelectionModel()
		 * .getSelectedItem()) { portId = currPortId; break; } }
		 * 
		 * // open serial port, and use class name for the appName. serialPort =
		 * (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);
		 * 
		 * // set port parameters serialPort.setSerialPortParams(DATA_RATE,
		 * SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
		 * SerialPort.PARITY_NONE);
		 * 
		 * // open the streams input = new BufferedReader(new InputStreamReader(
		 * serialPort.getInputStream())); output = serialPort.getOutputStream();
		 * char ch = 1; output.write(ch);
		 * 
		 * // add event listeners serialPort.addEventListener(this);
		 * serialPort.notifyOnDataAvailable(true); } catch (Exception e) {
		 * System.err.println(e.toString()); }
		 */
	}
}
