import java.util.Scanner;

public class Calci implements ICalculator{
    public int add(int x,int y) {
    	return x+y;
    }
    public float divide(int x,int y)throws RuntimeException{
    	float x1=x; float y1=y;
    	return x1/y1;
    }
	public static void main(String[] args) {
		Calci result=new Calci();
		int flag=0;
		Scanner in= new Scanner(System.in);
		while(flag==0) {
		System.out.println("Please, enter two numbers x , y respectively separated by the Enter key");
		int x=in.nextInt(); int y=in.nextInt();
		System.out.println("Please, choose the operation:\n1)Addition\n2)Division x/y\n3)Division y/x");
		int op=in.nextInt();
		if(op==1) {
			System.out.println(x+"+"+y+"="+result.add(x,y));
			flag=1;
		}else if(op==2) {
			if(y==0) {
				System.out.println("Error ! cannot divide by Zero, try again with different value for y");
			}else {
				System.out.println(x+"/"+y+"="+result.divide(x,y));
				flag=1;
			}
		}else if(op==3) {
			if(x==0) {
				System.out.println("Error ! cannot divide by Zero, try again with different value for x");
			}else {
				System.out.println(y+"/"+x+"="+result.divide(y,x));
				flag=1;
			}
		}else {
			System.out.println("Please re-enter x , y and choose a valid opertion number this time");
		}
		}		in.close();
		System.exit(0);
	}
}
