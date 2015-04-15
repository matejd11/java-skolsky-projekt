package Serial;

import gnu.io.SerialPort;

import java.io.BufferedReader;
import java.io.OutputStream;

public class SerialPortHelper {
	private static SerialPortHelper	port;

	public static SerialPortHelper getInstance() {
		if (port == null)
			port = new SerialPortHelper();
		return port;
	}

	public SerialPort				serialPort;
	public static final int			TIME_OUT	= 2000;
	public static final int			DATA_RATE	= 9600;
	public static BufferedReader	input;
	public static OutputStream		output;
}
