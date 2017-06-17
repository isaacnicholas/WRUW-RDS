
public class metadata {
	public String artist;
	public String title;
	public String show;

	public metadata(String a, String t, String s) {
		artist = a;
		title = t;
		show = s;

	}
	public metadata(){
		artist="";
		title="";
		show="";
	}
	public boolean compare(metadata m2){
	if(artist.equals(m2.artist)==false)
		return false;
	if(title.equals(m2.title)==false)
		return false;
	if(show.equals(m2.show)==false)
		return false;
	return true;
	}
	}
