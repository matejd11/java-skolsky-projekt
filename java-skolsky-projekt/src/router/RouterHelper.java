package router;

public class RouterHelper {

	protected ConsoleHelper	console;
	protected TelnetHelper	telnet;

	public RouterHelper() {
		console = new ConsoleHelper();
		telnet = new TelnetHelper();
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

}
