package eg.edu.alexu.csd.datastructure.iceHockey.cs54;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class testCase11 {

	@Test
	void test() {
		MainClass obj =new MainClass();
		String[] photo= {"94544H49S4","K9BI912FFS","K99FO12D5S"};
		int team=9;
		int threshold=20;
		Point[] expected={};
		
		//now the test assertion!!!----------------
		
		assertArrayEquals(expected, obj.findPlayers(photo, team, threshold));
	}

}
