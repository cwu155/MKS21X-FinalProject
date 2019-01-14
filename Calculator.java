import java.util.*;
import java.io.*;

public class Calculator{
  public static void main(String[] args){
    RealNumbers IGNORE;
    IGNORE = new RealNumbers();

    Equation userExpression;
    userExpression = new Equation();

    String directions = "To use this program, please enter the function that you want us to solve \nThe args entered should have a space in between (ie 2x + 3y) or in the format of add 2x 3y \nThis program can currently add, subtract, mulitply, divide, and find the GCF two strings \nIt can also evaluate an expression! (Without variables.) \nThe commands should be written in ALL LOWERCASE!! \nPlease do not simply enter x or y : Enter in the form 1x + 1y";
    // Scanner scan = new Scanner(System.in);
    // System.out.println("Enter a number or expression: ");
    // String input = scan.next();
    //
    // Integer result = Equation.evaluate(input);
    // System.out.println(result);
    if (args.length == 1){
      System.out.println(Equation.evaluate(args[0]));
      return;
      }

    if (args.length > 0){
      if (args[0].equals("add")){
        System.out.println(RealNumbers.add(args[1],args[2]));
      }
      if (args[0].equals("subtract")){
        System.out.println(RealNumbers.subtract(args[1],args[2]));
      }
      if (args[0].equals("multiply")){
        System.out.println(RealNumbers.multiply(args[1],args[2]));
      }
      if (args[0].equals("divide")){
        System.out.println(RealNumbers.divide(args[1],args[2]));
      }
      if (args[0].equals("gcf")){
        System.out.println(RealNumbers.GCF(args[1],args[2]));
      }
      if (args[1].equals("+")){
        System.out.println(RealNumbers.add(args[0],args[2]));
      }
      if (args[1].equals("-")){
        System.out.println(RealNumbers.subtract(args[0],args[2]));
      }
      if (args[1].equals("*")){
        System.out.println(RealNumbers.multiply(args[0],args[2]));
      }
      if (args[1].equals("/")){
        System.out.println(RealNumbers.divide(args[0],args[2]));
      }
    }
    else{
      System.out.println(directions);
    }
  }
}
