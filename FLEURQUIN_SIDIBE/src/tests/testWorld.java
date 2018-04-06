package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Places.Place;
import Places.World;

public class testWorld {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWorldNotNull() {
		World world = new World("World");
		Place p1 = new Place("cockpit");
		
		world.addPlace(null);
		assertTrue(world.getPlaces().isEmpty());
		
		world.addPlace(p1);
		assertSame(world.getPlaces().size(), 1);
		
		world.addPlace(p1);
		assertSame(world.getPlaces().size(), 1);		
		
	}

}
