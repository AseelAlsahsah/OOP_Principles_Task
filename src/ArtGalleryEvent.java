import java.time.LocalDate;
import java.util.*;

public class ArtGalleryEvent{
	private LocalDate date;
    private String description;
    private String location;
    private Entity entity;
    private ArrayList<Artwork> artworks = new ArrayList<>();
    private ArrayList<Visitor> visitors = new ArrayList<>();
    
    public ArtGalleryEvent(int id, String name, LocalDate date, String description, String location) {
    	entity = new Entity(id, name);
    	this.date = date;
    	this.description = description;
    	this.location = location;
    }
    
    public ArtGalleryEvent() {
    	entity = new Entity();
    	this.date = LocalDate.now();
    	this.description = "";
    	this.location = "";
    }

    public ArrayList<Artwork> getArtworks() { return artworks; }
    public ArrayList<Visitor> getVisitors() { return visitors; }
    
	public Entity getEntity() { return entity; }
	
	public LocalDate getDate() { return date; }
	public void setDate(LocalDate date) { this.date = date; }

	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }

	public String getLocation() { return location; }
	public void setLocation(String location) { this.location = location; }
	
	public String viewEventInfo() {
    	return "Event name: "+getEntity().getName()+", Date: "+date+", Description: "+description+", Location: "+location;
    }
	
	public void addArtWork(Artwork artwork) {
		artworks.add(artwork);
	}
	
	public void addVisitor(Visitor visitor) {
		visitors.add(visitor);
	}
	
	public void removeArtWork(int artworkId) {
		artworks.removeIf(a -> a.getEntity().getId() == artworkId);
	}

	public void removeVisitor(int visitorId) {
		visitors.removeIf(v -> v.getEntity().getId() == visitorId);
	}
}