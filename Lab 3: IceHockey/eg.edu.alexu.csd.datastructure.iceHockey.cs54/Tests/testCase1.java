package eg.edu.alexu.csd.datastructure.iceHockey.cs54;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class testCase1 {

	@Test
	void test() {
		MainClass obj =new MainClass();
		String[] photo= {"33JUBU33", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "OINFD33X" };
		int team=3;
		int threshold=16;
		Point[] expected={new Point (4,5),new Point(13,9),new Point(14,2) };
		
		//now the test assertion!!!----------------
		
		assertArrayEquals(expected, obj.findPlayers(photo, team, threshold));
	}

}
