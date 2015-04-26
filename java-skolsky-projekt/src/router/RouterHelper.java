package router;

public class RouterHelper {

	protected ConsoleHelper	console;
	protected TelnetHelper	telnet;
	protected GeneralHelper	general;

	public RouterHelper() {
		console = new ConsoleHelper();
		telnet = new TelnetHelper();
		general = new GeneralHelper();
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

	public void login(int i) {
		if (console.hasPassword()) {
			console.login();
		}
		general.login(i);
	}
}
