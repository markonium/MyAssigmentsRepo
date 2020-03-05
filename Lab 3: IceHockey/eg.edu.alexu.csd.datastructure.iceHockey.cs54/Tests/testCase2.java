package eg.edu.alexu.csd.datastructure.iceHockey.cs54;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class testCase2 {

	@Test
	void test() {
		MainClass obj =new MainClass();
		String[] photo= {"44444H44S4", "K444K4L444", "4LJ44T44XH", "444O4VIF44", "44C4D4U444", "4V4Y4KB4M4", "G4W4HP4O4W", "4444ZDQ4S4", "4BR4Y4A444", "4G4V4T4444" };
		int team=4;
		int threshold=16;
		Point[] expected={new Point(3,8),new Point (4,16),new Point (5,4), new Point(16,3), new Point(16,17),new Point (17,9)};
		
		//now the test assertion!!!----------------
		
		assertArrayEquals(expected, obj.findPlayers(photo, team, threshold));
	}

}
