import java.util.*;
import java.io.*;

public class Calculator{


    String directions = "To use this program, please enter the function that you want us to solve \nThe args entered should have a space in between (ie 2x + 3y) or in the format of add 2x 3y \nThis program can currently add, subtract, mulitply, divide, and find the GCF two strings \nIt can also evaluate an expression! (Without variables.) \nThe commands should be written in ALL LOWERCASE!! \nPlease do not simply enter x or y : Enter in the form 1x + 1y";

      public static void go(){

        boolean control = true;
        while (control){

          System.out.println("\nMAIN MENU:");
          System.out.println("[1] EXPRESSION");
          System.out.println("[2] EQUATION");
          System.out.println("[3] QUIT\n");

          Scanner sc = new Scanner(System.in);
          System.out.print("Selection: ");
          int menu_input = sc.nextInt();

          switch(menu_input) {
            case 1:
              Scanner sc1 = new Scanner(System.in);
              System.out.println("\nEnter an expression to evaluate:");
              String userExpression = sc1.nextLine();
              System.out.println(Expression.evaluate(userExpression));
              break;

            case 2:
              Scanner sc2 = new Scanner(System.in);
              System.out.println("\nEnter an equation to evaluate:");
              String userEquation = sc2.nextLine();
              System.out.println(Equation.simplify(userEquation));
              break;

            case 3:
              control = false;
              break;
            }
          }
        }

          public static void main(String[] args){
            go();
          }
        }
