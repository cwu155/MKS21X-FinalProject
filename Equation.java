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
  public static String reverse(String s){
    String ans = "";
    return ans;
  }
  public static void main(String[] args){
    seperate("4x + 1 = 5");
  }
}
