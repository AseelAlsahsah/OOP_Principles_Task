import java.time.LocalDate;
import java.util.*;

public class ArtGalleryEvent {
	private int id;
	private Organizer organizer;
    private static int eventCounter = 0;
	private String eventName;
	private LocalDate date;
	private String description;
	private String location;
	private List<Artist> enrolledArtists = new ArrayList<>();
	private List<Visitor> enrolledVisitors = new ArrayList<>();
    private List<Artwork> eventArtworks = new ArrayList<>();

    public ArtGalleryEvent(int id, String eventName, Organizer organizar, LocalDate date, String description, String location) {
        this.setId(id);
    	this.setEventName(eventName);
        this.setDate(date);
        this.setDescription(description);
        this.setLocation(location);
        this.setOrganizer(organizar); 
        setEventsCounter(getEventsCounter()+1);
    }
    
    public ArtGalleryEvent() {
        this(-1, "", null, LocalDate.now(), "", "");
    }
    
    public void viewEventInfo() {
    	System.out.println("Name: "+eventName+"\nDate: "+date+"\nDescription: "+description+"\nLocation: "+location);
    }
    
    public void enrollVisitor(Visitor visitor) {
		enrolledVisitors.add(visitor);
	}
    
	public void enrollArtist(Artist artist) {
		enrolledArtists.add(artist);
	}

    public void addArtwork(Artwork artwork) {
        eventArtworks.add(artwork);
    }
    
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    
    public List<Artwork> getEventArtworks() {
        return eventArtworks;
    }

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Artist> getArtists() {
		return enrolledArtists;
	}

	public List<Visitor> getVisitors() {
		return enrolledVisitors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getEventsCounter() {
		return eventCounter;
	}

	public static void setEventsCounter(int eventsCounter) {
		ArtGalleryEvent.eventCounter = eventsCounter;
	}
	
	public List<Artist> getEnrolledArtists() {
		return enrolledArtists;
	}

	public List<Visitor> getEnrolledVisitors() {
		return enrolledVisitors;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}
}
