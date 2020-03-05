package eg.edu.alexu.csd.datastructure.iceHockey.cs54;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class testCase10 {

	@Test
	void test() {
		MainClass obj =new MainClass();
		String[] photo= null;
		int team=4;
		int threshold=16;
		Point[] expected=null;
		
		//now the test assertion!!!----------------
		
		assertArrayEquals(expected, obj.findPlayers(photo, team, threshold));
	}

}
