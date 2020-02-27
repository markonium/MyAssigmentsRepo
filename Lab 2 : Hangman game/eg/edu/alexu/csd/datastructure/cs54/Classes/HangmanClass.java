package eg.edu.alexu.csd.datastructure.cs54;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class HangmanClass implements IHangman {
public String[] dictionary;
public char[] dispWord,check;
public int wordsSize=0;
public int flag=1,i,maxWrong,correct=0;
public String secretWord;
public String temp1="";

public void readIntoArray() {
	String[] words;
	try {
		Scanner f = new Scanner(new File("carsBrands.txt"));
		while(f.hasNextLine()) {
		wordsSize++;
		f.nextLine();
		}f.close();
		words=new String[wordsSize];
		Scanner m = new Scanner(new File("carsBrands.txt"));
		for(int i=0;i<wordsSize;i++) {
			words[i]=m.nextLine();
		}m.close();
		setDictionary(words);
	}catch(FileNotFoundException e){
		System.out.println("Error !! File not found, please create a file first");
	}
}
public void setDictionary(String[] words) {
	dictionary = new String[wordsSize];
	dictionary = words;
}
public String selectRandomSecretWord() {
	Random rand=new Random();
	secretWord = dictionary[rand.nextInt(wordsSize)];
	while(flag==1) {
	//checking the validity of the secret word
	//if invalid secret word is detected the game will automatically choose another word
	//moreover, if a uppercase letter is discovered it will be converted into lowercase in the words array
	for(i=0;i<secretWord.length();i++) {
		char letter= secretWord.charAt(i);
		if(letter<='z' && letter>='a') {continue;}
		else if(letter<='Z' && letter>='A') {letter-=32; continue;}
		else if(letter==' '||letter=='-'||letter=='\t') {continue;}
		else {break;}
	}if(i==secretWord.length()) {
		flag=0;
	}
	}dispWord=new char[secretWord.length()];
	check=new char[secretWord.length()];
	for(i=0;i<secretWord.length();i++) {
		check[i]='0';
		if(secretWord.charAt(i)==' ') {
			dispWord[i]=' ';
		}else if(secretWord.charAt(i)=='\t') {
			dispWord[i]='\t';
		}else if(secretWord.charAt(i)=='-') {
			dispWord[i]='-';
		}
		else {
		dispWord[i]='-';
		}temp1+=dispWord[i];
	}
	return secretWord;
}
public String guess(Character c) throws Exception{
	correct=0;
	char t=c;
	String temp="";
	if(t <='Z' && t>='A') {
	t-=32;
	}if(t <='z' && t>='a'){
		for(i=0;i<secretWord.length();i++) {
			if(secretWord.charAt(i)==t) {
				dispWord[i]=t;
				if(check[i]!=t) {
					check[i]=t;
	                correct=1;
				}
			}
			temp+=dispWord[i];
		}
		if(correct==0) {	
		if(maxWrong>0) {
		maxWrong--;
		}else {return null;}
		}return temp;
	}else {return null;}
}
public void setMaxWrongGuesses(Integer max) {
	if(max!=null) {
		maxWrong=max;
	}else {maxWrong=1;}
}

}
