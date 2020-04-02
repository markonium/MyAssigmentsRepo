package eg.edu.alexu.csd.datastructure.stack.cs54;
/**
 * This class implements the IExpressionEvaluator interafce
 * @author Fares M. Fouad
 *
 */
public class ExpressionEvaluatorClass implements IExpressionEvaluator{
	NodeStack stack=new NodeStack(); int detectChar,varNum; boolean detectVar;
	NodeStack stack1=new NodeStack(); NodeStack stack2=new NodeStack();
	/**
	 * This method checks for invalid parenthesis setup of invalid operators setup
	 * @param expression The infix expression to be checked
	 * @return 0 if the expression is invalid and 1 otherwise
	 */
	private int checkInfix(String expression) {
		detectChar=0; varNum=0; detectVar=false;
		StringBuilder indicator=new StringBuilder (expression);
		//--------------------------------------------------------------
		while(!stack.isEmpty()) {
			stack.pop();
		}
		if(expression.equals("")) {
			return 0;
		}
		for(int i=0; i < expression.length(); i++) {	
			if(detectChar==0 && ( Character.isDigit(expression.charAt(i)) || Character.isAlphabetic(expression.charAt(i)) ) ) {
				detectChar=1;
			}
			if(expression.charAt(i)==' ' || expression.charAt(i)=='\t' || expression.charAt(i)=='\n') {continue;}
			else if(detectChar==0 && (expression.charAt(i)=='*' || expression.charAt(i)=='/' || expression.charAt(i)==')') ) { return 0;}
			else if(!Character.isDigit(expression.charAt(i)) && !Character.isAlphabetic(expression.charAt(i)) && expression.charAt(i)!='*' && expression.charAt(i)!='/' && expression.charAt(i)!='+' && expression.charAt(i)!='-' && expression.charAt(i)!='(' && expression.charAt(i)!=')') {return 0;}
			else if(Character.isAlphabetic(expression.charAt(i))) {
				if(indicator.charAt(i)==expression.charAt(i)) {
					varNum++;
				}
				for(int t=i; t<expression.length(); t++) {
					if(indicator.charAt(t) == expression.charAt(i)) {
						indicator.setCharAt(t, '0');
					}
				}
				detectVar=true;
				for(int j=i+1; j < expression.length(); j++) {
					if(expression.charAt(j)==' ' || expression.charAt(j)=='\t' || expression.charAt(j)=='\n') {continue;}
					else if(Character.isAlphabetic(expression.charAt(j))) {
						return 0;
					}else {break;}
				}
			}
			else if(expression.charAt(i)=='(') {
				stack.push('(');
				for(int j=i+1; j < expression.length(); j++) {
					if(expression.charAt(j)==' ' || expression.charAt(j)=='\t' || expression.charAt(j)=='\n') {continue;}
					else if(expression.charAt(j)=='/' || expression.charAt(j)=='*') {
						return 0; 
					}else {break;}
				}
			}else if(expression.charAt(i)==')') {
				if((i+1) < expression.length()) {
					for(int j=i+1; j < expression.length(); j++) {
						if(expression.charAt(j)==' ' || expression.charAt(j)=='\t' || expression.charAt(j)=='\n') {continue;}
						else if(expression.charAt(j)=='(') {
							return 0;
						}else {break;}
					}
				}
				if(!stack.isEmpty() && (char)stack.pop()!='(') {
					return 0;
				}
			}
			else if(expression.charAt(i)=='*' || expression.charAt(i)=='/' || expression.charAt(i)=='+' || expression.charAt(i)=='-') {
				if((i+1) < expression.length()) {
					int found=0;
					for(int j=i+1; j < expression.length(); j++) {
						if(expression.charAt(j)==' ' || expression.charAt(j)=='\t' || expression.charAt(j)=='\n') {continue;}
						else if(expression.charAt(j)=='*' || expression.charAt(j)=='/' || expression.charAt(j)==')') {
							return 0;
						}else {
							found=1;
							break;
						}
					}
					if(found==0) {
						return 0;
					}
				}else {
					return 0;
				}
			}
		}if(!stack.isEmpty()) {
			return 0;
		}
		for(int i=0; i<stack.size(); i++) {
			stack.pop();
		}//reaching this point means that the test succeeded
		if(detectChar==0) {
			return 0;
		}
		return 1;
	}
	/**
	 * This method eliminate extra + or - operators
	 * such that ++=+ , +-=- and --=+
	 * @param expression The infix to deal with
	 * @return The infix expression after modification
	 */
	private String dealWithMultiblePlusOrMinus(String expression) {
		String temp1,temp2,temp3; int lastOperatorIndex=0; detectChar=0; int k;
		for(int i=0; i < expression.length(); i++) {
			temp1=""; temp2=""; temp3="";
			if(detectChar==0 && ( Character.isDigit(expression.charAt(i)) || Character.isAlphabetic(expression.charAt(i)) ) ) {
				detectChar=1;
			}
			else if(expression.charAt(i)==' ' || expression.charAt(i)=='\t' || expression.charAt(i)=='\n') {continue;}
			else if(detectChar==0 && (expression.charAt(i)=='+' || expression.charAt(i)=='-') ) {
				expression='0'+expression; i=-1;
			}		
			else if(expression.charAt(i)=='+') {
				lastOperatorIndex=i;
				for(int j=i+1; j<expression.length(); j++) {
					if(expression.charAt(j)==' ' || expression.charAt(j)=='\t' || expression.charAt(j)=='\n') {
						continue;
					}else if(expression.charAt(j)=='+') {
						for(int a=0; a<lastOperatorIndex ;a++) {
							temp1+=expression.charAt(a);
						}for(int b=j+1; b< expression.length() ;b++) {
							temp2+=expression.charAt(b);
						}expression=temp1+'+'+temp2;
						i--;
						break;
					}else if(expression.charAt(j)=='-') {
						for(int a=0; a<lastOperatorIndex ;a++) {
							temp1+=expression.charAt(a);
						}for(int b=j+1; b< expression.length() ;b++) {
							temp2+=expression.charAt(b);
						}expression=temp1+'-'+temp2;
						i--;
						break;
					}else {
						break;
					}
				}
			}else if(expression.charAt(i)=='-') {
				lastOperatorIndex=i;
				for(int j=i+1; j<expression.length(); j++) {
					lastOperatorIndex=i;
					if(expression.charAt(j)==' ' || expression.charAt(j)=='\t' || expression.charAt(j)=='\n') {
						continue;
					}else if(expression.charAt(j)=='-') {
						for(int a=0; a<lastOperatorIndex ;a++) {
							temp1+=expression.charAt(a);
						}for(int b=j+1; b< expression.length() ;b++) {
							temp2+=expression.charAt(b);
						}expression=temp1+'+'+temp2;
						i--;
						break;
					}else if(expression.charAt(j)=='+') {
						for(int a=0; a<lastOperatorIndex ;a++) {
							temp1+=expression.charAt(a);
						}for(int b=j+1; b< expression.length() ;b++) {
							temp2+=expression.charAt(b);
						}expression=temp1+'-'+temp2;
						i--;
						break;
					}else {
						break;
					}
				}
			}
		}
		
		for(int i=0; i<expression.length(); i++) { //deals with multiplication with negative integer
			temp1=""; temp2=""; temp3=""; k=0;
			if(expression.charAt(i)=='*' || expression.charAt(i)=='/') {
				lastOperatorIndex=i;
				for(int j=i+1; j<expression.length(); j++) {
					if(expression.charAt(j)==' ' || expression.charAt(j)=='\t' || expression.charAt(j)=='\n') {
						continue;
					}else if(expression.charAt(j)=='+') {
						for(int a=0; a<=lastOperatorIndex; a++) {
							temp1+=expression.charAt(a);
						}for(int b=j+1; b< expression.length(); b++) {
							temp2+=expression.charAt(b);
						}expression=temp1+temp2;
						break;
					}else if(expression.charAt(j)=='-') {
						for(int a=0; a<=lastOperatorIndex; a++) {
							temp1+=expression.charAt(a);
						}for(k=j+1; k<expression.length(); k++) {
							if(expression.charAt(j)==' ' || expression.charAt(j)=='\t' || expression.charAt(j)=='\n') {
								continue;
							}else if(Character.isDigit(expression.charAt(k))) {
								temp3+=expression.charAt(k);
							}else {break;}
						}for(int b=k ; b<expression.length(); b++) {
							temp2+=expression.charAt(b);
						}
						expression=temp1+"(0-"+temp3+')'+temp2;
						break;
					}else {break;}
				}
			}
		}
		return expression;
	}
	
	public String infixToPostfix(String expression) {
		String postFix="";
		if(checkInfix(expression)==0) {
			throw new IllegalArgumentException("Invalid infix expression !");
		}expression=dealWithMultiblePlusOrMinus(expression);
		//only valid infix will reach this point
		for(int i=0; i< expression.length(); i++) {
			if(expression.charAt(i)==' ' || expression.charAt(i)=='\t' || expression.charAt(i)=='\n') {continue;}
			else if(Character.isAlphabetic(expression.charAt(i)) ) {
				postFix+=expression.charAt(i);
				postFix+=' ';
			}
			else if(Character.isDigit(expression.charAt(i)) ) {
				postFix+=expression.charAt(i);
				if(i+1 < expression.length()) {
					for(int j=i+1; j<expression.length(); j++) {
						if(expression.charAt(j)==' ' || expression.charAt(j)=='\t' || expression.charAt(j)=='\n' ){
							i++;
							continue;
						}
						else if(Character.isDigit(expression.charAt(j)) ) {
							postFix+=expression.charAt(j);
							i++;
						}else {break;}
					}
				}postFix+=' ';
			}
			
			else if(expression.charAt(i)=='(') {
				stack.push(expression.charAt(i));
			}
			
			else if(expression.charAt(i)=='*' || expression.charAt(i)=='/') {
				while(true) {
					if(!stack.isEmpty() && ((char)stack.peek()=='*' || (char)stack.peek()=='/')  ) {
						postFix+=(char)stack.pop(); postFix+=' ';
					}else{
						stack.push(expression.charAt(i));
						break;
					}
				}	
			}
			
			else if(expression.charAt(i)=='+' || expression.charAt(i)=='-') {
				while(true) {
					if(!stack.isEmpty() && !( (char)stack.peek()=='(' ) ) {
						postFix+=(char)stack.pop(); postFix+=' ';
					}else {
						stack.push(expression.charAt(i));
						break;
					}
				}	
			}
			
			else if(expression.charAt(i)==')') {
				while((char)stack.peek()!='(') {
					postFix+=(char)stack.pop(); postFix+=' ';
				}stack.pop();
			}
			
		}while(!stack.isEmpty()) {
			postFix+=stack.pop(); 
			if(!stack.isEmpty()) {
				postFix+=' ';
			}
		}
		return postFix;
	}
	/**
	 * This method substitutes the variable in the post fix expression
	 * @param expression The post fix expression
	 * @return The postfix expression to substitute in
	 */
	private String substituteVariables(String expression) {
		String t1,t2,t3; char temp=' ';
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}for(int i=0; i<expression.length(); i++) {
			if(expression.charAt(i)==' ') {
				continue;
			}else if(Character.isAlphabetic(expression.charAt(i))) {
				temp=expression.charAt(i);
				for(int j=i; j<expression.length(); j++) {
					t1="";t2="";t3="";
					if(temp==expression.charAt(j)) {
						for(int a=0; a<j ; a++){
							t1+=expression.charAt(a);
						}for(int b=j+1; b<expression.length() ; b++){
							t2+=expression.charAt(b);
						}t3=Integer.toString((int)stack2.peek());
						expression=t1+t3+t2;
					}
				}stack2.pop();
			}
		}
		return expression;
	}
	
	public int evaluate(String expression) {
		String temp; float f1,f2,f3;
		if(!stack1.isEmpty()) {
			expression=substituteVariables(expression);
		}
		for(int i=0; i<expression.length(); i++) {
			temp=""; f1=0; f2=0; f3=0;
			if(expression.charAt(i)==' ' || expression.charAt(i)=='\t' || expression.charAt(i)=='\n' ){
				continue;
			}
			else if(Character.isDigit(expression.charAt(i))) {
				temp+=expression.charAt(i);
				for(int j=i+1; expression.charAt(j)!=' '; j++) {
					i++;
					if(Character.isDigit(expression.charAt(j))) {
						temp+=expression.charAt(j);
					}else {break;}
				}
				stack.push(temp);
			}else if(expression.charAt(i)=='+') {	
				stack.push( Float.toString(Float.parseFloat((String)stack.pop()) + Float.parseFloat((String)stack.pop())) );
			}else if(expression.charAt(i)=='-') {
				f1=Float.parseFloat((String)stack.pop());
				f2=Float.parseFloat((String)stack.pop());
				f3=f2-f1;
				stack.push( Float.toString(f3) );
			}else if(expression.charAt(i)=='*') {	
				stack.push( Float.toString(Float.parseFloat((String)stack.pop()) * Float.parseFloat((String)stack.pop())) );
			}else if(expression.charAt(i)=='/') {	
				f1=Float.parseFloat((String)stack.pop());
				f2=Float.parseFloat((String)stack.pop());
				if(f1==0) {
					throw new ArithmeticException("Error division by zero is not allowed !");
				}
				f3=f2/f1;
				stack.push( Float.toString(f3) );
			}
		}return (int)Float.parseFloat((String)stack.pop());
	}
}
