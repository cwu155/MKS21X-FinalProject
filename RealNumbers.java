// RealNumbers class goes here!
public class RealNumbers{
  //Given two substrings, return the sum
  public int add(String one, String two){
    return Integer.parseInt(one) + Integer.parseInt(two);
  }
  //Given two substrings, return the difference
  public int subtract(String one, String two){
    return Integer.parseInt(one) - Integer.parseInt(two);
  }
  //Given two substrings, return the product
  public int mulitply(String one, String two){
    return Integer.parseInt(one) * Integer.parseInt(two);
  }
  //Given two substrings, return the quotient
  public int divide(String one, String two){
    return Integer.parseInt(one) / Integer.parseInt(two);
  }
  //Given two substrings, return the GCF using Euclid's method
  private int GCF(String one, String two){
    //Variables for convenience
    int num1 = Integer.parseInt(one);
    int num2 = Integer.parseInt(two);
    //If the second number is 0, then the GCF is the first number
    if(num2 == 0){
      return num1;
    }
    //If num2 is not 0, using Eculid's method, find the GCF of with
    //num2 in num1's place and num2 replaced by the remainder of num1 and num2
    else{
      int temp = num1 % num2;
      return GCF(two,temp + "");
    }
  }
}
