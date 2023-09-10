
abstract class Artwork {
	private int id;
    private String title;
    private int yearCreated;
    private double price;
	private Visitor buyer;
    private Artist artist;
    private static int artworkCounter = 0;

    public Artwork(int id, String title, Artist artist, int yearCreated, double price) {
    	this.setId(id);
        this.setTitle(title);
        this.setArtist(artist);
        this.setYearCreated(yearCreated);
        this.setPrice(price);
        setArtworkCounter(getArtworkCounter()+1);
    }

    public abstract void displayInfo();

    public boolean isSold() {
        return buyer != null;
    }
    
	public int getYearCreated() {
		return yearCreated;
	}

	public void setYearCreated(int yearCreated) {
		this.yearCreated = yearCreated;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
        return title;
    }
	
	public void setTitle(String name) {
		this.title = name;
	}
	
	public static int getArtworkCounter() {
		return artworkCounter;
	}

	public static void setArtworkCounter(int artworkCounter) {
		Artwork.artworkCounter = artworkCounter;
	}

	public Visitor getBuyer() {
		return buyer;
	}

	public void setBuyer(Visitor buyer) {
		this.buyer = buyer;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
}

class Sculpture extends Artwork {
    private double weight;
    private double width;
    private double height;
    
    public Sculpture(int id, String title, Artist artist, int yearCreated, double price, double weight, double width, double height) {
      super(id, title, artist, yearCreated, price);
      this.setWeight(weight);
      this.setWidth(width);
      this.setHeight(height);
  }

  @Override
  public void displayInfo() {
      System.out.println("Title: "+getTitle()+"\nArtist: "+getArtist().getUsername()+
      		"\nYear Created: "+getYearCreated()+"\nPrice: $"+getPrice()+"\nWeight: "+weight+
      		"\nWidth: "+width+"\nHeight: "+height);
  }
    
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
}

class Painting extends Artwork {
    private String description;

    public Painting(int id, String title, Artist artist, int yearCreated, double price, String description) {
        super(id, title, artist, yearCreated, price);
        this.setDescription(description);
    }

    @Override
    public void displayInfo() {
    	System.out.println("Title: "+getTitle()+"\nArtist: "+getArtist().getUsername()+
        		"\nYear Created: "+getYearCreated()+"\nPrice: $"+getPrice()+"\nDescription: "+description);
    }
    
    public String getDescription() {
		return description;
	}
	
    public void setDescription(String description) {
		this.description = description;
	}
}