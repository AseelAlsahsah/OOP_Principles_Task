import java.util.*;

public class Artist extends User{
	private String artStyle;
    private boolean approved;
    private List<Artwork> artistArtworks = new ArrayList<>();


    public Artist(int id, String email, String username, String password, String artStyle) {
        super(id, email, username, password);
        this.setArtStyle(artStyle);
        this.setApproved(false);
        this.setRole("Artist");
    }
    
    public Artist() {
    	this(-1,"","","","");
    }
    
    @Override
	public void viewUserInfo() {
		System.out.println("ID: "+getId()+", Email: "+getEmail()+", username: "+getUsername()+", art style: "+artStyle);		
	}
 
    public boolean isApproved() { return approved; }

    public void addArtworkToEvent(int eventId, Artwork artwork) {
    	for(ArtGalleryEvent e : ArtGallerySystem.events)
    		if(e.getId() == eventId)
    			e.addArtwork(artwork);
    }
    
    public void addArtworksToProfile() {
    	Registration.getArtists().get(0).addPainting("Mona Lisa", 1503, 1000000, "Oil Paint");//0
		Registration.getArtists().get(1).addSculpture("David ", 1504, 2000000, 12478, 2.3, 5.17);//1
		Registration.getArtists().get(2).addPainting("The Starry Night", 1889, 3000000, "Oil Paint");//2
		Registration.getArtists().get(2).addPainting("Cafe Terrace at Night", 1888, 3000000, "Oil Paint");//3
    }
    
    public void addPainting(String name, int yearCreated, double price, String description) {
		if(isApproved()) {
			int nextArtworkId = Artwork.getArtworkCounter()+1;
			Painting painting = new Painting(nextArtworkId, name, this, yearCreated, price, description);
			artistArtworks.add(painting);
		}else
          System.out.println("Artist not approved. Cannot add painting.");
	}
	
	public void addSculpture(String name, int yearCreated, double price, double weight, double width, double height) {
		if(isApproved()) {
			int nextArtworkId = Artwork.getArtworkCounter()+1;
			Sculpture sculpture = new Sculpture(nextArtworkId, name, this, yearCreated, price, weight, width, height);
			artistArtworks.add(sculpture);
		}else
          System.out.println("Artist not approved. Cannot add sculpture.");
	}

    public void viewArtistArtworks() {
    	if(this.isApproved()) {
	    	System.out.println("\n"+getUsername()+"'s All Artworks:");
	        for (Artwork artwork : artistArtworks) 
	            System.out.println(artwork.getTitle());
    	}
    }
    
    public void removeArtWork(int artworkId) {
    	artistArtworks.removeIf((Artwork a) -> a.getId() == artworkId);
	}
    
    public void viewArtGalleryEvents(List<ArtGalleryEvent> events) {
        System.out.println("Artist " + getUsername() + " is viewing art gallery events:");
        for (ArtGalleryEvent event : events)
            System.out.println(event.getEventName());
    }

    public void enrollInEvent(int eventId) {
        for(ArtGalleryEvent event : ArtGallerySystem.events)
    		if(event.getId() == eventId)
    			event.enrollArtist(this);
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

	public String getArtStyle() {
		return artStyle;
	}

	public void setArtStyle(String artStyle) {
		this.artStyle = artStyle;
	}

	public List<Artwork> getArtistArtworks() {
		return artistArtworks;
	}
}


