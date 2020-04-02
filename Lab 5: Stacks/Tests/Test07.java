package eg.edu.alexu.csd.datastructure.stack.cs54;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test07{
	//Please note that test cases from 1 to 15 i'll be testing infix to postFix cases
	@Test
	void testInfixToPostfix() {
		ExpressionEvaluatorClass o=new ExpressionEvaluatorClass();
		String postfix=o.infixToPostfix("2+-2+1++++3---8/-4"); //Note that a dummy zero will be add to -4 put not -2 because +- == - already
		assertEquals("2 2 - 1 + 3 + 8 0 4 - / -",postfix);
	}

}