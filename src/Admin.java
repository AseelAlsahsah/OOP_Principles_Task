
public class Admin {
	private int id;
	private String email;
	private String password;
	
	public Admin(int id, String email, String password) {
		this.setId(id);
		this.setEmail(email);
		this.setPassword(password);
	}
	
	public Admin() {
		this(0, "admin@email.com", "admin123");
	}
	
	public void approveArtist(int id) {
		for(Artist artist : Registration.getArtists()) {
			if(artist.getId() == id) {
				artist.setApproved(true);
				Registration.addUsers(artist);
			}
		}
    }
	
	public void approveRequest() {
		approveArtist(3);
		approveArtist(4);
		approveArtist(5);
	}
	
	public void viewAllUsers() {
		System.out.println("\nAll Approved Users: ");
    	for(User user: Registration.getUsers()) {
			user.viewUserInfo();
		}
    }
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
