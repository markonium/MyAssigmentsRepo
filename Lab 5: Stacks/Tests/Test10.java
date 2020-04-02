package eg.edu.alexu.csd.datastructure.stack.cs54;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test10{
	//Please note that test cases from 1 to 15 i'll be testing infix to postFix cases
	@Test
	void testInfixToPostfix() {
		ExpressionEvaluatorClass o=new ExpressionEvaluatorClass();
		try {
			o.infixToPostfix("(4+2 / (8*4)");//A right bracket is missing 
			fail();
		}catch(IllegalArgumentException e) {
			assertEquals("Invalid infix expression !",e.getMessage());
		}	
	}

}