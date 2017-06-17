import org.apache.commons.net.telnet.TelnetClient;

import java.io.InputStream;
import java.io.PrintStream;
public class telenet {
	public static InputStream in;
	public static PrintStream out;

	public static void send(String s, String type) throws InterruptedException {
		TelnetClient telnet;
		telnet = new TelnetClient();
		try {
			telnet.connect("192.168.1.224");
			in = telnet.getInputStream();
			out = new PrintStream(telnet.getOutputStream());
			readUntil(":-)\r\n");
			if (type.equals("ps")){
				s=("PS_TEXT="+s);
			}else{
				s=("RT_TEXT="+s);
			}
			System.out.println(s);
			out.println(s);
			out.flush();
			in.read();
			telnet.disconnect();
		} catch (Exception e) {
			System.out.println("oops");
		}
	}

	public static String readUntil(String pattern) {
		try {
			char lastChar = pattern.charAt(pattern.length() - 1);
			StringBuffer sb = new StringBuffer();
			char ch = (char) in.read();
			while (true) {
				sb.append(ch);
				if (ch == lastChar) {
					if (sb.toString().endsWith(pattern)) {
						return sb.toString();
					}
				}
				ch = (char) in.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
