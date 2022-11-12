/* goal: without using library funtions, write a postfix calculator that adds and subtracts 
 * single digit numbers.
 * method: use a stack to keep track of operands, and once we reach an operator, execute the 
 * operator's function with the two preceding operands.
 */
import java.util.*;
public class SimpleCalculator {
	static boolean isDigit(char n) {//local method to determine if our char is a digit
		switch (n) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				return true;
			default:
				return false;
		}
	}
	//method to execute the calculation
	static int executePostfixCalculation(String input) {
		Stack<Integer> stack = new Stack<>();//create stack
		//set up a loop to loop thru each character in the string (**with respect to SPACES between)
		for (int i = 0; i < input.length(); i++ ) {
			char n = input.charAt(i);//character we will look at thru each loop
			if (n != ' ') {//if the char is NOT a space, execute the following:
				//if char is an operand (digit), push it into the stack
				if (isDigit(n) == true) {
					stack.push(n - '0');//by subtracting '0', the char will become an int. this way we can use the push(int) method
				}
				//if char is NOT a digit, check to see if it is an operator or invalid input
				else {
					int a = stack.pop();//pull out stack value 1
					int b = stack.pop();//pull out stack value 2 
					if (n == '+') {//if n = +, we add b (value 2) and a (value 1) operands we popped from the stack
						stack.push(b + a);//push the sum back into the stack
					}else if (n == '-') {//if n = -, we subtract a (value 1) from b (value 2) operands we popped from the stack
						stack.push(b - a);//push the difference back into the stack
					}
					/* TEST CASE: here is where we would check for invalid operators or other inputs. Please
					 * note that this calculator is for single digit addition and subtraction ONLY. that is 
					 * why the parameters are set up that way. In order for us to have a more complex calculator,
					 * we would need to set up a way to look at each digit in its 10's or 100's or 10ths (if dealing
					 * with doubles), which would be multiplying/dividing my multiples of 10. SEE CODE BELOW FOR ERROR 
					 * TEST CASE. this test case comes AFTER we have confirmed that n is not a digit or a space.
					 * else {
					 * 	  System.out.println("Sorry, your input, "+n+", is invalid.\nPlease only enter int values between 0-9 and operation values + or -");
					}*/
				}
			}
		}
		return stack.pop();//return value from the stack after traversing thru whole string and executing
	}
	public static void main(String[] args) {
		String input = "3 5 + 1 -";//3 + 5 - 1
		System.out.println("Answer: "+executePostfixCalculation(input));//execute and print ans
	}
	//TIME COMPLEXITY: Our time complexity is O(n), as we loop thru the string of size n once.
	//SPACE COMPLEXITY: Our space complexity is O(n), as the space needed grows linearly as the input grows.
}
