// RealNumbers class goes here!
import java.util.*;

public class RealNumbers{
  String sub;
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
  public void main(String[] args) {
    System.out.println("Testing RealNumbers");

    RealNumbers a = "4";
    RealNumbers b = "2";
    System.out.println(a.add(b)); //6
    System.out.println(a.subtract(b)); //2
    System.out.println(a.multiply(b)); //8
    System.out.println(a.divide(b)); //2
    System.out.println("9".GCF("15")); //3
    System.out.println("100".GCF("1")); //1
    System.out.println(sqrt("4")); //2
  }
}
