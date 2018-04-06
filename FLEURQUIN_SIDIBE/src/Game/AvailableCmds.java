package Game;

/**
 *  This class is used to specify how a command has to be build
 *  There are sometimes commands with many words
 *  i.e: command theItem theTarget
 */


public class AvailableCmds {
	private Commands cmd; // the command
	private String secondWord; // the second word, it can be an item
	private String thirdWord; // the third word, it can be an item
	
	// Constructor
	public AvailableCmds(Commands cmd, String second, String third){
		this.cmd = cmd;
		this.secondWord = second;
		this.thirdWord = third;
	}
	
	// Method to test if the cmd is a good command
	public boolean isCommand(){
		return (this.cmd != Commands.unknown);
	}
	
	// Method to get the command
	public Commands getCommand(){
		return this.cmd;
	}
	
	// Method to get the second word
	public String getSecondWord(){		
		return this.secondWord;
	}
	
	// Method to get the third word
	public String getThirdWord(){
		return this.thirdWord;
	}
	
	// Method to test if there is a second word
	public boolean hasSecondWord(){
		return (this.secondWord != null);
	}
	
	// Method to test if there is a third word
	public boolean hasThirdWord(){
		return (this.thirdWord != null);
	}
}
