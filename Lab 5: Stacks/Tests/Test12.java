package eg.edu.alexu.csd.datastructure.stack.cs54;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test12{
	//Please note that test cases from 1 to 15 i'll be testing infix to postFix cases
	@Test
	void testInfixToPostfix() {
		ExpressionEvaluatorClass o=new ExpressionEvaluatorClass();
		try {
			o.infixToPostfix(" 5+2/8+10*2 + ");//The infix cannot end with a binary operator
			fail();
		}catch(IllegalArgumentException e) {
			assertEquals("Invalid infix expression !",e.getMessage());
		}	
	}

}