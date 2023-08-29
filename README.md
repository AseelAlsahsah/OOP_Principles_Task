# Art Gallery Event Management System

This Markdown document provides an overview of a very small Art Gallery Management System implemented in Java. The goal is to implement key OOP principles to showcase how these objects interact, inherit, encapsulate data, and exhibit polymorphic behavior.

## Classes

### `Entity` Class

- The `Entity` class is a generic one that contains the common fields most classes have such as ID and name.
- It encapsulates data using private fields and provides public getters and setters.
- It has two constructors: a default constructor and a parameterized one.

```java
class Entity {
    private int id;
    private String name;

    public Entity() {
        // Default constructor
    }

    public Entity(int id, String name) {
        // Parameterized constructor
    }

    // Getters and setters
}
```

### `Artist` Class

- The `Artist` class represents an artist and his particular style.
- It contains an object of the `Entity` class to represent the artist's identity.
- The class includes a constructor to create an `Entity` and set the artist's style (default and parameterized ones).
- Class methods allow viewing artist information and listing artworks by the artist.

```java
class Artist {
    private String style;
    private Entity entity;

    public Artist(int id, String name, String style) {
        // Parameterized constructor
    }

    public Artist() {
        // Default constructor
    }

    // Getters and setters

    public String viewArtistInfo() {
        // Returns artist information
    }

    public void listArtistArtworks(List<Artwork> allArtworks) {
        // Lists artworks by the artist
    }
}
```

### `Visitor` Class

- The `Visitor` class represents a visitor to the art gallery, and every visitor has an email address.
- Similar to the `Artist` class, it contains an object of the `Entity` class to represent the visitor's identity.
- Includes a constructor to create an `Entity` and set the email (default and parameterized ones).
- Methods in this class allow viewing visitor information and buying artworks.

```java
class Visitor {
    private String email;
    private Entity entity;

    public Visitor(int id, String name, String email) {
        // Parameterized constructor
    }

    public Visitor() {
        // Default constructor
    }

    // Getters and setters

    public String viewVisitorInfo() {
        // Returns visitor information
    }

    public void buyArtwork(Artwork artwork) {
        // Allows the visitor to buy an artwork
    }
}
```

### `Artwork` Class

- The `Artwork` class represents artwork details such as the year created, price, and an artist, entity, and buyer (if sold) objects.
- It includes methods to view artwork information and check if it's sold.

```java
class Artwork {
    private int yearCreated;
    private double price;
    private Artist artist;
    private Entity entity;
    private Visitor buyer;

    public Artwork(int id, String name, Artist artist, int yearCreated, double price) {
        // Parameterized constructor
    }

    public Artwork() {
        // Default constructor
    }

    // Getters and setters

    public String viewArtworkInfo() {
        // Returns artwork information
    }

    public boolean isSold() {
        // Checks if the artwork is sold
    }
}
```

### Subclasses: `Sculpture` and `Painting`

- `Sculpture` and `Painting` subclasses inherit from the `Artwork` class.
- Each one of them adds fields, the painting adds description, and the sculpting adds width, weight, and height.

```java
class Sculpture extends Artwork {
    // Additional attributes and constructors
}

class Painting extends Artwork {
    // Additional attributes and constructors
}
```

### `ArtGalleryEvent` Class

- The `ArtGalleryEvent` class has fields like date, description, location, and an `Entity` object.
- It contains ArrayLists of `Artwork` and `Visitor` objects.
- This class has methods to add and remove artworks and visitors from the event, as well as view event information.

```java
class ArtGalleryEvent {
    private LocalDate date;
    private String description;
    private String location;
    private Entity entity;
    private ArrayList<Artwork> artworks = new ArrayList<>();
    private ArrayList<Visitor> visitors = new ArrayList<>();

    public ArtGalleryEvent(int id, String name, LocalDate date, String description, String location) {
        // Parameterized constructor
    }

    public ArtGalleryEvent() {
        // Default constructor
    }

    // Getters and setters

    public void addArtWork(Artwork artwork) {
        // Adds an artwork to the event
    }

    public void addVisitor(Visitor visitor) {
        // Adds a visitor to the event
    }

    public void removeArtWork(int artworkId) {
        // Removes an artwork from the event
    }

    public void removeVisitor(int visitorId) {
        // Removes a visitor from the event
    }

    public String viewEventInfo() {
        // Returns event information
    }
}
```

## Main Class

The `Main` class contains the `main` method where an art gallery event is created, then artists, artworks, and visitors are added to the event, and various operations are performed.

## Conclusion

In this document, a simple Art Gallery Event Management System that effectively applies OOP principles was shown. These principles provide a structured and organized way to represent and manage complex systems. The code showcases how classes, objects, inheritance, encapsulation, and polymorphism can be used to model and solve problems in an object-oriented manner.
