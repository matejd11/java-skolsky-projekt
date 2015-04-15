package Serial;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

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
	public String					name;

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
			char ch = 1;
			output.write(ch);

			// add event listeners serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
			System.out.println(portId.getCurrentOwner());
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	public static boolean opened() {
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		// First, Find an instance of serial port as set in PORT_NAMES.
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

			if (currPortId.getName() == port.name) {
				portId = currPortId;
				break;
			}
		}
		return "Serial.SerialPortHelper" == portId.getCurrentOwner();
	}

	public static void disconnect() {
		port.serialPort.close();
	}
}
