package Game;


import java.util.HashMap;
import java.util.Map;


/**
 *  This class is used to associate a string to a command
 *  thinks to a HashMap.
 *  Which permits to test if an input is a valid command
 * 
 */

public class GoodCommands {
	private Map<String, Commands> goodCmds = new HashMap<String, Commands>();	
	
	// Constructor	
	public GoodCommands(){		
		for(Commands cmd : Commands.values()){		
			if(cmd != Commands.unknown)
				this.goodCmds.put(cmd.toString(),cmd);				
		}
	}	
	
	// Method to get a command from a text
	public Commands getCommands(String text){
		Commands cmd = this.goodCmds.get(text);
		if(cmd != null){
			return cmd;
		}
		else{
			return Commands.unknown;
		}
	}
	
	// Method to test if a command is available
	public boolean isACommand(String text){
		return this.goodCmds.containsKey(text);
	}
	
	// ------ End of Methods
}
