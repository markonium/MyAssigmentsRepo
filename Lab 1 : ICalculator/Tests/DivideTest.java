import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DivideTest {

	@Test
	void testDivide() {
		Calci test = new Calci();
		assertEquals(3,test.divide(9,3)," 9/3 should equals 3");
		assertEquals(0.2,test.divide(1,5),0.0000001,"We provided a delta between actual and expected value in case of float");
		assertEquals(-4,test.divide(12,-3)," 12/(-3) should equals -4");
		assertEquals(0,test.divide(0,7)," 0/7 should equals 0");
		/*Dividing ny zero has been handled in the main function to give an error to the user that division by zero is not allowed*/  
	}

}
