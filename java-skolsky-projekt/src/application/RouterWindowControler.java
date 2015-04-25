package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RouterWindowControler {
	@FXML
	private Button			sendRIPButton;
	@FXML
	private TextField		S001_MASK;
	@FXML
	private PasswordField	loginConsolePassword;
	@FXML
	private TextField		FA01_MASK;
	@FXML
	private Button			sendFA00Button;
	@FXML
	private CheckBox		ripVersion2CheckBox;
	@FXML
	private CheckBox		FA01NoShCheckBox;
	@FXML
	private PasswordField	enablePasswordField;
	@FXML
	private CheckBox		FA00NoShCheckBox;
	@FXML
	private CheckBox		dnsLookupCheckBox;
	@FXML
	private PasswordField	telnetPasswordField;
	@FXML
	private Button			sendHostNameButton;
	@FXML
	private Button			refreshButton;
	@FXML
	private Button			sendFA01Button;
	@FXML
	private CheckBox		includeS000CheckBox;
	@FXML
	private Button			sendS000Button;
	@FXML
	private CheckBox		includeS001CheckBox;
	@FXML
	private CheckBox		telnetLSCheckBox;
	@FXML
	private Button			sendConsoleButton;
	@FXML
	private PasswordField	consolePasswordField;
	@FXML
	private CheckBox		S001NoShCheckBox;
	@FXML
	private CheckBox		consoleLoginCheckBox;
	@FXML
	private TextField		S001_IP_AD;
	@FXML
	private TextField		FA00_MASK;
	@FXML
	private CheckBox		consoleLSCheckBox;
	@FXML
	private TextField		S000_IP_ADD;
	@FXML
	private CheckBox		S000NoShCheckBox;
	@FXML
	private Button			sendS001Button;
	@FXML
	private TextField		hostnameField;
	@FXML
	private CheckBox		cdpCheckBx;
	@FXML
	private TextField		S000_MASK;
	@FXML
	private PasswordField	loginEnablePasswordField;
	@FXML
	private Button			sendTelnetButton;
	@FXML
	private CheckBox		includeFA01CheckBox;
	@FXML
	private Button			sendEnablePasswordButton;
	@FXML
	private CheckBox		telnetLoginCheckBox;
	@FXML
	private TextField		FA00_IP_ADD;
	@FXML
	private CheckBox		includeFA00CheckBox;
	@FXML
	private TextField		FA01_IP_ADD;

	@FXML
	void Button_click_refresh(ActionEvent event) {

	}

	@FXML
	void sendHostName(ActionEvent event) {

	}

	@FXML
	void sendEnablePassword(ActionEvent event) {

	}

	@FXML
	void sendConsole(ActionEvent event) {

	}

	@FXML
	void sendTelnet(ActionEvent event) {

	}

	@FXML
	void sendFA00(ActionEvent event) {

	}

	@FXML
	void sendFA01(ActionEvent event) {

	}

	@FXML
	void sendS000(ActionEvent event) {

	}

	@FXML
	void sendS001(ActionEvent event) {

	}

	@FXML
	void sendRIP(ActionEvent event) {

	}

}
