class Visitor{
	private String email;
	private Entity entity;

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public Entity getEntity() { return entity; }
	
	public Visitor(int id, String name, String email) {
		entity = new Entity(id, name);
		this.email = email;
	}
	
	public Visitor() {
		entity = new Entity();
		this.email = "";
	}
	
	public String viewVisitorInfo() { 
		return "ID: "+entity.getId()+", Name: "+entity.getName()+", Email: "+email; 
	}
	
	public void buyArtwork(Artwork artwork) {
        if (artwork.isSold()) {
            System.out.println("Artwork is already sold");
        } else {
            artwork.setBuyer(this);
            System.out.println("You have successfully purchased " + artwork.getEntity().getName());
        }
    }
}
