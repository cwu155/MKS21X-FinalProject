import java.util.*;

public class Equation{
  //Solving an expression or equation using PEMDAS - Order of Operations
  //Shunting-Yard Algorithm

  //Creates an array of tokens.
  public static String input = "1 + 2"; // Should take a user input in the future
  public static StringTokenizer st = new StringTokenizer(input, " "); //Create StringTokenizer Object
  public static List<String> Tokens = new ArrayList<String>();   //Create ArrayList Object

  //Adds tokens from input into ArrayList Tokens
  public static void addTokens(){
    while(st.hasMoreTokens()) {
      Tokens.add(st.nextToken());
      }
    }

  public static boolean isNumber(String inputToken){
    try {
        double token = Double.parseDouble(inputToken);
        } catch (NumberFormatException nfe) {
          return false;
        }
      return true;
  }

  //Creates a stack of operations.
  public static List<String> Operations = new ArrayList<String>();

  //Creates a queue of the output.
  public static List<String> Output = new ArrayList<String>();

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


    public static void main(String[] args) { //Testing purposes
      addTokens();

      }
    }
