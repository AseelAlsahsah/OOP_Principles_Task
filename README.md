# Art Gallery Event Management System

This Markdown document overviews a small Art Gallery Management System implemented in Java. The goal is to implement key OOP principles to showcase how these objects interact, inherit, encapsulate data, and exhibit abstraction and polymorphic behavior.

## Classes

### `Registration` Class

- The `Registration` class is designed for user management in a system. It categorizes users as Visitors, Artists, and Organizers, and keeps a list of all users.
- Key features are:
    1. **Fields**: Static lists for all users, artists, visitors, and organizers.
    2. **Default Constructor**: Initializes empty lists.

```java
public class Registration {
    private static List<User> users;
    private static List<Artist> artists;
    private static List<Visitor> visitors;
    private static List<Organizer> organizers;

    public Registration() {
        // default constructor
    }

    public void registerVisitor(String email, String username, String password) {
    	// adds the visitor to users and visitors lists
    }

    public void registerArtist(String email, String username, String password, String artStyle) {
        // adds the artist only to artists list, because it's not approved yet
    }
    
    public void registerOrganizer(String email, String username, String password) {
        // adds the organizer to users and organizers lists
    }
    
    public void createUsers() {
    	// creates new visitor, artist, and organizer objects
    }

    public static void addUsers(User user) {
        // adds the user to the users list
    }
    
    //Getters and Setters
}
```

### `User` Class

- The `User` class is a generic one containing the common fields and methods between child classes such as ID, email, username, and password.
- It encapsulates data using private fields and provides public getters and setters.
- It has two constructors: a default constructor and a parameterized one.

```java
public class User {
    private int id;
    private String email;
    private String username;
    private String password;
    private String role;
    private static int userCounter = 0;

    public User(int id, String email, String username, String password) {
        // Parameterized constructor
    }
    
    public User() {
        // Default constructor
    }

    // Getters, setters, and other methods
}
```

### `Artist` Class

- The `Artist` class represents an artist and his particular style.
- It inherits the `User` class.
- It has two constructors: a default constructor and a parameterized one.

```java
class Artist extends User{
    private String artStyle;
    private boolean approved;
    private List<Artwork> artistArtworks = new ArrayList<>();

    public Artist(int id, String email, String username, String password, String artStyle) {
        // Parameterized constructor
    }

    public Artist() {
        // Default constructor
    }

    @Override
    public void viewUserInfo() {
        // Prints user information
    }

    public boolean isApproved() { return approved; }

    public void addArtworkToEvent(int eventId, Artwork artwork) {
    	// adds an artwork to a specific event
    }

    public void addArtworksToProfile() {
    	//creates a new artwork and associates it with a specific artist.
    }

    public void addPainting(String name, int yearCreated, double price, String description) {
        //adds the painting to the artist's artworks
    }
	
    public void addSculpture(String name, int yearCreated, double price, double weight, double width, double height) {
        //adds the sculpture to the artist's artworks
    }

    public void viewArtistArtworks() {
    	// prints artists's artworks
    }

    public void removeArtWork(int artworkId) {
    	// remove artists's artwork from account
    }

    public void viewArtGalleryEvents(List<ArtGalleryEvent> events) {
        // retrieves all events in the system and prints their names
    }

    public void enrollInEvent(int eventId) {
        // registers the artist with a specific event
    }

    // Getters and setters
}
```

### `Visitor` Class

- The `Visitor` class represents a visitor to the art gallery.
- Similar to the `Artist` class, it inherits the `User` class.
- It has two constructors: a default constructor and a parameterized one.

```java
class Visitor extends User{
    public Visitor(int id, String email, String username, String password) {
        // Parameterized constructor
    }

    public Visitor() {
        // Default constructor
    }

    public void viewArtGalleryEvents(List<ArtGalleryEvent> events) {
        // retrieves all events in the system and prints their names
    }

    public void enrollInEvent(int eventId) {
        // registers the visitor with a specific event
    }

    public void buyArtwork(Artwork artwork) {
        // Allows the visitor to buy an artwork
    }

    public void viewEventArtworks(ArtGalleryEvent event) {
        // prints all event artworks and divides them into sculpture and painting groups
    }
}
```

### `Organizer` Class

- The `Organizer` class represents an organizer for a specific event.
- Similar to the `Artist` and `Visitor` classes, it inherits the `User` class.
- It has two constructors: a default constructor and a parameterized one.

```java
class Organizer extends User {
    public Organizer(int id, String email, String username, String password) {
        // Parameterized constructor
    }

    public Organizer() {
        // Default constructor
    }

    public void createEvent() {
        //creates a new event and associates it with the organizer
    }

    public void viewMyEvents() {
        // prints all events created by this organizer
    }

    public void viewEnrolledUsers(ArtGalleryEvent event) {
        // prints the usernames of all visitors and artists enrolled in a specific event
    }

    public void addArtistArtworks(ArtGalleryEvent event, Artist artist) {
        // calls the addArtworkToEvent() method to add an artwork to a specific event.
    }
}
```

### `Admin` Class

- The `Admin` class is responsible for doing actions related to the system itself, such as approving artist requests.
- Fields are ID, email, and password.
- It has two constructors: a default constructor and a parameterized one.

```java
public class Admin {
    private int id;
    private String email;
    private String password;

    public Admin(int id, String email, String password) {
        // Parameterized constructor
    }
    
    public Admin() {
        // Default constructor
    }

    public void approveArtist(int id) {
        // adds the artist to the registered users on the system
    }

    public void viewAllUsers() {
        // views all artists, visitors, and organizers information
    }

    // Getters, setters, and other methods
}
```

### `Artwork` Abstract Class

- The `Artwork` class is an abstract one that represents artwork details such as its title, year created, price, artist, and buyer (if sold) objects.
- It includes methods to view artwork information and check if it was sold for example.
- It Uses Abstraction, which allows a high-level view of functionality while leaving specific implementations to subclasses.

```java
class Artwork {
    private int id;
    private String title;
    private int yearCreated;
    private double price;
    private Visitor buyer;
    private Artist artist;
    private static int artworkCounter = 0;

    public Artwork(int id, String title, Artist artist, int yearCreated, double price) {
        // Parameterized constructor
    }

    public abstract void displayInfo();

    public boolean isSold() {
        // Checks if the artwork is sold
    }

    // Getters and setters
}
```

### Subclasses: `Sculpture` and `Painting`

- `Sculpture` and `Painting` subclasses inherit the `Artwork` Abstract class.
- Each one of them adds its own fields, the painting adds description, and the sculpting adds width, weight, and height.
- they both implements the displayInfo() method as needed.

```java
class Sculpture extends Artwork {
    // Additional attributes and constructors
}

class Painting extends Artwork {
    // Additional attributes and constructors
}
```

### `ArtGalleryEvent` Class

- The `ArtGalleryEvent` class has fields like event name, date, description, location, and an `Organizer` object.
- It contains ArrayLists of `eventArtworks`, `enrolledArtists`, and `enrolledVisitors` objects.
- This class has methods to add and remove artworks and visitors from the event, as well as view event information.

```java
class ArtGalleryEvent {
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
        // Parameterized constructor
    }

    public ArtGalleryEvent() {
        // Default constructor
    }

    public String viewEventInfo() {
        // Returns event information
    }

    public void enrollVisitor(Visitor visitor) {
        // adds a visitor to enrolledVisitors array
    }
    
	public void enrollArtist(Artist artist) {
        // adds an artist to enrolledArtists array
    }

    public void addArtWork(Artwork artwork) {
        // Adds an artwork to the event (eventArtworks array)
    }

    // Getters and setters
}
```

## Main Class

The `Main` class contains the `main` method where an art gallery event is created by an organizer, then artists, artworks, and visitors are added to the event, and various operations are performed.

## Conclusion

In this document, a simple Art Gallery Event Management System that effectively applies OOP principles was shown. These principles provide a structured and organized way to represent and manage complex systems. The code showcases how classes, objects, inheritance, encapsulation, and polymorphism can be used to model and solve problems in an object-oriented manner.
