import java.time.LocalDate;
import java.util.*;
public class ArtGallerySystem {

	private static List<ArtGalleryEvent> events = new ArrayList<>();
	
	public static List<ArtGalleryEvent> getEvents() { return events; }
	public static void addToEvents(ArtGalleryEvent event) { events.add(event); }
	
	public static void main(String[] args) {

		Registration reg = new Registration();
		
		reg.createUsers();

		System.out.println("*****************first scenario: Admin*********************");		
		
		Admin admin = new Admin();
		
		//admin will view all registered users
		admin.viewAllUsers();
		
		//admin will approve 3 artist requests by their id to be registered
		admin.approveArtist(3);
		admin.approveArtist(4);
		admin.approveArtist(5);
		
		//admin will view registered users again
		admin.viewAllUsers();

		
		System.out.println("\n*****************second scenario: Organizer*********************");		

		//we will let organizer with index 0 do the work
		Organizer organizer = Registration.getOrganizers().get(0);

		//organizer created a new event
		organizer.createEvent("Some Event", LocalDate.of(2023, 9, 6), "An event description", "Amman, Jordan");

		//organizer viewed enrolled users in his event (none is enrolled yet)
		organizer.viewEnrolledUsers(events.get(0));

		//organizer viewed his events
		organizer.viewMyEvents();

		System.out.println("\n*****************third scenario: Artist*********************");		

		//we will let artist with index 2 do the work
		Artist artist = Registration.getArtists().get(2);
				
		//artist viewed his own account information 
		artist.viewUserInfo();
		
		//artist added some artworks to his profile
		artist.addPainting("The Starry Night", 1889, 3000000, "Oil Paint");
		artist.addPainting("Cafe Terrace at Night", 1888, 3000000, "Oil Paint");
		
		//artist viewed his artworks in his profile
		artist.viewArtistArtworks();

		//artist viewed available art gallery events
		artist.viewArtGalleryEvents(getEvents());
		
		//artist enrolled in the first event
		artist.enrollInEvent(1);

		//artist added both of his artworks to the event
		artist.addArtworkToEvent(1, artist.getArtistArtworks().get(0));
		artist.addArtworkToEvent(1, artist.getArtistArtworks().get(1));
		
		System.out.println("\n*****************fourth scenario: Visitor*********************");		

		//we will let visitor with index 0 do the work
		Visitor visitor = Registration.getVisitors().get(0);
				
		//visitor viewed available art gallery events
		visitor.viewArtGalleryEvents(getEvents());
		
		//visitor enrolled in the first event
    	visitor.enrollInEvent(1);

    	//visitor viewed artworks of the event
		visitor.viewEventArtworks(events.get(0));
	
		//visitor bought the first artwork.
		visitor.buyArtwork(events.get(0).getEventArtworks().get(0));
	}

}
