package eg.edu.alexu.csd.datastructure.stack.cs54;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test13{
	//Please note that test cases from 1 to 15 i'll be testing infix to postFix cases
	@Test
	void testInfixToPostfix() {
		ExpressionEvaluatorClass o=new ExpressionEvaluatorClass();
		try {
			o.infixToPostfix("(/2 + 3)");//The infix cannot contain left bracket followed by * or /
			fail();
		}catch(IllegalArgumentException e) {
			assertEquals("Invalid infix expression !",e.getMessage());
		}	
	}

}