package Game;


import java.util.Scanner;


import Characters.*;
import Characters.Character;
import Items.*;
import Places.*;


/**
 *  This class is used to build the game by
 *  creating the world and its places, exits, items
 *  and characters
 */

public class GameBuilding {
	private CommandsGenerator generator; // The generator of commands
	private Place startPlace; // The starting place
	private Hero hero; // The hero or main character
	private Item cahierDeBord; // The Quest
	private World world; // The world
	
	private static final String HERO_NAME = "Explorer";
	private static final int HERO_HP = 100;
	private static final int HERO_O2 = 100;
	
	private static final String WORLD_NAME = "NAUTILUS";
	
	// =============================================================================
	// Constructor
	public GameBuilding(){
		this.generator = new CommandsGenerator();				
	}
	
	// =============================================================================
	// Method to display the scenario
	public void scenario(){
		System.out.println("\nVous etes Octave Charpentier, un explorateur qui a dedie sa vie a la recherche d'information"); 
		System.out.println("sur le fameux Capitaine Nemo et son sous-marin le Nautilus.");
		System.out.println("Lors d'une escale en Jamaique, vous faites la rencontre d'un equipage et de son capitaine qui pretend");
		System.out.println("avoir des informations sur la localisation de la celebre machine et vous decidez de le rejoindre.");
		System.out.println("Apres plusieurs jours en mer, il s'avere que les informations de ce mysterieux capitaine etait juste,");
		System.out.println("le Nautilus se trouve au fond de l'ocean juste en dessous de votre navire et vous vous portez volontaire"); 
		System.out.println("pour explorez la machine de guerre.\n");
		System.out.println("Le but de votre plongee est de recuperer le livre de bord du Nautilus dans lequel ");
		System.out.println("le Capitaine Nemo aurait decrit son voyage et surtout l'emplacement de tous ses tresors."); 		
	}
	
	// =============================================================================
	// Method to display the menu
	public void menu(){
		String input;
		Scanner sc = new Scanner(System.in);
		
		while(true){						
			System.out.println("\t\t\t==========================");
			System.out.println("\t\t\t COLOSSAL CAVE ADVENTURE");
			System.out.println("\t\t\t==========================");
			System.out.println("\n\n\t 1 -------------------------> Nouvelle Partie");
			System.out.println("\n\t 2 -------------------------> Aide");			
			System.out.println("\n\t 0 -------------------------> Quitter");
			System.out.print("\n\t Faites votre choix : ");
			input = sc.nextLine();
			switch (input) {
				case "1": 	clearScreen();
							this.hero = new Hero(HERO_NAME, HERO_HP, HERO_O2);
							this.createTheWorld();
							scenario();
							System.out.println("\n\nAppuyez sur \"entree\" pour commencez l'aventure...");
				sc.nextLine();
							clearScreen();
							System.out.println("Vous venez de penetrer dans l'enceinte du Nautilus.");
							System.out.println("Vous vous trouvez dans une piece mysterieuse dont la porte est verrouillee.");					
							System.out.println("Pour avoir de l'aide, tapez \"help\""); 
							System.out.println("\n\nAppuyez sur \"entree\" pour commencez...");
				sc.nextLine();
							clearScreen();
							this.play();
							break;
					
				case "2": displayHelp(); 
						  break;
												
				case "0": System.exit(0);
						  sc.close();
						  break;
		
				default: System.out.println("Mauvais choix, Veuillez ressayer de nouveau.");
						 System.out.println("\n\nAppuyez sur \"entree\"...");
				sc.nextLine();
						 clearScreen();
						 break;
			}
		}
	}
	
	
	
	// =============================================================================
	// Method to create the world
	public void createTheWorld(){
		// ********************************* The world
		this.world = new World(WORLD_NAME);
		
		// ********************************* The places and rooms
		this.startPlace = new Place("salle_depart");
		this.hero.setPosition(this.startPlace);
		
		Place couloir1 = new Place("premier_couloir");
		Place couloir2 = new Place("deuxieme_couloir");
		Place couloir3 = new Place("troisieme_couloir");
		Place couloir4 = new Place("quatrieme_couloir");
		
		Place toilettes = new Place("toilettes");
		Place vestiaires = new Place("vestiaires");
		
		Place salleMachines = new Place("salle_des_machines");		
		Place cuisine = new Place("cuisine");
		Place hall = new Place("hall");
		Place salleManger = new Place("salle_a_manger");
		Place salleSport = new Place("salle_de_sport");
		
		Place pieceSecrete = new Place("piece_secrete");
		Place cabine1 = new Place("cabine_des_matelots");
		Place cabine2 = new Place("cabine_des_femmes");
		Place cabine3 = new Place("cabine_des_hommes");
		
		Place cockpit = new Place("cockpit");
		
		// ********************************* The exits between places and rooms
		Exit startPlaceToCouloir1 = new LockDoor("startPlaceToCouloir1", this.startPlace, couloir1); // LockDoor
		new Exit("couloir1ToToilettes", couloir1, toilettes);
		new Exit("couloir1ToCouloir2", couloir1, couloir2);
		new Exit("couloir2ToSalleMachine", couloir2, salleMachines);
		new Exit("couloir2ToCouloir3", couloir2, couloir3);
		Exit salleMachineToPieceSecrete = new LockDoor("salleMachineToPieceSecrete", salleMachines, pieceSecrete);
		new Exit("couloir3ToSalleMachine", couloir3, salleMachines);
		Exit couloir3ToCuisine = new LockDoor("couloir3ToCuisine", couloir3, cuisine); // LockDoor
		new Exit("couloir3ToHall", couloir3, hall);		
		new Exit("hallToSalleManger", hall, salleManger);
		new Exit("hallToCabine1", hall, cabine1);
		new Exit("hallToCabine2", hall, cabine2);
		new Exit("hallToCabine3", hall, cabine3);
		new Exit("hallToCouloir4", hall, couloir4);
		Exit couloir4ToCockpit = new LockDoor("couloir4ToCockpit", couloir4, cockpit); // LockDoor
		new Exit("couloir4ToSalleSport", couloir4, salleSport);
		new Exit("salleSportToVestiaires", salleSport, vestiaires);
		
		// ********************************* The items
		this.cahierDeBord = new Book("cahier_de_bord", "C'est le cahier de bord du Capitaine Nemo");
		
		Item cleSalleDepart = new Key("cle_salle_depart", "C'est la cle de la salle de depart");
		((LockDoor)startPlaceToCouloir1).setKey((Key) cleSalleDepart);
		
		Item cleCuisine = new Key("cle_cuisine", "C'est la cle de la cuisine");
		((LockDoor)couloir3ToCuisine).setKey((Key) cleCuisine);
		
		Item cleCockpit = new Key("cle_cockpit", "C'est la cle du cockpit");
		((LockDoor)couloir4ToCockpit).setKey((Key) cleCockpit);
		
		Item clePieceSecrete = new Key("cle_piece_secrete","C'est la cle de la piece secrete");
		((LockDoor)salleMachineToPieceSecrete).setKey((Key) clePieceSecrete);
		
		Item oxygene = new Oxygen("oxygene","C'est une capsule d'oxygene, utilisez la pour restaurer votre energie");		
		Item munitions = new Arrow("munitions", "Ce sont des fleches pour le harpon", 15);
		Item couteau = new Knife("couteau", "C'est un couteau en or, utilisez le pour vous defendre", 25);
		Item harpon = new Harpon("harpon","C'est un harpon, utilisez-le pour vous defendre", 40);
		
		// ********************************* The characters
		Character nemo = new Nemo("Nemo",100);
		Character megalodon = new Shark("megalodon", 150, 20);
		Character shark1 = new Shark("requin", 50 , 10);
		Character shark2 = new Shark("requin", 55 , 10);
		Character octopus1 = new Octopus("pieuvre", 15 , 5);
		Character octopus2 = new Octopus("pieuvre", 17 , 5);
		Character octopus3 = new Octopus("pieuvre", 15 , 5);
		Character octopus4 = new Octopus("pieuvre", 19 , 5);
		
		// ******************************** Adding items and characters to rooms
		this.startPlace.addItem(cleSalleDepart);							
		couloir1.addCharacter(octopus1);
		couloir1.addItem(couteau);
		toilettes.addItem(oxygene);
		couloir3.addCharacter(octopus2);
		salleMachines.addCharacter(octopus3);
		pieceSecrete.addItem(oxygene);
		pieceSecrete.addItem(munitions);
		pieceSecrete.addItem(harpon);
		cuisine.addItem(oxygene);
		cuisine.addItem(munitions);
		hall.addCharacter(shark2);
		hall.addItem(oxygene);
		salleManger.addItem(oxygene);
		salleManger.addItem(cleCuisine);
		cabine1.addItem(munitions);
		cabine1.addCharacter(octopus4);
		cabine2.addItem(clePieceSecrete);
		cabine3.addItem(oxygene);
		couloir4.addItem(oxygene);
		couloir4.addCharacter(shark1);
		salleSport.addCharacter(megalodon);
		vestiaires.addItem(cleCockpit);
		vestiaires.addItem(oxygene);
		cockpit.addCharacter(nemo);
		cockpit.addItem(this.cahierDeBord);
		
		// ********************************* Adding places into the world
		world.addPlace(this.startPlace);
		world.addPlace(couloir1);
		world.addPlace(couloir2);
		world.addPlace(couloir3);
		world.addPlace(couloir4);
		world.addPlace(toilettes);
		world.addPlace(vestiaires);
		world.addPlace(salleMachines);
		world.addPlace(salleManger);
		world.addPlace(salleSport);
		world.addPlace(pieceSecrete);
		world.addPlace(cuisine);
		world.addPlace(hall);
		world.addPlace(cabine1);
		world.addPlace(cabine2);
		world.addPlace(cabine3);
		world.addPlace(cockpit);
		
	}
	
	// =============================================================================
	// Method to play the game
	public void play(){
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = "";
		while((!this.hero.hasItem(cahierDeBord)) && (this.hero.isAlive()) && (this.hero.getOxygen() > 0)){	
			this.clearScreen2();
			System.out.println("Points de Vie : " + this.hero.getHP());
			System.out.println("Niveau Oxygene : " + this.hero.getOxygen());
			System.out.println("\nVous etes dans " + this.hero.getPosition());
			
			if(this.hero.getPosition().containsEnemy()){				
				Ennemy ennemy = this.hero.getPosition().getEnemy();
				startFighting(this.hero,ennemy);					
			}			
			
			System.out.print("\n>> ");
			input = sc.nextLine();
			this.interpretCmds(input);	
			this.hero.setOxygen(this.hero.getOxygen()-2);
		}
		
		if(!this.hero.isAlive()){
			System.out.println("\n\n\t!!!!!!! GAME OVER !!!!!!!");
		}
		else{	
			Character nemo = this.hero.getPosition().getCharacter("Nemo");
			if(nemo instanceof Nemo)
				((Nemo)nemo).speak();
			System.out.println("\n\n\tFelicitation, votre quete est achevee...");
		}
		System.out.println("\n\nAppuyez sur \"entree\"...");
		input = sc.nextLine();
		this.menu();
	}
	
	// =============================================================================
	// Method to interpret a command	
	/**
	 * 
	 * @param String
	 */
	public void interpretCmds(String input){		
		
		AvailableCmds cmd = this.generator.getCommand(input);		
		
		if(!cmd.isCommand()){
			System.out.println("Ceci n'est pas une commande valide.");
			System.out.println("Taper \"help\" pour avoir de l'aide\n");
		}
		else{
			Commands action = cmd.getCommand();
			switch (action){
				case go : 
						this.move(cmd);
						break;
				case help : 
						this.displayHelp();						
						break;
				case take : 
						this.takeItem(cmd);
						break;
				case use :  
						this.useItem(cmd);
						break;
				case attack : 
						System.out.println("Vous ne pouvez attaquer que lors d'un combat.\n");
						break;
				case look : 
						this.getDescription(cmd);
						break;
				case quit : 
						clearScreen();
						this.menu();
						break;
				case map : 
						this.printMap();
						break;
				case inventory : 
						this.displayInventory();
						break;
				default : break;							 
			}
		}
	}
	
	// =============================================================================
	// Method to display the inventory
	public void displayInventory(){
		if(this.hero.getInventory().isEmpty()){
			System.out.println("Vous n'avez aucun objet...");
		}
		else{
			this.hero.displayInventory();
		}
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("\nAppuyez sur \"entree\" pour reprendre...");
		sc.nextLine();		
	}
	

	// =============================================================================
	// Method to clear the console
	public void clearScreen(){	
		for(int i=0 ; i<50 ; i++)
			System.out.println();
	}
	
	// Method to clear the screen
	public void clearScreen2(){
		for(int i=0 ; i<5 ; i++)
			System.out.println();
	}
	
	// =============================================================================
	// Method to display the map
	public void printMap(){
		this.world.map();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Appuyez sur \"entre\" pour reprendre l'aventure....");
		sc.nextLine();
		this.clearScreen();
		//sc.close();
	}
	
	// =============================================================================
	// Method to look a thing (item or place)
	public void getDescription(AvailableCmds cmd){
		if(!cmd.hasSecondWord()){
			this.hero.getPosition().description();
		}
		else{
			if(cmd.hasThirdWord()){
				System.out.println("Combinaison impossible. Veuillez consulter l'aide!\n");
			}
			else{
				String secondWord = cmd.getSecondWord();
				Item item = this.hero.getItem(secondWord);
				if(item == null){
					System.out.println("Vous ne possedez pas cet objet...\n");
				}
				else{
					System.out.println(item.getName() + " : " + item.getDescription());
				}
			}			
		}
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("\nAppuyez sur \"entree\" pour reprendre...");
		sc.nextLine();
	}
	
	// =============================================================================
	// Method to take an item
	/**
	 * 
	 * @param AvailableCmds
	 */
	public void takeItem(AvailableCmds cmd){
		
		if(!cmd.hasSecondWord()){ // If cmd hasn't a second word
			System.out.println("Impossible de prendre cet objet...");
		}
		else{ // if cmd has a second word
			if(cmd.hasThirdWord()){
				System.out.println("Impossible de prendre cet objet...");
			}
			else{
				Item item = this.hero.getPosition().getItem(cmd.getSecondWord());
				if(item == null){
					System.out.println("Cet objet n'est pas dans cette piece");
				}
				else{
					this.hero.addItemToInventory(item);
					this.hero.getPosition().removeItem(item);				
				}
			}
		}
	}
	
	// =============================================================================
	// Method to display all commands
	public void displayHelp(){
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		System.out.println("\n\n\t\tCommandes disponibles: \n\n");
		this.generator.displayAllCommands();
		System.out.println("\nAppuyez sur \"entree\" pour reprendre...");
		sc1.nextLine();
		clearScreen();
		//sc1.close();
	}
	
	// =============================================================================
	// Method to move
	/**
	 * 
	 * @param cmd
	 */
	public void move(AvailableCmds cmd){
		if(!cmd.hasSecondWord() || cmd.hasThirdWord()){ // if the command hasn't a second word
			System.out.println("Vous ne pouvez pas allez a cet endroit...");
		}
		else{ // If the command has a second word
			
			String direction = cmd.getSecondWord();
			Place placeToGo = this.hero.getPosition().getExit(direction);
			if(placeToGo == null){
				System.out.println("Vous ne pouvez pas allez a cet endroit...");
			}
			else{
				Exit e = this.hero.getPosition().getExit(placeToGo);
				if(e == null){
					System.out.println("Vous ne pouvez pas allez a cet endroit...");
				}
				else{
					if(e instanceof LockDoor){						
						if(((LockDoor) e).isLock()){
							System.out.println("Cette porte necessite une cle.");
							System.out.println("Utilisez la cle pour la deverouiller...");
						}
						else{
							placeToGo.addCharacter(this.hero);
							this.hero.setPosition(placeToGo);								
						}
					}
					else{						
						placeToGo.addCharacter(this.hero);
						this.hero.setPosition(placeToGo);														
					}					
				}				
			}			
		}
	}
	
	// =============================================================================
	// Method to use an item
	/**
	 * 
	 * @param cmd
	 */
	public void useItem(AvailableCmds cmd){
		if(!cmd.hasSecondWord()){
			System.out.println("Il n'y a rien a utiliser...");
			System.out.println("Taper \"help\" pour avoir de l'aide");
		}
		
		else{ // if there is a second word
			String secondWord = cmd.getSecondWord();
			Item item = this.hero.getItem(secondWord);
			if(item == null){ 
				System.out.println("Vous n'avez pas cet objet...");
			}
			
			else{
				if((item instanceof Knife)){ // If the hero wants use a knife
					if(!cmd.hasThirdWord()){
						System.out.println("Sur quoi comptez-vous utiliser cet objet??");
					}
					else{
						String thirdWord = cmd.getThirdWord();
						Character ennemy = this.hero.getPosition().getCharacter(thirdWord);
						if(ennemy == null){
							System.out.println("Cette creature n'est pas en ce lieu...");
						}
						else if(ennemy instanceof Hero){
							System.out.println("Vous ne pouvez pas vous suicider!!!");
							System.out.println("Votre quete n'est pas encore accomplie...");
						}
						else if(ennemy instanceof Nemo){
							System.out.println("Cette creature est un fantome...");
						}
						else{
							this.hero.attack(ennemy, (Weapon)item);							
						}
					}
				} // ---- End of using of the knife
				
				else if(item instanceof Arrow){ // If the hero wants use an arrow
					if(!this.hero.hasItem(item)){
						System.out.println("Vous n'avez plus de fleches...");
					}
					else{
						if(!cmd.hasThirdWord()){
							System.out.println("Sur quoi comptez-vous utiliser cet objet??");
						}
						else{
							String thirdWord = cmd.getThirdWord();
							Character ennemy = this.hero.getPosition().getCharacter(thirdWord);
							if(ennemy == null){
								System.out.println("Cette creature n'est pas en ce lieu...");
							}
							else if(ennemy instanceof Hero){
								System.out.println("Vous ne pouvez pas vous suicider!!!");
								System.out.println("Votre quete n'est pas encore accomplie...");
							}
							else if(ennemy instanceof Nemo){
								System.out.println("Cette creature est un fantome...");
							}
							else{
								this.hero.attack(ennemy, (Weapon)item);
								this.hero.removeItem(item); // We remove one arrow from the inventory
							}
						}
					}
				} // ---- End of using of the arrow
				
				else if(item instanceof Harpon){ // If the hero wants use the harpoon
					Arrow arrow = null;
					for(Item i : this.hero.getInventory().keySet()){
						if(i instanceof Arrow)
							arrow = (Arrow) i;
					}
					
					if(arrow == null){
						System.out.println("Vous n'avez plus de fleches...");
					}
					else{
						if(!cmd.hasThirdWord()){
							System.out.println("Sur quoi comptez-vous utiliser cet objet??");
						}
						else{
							String thirdWord = cmd.getThirdWord();
							Character ennemy = this.hero.getPosition().getCharacter(thirdWord);
							if(ennemy == null){
								System.out.println("Cette creature n'est pas en ce lieu...");
							}
							else if(ennemy instanceof Hero){
								System.out.println("Vous ne pouvez pas vous suicider!!!");
								System.out.println("Votre quete n'est pas encore accomplie...");
							}
							else if(ennemy instanceof Nemo){
								System.out.println("Cette creature est un fantome...");
							}
							else{
								this.hero.attack(ennemy, (Weapon)item);
								this.hero.removeItem(arrow); // We remove one arrow from the inventory
							}
						}
					}
				} // ---- End of using of the harpoon
				
				else if(item instanceof Oxygen){ // If the hero wants use an oxygen caps.
					if(!cmd.hasThirdWord()){
						this.hero.setOxygen(HERO_O2);
						this.hero.setHP(HERO_HP);
						this.hero.removeItem(item);
						System.out.println("Niveau d'oxygene restaure...");
						System.out.println("Points de vie restaures...");
					}
					else{
						System.out.println("Cette combinaison est impossible.");
					}
				} // ---- End of using of oxygen
				
				else if(item instanceof Key){ // If the hero wants use a key
					if(!cmd.hasThirdWord()){ 
						System.out.println("Veuillez indiquer la direction.");
					}
					else{
						Place place = this.hero.getPosition().getExit(cmd.getThirdWord());
						Exit e = this.hero.getPosition().getExit(place);
						if(e == null){
							System.out.println("Cette sortie n'existe pas.");
						}
						else{
							if(e instanceof LockDoor){ // If it's a door with lock
								if(((LockDoor) e).getKey() == item){ // If it's the same key
									((LockDoor) e).unlock();
									System.out.println("La porte est deverouillee...");
								}
								else{ // If it isn't the same key
									if(!((LockDoor) e).isLock()) // If the door is already opened
										System.out.println("Cette sortie n'est pas verouillee");
									else
										System.out.println("Ce n'est pas la bonne cle...");
								}
							}
							else{
								System.out.println("Cette porte est deja ouverte");
							}
						}						
					}
				} // ---- End of using of the key
			} // ---- End of using of the item
		} // ---- End of analyzing of the second and third word
	}
	
	// =============================================================================
	// Method to start fighting
	/**
	 * 
	 * @param champion
	 * @param outsider
	 */
	public void startFighting(Character champion, Ennemy outsider){	
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int round = 1;
		System.out.println("\nVous etes attaques par " + outsider.getName() + ", defendez-vous!!!\n");
		while(champion.isAlive() && outsider.isAlive()){
			System.out.println("------------- ROUND " + round + " ------------");
			System.out.println(champion.getName() + " : " + champion.getHP() + " points de vie");
			System.out.println(outsider.getName() + " : " + outsider.getHP() + " points de vie\n");
			
			System.out.print("> ");
			String input = sc.nextLine();	
			
			if(input.equals(Commands.attack.toString())){
				champion.attack(outsider, null); // null ==> champion uses its harms
			}			
			else{
				String[] cmd = input.split(" +");
				if(cmd[0].equals(Commands.go.toString())){
					System.out.println("Vous ne pouvez pas vous enfuire...");
				}
				else
					interpretCmds(input);
			}
			
			outsider.attack(champion, outsider.getWeapon());
			
			if(outsider.isAlive()){
				System.out.println(outsider.getName() + " viens de vous attaquer... Defendez-vous\n");
			}
			round++;
		}
		if(!outsider.isAlive()){
			System.out.println("\nVous avez mis " + outsider.getName() + " K.O");	
			this.hero.getPosition().removeCharacter(outsider);
		}		
	}
	
	
	
	// --------- End of Methods
}
