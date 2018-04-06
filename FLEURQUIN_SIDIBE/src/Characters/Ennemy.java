package Characters;

import Items.Weapon;

public abstract class Ennemy extends Character {
	private int damage;
	private Weapon weapon;
	
	public Ennemy(String n, int pv, int damage) {
		super(n,pv);
		this.damage = damage;
		this.weapon = null;
	}
	
	public int getDamage(){
		return this.damage;
	}
	
	public Weapon getWeapon(){
		return this.weapon;
	}
	
	public abstract int attack(Character c, Weapon w);
}