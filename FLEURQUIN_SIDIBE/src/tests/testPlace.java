package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Characters.Octopus;
import Items.Item;
import Places.Exit;
import Places.Place;

public class testPlace {

	private Place place1;
	private Place place2;
	private Octopus perso1;
	private Octopus perso2;
	private Item item1;
	private Item item2;
	private Exit exit1;
	private Exit exit2;
	
	public testPlace() {		
	}
	
	@BeforeClass
	public static void setUpBeforeClass(){
	}

	@AfterClass
	public static void tearDownAfterClass() {
	}

	@Before
	public void setUp() {
		place1 = new Place("Corridor");
		place2 = new Place("Hall");
		perso1 = new Octopus("Octopus", 10, 5);
		perso2 = new Octopus("AnotherOctopus", 10, 5);
		exit1 = new Exit("Corridor_Hall", place1, place2);
		exit2 = null;
		item1 = new Item("Cle_Cockpit","Ceci est la cle du cockpit");
		item2 = new Item("Couteau", "Couteau en or, utilisez le pour vous defendre");
		
	}

	@After
	public void tearDown()  {
	}

	@Test
	public void testAddCharacters() {
		place1.addCharacter(null);
		assertTrue(place1.getCharacters().isEmpty());		
		
		place1.addCharacter(perso1);
		assertSame(perso1, place1.getCharacter("Octopus"));		
		
		place2.addCharacter(perso2);
		assertTrue(place2.containsEnemy());		
	}	
	
	@Test
	public void testRemoveCharacters(){
		place1.removeCharacter(perso1);
		place2.removeCharacter(null);
		
		place1.addCharacter(perso1);
		assertTrue(place1.containsEnemy());
		
		place1.removeCharacter(perso1);
		assertFalse(place1.containsEnemy());
	}
		
	@Test
	public void testAddExits(){
		int size1 = place2.getExits().size();
		place2.addExit(null);
		assertSame(place2.getExits().size(), size1);
		
		place1.addExit(exit1);
		assertSame(place1 , exit1.getNeighbour1());
		assertSame(place2.getExit(place1), place1.getExit(place2));
		
		assertSame(place2, place1.getExit(place2.getName()));
		
		int size2 = place1.getExits().size();
		place1.addExit(null);
		assertSame(size2, place1.getExits().size());
		
		place2.addExit(exit2);
		assertSame(place1, place2.getExit(place1.getName()));
	}
	
	@Test
	public void testAddItems(){
		place1.addItem(null);
		assertTrue(place1.getItems().isEmpty());
		
		place2.addItem(item1);
		assertSame(place2.getItem(item1.getName()), item1);
		assertSame(place2.getItems().size(), 1);
		
		place2.removeItem(item2);
		assertSame(place2.getItems().size() , 1);
		
		place2.addItem(item1);
		place2.addItem(item2);
		place2.addItem(item2);
		assertSame(place2.getItem(item2.getName()), item2);
		assertSame(place2.getItems().size() , 2);
	}
	
	@Test
	public void removeItem(){
		place2.removeItem(item1);
		place1.removeItem(null);
		
		place1.addItem(item1);
		assertFalse(place1.getItems().isEmpty());
		
		place1.removeItem(item1);
		assertSame(place1.getItems().size(), 0);
	}

}
