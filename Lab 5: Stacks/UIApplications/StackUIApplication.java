package eg.edu.alexu.csd.datastructure.stack.cs54;

import java.util.EmptyStackException;
import java.util.Scanner;
/**
 * The main class to test the stack implementation
 * @author Fares M. Fouad
 *
 */
public class StackUIApplication {
	/**
	 * The main method
	 * @param args An array of strings which stores arguments passed by command line while starting the program
	 */
	public static void main(String[] args) {
		NodeStack testStack=new NodeStack();
		Scanner in=new Scanner(System.in);
		String op="I've been initialized";
		System.out.println("A stack has been created to be tested");
		while(!op.equals("6")){
			int flag=1;
			while(flag==1) {
				System.out.print("Please choose an operation\n1: Push\n2: Pop\n3: Peek\n4: Get size\n5: Check if empty\n6: Exit\n----------->");
				op=in.next();
				if(!op.equals("1") && !op.equals("2") && !op.equals("3") && !op.equals("4") && !op.equals("5") && !op.equals("6")) {
					System.out.println("Please enter a valid operation number !");
					flag=1;
				}else {
					flag=0;
				}
			}//Now we have valid operation number
			if(op.equals("1")) {
				System.out.print("Enter the object you want to push ----------->");
				testStack.push(in.next());
			}else if(op.equals("2")) {
				try {
					System.out.println("==============================================");
					System.out.println(testStack.pop());
					System.out.println("==============================================");
				}catch(EmptyStackException e) {
					System.out.println("==============================================");
					System.out.println("Stack is empty");
					System.out.println("==============================================");
				}
			}else if(op.equals("3")) {
				try {
					System.out.println("==============================================");
					System.out.println(testStack.peek());
					System.out.println("==============================================");
				}catch(EmptyStackException e) {
					System.out.println("==============================================");
					System.out.println("Stack is empty");
					System.out.println("==============================================");
				}
			}else if(op.equals("4")) {
				System.out.println("==============================================");
				System.out.println("Stack size is "+testStack.size());
				System.out.println("==============================================");
			}else if(op.equals("5")){
				System.out.println("==============================================");
				System.out.println(testStack.isEmpty());
				System.out.println("==============================================");
			}
		}
		
		
		in.close();
	}
}
