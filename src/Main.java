
public class Main {

	public static void main(String[] args) {
		ArtGalleryEvent event = new ArtGalleryEvent();
		
		Artist artist1 = new Artist(1, "Leonardo da Vinci", "Renaissance");
		Artist artist2 = new Artist(2, "Michelangelo", "Realism");
		Artist artist3 = new Artist(3, "Vincent van Gogh", "Pointillism");
		
		Painting painting1 = new Painting(1, "Mona Lisa", artist1, 1503, 1000000, "Oil Paint");
		Painting painting2 = new Painting(2, "The Starry Night", artist3, 1889, 3000000, "Oil Paint");
		Painting painting3 = new Painting(2, "Cafe Terrace at Night", artist3, 1888, 3000000, "Oil Paint");

		Sculpture sculpture1 = new Sculpture(1, "David ", artist2, 1504, 2000000, 12478, 2.3, 5.17);
		Sculpture sculpture2 = new Sculpture();
		
		Visitor visitor1 = new Visitor(1, "Aseel", "aseel.sahsah01@gmail.com");
		Visitor visitor2 = new Visitor(2, "ola", "olaalomari@gmail.com");
		
		// polymorphism here is i have a list of artwork and i'm assigning it a references of sculpture and paining
		event.addArtWork(sculpture1);
		event.addArtWork(sculpture2);
		event.addArtWork(painting1);
		event.addArtWork(painting2);
		event.addArtWork(painting3);
		
		event.addVisitor(visitor1);
		
		System.out.println("****All Registered Artworks*****");
		for(Artwork a : event.getArtworks()) {
			System.out.println(a.viewArtworkInfo());
		}
		
		System.out.println("\n****All Artworks after one is removed****");
		
		event.removeArtWork(painting1.getEntity().getId());
		
		for(Artwork a : event.getArtworks()) {
			System.out.println(a.viewArtworkInfo());
		}

		System.out.println("\n****All Visitors*****");
		for(Visitor v : event.getVisitors()) {
			System.out.println(v.viewVisitorInfo());
		}
		System.out.println();
		
		artist3.listArtistArtworks(event.getArtworks());
		System.out.println();
		
		visitor1.buyArtwork(painting3);
		visitor2.buyArtwork(painting3);
		visitor2.buyArtwork(sculpture1);
	}
}