package eg.edu.alexu.csd.datastructure.iceHockey.cs54;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class testCase4 {

	@Test
	void test() {
		MainClass obj =new MainClass();
		String[] photo= {"11111", "1AAA1", "1A1A1", "1AAA1", "11111" };
		int team=1;
		int threshold=3;
		Point[] expected={new Point(5,5),new Point(5,5)};
		
		//now the test assertion!!!----------------
		
		assertArrayEquals(expected, obj.findPlayers(photo, team, threshold));
	}

}
