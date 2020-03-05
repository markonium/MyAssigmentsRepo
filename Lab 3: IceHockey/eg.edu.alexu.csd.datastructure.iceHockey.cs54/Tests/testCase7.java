package eg.edu.alexu.csd.datastructure.iceHockey.cs54;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class testCase7 {

	@Test
	void test() {
		MainClass obj =new MainClass();
		String[] photo= {"7764FWR8N8E8AVHRY"};
		int team=9;
		int threshold=50;
		Point[] expected= {};
		
		//now the test assertion!!!----------------
		
		assertArrayEquals(expected, obj.findPlayers(photo, team, threshold));
	}

}
