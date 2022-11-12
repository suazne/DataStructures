/* goal: create an infix calculator with an operator and operand stack
 * method: create methods to change string input to an a string array, check if an element is numeric,
 * check prpecedence of operators (order of operations), execute math functions (+,-,*,/), and use all
 * these methods in a larger method to execute the infix expression, returning the answer as the last
 * operand in the operand stack.
 */
import java.util.Stack;

public class InfixCalculator {
//methods
	//local method to determine if our char is a number (operand)
	static boolean isNumeric(String input) {
	    try {
	        int val = Integer.parseInt(input);//if the val is an integer this will work
	        return true;
	    } catch (NumberFormatException ex) {//else, throw exception and return false
	    	return false;
	    }
	}
	//method to test if preceding operator (operator1) has precedence over current operator (operator2)
	static boolean precedence(char operator1, char operator2) {
		//if operator1 is * or / and operator2 is + or -
		if ((operator1 == '*' || operator1 == '/')&&(operator2 == '+' || operator2 == '-')) {
			return false;//false: our current operator (operator2) doesn't have precedence
		}else {
			return true;//true: our current operator should be done first
		}
	}
	//method to carry out basic math (+,-,*,/) operators
	static int execute(char operator, int b, int a) {
		//switch block to execute each mini expression
		switch (operator) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0) {//TESTgotta watch out for undefined equations !!!!
				throw new UnsupportedOperationException("Undefined. Cannot divide by 0.");
			}
			return a / b;//after checking, execute
		default://if we get here, there is something wrong, so return a message:
			System.out.println("Sorry, you have entered an invalid character.");
			return 0;
		}
	}
	// method to execute calculation
	static int executeInfixCalculation(String input) {
		//create 2 stacks: one for operators and another for operands
		Stack<Character> operatorStack = new Stack<>();
		Stack<Integer> operandStack = new Stack<>();
		//split input string into an array of strings
		String[] equationElements = input.split(" ");
		//iterate thru each 'element' in the expression
		for (int i = 0; i < equationElements.length; i++) {
			String n = equationElements[i];//character we will look at thru each loop
				//if String is an operand (digit), push it into the operandStack
				if (isNumeric(n) == true) {
					operandStack.push(Integer.parseInt(n));
				}
				//if element is NOT a digit, check to see if it is an operator or invalid input
				else {
					char operator = n.charAt(0);
					//switch block for operators
					switch (operator) {
					case '+':
					case '-':
					case '*':
					case '/':
						//if the operatorStack is not empty, and the last operator has precedence over the current,
						if ((operatorStack.size() > 0)&&(precedence(operator, operatorStack.peek()))){
							//execute the previous operator with the two previous operands, then push the sol'n onto operandStack
							operandStack.push(execute(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
						}
						//push current operator onto stack
						operatorStack.push(operator);
					default:
						break;	
					}
			}
		}
		//after we have iterated thru the entire array of elements, execute any leftover items in the stacks
		while (operatorStack.size() > 0) {
			operandStack.push(execute(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
		}
		return operandStack.pop();
	}
//MAIN METHOD to run
	public static void main(String[] args) {
		String expression = "10 * 2 - 15";//this is the assigned expression from the assignment
		System.out.println("Answer: "+executeInfixCalculation(expression));//print answer!!!
	}

}
/* TIME COMPLEXITY: O(n) because as the string increases in length, the execution time increases approximately the same amount (for
 * loop iterates thru an array with the number of elements in the equation)
 * SPACE COMPLEXITY: O(n) because the number of data structures does not increase as the input increases. Because of this, 
 * space complexity is linear.
 */
