package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Places.Exit;
import Places.Place;

public class testExit {

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
	public void testExitNull() {			
		Exit ExitNull = new Exit(null,null,null);
		assertNull(ExitNull.getName());
		assertNull(ExitNull.getNeighbour1());
		assertNull(ExitNull.getNeighbour2());
	}
	
	@Test
	public void testExitNotNull(){
		String name = "p1_To_p2";
		Place p1 = new Place("couloir");
		Place p2 = new Place("cockpit");
		
		Exit exit = new Exit(name,null,p2);
		assertNull(exit.getName());
		assertNull(exit.getNeighbour2());
		
		exit = new Exit(name,p1,p2);
		assertEquals(name, exit.getName());
		assertSame(p1, exit.getNeighbour1());
		assertEquals(exit.getNeighbour2(), p2);
	}


}
