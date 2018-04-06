package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Characters.Hero;
import Items.Item;
import Places.Place;

public class testHero {

	private Hero hero1;
	private Hero hero2;
	private Place place1;
	private Place place2;
	private Item item1;
	private Item item2;
	
	
	public testHero() {		
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() {	
		place1 = null;
		place2 = new Place("couloir");
		hero1 = new Hero("FirstHero", 10, 10);
		hero2 = new Hero("SecondHero", 5 , 5);	
		item1 = new Item("Cle_Cockpit","Ceci est la cle du cockpit");
		item2 = new Item("Couteau", "Couteau en or, utilisez le pour vous defendre");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetPosition1() {
		hero1.setPosition(place1);
		assertNull(hero1.getPosition());
		
		hero1.setPosition(place2);		
		assertSame(hero1.getPosition(), place2);	
		//assertNull(hero1.getPosition());
	}
	
	@Test
	public void testSetPosition2(){
		place2.addCharacter(hero2);		
		assertSame(hero2.getPosition(), place2);
		
		hero1.setPosition(place2);
		assertSame(hero1.getPosition(), place2);
	}
	
	@Test
	public void testAddItem(){
		hero1.addItemToInventory(null);
		assertTrue(hero1.getInventory().isEmpty());
		
		hero1.addItemToInventory(item1);
		assertSame(hero1.getItem(item1.getName()), item1);
	}
	
	@Test
	public void removeItem(){
		hero2.addItemToInventory(item1);
		int size = hero2.getInventory().size();
		
		hero2.addItemToInventory(null);
		assertSame(size, hero2.getInventory().size());
		
		hero2.addItemToInventory(item2);
		hero2.removeItem(item2);
		assertFalse(hero2.hasItem(item2));		
		
	}

}
