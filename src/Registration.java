import java.util.*;

public class Registration {
	private static List<User> users;
	private static List<Artist> artists;
	private static List<Visitor> visitors;
	private static List<Organizer> organizers;

    public Registration() {
        users = new ArrayList<>();
        artists = new ArrayList<>();
        visitors = new ArrayList<>();
        organizers = new ArrayList<>();
    }

    public void registerVisitor(String email, String username, String password) {
    	int nextUserId = User.getUserCounter()+1;
        Visitor visitor = new Visitor(nextUserId, email, username, password);
        visitors.add(visitor);
        users.add(visitor);
    }

    public void registerArtist(String email, String username, String password, String artStyle) {
    	int nextUserId = User.getUserCounter()+1;
        Artist artist = new Artist(nextUserId, email, username, password, artStyle);
        artists.add(artist);
    }
    
    public void registerOrganizer(String email, String username, String password) {
    	int nextUserId = User.getUserCounter()+1;
        Organizer organizer = new Organizer(nextUserId, email, username, password);
        organizers.add(organizer);
        users.add(organizer);
    }
    
    public void createUsers() {
    	registerVisitor("aseelsahsah@gmail.com", "Aseel Alsahsah", "aseel123");//0
		registerVisitor("olaalomari@gmail.com", "ola alomari", "ola123");//1
		
		registerArtist("davinci@gmail.com", "Leonardo da Vinci", "ven123", "Renaissance");//2
		registerArtist("mich@gmail.com", "Michelangelo", "mich123", "Realism");//3
		registerArtist("vincent@gmail.com", "Vincent van Gogh", "vin123", "Pointillism");//4
		
		registerOrganizer("organizer@email.com", "organizer 1", "123");
    }

    public static void addUsers(User user) {
        users.add(user);
    }
    
    public static List<User> getUsers() {
        return users;
    }
    
	public static List<Artist> getArtists() {
		return artists;
	}

	public static List<Visitor> getVisitors() {
		return visitors;
	}

	public static List<Organizer> getOrganizers() {
		return organizers;
	}
}
