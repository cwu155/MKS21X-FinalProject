import java.util.*;
import java.io.*;

public class Calculator extends RealNumbers{
  public static void main(String[] args){
    String info = "To use this program, please enter the function that you want us to solve \n The args entered should have a space in between (ie x + y) or in the format of add x y \n This program can currently add, subtract, mulitply, and divide two strings";
    Scanner s = new Scanner(System.in);
    if (args.length > 0){
      if (args[0] == "add"){
        System.out.println(add(args[1],args[2]));
      }
    }
    else{
      System.out.println(info);
    }
  }
}
