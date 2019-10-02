	import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;

import java.io.IOException;

import java.io.PrintStream;

public class CalculatorsStackArray {

     // stack

     public static ArrayStack<Integer> Stack_Operand = new ArrayStack<Integer>();

     // operator exist or not

     public static ArrayStack<Character> Stack_Operator = new ArrayStack<Character>();

     public static boolean has(char operator1, char operator2) {

          if (operator2 == '(' || operator2 == ')')

               return false;

          if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-'))

               return false;

          else

               return true;

     }

     //finding factorial of the given number

     public static int factorialMethod(int operand) {

          if (operand <= 1)

               return 1;

          else

               return operand * factorialMethod(operand - 1);

     }

     //Arithmetic operations on the two operands

     public static int evalArthmeticOperator(char op1, int y, int x)

     {

          switch (op1)

          {

          case '+'://addition

               return x + y;

          case '-'://subtraction

               return x - y;

          case '*'://multiplication

               return x * y;

          case '/'://division

               if (y == 0)

                     throw new UnsupportedOperationException("zero value");

               return x / y;      

          case '^'://power function

               return (int) Math.pow(x, y);

          }

          return 0;

     }

     //Method for check whether given character is number or not

     public static boolean isNumber(char op) {

          if (op >= '0' && op <= '9')

               return true;

          else

               return false;

     }

     public static int expevaluate(String expression)

     {//get expression as string

          char[] tok = expression.toCharArray();

          int i = 0;

          while (i < tok.length)

          {

               if (tok[i] == ' ') {

                     i++;

                     continue;

               }

               if (isNumber(tok[i])) {

                     StringBuffer buff = new StringBuffer();

                     while (i < tok.length && isNumber(tok[i]))

                          buff.append(tok[i++]);

               Stack_Operand.push(Integer.parseInt(buff.toString()));

               }

               else if (tok[i] == '(')

                     Stack_Operator.push(tok[i]);

               else if (tok[i] == ')')

               {

                     while (Stack_Operator.top() != '(')

                     Stack_Operand.push(evalArthmeticOperator(Stack_Operator.pop(), Stack_Operand.pop(), Stack_Operand.pop()));

                     Stack_Operator.pop();

               }

               else if (tok[i] == '+' || tok[i] == '-' || tok[i] == '*' || tok[i] == '/'||tok[i] == '^')

{

                     while (!Stack_Operator.isEmpty() && has(tok[i], Stack_Operator.top()))

                     Stack_Operand.push(evalArthmeticOperator(Stack_Operator.pop(), Stack_Operand.pop(), Stack_Operand.pop()));

                     Stack_Operator.push(tok[i]);

               }

               else if(tok[i] == '!'){

                     int f = factorialMethod(Stack_Operand.pop());

                     Stack_Operand.push(f);

               }

                    

               i++;

          }

          while (!Stack_Operator.isEmpty())

          Stack_Operand.push(evalArthmeticOperator(Stack_Operator.pop(), Stack_Operand.pop(), Stack_Operand.pop()));

          return Stack_Operand.pop();

     }

     public static void main(String[] args) throws IOException {

          File file11 = new File("input.txt");

          PrintStream o1 = new PrintStream(new File("output2.txt"));

          BufferedReader br11 = new BufferedReader(new FileReader(file11));

          String st11;

          while ((st11 = br11.readLine()) != null) {

               System.setOut(o1);

               System.out.println(st11);

               System.out.println(expevaluate(st11));

          }

     }

}

	