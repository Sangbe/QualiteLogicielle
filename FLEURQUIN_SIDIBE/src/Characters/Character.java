package Characters;

import Items.Weapon;

public abstract class Character {

	private String name;
	private int HP;

	// Constructor
	public Character(String n, int pv) {
		this.name = n;
		this.HP = pv;		
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getHP() {
		return this.HP;
	}

	/**
	 * 
	 * @param pv
	 */
	public void setHP(int pv) {
		this.HP = pv;		
	}
	
	//
	public boolean isAlive(){
		if(this.HP > 0)
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @param Character
	 */
	public abstract int attack(Character c, Weapon w);

}