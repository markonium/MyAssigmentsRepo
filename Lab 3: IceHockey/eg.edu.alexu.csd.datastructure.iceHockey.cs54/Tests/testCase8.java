package eg.edu.alexu.csd.datastructure.iceHockey.cs54;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class testCase8 {

	@Test
	void test() {
		MainClass obj =new MainClass();
		String[] photo= {"2SRF5CX48SD4S4"};
		int team=9999;
		int threshold=20;
		Point[] expected={};
		
		//now the test assertion!!!----------------
		
		assertArrayEquals(expected, obj.findPlayers(photo, team, threshold));
	}
}
