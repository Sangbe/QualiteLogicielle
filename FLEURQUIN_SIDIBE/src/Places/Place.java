package Places;

import java.util.HashSet;
import java.util.Set;

import Characters.Character;
import Characters.Ennemy;
import Characters.Hero;
import Items.Item;

public class Place {

	private Set<Exit> exits = new HashSet<>();
	private Set<Item> items = new HashSet<>();
	private Set<Character> character = new HashSet<>();
	private String name;
	
	// =============================================================================
	// Constructor
	/**
	 * 
	 * @param String
	 */
	public Place(String n) {
		this.name = n;
	}
	
	// =============================================================================
	@Override
	public String toString(){
		return this.name;
	}
	
	// =============================================================================
	// Method to get the name
	/**
	 * 
	 * @return String
	 */
	public String getName(){
		return this.name;
	}
	
	// =============================================================================
	// Method to add a item
	/**
	 * 
	 * @param Item
	 */
	public void addItem(Item item) {
		if(item != null && !this.items.contains(item))
			this.items.add(item);
	}
	
	// =============================================================================
	// Method to remove a item
	/**
	 * 
	 * @param Item
	 */
	public void removeItem(Item item){
		if(this.items.contains(item))
			this.items.remove(item);
	}
	
	// =============================================================================
	// Method to get an item through a name
	/**
	 * 
	 * @param name
	 * @return Item
	 */
	public Item getItem(String name){
		if(name != null){
			for(Item i : this.items){
				if(i.getName().equals(name))
					return i;
			}
		}
		return null;
	}
	
	// =============================================================================
	// Method to get all items
	public Set<Item> getItems(){
		return this.items;
	}
	
	// =============================================================================
	// Method to add a character
	/**
	 * 
	 * @param Character c
	 */
	public void addCharacter(Character c) {
		if(c != null){
			if(!this.character.contains(c)){
				this.character.add(c);
				if(c instanceof Hero)
					((Hero)c).setPosition(this);
			}
		}
	}
	
	// =============================================================================
	// Method to remove a character
	/**
	 * 
	 * @param c
	 */
	public void removeCharacter(Character c){
		if(this.character.contains(c))
			this.character.remove(c);
	}
	
	// =============================================================================
	// Method to get all characters
	public Set<Character>  getCharacters(){
		return this.character;
	}
	
	// =============================================================================
	// Method to get a character through its name
	/**
	 * 
	 * @param name
	 * @return Character
	 */
	public Character getCharacter(String name){
		for(Character c : this.character){
			if(c.getName().equals(name))
				return c;
		}
		return null;
	}
	
	// =============================================================================
	// Method to test if a contains an enemy
	public boolean containsEnemy(){
		for(Character c : this.character){
			if(c instanceof Ennemy)
				return true;
		}
		return false;
	}
	
	// =============================================================================
	// Method to get an enemy 
	public Ennemy getEnemy(){
		for(Character c : this.character){
			if(c instanceof Ennemy)
				return (Ennemy) c;
		}
		return null;
	}
	
	// =============================================================================
	// Method to add an exit
	/**
	 * 
	 * @param Exit e
	 */
	public void addExit(Exit e) {
		if(e != null && !this.exits.contains(e)){
			this.exits.add(e);			
		}
	}
	
	// =============================================================================
	// Method to get an exit towards a place through its name
	/**
	 * 
	 * @param name
	 * @return Place
	 */
	public Place getExit(String name){
		if(name != null && name != this.name){
			for(Exit p : this.exits){
				if(p.getNeighbour1().name.equals(name))
					return p.getNeighbour1();
				else if(p.getNeighbour2().name.equals(name))
					return p.getNeighbour2();
			}
		}
		return null;
	}
	
	// =============================================================================
	// Method to get the exit to an other place
	/**
	 * 
	 * @param Place
	 * @return Exit
	 */
	public Exit getExit(Place p){
		for(Exit e : this.exits){
			if((e.getNeighbour1() == this) && (e.getNeighbour2() == p))
				return e;
			else if((e.getNeighbour1() == p) && (e.getNeighbour2() == this))
				return e;
		}
		return null;
	}
	
	// =============================================================================
	// Method to get all exits
	public Set<Exit> getExits(){
		return this.exits;
	}
	
	// =============================================================================
	// Description of the place
	public void description(){			
		System.out.println("Dans cette piece vous avez : ");
			
		for(Exit e : this.exits){
			if(e.getNeighbour1() != this){
				System.out.print("\t---> une sortie vers : ");
				System.out.println(e.getNeighbour1());
			}
			if(e.getNeighbour2() != this){
				System.out.print("\t---> une sortie vers : ");
				System.out.println(e.getNeighbour2());
			}
		}			
			
		if(this.items.size() > 0 ){		
			System.out.println("Objet(s) present(s) : ");
			for(Item i : this.items){
				System.out.println("\t---> " + i.getName());
			}
		}				
	}
		
	// -------- End of Methods
}