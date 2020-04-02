package eg.edu.alexu.csd.datastructure.stack.cs54;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The main/driver class to test the conversion from infix to postfix 
 * @author Fares M. Fouad
 *
 */
public class expressionEvaluatorUIApplication {
	/**
	 * The main method
	 * @param args An array of strings which stores arguments passed by command line while starting the program
	 */
	public static void main(String[] args) {
		ExpressionEvaluatorClass o=new ExpressionEvaluatorClass();
		Scanner in =new Scanner(System.in); int retryFlag=1; String postFix=""; int varValues=0,exit=0;
		while(retryFlag==1) {
			retryFlag=0;
			System.out.println("Rules:\n1) Multible + or - will be converted before processing the infix according to the rules ++=+ , +-=- and --=+");
			System.out.println("2) Negative numbers will be processed by adding dummy zero example: 5/-2 = 5/(0-2)");
			System.out.println("3) Division by zero will not cause a problem in conversion to postfix but it will throw exception in evaluation");
			System.out.println("=====================================================");
			System.out.print("Please enter an infix expression\n------------>  ");
			try {
				postFix=o.infixToPostfix(in.next());
			}catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
				retryFlag=1;
			}
		}//At this point we have a valid infix !
		retryFlag=1; int temp=o.varNum;
		System.out.println("================================");
		System.out.println("The post fix is --> "+postFix);
		System.out.println("================================");
		if(o.detectVar) {
			System.out.println(o.varNum + " variables detected !");
			while(temp!=0) {
				System.out.println("Enter the variables values to substitute separated by enter\nPlease note that you have to enter the values of variables respectevily according to ther appearance\nor enter 0 to exit");
				System.out.print("----->  ");
				try {
					varValues=in.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("Invalid variable value, try again");
					in.nextLine();
					continue;
				}if(varValues==0) {
					System.out.println("Thank you for using my mini-project !");
					exit=1;
					break;
				}else {
					temp--;
					o.stack1.push(varValues);
					if(temp!=0) {
					System.out.println(temp+" variable value(s) remained");
					}else {
						System.out.println("Well done all variables values have been stored succeesfully !");
					}
				}
			}
		}if(exit==0) {
			System.out.println("================================");
			System.out.println("The value of the postfix after evalation");
			try {
				System.out.println("---------------> "+ o.evaluate(postFix));
			}catch(ArithmeticException e) {
				System.out.println(e.getMessage() + "\nrelaunch and try again ");
			}
			System.out.println("================================");
		}
		in.close();
	}

}
