package eg.edu.alexu.csd.datastructure.stack.cs54;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test20 {
	//Please note that test cases from 1 to 15 i'll be testing infix to postFix cases
	@Test
	void testInfixToPostfix() {
		ExpressionEvaluatorClass o=new ExpressionEvaluatorClass();
		try {
			o.evaluate(o.infixToPostfix("1/0"));
			fail();
		}catch(ArithmeticException e){
			assertEquals("Error division by zero is not allowed !",e.getMessage());
		}
	}

}