import java.util.*;
public class ArtGallerySystem {

	public static List<ArtGalleryEvent> events = new ArrayList<>();
	
	public void systemBuyingProcesses() {
		events.get(0).getEnrolledVisitors().get(0).buyArtwork(events.get(0).getEventArtworks().get(0));
		events.get(0).getEnrolledVisitors().get(1).buyArtwork(events.get(0).getEventArtworks().get(0));
		events.get(0).getEnrolledVisitors().get(1).buyArtwork(events.get(0).getEventArtworks().get(1));
	}
	
	public void enrollUsersInEvent(int eventId) {
    	Registration.getVisitors().get(0).enrollInEvent(eventId);
		Registration.getVisitors().get(1).enrollInEvent(eventId);
		Registration.getArtists().get(0).enrollInEvent(eventId);
		Registration.getArtists().get(2).enrollInEvent(eventId);
    }
	
	public static void main(String[] args) {

		ArtGallerySystem system1 = new ArtGallerySystem();
		Registration reg = new Registration();
		
		reg.createUsers();

		Admin admin = new Admin();
		Artist artist = Registration.getArtists().get(2);
		Organizer organizer = Registration.getOrganizers().get(0);
		Visitor visitor = Registration.getVisitors().get(0);

		admin.viewAllUsers();
		
		admin.approveRequest();
		
		admin.viewAllUsers();

		artist.addArtworksToProfile();
		
		artist.viewArtistArtworks();
		
		organizer.createEvent();
				
		system1.enrollUsersInEvent(1);
		
		organizer.viewEnrolledUsers(events.get(0));
		
		organizer.addArtistArtworks(events.get(0), events.get(0).getEnrolledArtists().get(1));

		visitor.viewEventArtworks(events.get(0));
	
		system1.systemBuyingProcesses();
		
		System.out.println();
		organizer.viewMyEvents();
	}

}
