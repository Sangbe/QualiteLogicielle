package Characters;

import Items.Weapon;

public class Octopus extends Ennemy {
	
	public Octopus(String n, int pv, int damage) {
		super(n,pv, damage);		
	}
	
	public int attack(Character c, Weapon w){		
		if(c instanceof Hero){
			c.setHP(c.getHP() - this.getDamage());			
		}		
		return c.getHP();
	}
	
	// Method to speak
	public void speak(){
		System.out.println("BOUHOUHOU....");
	}
}