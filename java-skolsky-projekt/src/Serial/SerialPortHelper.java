package Serial;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;

public class SerialPortHelper {
	private static SerialPortHelper	port;

	public static SerialPortHelper getInstance() {
		if (port == null)
			port = new SerialPortHelper();
		return port;
	}

	protected SerialPort			serialPort;
	protected static final int		TIME_OUT	= 2000;
	protected static final int		DATA_RATE	= 9600;
	protected static BufferedReader	input;
	protected static OutputStream	output;
	protected String				name;

	public void openPort(String name) {
		try {
			CommPortIdentifier portId = null;

			Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

			// First, Find an instance of serial port as set in PORT_NAMES.
			while (portEnum.hasMoreElements()) {
				CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

				if (currPortId.getName() == name) {
					portId = currPortId;
					this.name = name;
					break;
				}
			}

			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

			// set port parameters
			serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

			// open the streams
			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			output = serialPort.getOutputStream();
			/*
			 * char ch = 1; output.write(ch);
			 */

			// add event listeners serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
			System.out.println(portId.getCurrentOwner());
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	protected void close() {
		if (input != null)
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (output != null)
			try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (serialPort != null)
			serialPort.close();
	}

	public static boolean opened() {
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		// First, Find an instance of serial port as set in PORT_NAMES.
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			if (port == null) {
				return false;
			}
			if (currPortId.getName() == port.name) {
				portId = currPortId;
				break;
			}
		}
		return "Serial.SerialPortHelper" == portId.getCurrentOwner();
	}

	protected void sendMessage(String message) {
		try {
			output.write(message.getBytes(Charset.forName("UTF-8")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getName() {
		return port.name;
	}

	public static void disconnect() {
		port.close();
	}

	public static void send(String message) {
		if (opened()) {
			port.sendMessage(message);
		}
	}
}
