package Items;
public class Weapon extends Item {
	private int damage;
	public static final int DEFAULT_DAMAGE = 1;
	
	// Constructor
	public Weapon(String n, String desc, int d) {
		super(n, desc);
		this.damage = d;
	}
	
	// Method to get the damage
	public int getDamage(){
		return this.damage;
	}
}