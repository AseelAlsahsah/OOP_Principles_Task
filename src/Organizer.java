import java.time.LocalDate;

public class Organizer extends User{
	
	public Organizer(int id, String email, String username, String password) {
        super(id, email, username, password);
        this.setRole("Organizer");
    }
	
	public Organizer() {
        this(-1, "", "", "");
    }
	
	public void createEvent(String name, LocalDate date, String description, String location) {
		int nextEventId = ArtGalleryEvent.getEventsCounter()+1;
    	ArtGalleryEvent event1 = new ArtGalleryEvent(nextEventId, name, this, date, description, location);
    	ArtGallerySystem.addToEvents(event1);
    }
	
	public void viewMyEvents() {
		System.out.println("\nMy Events: ");
		for(ArtGalleryEvent e : ArtGallerySystem.getEvents()) {
			if(e.getOrganizer().equals(this))
				e.viewEventInfo();
		}
	}
	
	public void viewEnrolledUsers(ArtGalleryEvent event) {
		System.out.println("\nEnrolled visitors in event "+event.getId()+" : ");
		if(event.getEnrolledVisitors().isEmpty())
			System.out.println("No Visitors yet");
		else
			for(Visitor v: event.getEnrolledVisitors())
				System.out.println(v.getUsername());
		
		System.out.println("\nEnrolled artists in event 1: ");
		if(event.getEnrolledArtists().isEmpty())
			System.out.println("No Artists yet");
		else
			for(Artist a: event.getEnrolledArtists())
				System.out.println(a.getUsername());
	}
}
