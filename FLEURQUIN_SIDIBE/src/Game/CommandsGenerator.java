package Game;

import java.util.StringTokenizer;

/**
 *  This class is used to generate available commands from inputs
 */

public class CommandsGenerator {
	
	private GoodCommands cmd;
	private AvailableCmds validCmd;
	
	// Constructor
	public CommandsGenerator(){
		this.cmd = new GoodCommands();
		this.validCmd = new AvailableCmds(Commands.unknown, null, null);
	}
	
	// Method to get the command from the text
	public AvailableCmds getCommand(String text){
		String word1 = null;
		String word2 = null;
		String word3 = null;				
		StringTokenizer token = new StringTokenizer(text);
		
		if(token.hasMoreTokens()){
			word1 = token.nextToken();			
		}
		
		if(token.hasMoreTokens()){
			word2 = token.nextToken();
		}
		
		if(token.hasMoreTokens()){
			word3 = token.nextToken();
		}
			
		/*
		 *  On teste si word1 est une commande en utilisant
		 *  la methode isCommand se trouvant dans la classe GoodCommands
		 *  on retourne la commande correspondante
		 */
		if(this.cmd.isACommand(word1) && (token.countTokens()==0)){
			this.validCmd = new AvailableCmds(this.cmd.getCommands(word1), word2, word3);
			return this.validCmd;
		}
		else{
			this.validCmd = new AvailableCmds(Commands.unknown, word2, word3);
			return this.validCmd;
		}		
	}
	
	// Method to get good commands
	public void displayAllCommands(){	
		System.out.println("help:        affiche cette aide.");
		System.out.println("quit:        permet de quitter le jeu");
		System.out.println("inventory:   permet d'afficher son inventaire.");
		System.out.println("map:         affiche la carte");
		
		System.out.println("look:        permet d'afficher les objets et les sorties présentes dans la pièce courante");
		System.out.println("\t---> look : affiche la description de votre position,");
		System.out.println("\t---> look nomObjet : affiche la description de l'objet");
		
		System.out.println("go:          permet de se deplacer");
		System.out.println("\t---> go direction : permet de se rendre dans la direction indiquee");
		
		System.out.println("use:         permet d'utiliser un objet de son inventaire.");
		System.out.println("\t---> use Cle direction : permet d'utiliser la cle pour deverouiller la porte menant a ce lieu");
		System.out.println("\t---> use arme ennemi : permet d'utiliser l'arme sur l'ennemi");
		
		System.out.println("take:        permet de ramasser un objet dans la pièce courante.");
		System.out.println("\t---> take arme : permet de rammasser l'arme");		
		
		System.out.println("attack:      Cette commande ne s'utilise que lors d'un combat.");
		System.out.println("\t---> attack : permet d'attaquer a mains nus votre adversaire.");
	
	}
	
}
