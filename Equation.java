//Solving equations goes here!
//Ex.) 4x + 1 = 5
//Output should be something ike x = 1
import java.util.*;
public class Equation{
  public static String answer = "";
  public static String eval = "";
  public static void seperate(String s){
    s = s.trim();
    Boolean equal = false;
    for (int i = 0; i < s.length(); i ++){
      if (s.substring(i,i + 1).equals("=")){
//        System.out.println("HIT EQUAL!");
        equal = true;
        i ++;
      }
      if (!equal){
        eval += s.substring(i,i+1);
//        System.out.println("Eval " + eval);
      }
      else{
        answer += s.substring(i,i+1);
//        System.out.println("Answer " + answer);
      }
    }
//    System.out.println("Final Eval " + eval);
//    System.out.println("Final answer " + answer);
}

  public static String SolveOneSide(String s){
    seperate(s);
    String temp = eval.replaceAll(" ","");
    String first = "";
    String second = "";
    Boolean func = false;
    String function = "";
    for (int i = 0; i < temp.length(); i ++){
      if ("+-*/".contains(temp.substring(i,i+1))){
//        System.out.println("Func is switched from false to true. All changes should be in second half!");
        function += temp.substring(i,i+1);
        func = true;
        i ++;
      }
      if (!func){
        first += temp.substring(i,i+1);
//        System.out.println("First half -" + first);
      }
      else{
        second += temp.substring(i,i+1);
//        System.out.println("Second half -" + second);
      }
    }
    if (function.equals("+")){
      return RealNumbers.add(first,second);
    }
    else if (function.equals("-")){
      return RealNumbers.subtract(first,second);
    }
    else if (function.equals("*")){
      return RealNumbers.multiply(first,second);
    }
    else if (function.equals("/")){
      return RealNumbers.divide(first,second);
    }
    return temp;
  }
  public static void main(String[] args){
    //seperate("4x + 1 = 5");
    System.out.println(SolveOneSide("4x + 4x = 5"));
  }
}
