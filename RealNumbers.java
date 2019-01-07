// RealNumbers class goes here!
import java.util.*;

public class RealNumbers{
  String sub;
  String var;
  //Returns if the the string contains a variable, and if so, sets var to the variable
  public boolean containsVariable(String s){
    s = s.toLowerCase();
    if (s.contains("a")){
      var = "a";
      return true;
    }
    else if (s.contains("b")){
      var = "b";
      return true;
    }
    else if (s.contains("c")){
      var = "c";
      return true;
    }
    else if (s.contains("d")){
      var = "d";
      return true;
    }
    else if (s.contains("e")){
      var = "e";
      return true;
    }
    else if (s.contains("f")){
      var = "f";
      return true;
    }
    else if (s.contains("g")){
      var = "g";
      return true;
    }
    else if (s.contains("h")){
      var = "h";
      return true;
    }
    else if (s.contains("i")){
      var = "i";
      return true;
    }
    else if (s.contains("j")){
      var = "j";
      return true;
    }
    else if (s.contains("k")){
      var = "k";
      return true;
    }
    else if (s.contains("l")){
      var = "l";
      return true;
    }
    else if (s.contains("m")){
      var = "m";
      return true;
    }
    else if (s.contains("n")){
      var = "n";
      return true;
    }
    else if (s.contains("o")){
      var = "o";
      return true;
    }
    else if (s.contains("p")){
      var = "p";
      return true;
    }
    else if (s.contains("q")){
      var = "q";
      return true;
    }
    else if (s.contains("r")){
      var = "r";
      return true;
    }
    else if (s.contains("s")){
      var = "s";
      return true;
    }
    else if (s.contains("t")){
      var = "t";
      return true;
    }
    else if (s.contains("u")){
      var = "u";
      return true;
    }
    else if (s.contains("v")){
      var = "v";
      return true;
    }
    else if (s.contains("w")){
      var = "w";
      return true;
    }
    else if (s.contains("x")){
      var = "x";
      return true;
    }
    else if (s.contains("y")){
      var = "y";
      return true;
    }
    else if (s.contains("z")){
      var = "z";
      return true;
    }
    return false;
  }
  //Given two substrings, return the sum
  public RealNumbers(String s){
    sub = s;
  }
  public int add(String other){
    return Integer.parseInt(this) + Integer.parseInt(other);
  }
  //Given two substrings, return the difference
  public int subtract(String other){
    return Integer.parseInt(this) - Integer.parseInt(other);
  }
  //Given two substrings, return the product
  public int multiply(String other){
    return Integer.parseInt(this) * Integer.parseInt(other);
  }
  //Given two substrings, return the quotient
  public int divide(String other){
    return Integer.parseInt(this) / Integer.parseInt(other);
  }
  //Given two substrings, return the GCF using Euclid's method
  //Made public for testing purposes
  public int GCF(String other){
    //Variables for convenience
    int num1 = Integer.parseInt(this);
    int num2 = Integer.parseInt(other);
    //If the second number is 0, then the GCF is the first number
    if(num2 == 0){
      return num1;
    }
    //If num2 is not 0, using Euclid's method, find the GCF of with
    //num2 in num1's place and num2 replaced by the remainder of num1 and num2
    else{
      int temp = num1 % num2;
      return GCF(other,temp + "");
    }
  }

  // Given a value, return its square root using Newton's Method
  public double sqrt(String value){
    double result = 1;
    double a = (Double.parseDouble(value));
      for (int i = 0; i < Double.parseDouble(value); i++){
        result = 0.5 * (result + a / result);
      }
      return (int)result;
    }

  //Testing methods
//   public void main(String[] args) {
//     System.out.println("Testing RealNumbers");
//
//     RealNumbers a = "4";
//     RealNumbers b = "2";
//     System.out.println(a.add(b)); //6
//     System.out.println(a.subtract(b)); //2
//     System.out.println(a.multiply(b)); //8
//     System.out.println(a.divide(b)); //2
//     System.out.println("9".GCF("15")); //3
//     System.out.println("100".GCF("1")); //1
//     System.out.println(sqrt("4")); //2
//   }
}
