package Places;

/**
 * This Exit is bidirectional :  Place1 <-------> Place2 
 */

public class Exit {
    private String name;
	private Place neighbour1;
	private Place neighbour2;	
	private boolean isOpen;
	public final static boolean DEFAULT_OPEN = true;
	
	// =============================================================================
	public Exit(String name, Place p1, Place p2) {
		if(p1 != null && p2 != null){
			this.name = name;
			this.neighbour1 = p1;
			p1.addExit(this);
			this.neighbour2 = p2;
			p2.addExit(this);
			this.isOpen = Exit.DEFAULT_OPEN;
		}
	}
	
	// =============================================================================
	public void open() {
		if(this.isOpen == false)
			this.isOpen = true;
	}
	
	// =============================================================================
	public void close() {
		if(this.isOpen == true)
			this.isOpen = false;
	}
	
	// =============================================================================
	// Method to know if the exit is opened
	public boolean isOpen(){
		return this.isOpen;
	}
	
	// =============================================================================
	// Method to get the name
	public String getName(){
		return this.name;
	}
	
	// =============================================================================
	public Place getNeighbour1(){
		return this.neighbour1;
	}
	
	// =============================================================================
	public Place getNeighbour2(){
		return this.neighbour2;
	}
	
	// ---------- End of Methods
}