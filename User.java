
public class User {
	
	private String name;
	private int id; 
	
	public User(String userName, int id) {
        this.name = userName;
        this.id = id; 
 
    }
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id; 
	}
	
	@Override
	public String toString() {
		return  "User " + this.name + ", ID: " + this.id;
	}
}
