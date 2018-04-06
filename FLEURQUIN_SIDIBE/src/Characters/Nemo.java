package Characters;

import Items.Weapon;

public class Nemo extends Character {

	public Nemo(String n, int pv) {
		super(n,pv);
	}
	
	public int attack(Character c, Weapon w){			
		return c.getHP();
	}
	
	public void speak(){
		System.out.println("Cela fait tellement longtemps que j'attends cet instant.");
		System.out.println("Je me rejouis que mon HERITAGE soit enfin revele aux yeux du monde.");		
		System.out.println("Je peux m'en allez en paix..");
		System.out.println("......AHAHAHAHAHAHAHAHAH......");
	}
}