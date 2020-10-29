package catering;


public class Meal {
	
	private String description = null;
	private int guestNumber = 0;
	
	
	public Meal(String description, int guestNumber) {
		this.description = description;
		this.guestNumber = guestNumber;
	}
	
	public String toString(){
		return ("This meal is a " + description + " for guest " + guestNumber);
	}
	public int getGuestNumber() {
		return this.guestNumber;
	}

}
