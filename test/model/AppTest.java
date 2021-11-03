package model;


import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppTest {

	App app;
/*
	private void setupScenery1() throws FileNotFoundException, IOException { 
		app = new App();
		for (int i = 0; i < 4; i++) {
			Player temp = new Player("name"+i, i, "Delfines", i, 5, 6, 8+i, i);
			//app.addPlayer(temp);
		}
	}*/

	private void setupScenery1() throws IOException {
		app = new App();
		Player temp = new Player("El bicho", 19, "Tapitas", 3, 4, 5, 6, 7);

		app.addPlayer(temp);
	}

	@Test
	public void testApp() throws Exception {

	}

	@Test
	public void testAddPlayer() throws Exception {
		setupScenery1();

		assertEquals("El bicho,19,Tapitas,3,4,5,6,7",app.getPlayers().toString().replaceAll("\\[|\\]", ""));
	}

	@Test
	public void testClean() throws Exception {
		setupScenery1();

		app = new App();

		assertEquals("", app.getPlayers().toString().replaceAll("\\[|\\]", ""));

		//Cleal all
	}

}
