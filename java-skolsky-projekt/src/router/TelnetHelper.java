package router;

public class TelnetHelper {

	protected boolean	login;
	protected boolean	logging_synchronouse;
	protected String	password;

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public boolean isLogging_synchronouse() {
		return logging_synchronouse;
	}

	public void setLogging_synchronouse(boolean logging_synchronouse) {
		this.logging_synchronouse = logging_synchronouse;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
