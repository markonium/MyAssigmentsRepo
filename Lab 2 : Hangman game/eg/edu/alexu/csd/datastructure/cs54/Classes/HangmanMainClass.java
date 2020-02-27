package eg.edu.alexu.csd.datastructure.cs54;
import java.util.Scanner;
import java.util.InputMismatchException;
public class HangmanMainClass {


	public static void main(String[] args) throws Exception {
		HangmanClass n=new HangmanClass();
		int flag1=1,flag2=1;
		char g;
		String temp;
		Scanner in=new Scanner(System.in);
		try {
			
		while(flag1==1) {
		System.out.print("\t\t\t\tWelcome to Hangman !!\n");
		System.out.print("\n\t\t\tThe game dictionary is about car brands\n\t\t\tand it contains 20 brands\n\n\t\t\t\t1)Use pre-existing dictionary\n\t\t\t\t2)Exit\n");
		System.out.print("\n-------->");
		int x = in.nextInt();
		if(x==1) {
			flag1=0;
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            n.readIntoArray();
			n.selectRandomSecretWord();
			System.out.print("\t\tEnter maximum number of wrong guesses you want\n");
			System.out.print("\n-------->");
			int y=in.nextInt();
			n.setMaxWrongGuesses(y);
			System.out.print("\n\n\n\n");
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.print("\t\tA car brand has been choosen randomly !!\n");
			System.out.print("\t\t\tRemaining wrong guesses: "+n.maxWrong+"\n");
			System.out.print("\tThe secret word---->    "+n.temp1+"\n");
			System.out.print("\t\t\t\tGuess a letter !!\n");
			System.out.print("\n-------->");
			
			while(n.maxWrong!=0) {
            g=in.next().charAt(0);
            temp=n.guess(g);
            if(temp==null) {
            	System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            	System.out.print("\tError!! only letters are allowed, please try again\n");
            	System.out.print("\t\t\tRemaining wrong guesses: "+n.maxWrong+"\n");
    			System.out.print("\t\t\t\tGuess a letter !!\n");
    			System.out.print("\n-------->");
            	continue;
            }
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.print("\t\t\tRemaining wrong guesses: "+n.maxWrong+"\n");
            System.out.print("\tThe secret word---->    "+temp+"\n");
            System.out.print("\t\t\t\tGuess a letter !!\n");
			System.out.print("\n-------->");
			if(temp.equals(n.secretWord)) {
			flag2=0;
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.print("\t\tCongratulation you guessed the right word !!\n\n\n\n");
			}
			}if(flag2==1) {
				System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.print("\t\tYou failed !! .. better luck next time !!\n\n\n\n");
			}
			
			
		}else if(x==2) {
			flag1=0;
			System.exit(0);
		}else {
			continue;
		}
		}
		
		}catch(InputMismatchException e) {
			System.out.print("Error please rerun and input a valid number");
		}
	in.close();
	}

}
