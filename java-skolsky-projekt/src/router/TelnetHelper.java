package router;

import Serial.SerialPortHelper;

public class TelnetHelper {

	protected boolean	login;
	protected boolean	logging_synchronous;
	protected String	password;

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public boolean isLogging_synchronouse() {
		return logging_synchronous;
	}

	public void setLogging_synchronous(boolean logging_synchronous) {
		this.logging_synchronous = logging_synchronous;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void send(RouterHelper router) {
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("end");
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("exit");
		SerialPortHelper.sendln("");

		router.login(2);

		SerialPortHelper.sendln("line vty 0 15");
		SerialPortHelper.send("password ");
		SerialPortHelper.sendln(password);
		if (login) {
			SerialPortHelper.sendln("login");
		} else {
			SerialPortHelper.sendln("no login");
		}
		if (logging_synchronous) {
			SerialPortHelper.sendln("logging synchronous");
		} else {
			SerialPortHelper.sendln("no logging synchronous");
		}
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("end");
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("exit");
		SerialPortHelper.sendln("");
	}
}
