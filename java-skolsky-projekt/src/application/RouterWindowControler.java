package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Serial.SerialPortHelper;

public class RouterWindowControler {

	@FXML
	private Button			RefreshButton;

	@FXML
	private PasswordField	passwordField;

	@FXML
	private TextField		textField;

	@FXML
	void Button_click_refresh(ActionEvent event) throws IOException {
		System.out.println("skuska");
		SerialPortHelper.send("skuska");
		System.out.println(passwordField.getText());

		String a = passwordField.getText();
		passwordField.clear();
		passwordField.setPromptText(a);
	}
}
