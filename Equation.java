import java.util.*;

public class Equation{
  //Solving an expression or equation using PEMDAS - Order of Operations
  //Shunting-Yard Algorithm

  public static String priority2 = "+-";
  public static String priority3 = "*/";
  public static String priority4 = "^";

  //Creates an array of tokens.
  public static String input = "4 + 18 / ( 9 - 3 )"; // Should take a user input in the future
  public static StringTokenizer st = new StringTokenizer(input); //Create StringTokenizer Object
  public static List<Token> Tokens = new ArrayList<Token>();   //Create ArrayList Object
  public static List<Token> Stack = new ArrayList<Token>(); //Creates a stack of operations.
  public static List<Token> Queue = new ArrayList<Token>(); //Creates a queue of the output.

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

        // While there are tokens to be read:
        // Read a token
        //   If it's a number add it to queue
        //   If it's an operator
        //         While there's an operator on the top of the stack with greater precedence:
        //                 Pop operators from the stack onto the output queue
        //                 Push the current operator onto the stack
        //   If it's a left bracket push it onto the stack
        //   If it's a right bracket
        //       While there's not a left bracket at the top of the stack:
        //               Pop operators from the stack onto the output queue.
        //               Pop the left bracket from the stack and discard it
        //       While there are operators on the stack, pop them to the queue

//Forms the operations stack and output stack. [Currently in progress]
// 4 + 18 / (9 - 3) --> 4, 18, 9, 3, -, /, +
// [4 + 18 / ( 9 - 3 )] size: 9

public static void formStacks(){
  for (int i = 0; i < Tokens.size(); i++){
    if (isNumber(Tokens.get(i)) == true){
      Queue.add(Tokens.get(i));
     } else {
       //if (Stack.size() == 0) {Stack.add(Tokens.get(i));} else {
       //if (Stack.get(stackIter).getPriority() < Tokens.get(i).getPriority()){
         Stack.add(Tokens.get(i));
         //stackIter += 1;
       }
    //  }
    if (Tokens.get(i).getString() == "("){
      Stack.add(Tokens.get(i));
    }
    // if (Tokens.get(i).getString() == ")"){
    //   while (Stack.get(Stack.size()-1).getString() != "("){
    //     Queue.remove(Queue.indexOf("("));
      }
      }
  // }
  //}

  public static void organizeStacks(){
    for (Token element : Stack){
      Queue.add(element);
    }
  }

    public static void main(String[] args) { //Testing purposes
      addTokens();
      setPriority();
      formStacks();
      for(Token element : Queue) {
            System.out.println(element.getString());
        }
      for(Token element : Stack){
        System.out.println(element.getString());
      }

      }
    }
