package router;

import Serial.SerialPortHelper;

public class FastEthernetHelper {

	protected String ipAddress;
	protected int mask_prefix;
	protected String mask;
	protected boolean no_shutdown;
	protected String name;

	public FastEthernetHelper(String number) {
		name = "fa" + number;
	}

	public String getIp_address() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getMask_prefix() {
		return mask_prefix;
	}

	public void setMask_prefix(int mask_prefix) {
		this.mask_prefix = mask_prefix;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public boolean isNo_shutdown() {
		return no_shutdown;
	}

	public void setNo_shutdown(boolean no_shutdown) {
		this.no_shutdown = no_shutdown;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void send(RouterHelper router) {
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("end");
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("exit");
		SerialPortHelper.sendln("");

		router.login(2);

		SerialPortHelper.sendln("line console 0");
		SerialPortHelper.sendln("ip add " + ipAddress + " " + maska());

		if (no_shutdown) {
			SerialPortHelper.sendln("no shutdown");
		} else {
			SerialPortHelper.sendln("shutdown");
		}
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("end");
		SerialPortHelper.sendln("");
		SerialPortHelper.sendln("exit");
		SerialPortHelper.sendln("");
	}

	private String maska() {
		if (mask != null && !mask.isEmpty())
			return mask;

		String[] res = new String[4];

		res[0] = "0";
		res[1] = "0";
		res[2] = "0";
		res[3] = "0";

		if (mask_prefix>24){
		    res[0] = "255";
		    res[1] = "255";
		    res[2] = "255";
		    res[3] = Integer.toString((int)Math.pow(2, mask_prefix-32) -1);
		}
		else if (mask_prefix>16){
		    res[0] = "255";
		    res[1] = "255";
		    res[2] = Integer.toString((int)Math.pow(2, mask_prefix-16) -1);
		    res[3] = "0";
		}
		else if (mask_prefix>8){
		    res[0] = "255";
		    res[1] = Integer.toString((int)Math.pow(2, mask_prefix-8) -1);
		    res[2] = "0";
		    res[3] = "0";
		}
		else {

		    res[0] = Integer.toString((int)Math.pow(2, mask_prefix) -1);
		    res[1] = "0";
		    res[2] = "0";
		    res[3] = "0";
		}
		return res[0] + "." + res[1] + "." + res[2] + "." + res[3];


	}
}
