import java.util.*;

public class Expression{
  //Solving an expression or equation using PEMDAS - Order of Operations
  //Shunting-Yard Algorithm
  public static String priority2 = "+-";
  public static String priority3 = "*/";
  public static String priority4 = "^";
  public static String functions = "sin";
  public static Integer newNumber;

  //Creates an array of tokens.
  public static String infix; // Should take a user input in the future
  public static StringTokenizer st; //Create StringTokenizer Object
  public static List<Token> Tokens = new ArrayList<Token>();   //Create ArrayList Object
  public static List<Token> Stack = new ArrayList<Token>(); //Creates a stack of operations.
  public static List<Token> Queue = new ArrayList<Token>(); //Creates a queue of the output.
  public static Stack<Double> stack = new Stack<Double>();

  public Expression(){}

  //Checks to see if input has spaces. If it does not, insert a space.
   public static String formatInput(String input){
     String result = "";
     if (!(input.contains(functions))){
       for (int i = 0; i < input.length(); i++){
         result += input.substring(i, i+1) + " ";
        }
      } else {return input;}
        return result;
   }

  //Adds tokens from the user's input into ArrayList Tokens.
  public static void addTokens(){
    while(st.hasMoreTokens()) {
      Token newToken = new Token(st.nextToken(), 1);
      Tokens.add(newToken);
      }
    }

  //Sets the priority of each token. This code should be more efficient.
  public static void setPriority(){
    for (Token element : Tokens){
      if (priority2.contains(element.getString())){
        element.setPriority(2);
      } else if (priority3.contains(element.getString())){
        element.setPriority(3);
      } else if (priority4.contains(element.getString())){
        element.setPriority(4);
      } else {
        element.setPriority(1);
      }
    }
  }

  //Checks to see if the token is numeric.
  public static boolean isNumber(Token inputToken){
    try {
        double token = Double.parseDouble(inputToken.getString());
        } catch (NumberFormatException nfe) {
          return false;
        }
      return true;
  }

  //Pretty unnecessary.
  public static boolean isFunction(Token inputToken){
    return (functions.contains(inputToken.getString()));
  }

  //Returns the element at the top of the stack.
  public static Token peek(){
    return Stack.get(Stack.size()-1);
  }

  //Helper function!
  public static void addTop(){
    Token topToken = Stack.get(Stack.size()-1);
    Queue.add(topToken);
    Stack.remove(topToken);
  }

  //Converts infix to postfix notation.
  public static void infixToPostfix(String expression){
    infix = formatInput(expression);
    st = new StringTokenizer(infix);
    addTokens();
    setPriority();

    for (Token element : Tokens){
      if (isNumber(element)){Queue.add(element);
      } else if (isFunction(element)){Stack.add(element);
      } else if (element.getString().equals("(")){Stack.add(element);
      } else if (element.getString().equals(")")){
        while (!(peek().getString().equals("("))){
          addTop();
        } if (peek().getString().equals("(")){Stack.remove(peek());}
        } else {
            if (Stack.size() == 0){Stack.add(element);}
            else if (element.getPriority() >= peek().getPriority()){
              Stack.add(element);
            } else {
              for (int i = Stack.size()-1; i >= 0; i--){
                Queue.add(Stack.get(i));
                Stack.remove(Stack.get(i));
              }
                Stack.add(element);
            }
          }
        }
      if (Stack.size() != 0){
        for (int i = Stack.size()-1; i >= 0; i--){
          Queue.add(Stack.get(i));
          Stack.remove(Stack.get(i));
        }
      }
    }

  //Evaluates postfix notation.
  public static Double evaluate(String expression){
    infixToPostfix(expression);

    for (Token element : Queue){
                if (element.getString().equals("+")){
                    stack.push(stack.pop() + stack.pop());
                  } else if (element.getString().equals("-")) {
                    stack.push(-stack.pop() + stack.pop());
                  } else if (element.getString().equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                  } else if (element.getString().equals("/")) {
                    Double divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                  } else if (element.getString().equals("^")) {
                    Double first = stack.pop();
                    Double second = stack.pop();
                    stack.push(Math.pow(second, first));
                  } else if (element.getString().equals("sin")){
                    stack.push(Math.sin(Math.toRadians(stack.pop())));
                  } else if (element.getString().equals("cos")){
                    stack.push(Math.cos(Math.toRadians(stack.pop())));
                  } else if (element.getString().equals("tan")){
                    stack.push(Math.tan(Math.toRadians(stack.pop())));
                  }
                    else {
                    stack.push(Double.valueOf(element.getString()));
                  }
                }
        return stack.pop();
    }


    public static void main(String[] args) { //Testing purposes
      //for (Token element : Tokens){System.out.println(element.getString());}
      //System.out.println(formatInput("sin 30"));
      System.out.println(evaluate("( sin 30 ) + 1"));

      }
    }
