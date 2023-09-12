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
		System.out.println("Email: "+getEmail()+", username: "+getUsername()+", art style: "+artStyle);		
	}
 
    public boolean isApproved() { return approved; }

    public void addArtworkToEvent(int eventId, Artwork artwork) {
    	for(ArtGalleryEvent e : ArtGallerySystem.getEvents())
    		if(e.getId() == eventId)
    			e.addArtwork(artwork);
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
        System.out.println("\nArt gallery events:");
        for (ArtGalleryEvent event : events)
            System.out.println(event.getEventName());
    }

    public void enrollInEvent(int eventId) {
        for(ArtGalleryEvent event : ArtGallerySystem.getEvents())
    		if(event.getId() == eventId) {
    			event.enrollArtist(this);
    			System.out.println("\nArtist enrolled in "+event.getEventName()+" successfully");
    		}
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


