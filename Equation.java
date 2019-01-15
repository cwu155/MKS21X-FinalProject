//Solving equations goes here!
//Ex.) 4x + 1 = 5
//Output should be something ike x = 1
import java.util.*;
public class Equation{
  public static String ans = "";
  public static String eval = "";
  public static void seperate(String s){
    s = s.trim();
    Boolean equal = false;
    for (int i = 0; i < s.length(); i ++){
      if (s.substring(i,i + 1).equals("=")){
        System.out.println("HIT EQUAL!");
        equal = true;
        i ++;
      }
      if (!equal){
        eval += s.substring(i,i+1);
        System.out.println("Eval " + eval);
      }
      else{
        ans += s.substring(i,i+1);
        System.out.println("Ans " + ans);
      }
    }
    System.out.println("Final Eval " + eval);
    System.out.println("Final ans " + ans);
  }
  public static void main(String[] args){
    seperate("4x + 1 = 5");
  }
}
