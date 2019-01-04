// RealNumbers class goes here!

public class RealNumbers{
  //Given two substrings, return the sum
  public static int add(String one, String two){
    return Integer.parseInt(one) + Integer.parseInt(two);
  }
  //Given two substrings, return the difference
  public static int subtract(String one, String two){
    return Integer.parseInt(one) - Integer.parseInt(two);
  }
  //Given two substrings, return the product
  public static int multiply(String one, String two){
    return Integer.parseInt(one) * Integer.parseInt(two);
  }
  //Given two substrings, return the quotient
  public static int divide(String one, String two){
    return Integer.parseInt(one) / Integer.parseInt(two);
  }
  //Given two substrings, return the GCF using Euclid's method
  //Made public for testing purposes
  public static int GCF(String one, String two){
    //Variables for convenience
    int num1 = Integer.parseInt(one);
    int num2 = Integer.parseInt(two);
    //If the second number is 0, then the GCF is the first number
    if(num2 == 0){
      return num1;
    }
    //If num2 is not 0, using Euclid's method, find the GCF of with
    //num2 in num1's place and num2 replaced by the remainder of num1 and num2
    else{
      int temp = num1 % num2;
      return GCF(two,temp + "");
    }
  }

  //Testing methods
  public static void main(String[] args) {
    System.out.println("Testing RealNumber");

    String a = "4";
    String b = "2";
    System.out.println(add(a, b)); //6
    System.out.println(subtract(a, b)); //2
    System.out.println(multiply(a, b)); //8
    System.out.println(divide(a, b)); //2
    System.out.println(GCF("9","15")); //3
    System.out.println(GCF("100","1")); //1
  }
}
