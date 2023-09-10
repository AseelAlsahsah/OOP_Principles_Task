
public class User {
	private int id;
	private String email;
    private String username;
    private String password;
    private String role;
    private static int userCounter = 0;

    public User(int id, String email, String username, String password) {
    	this.setId(id);
        this.setEmail(email);
        this.setUsername(username);
        this.setPassword(password);
        if(id >= 0)
        	setUserCounter(getUserCounter()+1);
    }
    
    public User() {
    	this(-1, "", "", "");
    }

    public void viewUserInfo(){
		System.out.println("ID: "+getId()+", Email: "+getEmail()+", username: "+getUsername());
	}    
    
    public boolean isVisitor() {
    	return role == "Visitor";
    }

    public boolean isArtist() {
    	return role == "Artist";
    }
    
    public boolean isOrganizer() {
    	return role == "Organizer";
    }
    
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getUserCounter() {
		return userCounter;
	}

	public void setUserCounter(int counter) {
		userCounter = counter;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
