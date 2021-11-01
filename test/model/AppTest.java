package model;


import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;



public class AppTest {

	App app;

	private void setupScenery1() throws FileNotFoundException, IOException { 
		app = new App();
		for (int i = 0; i < 4; i++) {
			Player temp = new Player("name"+i, i, "Delfines", i, 5, 6, 8+i, i);
			app.addPlayer(temp);
		}
	}


	@Test
	public void testApp() throws Exception {

	}

	@Test
	public void testAddPlayer() throws Exception {
		setupScenery1();
	}

	@Test
	public void testClean() throws Exception {
		setupScenery1();
	}

}
