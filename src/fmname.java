
public class fmname {
	public static String getName(metadata m) {
		System.out.println("creating naeme");
		if (m.artist.length() + m.title.length() + m.show.length() <= 32 && m.artist.length() > 0
				&& m.title.length() > 0 && m.show.length() > 0)
			return ("Now Playing: " + m.title + " by " + m.artist + " on " + m.show + " on WRUW-FM");
		else if (m.artist.length() + m.title.length() + m.show.length() <= 45 && m.artist.length() > 0
				&& m.title.length() > 0 && m.show.length() > 0)
			return (m.title + " by " + m.artist + " on " + m.show + " on WRUW-FM");
		else if (m.artist.length() + m.title.length() + m.show.length() <= 56 && m.artist.length() > 0
				&& m.title.length() > 0 && m.show.length() > 0)
			return (m.title + " by " + m.artist + " on " + m.show);
		else if (m.artist.length() + m.title.length() <= 60 && m.artist.length() > 0 && m.title.length() > 0)
			return (m.title + " by " + m.artist);
		else if (m.artist.length() + m.show.length() <= 37 && m.artist.length() > 0 && m.show.length() > 0)
			return ("Now Playing: " + m.artist + " on " + m.show + " on WRUW-FM");
		else if (m.artist.length() + m.show.length() <= 50 && m.artist.length() > 0 && m.show.length() > 0)
			return (m.artist + " on " + m.show + " on WRUW-FM");
		else if (m.artist.length() + m.show.length() <= 60 && m.artist.length() > 0 && m.show.length() > 0)
			return (m.artist + " on " + m.show);
		else if (m.title.length() <= 64 && m.title.length() > 0)
			return (m.title.toString());
		else if (m.artist.length() <= 64 && m.artist.length() > 0)
			return (m.artist.toString());
		else if (m.show.length() <= 41 && m.show.length() > 0)
			return ("Now Playing: " + m.show + " on WRUW-FM");
		else if (m.show.length() <= 53 && m.show.length() > 0)
			return (m.show + " on WRUW-FM.");
		else if (m.show.length() <= 64 && m.show.length() > 0)
			return (m.show.toString());
		else
			return ("WRUW-FM: More Music, Fewer Hits.");
	}
}
