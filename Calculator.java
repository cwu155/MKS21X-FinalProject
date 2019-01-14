import java.util.*;
import java.io.*;

public class Calculator{
  public static void main(String[] args){
    RealNumbers IGNORE;
    IGNORE = new RealNumbers();
    String info = "To use this program, please enter the function that you want us to solve \n The args entered should have a space in between (ie 2x + 3y) or in the format of add 2x 3y \n This program can currently add, subtract, mulitply, divide, and find the GCF two strings \n The commands should be written in ALL LOWERCASE!! \n Please do not simply enter x or y : Enter in the form 1x + 1y";
    Scanner s = new Scanner(System.in);
    if (args.length > 0){
      // if (args[0].equals("add")){
      //   System.out.println(IGNORE.add(args[1],args[2]));
      // }
      // if (args[0].equals("subtract")){
      //   System.out.println(IGNORE.subtract(args[1],args[2]));
      // }
      // if (args[0].equals("multiply")){
      //   System.out.println(IGNORE.multiply(args[1],args[2]));
      // }
      // if (args[0].equals("divide")){
      //   System.out.println(IGNORE.divide(args[1],args[2]));
      // }
      // if (args[0].equals("gcf")){
      //   System.out.println(IGNORE.GCF(args[1],args[2]));
      // }
      // if (args[1].equals("+")){
      //   System.out.println(IGNORE.add(args[0],args[2]));
      // }
      // if (args[1].equals("-")){
      //   System.out.println(IGNORE.subtract(args[0],args[2]));
      // }
      // if (args[1].equals("*")){
      //   System.out.println(IGNORE.multiply(args[0],args[2]));
      // }
      // if (args[1].equals("/")){
      //   System.out.println(IGNORE.divide(args[0],args[2]));
      // }
    }
    else{
      System.out.println(info);
    }
  }
}
