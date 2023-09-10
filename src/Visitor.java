import java.util.*;

public class Visitor extends User{
	
	public Visitor(int id, String email, String username, String password) {
        super(id, email, username, password);
        this.setRole("Visitor");
    }
	
	public Visitor() {
        this(-1, "", "", "");
    }
	
    public void viewArtGalleryEvents(List<ArtGalleryEvent> events) {
        for (ArtGalleryEvent event : events)
            System.out.println("Name: "+event.getEventName());
    }

    public void enrollInEvent(int eventId) {
    	for(ArtGalleryEvent event : ArtGallerySystem.events)
    		if(event.getId() == eventId)
    			event.enrollVisitor(this);
    }
	
	public void buyArtwork(Artwork artwork) {
		if (artwork.isSold()) {
			System.out.println("Artwork is already sold");
	    } else {
	        artwork.setBuyer(this);
	        System.out.println("You have successfully purchased " + artwork.getTitle());
	    }
    }
	
	public void viewEventArtworks(ArtGalleryEvent event) {
		System.out.println("\nAll "+event.getEventName()+" artworks:");
    	if(!event.getEventArtworks().isEmpty()) {
    		System.out.println("Sculptures: ");
	    	for(Artwork a : event.getEventArtworks())
		    	if(a instanceof Sculpture) {
		    		a.displayInfo();
		    		System.out.println();
		    	}
	   
	    	System.out.println("\nPaintings: ");
		    for(Artwork a : event.getEventArtworks()) 
		    	if(a instanceof Painting) { 
		    		a.displayInfo();
		    		System.out.println();
		    	}
		    
    	}else System.out.println("No artworks are added here.");
    }
}
