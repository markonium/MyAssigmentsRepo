package eg.edu.alexu.csd.datastructure.stack.cs54;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test15{
	//Please note that test cases from 1 to import org.junit.jupiter.api.Test; i'll be testing infix to postFix cases
	@Test
	void testInfixToPostfix() {
		ExpressionEvaluatorClass o=new ExpressionEvaluatorClass();
		try {
			o.infixToPostfix("(1+2)(3*4)");//The infix cannot contain right bracket followed by left bracket
			fail();
		}catch(IllegalArgumentException e) {
			assertEquals("Invalid infix expression !",e.getMessage());
		}	
	}

}