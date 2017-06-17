import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class webscraper {

	public static metadata getname() throws IOException {
		URL url;
		BufferedReader br;
		InputStream is = null;
		String line;
		StringBuilder artist = new StringBuilder();
		StringBuilder title = new StringBuilder();
		StringBuilder show = new StringBuilder();
		try {
			url = new URL("https://wruw.org");
			is = url.openStream();
			br = new BufferedReader(new InputStreamReader(is));
			for (int i = 0; i < 89; i++)
				line = br.readLine();
			line = br.readLine();
			int l = 78;
			while (line.charAt(l) != '<') {
				artist.append(line.charAt(l));
				++l;
			}
			line = br.readLine();
			l = 74;
			while (line.charAt(l) != '<') {
				title.append(line.charAt(l));
				++l;
			}
			for (int i = 0; i < 2; i++)
				br.readLine();
			line = br.readLine();
			l = 80;
			while (line.charAt(l) != '>')
				++l;
			++l;
			while (line.charAt(l) != '<') {
				show.append(line.charAt(l));
				++l;
			}
			metadata m = new metadata(fixchars(artist.toString()), fixchars(title.toString()), fixchars(show.toString()));
			return m;

		} catch (IOException e) {
			metadata m = new metadata();
			return m;
		}
	}

	public static String fixchars(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '&' && s.charAt(i + 1) == '#' && s.charAt(i + 2) == '8' && s.charAt(i + 3) == '2'
					&& s.charAt(i + 4) == '1' && s.charAt(i + 5) == '7' && s.charAt(i+6)==';') {
				sb.append('\'');
				i = i + 6;
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	// &#8217;

}
