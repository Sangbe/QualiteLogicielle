package Characters;

import Items.Weapon;

public class Shark extends Ennemy {
		
	public Shark(String n, int pv, int damage) {
		super(n,pv,damage);
	}
	
	public int attack(Character c, Weapon w){		
		if(c instanceof Hero){
			c.setHP(c.getHP() - this.getDamage());			
		}		
		return c.getHP();
	}
	
	// ----- End of methods
}