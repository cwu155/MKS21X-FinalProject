//Solving equations goes here!
//Ex.) 4x + 1 = 5
//Output should be something like x = 1
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

  public static String SimplifySide(String s,String side){
    String temp;
    String first = "";
    String second = "";
    Boolean func = false;
    String function = "";
    if (side.equals("ans")){
      temp = answer.replaceAll(" ","");
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
    }
    else{
      temp = eval.replaceAll(" ","");
      for (int i = 0; i < temp.length(); i ++){
        if ("+-*/".contains(temp.substring(i,i+1))){
          if (i == 0){
            i++;
          }
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
  public static String SimplifyFirst(String s){
    seperate(s);
    String tempeval = eval.replaceAll(" ","");
    String tempans = answer.replaceAll(" ","");
    String side1 = SimplifySide(tempeval,"eval");
    String side2 = SimplifySide(tempans,"ans");
    String num = "";
    String func = "";
    String newans = "";
    int Index = 0;
    for (int i = 0;i < side1.length();i ++){
      if ("+-*/".contains(side1.substring(i,i+1))){
        func = side1.substring(i,i+1);
        Index = i + 1;
        i = s.length();
      }
    }
    for(int i = Index;i < side1.length();i++){
      num += side1.substring(i,i+1);
    }
    if (func.equals("+")){
      newans = RealNumbers.subtract(side2,num);
    }
    if (func.equals("-")){
      newans = RealNumbers.add(side2,num);
    }
    if (func.equals("*")){
      newans = RealNumbers.divide(side2,num);
    }
    if (func.equals("/")){
      newans = RealNumbers.multiply(side2,num);
    }
    if (newans.equals("")){
      newans = "0";
    }
    return side1.replace(func + num , "") + "=" + newans;
    }
  public static String Simplifyvar(String s){
    String num = "";
    for (int i = 0; i < s.length(); i ++){
      if ("1234567890".contains(s.substring(i, i + 1))){
        num += s.substring(i,i+1);
      }
    }
    return num;
  }
  public static void main(String[] args){
    String s = "3x+9871=984";
    //seperate(s);
    System.out.println(SimplifyFirst(s));
  }
}
