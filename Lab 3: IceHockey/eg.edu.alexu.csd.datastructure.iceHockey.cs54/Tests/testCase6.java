package eg.edu.alexu.csd.datastructure.iceHockey.cs54;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class testCase6 {

	@Test
	void test() {
		MainClass obj =new MainClass();
		String[] photo= {"44444H44S4"};
		int team=4;
		int threshold=20;
		Point[] expected={new Point(5,1)};
		
		//now the test assertion!!!----------------
		
		assertArrayEquals(expected, obj.findPlayers(photo, team, threshold));
	}

}
