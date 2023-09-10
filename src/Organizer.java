import java.time.LocalDate;

public class Organizer extends User{
	
	public Organizer(int id, String email, String username, String password) {
        super(id, email, username, password);
        this.setRole("Organizer");
    }
	
	public Organizer() {
        this(-1, "", "", "");
    }
	
	public void createEvent() {
		int nextEventId = ArtGalleryEvent.getEventsCounter()+1;
    	ArtGalleryEvent event1 = new ArtGalleryEvent(nextEventId, "Some Event", this, LocalDate.of(2023, 9, 6), "An event description", "Amman, Jordan");
    	ArtGallerySystem.events.add(event1);
    }
	
	public void viewMyEvents() {
		for(ArtGalleryEvent e : ArtGallerySystem.events) {
			if(e.getOrganizer().equals(this))
				e.viewEventInfo();
		}
	}
	
	public void viewEnrolledUsers(ArtGalleryEvent event) {
		System.out.println("\nEnrolled visitors in event "+event.getId()+" : ");
		for(Visitor v: event.getEnrolledVisitors())
			System.out.println(v.getUsername());
		
		System.out.println("\nEnrolled artists in event 1: ");
		for(Artist a: event.getEnrolledArtists())
			System.out.println(a.getUsername());
	}
	
	public void addArtistArtworks(ArtGalleryEvent event, Artist artist) {
		artist.addArtworkToEvent(event.getId(), artist.getArtistArtworks().get(0));
		artist.addArtworkToEvent(event.getId(), artist.getArtistArtworks().get(1));
    }
}
