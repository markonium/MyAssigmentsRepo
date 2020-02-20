import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddTest {

	@Test
	void testAdd() {
		Calci test = new Calci();
		assertEquals(7,test.add(3,4),"3+4 should equals 7");
		assertEquals(2,test.add(-8,10),"-8+10 should equals 2");
		assertEquals(2,test.add(6,-4),"6+(-4) should equals 2");
	}
}
