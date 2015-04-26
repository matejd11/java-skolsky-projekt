package router;

import Serial.SerialPortHelper;

public class GeneralHelper {
	protected String	hostName;
	protected String	enablePassword;
	protected boolean	dnsLookup;
	protected boolean	cdp;

	public void sendPassword(RouterHelper router) {
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("end");
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("exit");
		SerialPortHelper.sendln("");

		router.login(2);

		SerialPortHelper.send("enable password ");
		SerialPortHelper.sendln(enablePassword);

		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("end");
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("exit");
		SerialPortHelper.sendln("");
	}

	public void sendHostname(RouterHelper router) {
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("end");
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("exit");
		SerialPortHelper.sendln("");

		router.login(2);

		SerialPortHelper.send("hostname ");
		SerialPortHelper.sendln(hostName);

		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("end");
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("exit");
		SerialPortHelper.sendln("");
	}

	public void sendAllGeneral(RouterHelper router) {
		sendHostname(router);
		sendPassword(router);
		sendGeneral(router);
	}

	public void sendGeneral(RouterHelper router) {
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("end");
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("exit");
		SerialPortHelper.sendln("");

		router.login(2);

		if (dnsLookup) {
			SerialPortHelper.sendln("ip domain-lookup");
		} else {
			SerialPortHelper.sendln("no ip domain-lookup");
		}
		if (cdp) {
			SerialPortHelper.sendln("cdp run");
		} else {
			SerialPortHelper.sendln("no cdp run");
		}

		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("end");
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("exit");
		SerialPortHelper.sendln("");
	}

	public void login(int i) {

		if (i >= 1) {
			SerialPortHelper.sendln("enable");
			if (enablePassword != null && !enablePassword.isEmpty()) {
				SerialPortHelper.sendln(enablePassword);
			}
		}
		if (i >= 2) {
			SerialPortHelper.sendln("configure terminal");
		}
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
}
