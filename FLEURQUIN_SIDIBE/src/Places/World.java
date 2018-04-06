package Places;
import java.util.*;

public class World {

	private Set<Place> places = new HashSet<>();
	private String name;
	
	// Constructor
	public World(String n) {
		this.name = n;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
	
	// Method to add a place
	public void addPlace(Place p){
		if(p != null)
			this.places.add(p);
	}
	
	// Method to get all places
	public Set<Place> getPlaces(){
		return this.places;
	}
	
	// Method to display all places
	public void displayPlaces(){
		for(Place p : this.places)
			System.out.println(p);
	}
	
	// --------- MAP Building
	
	public void map(){
		System.out.println("");
		
		System.out.println("\t\t\t\t\t\t\t\t\t\t   ______________________"); 
		System.out.println("\t\t\t\t\t\t\t\t\t\t  | \t Salle A\t |"); 
		System.out.println("\t\t\t\t\t\t\t\t\t\t  | \t Manger\t\t |"); 
		System.out.println("\t\t\t\t\t\t\t\t\t  ________|______________   _____|_______________________");
		System.out.println("\t\t\t\t\t\t\t\t\t | \t\t\t\t | \t\t\t |"); 
		System.out.println("\t ________________________________________________________________| \t\t\t\t   \t\t\t |");
		System.out.println("\t| \t\t | \t\t\t\t | \t\t | \t\t\t\t | \t ????\t\t |");
		System.out.println("\t| Piece de\t | \t Salle Des\t\t|:|\t???\t | \t\t\t\t |_______________________|");
		System.out.println("\t| Depart\t | \t Machines\t\t | \t\t | \t\t\t\t | \t ????\t\t |");
		System.out.println("\t|_______==_______|_________________   ___________|_______________| \t\t\t\t   \t\t\t |");
		System.out.println("\t| \t\t | \t\t\t | \t\t\t | \t\t\t\t | \t\t\t |");
		System.out.println("\t|  Couloir1\t   \tCouloir2\t | \tCouloir3\t   \t\t\t\t |_______________________|");
		System.out.println("\t| \t\t | \t\t\t   \t\t\t | \t\t\t\t | \t\t\t |");
		System.out.println("\t|________   _____|_______________________|__________==___________| \t\t\t\t | \t ????\t\t |");
		System.out.println("\t\t|\t | \t\t\t | \t\t\t | \t\t\t\t | \t\t\t |");
		System.out.println("\t\t|???\t | \t\t\t | \t????\t\t | \t\t\t\t   \t\t\t |");
		System.out.println("\t\t|\t | \t\t\t | \t\t\t | \t\t\t\t | \t\t\t |");
		System.out.println("\t\t|________| \t\t\t |_______________________|_________________   ___________|_______________________| ");
		
		System.out.println("\t\t\t\t\t\t\t\t  | \t\t\t| \t  | \t\t\t|");
		System.out.println("\t\t\t\t\t\t\t\t  | \t\t\t  ???\t  | \t\t\t|");
		System.out.println("\t\t\t\t\t\t\t\t  | \t Salle De\t| \t  | \t\t\t|");
		System.out.println("\t\t\t\t\t\t\t\t  | \t Sport\t\t| \t  | \t\t\t|");
		System.out.println("\t\t\t\t\t\t\t\t  | \t\t\t| \t |:|\t????\t\t|");
		System.out.println("\t\t\t\t\t\t\t\t  |__________  _________|_________|_____________________|");
		System.out.println("\t\t\t\t\t\t\t\t\t | \t  |");
		System.out.println("\t\t\t\t\t\t\t\t\t | ????\t  |");
		System.out.println("\t\t\t\t\t\t\t\t\t |________|");
	
	}
	
	// ---------- End of Methods
}