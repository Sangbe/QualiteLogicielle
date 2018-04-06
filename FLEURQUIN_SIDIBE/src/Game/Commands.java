package Game;

/**
 *  This class contains all valid commands of the game
 */

public enum Commands {
	go("go"), 
	use("use"), 
	take("take"), 
	look("look"), 
	help("help"), 
	quit("quit"),
	inventory("inventory"), 
	attack("attack"), 
	map("map"),
	unknown("@");
	
	private String cmdString;
	
	Commands(String text){
		this.cmdString = text;
	}
	
	public String toString(){
		return this.cmdString;
	}
}