package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import router.RouterHelper;

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
	private Button			sendGeneralButton;
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

	private RouterHelper	router;

	@FXML
	public void initialize() {
		router = new RouterHelper();
	}

	@FXML
	void Button_click_refresh(ActionEvent event) {

	}

	@FXML
	void sendHostName(ActionEvent event) {
		String hostName = hostnameField.getText();
		router.getGeneral().setHostName(hostName);
		router.getGeneral().sendHostname(router);
	}

	@FXML
	void sendEnablePassword(ActionEvent event) {

	}

	@FXML
	void sendConsole(ActionEvent event) {
		boolean logginsynchronous = consoleLSCheckBox.isSelected();
		router.getConsole().setLogging_synchronous(logginsynchronous);
		boolean login = consoleLoginCheckBox.isSelected();
		router.getConsole().setLogin(login);
		String password = consolePasswordField.getText();
		router.getConsole().setPassword(password);

		router.getConsole().send(router);
	}

	@FXML
	void sendTelnet(ActionEvent event) {
		boolean logginsynchronous = telnetLSCheckBox.isSelected();
		router.getTelnet().setLogging_synchronous(logginsynchronous);
		boolean login = telnetLoginCheckBox.isSelected();
		router.getTelnet().setLogin(login);
		String password = telnetPasswordField.getText();
		router.getTelnet().setPassword(password);

		router.getTelnet().send(router);
	}

	@FXML
	void sendFA00(ActionEvent event) {
		boolean shutdown = FA00NoShCheckBox.isSelected();
		router.getFastEthernet00().setNo_shutdown(shutdown);
		int mask_prefix = Integer.parseInt(FA00_MASK.getText());
		router.getFastEthernet00().setMask_prefix(mask_prefix);
		String ipAddress = FA00_IP_ADD.getText();
		router.getFastEthernet00().setIpAddress(ipAddress);
		
		router.getFastEthernet00().send(router);
	}

	@FXML
	void sendFA01(ActionEvent event) {
		boolean shutdown = FA01NoShCheckBox.isSelected();
		router.getFastEthernet01().setNo_shutdown(shutdown);
		int mask_prefix = Integer.parseInt(FA01_MASK.getText());
		router.getFastEthernet01().setMask_prefix(mask_prefix);
		String ipAddress = FA01_IP_ADD.getText();
		router.getFastEthernet01().setIpAddress(ipAddress);
		
		router.getFastEthernet01().send(router);
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

	@FXML
	void sendGeneral(ActionEvent event) {

	}

}
