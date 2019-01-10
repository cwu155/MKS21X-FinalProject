import java.util.*;

public class Equation{
  //Solving an expression or equation using PEMDAS - Order of Operations
  //Shunting-Yard Algorithm

  public static String parenthesis = "()";
  public static String priority2 = "+-";
  public static String priority3 = "*/";
  public static String priority4 = "^";
  public static Token top;
  public static Integer result;

  //Creates an array of tokens.
  public static String infix; // Should take a user input in the future
  public static StringTokenizer st; //Create StringTokenizer Object
  public static List<Token> Tokens = new ArrayList<Token>();   //Create ArrayList Object
  public static List<Token> Stack = new ArrayList<Token>(); //Creates a stack of operations.
  public static List<Token> Queue = new ArrayList<Token>(); //Creates a queue of the output.
  public static List<Token> Numbers = new ArrayList<Token>();

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

  //Returns the element at the top of the stack.
  public static Token peek(){
    return Stack.get(Stack.size()-1);
  }

  //Basically a pop function? Helper function!
  public static void pop(){
    String right = Numbers.get(Numbers.size()-1).getString();
    String left = Numbers.get(Numbers.size()-2).getString();
    String operator = peek().getString();
    if (operator.equals("+")){result = Integer.valueOf(left) + Integer.valueOf(right);} else
    if (operator.equals("-")){result = Integer.valueOf(left) - Integer.valueOf(right);} else
    if (operator.equals("*")){result = Integer.valueOf(left) * Integer.valueOf(right);} else
    if (operator.equals("/")){result = Integer.valueOf(left) / Integer.valueOf(right);} else
    if (operator.equals("^")){result = Integer.valueOf(left) ^ Integer.valueOf(right);} else {
      System.out.println(operator);
    }
    Token resultToken = new Token(Integer.toString(result), 1);
    Numbers.add(resultToken);
  }


public static void splitInfix(){
  for (int i = 0; i < Tokens.size(); i++){
    if (isNumber(Tokens.get(i)) == true){
      Queue.add(Tokens.get(i));
      Numbers.add(Tokens.get(i));
    }
  }
  for (int i = 0; i < Tokens.size(); i++){
    if (isNumber(Tokens.get(i)) == false){
      Queue.add(Tokens.get(i));
      }
    }
  }

  public static String evaluate(String expression){
    infix = expression;
    st = new StringTokenizer(infix);
    addTokens();
    setPriority();
    splitInfix();

    for (Token element : Queue){
      if (isNumber(element)){Numbers.add(element);
      } else if (element.getString().equals("(")) {Stack.add(element);
      } else if (element.getString().equals(")")){
       top = peek();
       while ((!(top.getString().equals(")")) && (top != null))){
             pop();
             top = peek();
             for (Token thing : Stack){if (thing.getString().equals("(")){Stack.remove(thing);}}
       }
     } else {
       if (Stack.size() == 0){Stack.add(element);} else {
         top = peek();
         while ((!(parenthesis.contains(element.getString()))) && (top.getPriority() > element.getPriority())){
           pop();
           top = peek();
           Stack.add(element);
         }
       }
     }
    }

    while (peek() != null) {pop();}
    return Numbers.get(0).getString();
  }

    public static void main(String[] args) { //Testing purposes
      evaluate("4 + 18 / ( 9 - 3 )");

      System.out.println("Current Queue");
      for(Token element : Queue) {
            System.out.println(element.getString());
        }

      System.out.println("Current Stack");
      for(Token element : Stack){
         System.out.println(element.getString());
       }

      System.out.println("Current Numbers");
      for (Token element : Numbers){
        System.out.println(element.getString());
      }

      System.out.println(peek().getString());

      }
    }
