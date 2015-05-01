package router;

public class RouterHelper {

	protected ConsoleHelper	console;
	protected TelnetHelper	telnet;
	protected GeneralHelper	general;
	protected FastEthernetHelper fastEthernet00;
	protected FastEthernetHelper fastEthernet01;
	protected SerialHelper serial000;
	protected SerialHelper serial001;
	

	public RouterHelper() {
		console = new ConsoleHelper();
		telnet = new TelnetHelper();
		general = new GeneralHelper();
		fastEthernet00 = new FastEthernetHelper("0/0");
		fastEthernet01 = new FastEthernetHelper("0/1");
		serial000 = new SerialHelper("0/0/0");
		serial001 = new SerialHelper("0/0/1");
	}

	public ConsoleHelper getConsole() {
		return console;
	}

	public void setConsole(ConsoleHelper console) {
		this.console = console;
	}

	public TelnetHelper getTelnet() {
		return telnet;
	}

	public void setTelnet(TelnetHelper telnet) {
		this.telnet = telnet;
	}

	public GeneralHelper getGeneral() {
		return general;
	}

	public void setGeneral(GeneralHelper general) {
		this.general = general;
	}
	

	public FastEthernetHelper getFastEthernet00() {
		return fastEthernet00;
	}

	public void setFastEthernet00(FastEthernetHelper fastEthernet00) {
		this.fastEthernet00 = fastEthernet00;
	}

	public FastEthernetHelper getFastEthernet01() {
		return fastEthernet01;
	}

	public void setFastEthernet01(FastEthernetHelper fastEthernet01) {
		this.fastEthernet01 = fastEthernet01;
	}

	public SerialHelper getSerial000() {
		return serial000;
	}

	public void setSerial000(SerialHelper serial000) {
		this.serial000 = serial000;
	}

	public SerialHelper getSerial001() {
		return serial001;
	}

	public void setSerial001(SerialHelper serial001) {
		this.serial001 = serial001;
	}

	public void login(int i) {
		if (console.hasPassword()) {
			console.login();
		}
		general.login(i);
	}
}
