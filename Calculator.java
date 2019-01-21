import java.util.*;
import java.io.*;

public class Calculator{
  public static void main(String[] args){

<<<<<<< HEAD
    String directions = "To use this program, please enter the function that you want us to solve \nThe args entered should have a space in between (ie 2x + 3y) or in the format of add 2x 3y \nThis program can currently add, subtract, mulitply, divide, and find the GCF two strings \nIt can also evaluate an expression! (Without variables.) \nThe commands should be written in ALL LOWERCASE!! \nPlease do not simply enter x or y : Enter in the form 1x + 1y";
=======
    String directions = "To use this program, please enter the function that you want us to solve \nThe args entered should have a space in between (ie 2x + 3y) or in the format of add 2x 3y \nThis program can currently add, subtract, mulitply, divide, and find the GCF two strings \nIt can also evaluate an expression! (Without variables.) \nThe commands should be written in ALL LOWERCASE!! \nPlease do not simply enter x or y : Enter in the form 1x + 1y \n You can also solve for x in linear equations (ie 3x + 9871 = 984) \n To use this this feature, please type in equation (all lowercase) and enter the equation between quotations (see example above)";
    // Scanner scan = new Scanner(System.in);
    // System.out.println("Enter a number or expression: ");
    // String input = scan.next();
    //
    // Integer result = Equation.evaluate(input);
    // System.out.println(result);
    if (args.length == 1){
      System.out.println(Expression.evaluate(args[0]));
      return;
      }
>>>>>>> a7a5a00826e496543ac2bdd83ab37dba38b4c1b4

      System.out.println("MAIN MENU:");
      System.out.println("[1] EXPRESSION");
      System.out.println("[2] EQUATION");
      System.out.println("[3] QUIT\n");

      Scanner sc = new Scanner(System.in);
      System.out.print("input: ");
      int menu_input = sc.nextInt();

      switch(menu_input) {
        case 1:
          Scanner sce = new Scanner(System.in);
          System.out.println("\nEnter an expression to evaluate:");
          String userExpression = sce.nextLine();

          System.out.println(Expression.evaluate(userExpression));
        }
      }
<<<<<<< HEAD
=======
      if (args[0].equals("equation")){
        String s = args[1];
        Equation.SimplifyFirst(s);
        System.out.println(Equation.SimplifyVar(s));
      }
    }
    else{
      System.out.println(directions);
    }
  }
>>>>>>> a7a5a00826e496543ac2bdd83ab37dba38b4c1b4
}
