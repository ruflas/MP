
public class Cancion {
	private String title,artist;
	
	public Cancion(String title,String artist) {
		this.setTitle(title);
		this.setArtist(artist);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
}
