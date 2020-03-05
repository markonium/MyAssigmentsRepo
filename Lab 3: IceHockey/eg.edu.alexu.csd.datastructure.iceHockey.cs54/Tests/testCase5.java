package eg.edu.alexu.csd.datastructure.iceHockey.cs54;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class testCase5 {

	@Test
	void test() {
		MainClass obj =new MainClass();
		String[] photo= {"88NKMG8N8E8JI88"};
		int team=8;
		int threshold=50;
		Point[] expected=new Point[0];
		
		//now the test assertion!!!----------------
		
		assertArrayEquals(expected, obj.findPlayers(photo, team, threshold));
	}

}
