package eg.edu.alexu.csd.datastructure.stack.cs54;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test02 {
	//Please note that test cases from 1 to 15 i'll be testing infix to postFix cases
	@Test
	void testInfixToPostfix() {
		ExpressionEvaluatorClass o=new ExpressionEvaluatorClass();
		String postfix=o.infixToPostfix("1*2/300");
		assertEquals("1 2 * 300 /",postfix);
	}

}
