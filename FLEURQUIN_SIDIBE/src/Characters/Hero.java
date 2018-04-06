package Characters;
import java.util.*;

import Items.*;
import Places.Place;

public class Hero extends Character {

	private Map<Item,Integer> inventory = new HashMap<>(); 
	private Place position;	
	private int oxygen;
	private static final int DEFAULT_DAMAGE = 3;
	
	// =============================================================================
	// Constructor
	public Hero(String n, int HP, int O2) {		
		super(n, HP);
		this.oxygen = O2;
	}
	
	// =============================================================================
	@Override
	public String toString(){
		return this.getName();
	}	
	
	// =============================================================================
	// Method to get thegetItem Oxygen
	public int getOxygen() {
		return this.oxygen;
	}
	
	// =============================================================================
	// Method to update the oxygen
	public void setOxygen(int O2) {
		this.oxygen = O2;		
	}
	
	// =============================================================================
	// Method to get the place
	public Place getPosition() {
		return this.position;
	}
	
	// =============================================================================
	// Method to update the place
	public void setPosition(Place p){
		if(p != null){
			if(this.position != p){
				this.position = p;
				p.addCharacter(this);
			}
		}
	}
	
	// =============================================================================
	// Method to add an item
	public void addItemToInventory(Item item) {
		if(item != null){
			if(!this.inventory.containsKey(item)){
				this.inventory.put(item, 1);
			}
			else{
				int nb = this.inventory.get(item);
				this.inventory.replace(item, nb+1);
			}	
		}
	}
	
	// =============================================================================
	// Method to get an item through its name
	public Item getItem(String name){
		Item item1 = null;		
			for(Item item2 : this.inventory.keySet()){
				if(item2.getName().equals(name))
					item1 = item2;
			}			
		return item1;
	}
	
	// =============================================================================
	// Method to test if an item is into the inventory
	public boolean hasItem(Item item){
		return this.inventory.containsKey(item);
	}
	
	// =============================================================================
	// Method to remove an item
	public void removeItem(Item item){
		if(this.inventory.containsKey(item)){
			int nb = this.inventory.get(item);
			if(nb==1)
				this.inventory.remove(item);
			else{
				nb--;
				this.inventory.replace(item, nb);
			}
		}
	}
	
	// =============================================================================
	// Method to get the inventory
	public Map<Item, Integer> getInventory(){
		return this.inventory;
	}
	
	// =============================================================================
	// Method to display the inventory
	public void displayInventory(){
		for(Item item : this.inventory.keySet()){
			System.out.print("(" + item.getName() + " , ");
			System.out.println(this.inventory.get(item) + ")");
		}
	}
	
	// =============================================================================
	// Method to attack a character
	public int attack(Character c, Weapon w){			
		if(w == null){
			c.setHP(c.getHP()-DEFAULT_DAMAGE);
		}
		else{						
			c.setHP(c.getHP() - w.getDamage());
		}			
		return c.getHP();
	}
	
	// --------- End of Methods
}