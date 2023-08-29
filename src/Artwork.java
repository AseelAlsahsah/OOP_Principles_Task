class Artwork{
    private int yearCreated;
    private double price;
    private Artist artist;
	private Entity entity;
	private Visitor buyer;

    public Visitor getBuyer() { return buyer; }
    public void setBuyer(Visitor buyer) { this.buyer = buyer; }
	
	public Artist getArtist() { return artist; }
	public void setArtist(Artist artist) { this.artist = artist; }
    
    public int getYearCreated() { return yearCreated; }
    public void setYearCreated(int yearCreated) { this.yearCreated = yearCreated; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public Entity getEntity() { return entity; }
    
    public Artwork(int id, String name, Artist artist, int yearCreated, double price) {
    	entity = new Entity(id, name);
    	this.artist = artist;
    	this.yearCreated = yearCreated;
    	this.price = price;
	}
    
    public Artwork() {
    	entity = new Entity();
    	this.artist = new Artist();
    	this.yearCreated = -1;
    	this.price = -1;
	}
    
    public String viewArtworkInfo() {
        return "Title: " + entity.getName() + ", Artist: " + artist.getEntity().getName() + ", Year Created: " + yearCreated + ", Price: $" + price;
    }
    
    public boolean isSold() {
        return buyer != null;
    }
    
}

class Sculpture extends Artwork{
	private double width;
	private double height;
	private double weight;
	
	public double getWidth() { return width; }
	public void setWidth(double width) { this.width = width; }
	
	public double getHeight() {	return height; }
	public void setHeight(double height) { this.height = height; }
	
	public double getWeight() { return weight; }
	public void setWeight(double weight) { this.weight = weight; }
	
	public Sculpture(int id, String name, Artist artist, int yearCreated, double price, double weight, double width, double height) {
        super(id, name, artist, yearCreated, price);
        this.weight = weight;
        this.width = width;
        this.height = height;
    }
	
	public Sculpture() {
        this.weight = -1;
        this.width = -1;
        this.height = -1;
    }
}

class Painting extends Artwork{

	private String description;
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	public Painting(int id, String name, Artist artist, int yearCreated, double price, String description) {
		super(id, name, artist, yearCreated, price);
		this.description = description;
	}
	
	public Painting() {
		this.description = "";
	}
}