import java.util.*;

class Artist{
	private String style;
	private Entity entity;
	
	public String getStyle() { return style; }
	public void setStyle(String style) { this.style = style; }
	
	public Entity getEntity() { return entity; }
	
	public Artist(int id, String name, String style) {
		entity = new Entity(id, name);
		this.style = style;
	}
	
	public Artist() {
		entity = new Entity();
		this.style = "";
	}
	
	public String viewArtistInfo() { 
		return "ID: "+entity.getId()+", Name: "+entity.getName()+", Style: "+style; 
	}
	
	public void listArtistArtworks(List<Artwork> allArtworks) {
        System.out.println("Artworks by " + entity.getName() + ":");
        for (Artwork artwork : allArtworks) {
            if (artwork.getArtist().entity.getId() == entity.getId()) {
                System.out.println("Title: "+artwork.getEntity().getName());
            }
        }
    }
}