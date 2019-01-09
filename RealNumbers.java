// RealNumbers class goes here!
import java.util.*;

public class RealNumbers{
  String sub;
  public static String var;
  public static String numbers = "1234567890";
  //Returns if the the string contains a variable, and if so, sets var to the variable
  public static boolean containsVariable(String s){
    for (int i = 0; i < s.length(); i++){
      if (!(numbers.contains(s.substring(i,i+1)))){
        var = s.substring(i,i+1);
        return true;
      }
    }
    return false;
  }
  //Given a string s with a single variable, loop through the string and return
  //the variable
  public static String Variable(String s){
    for (int i = 0; i < s.length(); i++){
      if (!(numbers.contains(s.substring(i,i+1)))){
        return s.substring(i,i+1);
      }
    }
    return "";
  }
  //Given two substrings, return the sum
  // public RealNumbers(String s){
  //   sub = s;
   public static String add(String one, String two){
     //If string one has a variable...
     if (containsVariable(one)){
       //And string two has a variable...
       if(containsVariable(two)){
         //If the variable from the two strings are the same, add the numerical
         //values of the two strings with the variable added at the end
         if (Variable(one).equals(Variable(two))){
           String vari = Variable(one);
           String temp1 = one.replace(vari,"");
           String temp2 = two.replace(vari,"");
           if (add(temp1,temp2).equals("1")){
             return vari;
           }
           else if (add(temp1,temp2).equals("-1")){
             return "-" + vari;
           }
           else if (add(temp1,temp2).equals("0")){
             return "0";
           }
           else{
             return add(temp1,temp2) + vari;
           }
         }
         //If the varibles are not the same, they cannot be simplified further
         //Therefore, return the two strings with a + sign in the middle
         else{
           return one + "+" + two;
         }
       }
       return one + "+" + two;
     }
     if (containsVariable(two) && !containsVariable(one)){
       return one + "+" + two;
     }
     //Else, return the value of the two strinsg added together
     return Integer.parseInt(one) + Integer.parseInt(two) + "";
   }
   //Given two substrings, return the difference
   public static String subtract(String one, String two){
     //If string one has a variable...
     if (containsVariable(one)){
       //And string two has a variable...
       if(containsVariable(two)){
         //If the variable from the two strings are the same, subtract the numerical
         //values of the two strings with the variable added at the end
         if (Variable(one).equals(Variable(two))){
           String vari = Variable(one);
           String temp1 = one.replace(vari,"");
           String temp2 = two.replace(vari,"");
           if (subtract(temp1,temp2).equals("1")){
             return vari;
           }
           else if (subtract(temp1,temp2).equals("-1")){
             return "-" + vari;
           }
           else{
             return subtract(temp1,temp2) + vari;
           }
         }
         //If the varibles are not the same, they cannot be simplified further
         //Therefore, return the two strings with a - sign in the middle
         else{
           return one + "-" + two;
         }
       }
       return one + "-" + two;
     }
     if (containsVariable(two) && !containsVariable(one)){
       return one + "-" + two;
     }
     //Else, return the difference of the two strings
     return Integer.parseInt(one) - Integer.parseInt(two) + "";
   }
  // //Given two substrings, return the product
   public static String multiply(String one, String two){
     //If string one has a variable...
     if (containsVariable(one)){
       //And string two has a variable...
       if(containsVariable(two)){
         //If the variable from the two strings are the same, muliply the numerical
         //values of the two strings with the variable added at the end
         if (Variable(one).equals(Variable(two))){
           String vari = Variable(one);
           String temp1 = one.replace(vari,"");
           String temp2 = two.replace(vari,"");
           if (multiply(temp1,temp2).equals("1")){
             return vari + "^2";
           }
           else if (multiply(temp1,temp2).equals("-1")){
             return "-" + vari + "^2";
           }
           else{
             return multiply(temp1,temp2) + vari + "^2";
           }
         }
         //If the varibles are not the same,
         else{
           String vari1 = Variable(one);
           String vari2 = Variable(two);
           String temp1 = one.replace(vari1,"");
           String temp2 = two.replace(vari2,"");
           return multiply(temp1,temp2) + vari1 + vari2;
         }
       }
       String vari = Variable(one);
       String temp = one.replace(vari,"");
       return multiply(temp,two) + vari;
     }
     if (containsVariable(two) && !containsVariable(one)){
       String vari = Variable(two);
       String temp = two.replace(vari,"");
       if (temp.length() == 0){
         return one + two;
       }
       return multiply(one,temp) + vari;
     }
     //Else, return the product of the two strings
     return Integer.parseInt(one) * Integer.parseInt(two) + "";
   }
  // //Given two substrings, return the quotient
   public static String divide(String one, String two){
     if (two == "0"){
       return "Divide by 0 error!";
     }
     //If string one has a variable...
     if (containsVariable(one)){
       //And string two has a variable...
       if(containsVariable(two)){
         //If the variable from the two strings are the same, divide the numerical
         //values of the two strings with the variable added at the end
         if (Variable(one).equals(Variable(two))){
           String vari = Variable(one);
           String temp1 = one.replace(vari,"");
           String temp2 = two.replace(vari,"");
           if (divide(temp1,temp2).equals("1")){
             return vari + "^2";
           }
           else if (divide(temp1,temp2).equals("-1")){
             return "-" + vari + "^2";
           }
           else{
             return divide(temp1,temp2) + vari + "^2";
           }
         }
         //If the varibles are not the same,
         else{
           String vari1 = Variable(one);
           String vari2 = Variable(two);
           String temp1 = one.replace(vari1,"");
           String temp2 = two.replace(vari2,"");
           return divide(temp1,temp2) + vari1 + vari2;
         }
       }
       String vari = Variable(one);
       String temp = one.replace(vari,"");
       return divide(temp,two) + vari;
     }
     if (containsVariable(two) && !containsVariable(one)){
       String vari = Variable(two);
       String temp = two.replace(vari,"");
       if (temp.length() == 0){
         return one + two;
       }
       return divide(one,temp) + vari;
     }
     //Else, return the quotient of the two strings
     return Integer.parseInt(one) / Integer.parseInt(two) + "";
   }
  // //Given two substrings, return the GCF using Euclid's method
  // //Made public for testing purposes
  // public int GCF(String one, String two){
  //   //Variables for convenience
  //   int num1 = Integer.parseInt(one);
  //   int num2 = Integer.parseInt(two);
  //   //If the second number is 0, then the GCF is the first number
  //   if(num2 == 0){
  //     return num1;
  //   }
  //   //If num2 is not 0, using Euclid's method, find the GCF of with
  //   //num2 in num1's place and num2 replaced by the remainder of num1 and num2
  //   else{
  //     int temp = num1 % num2;
  //     return GCF(two,temp + "");
  //   }
  // }
  //
  // // Given a value, return its square root using Newton's Method
  // public double sqrt(String value){
  //   double result = 1;
  //   double a = (Double.parseDouble(value));
  //     for (int i = 0; i < Double.parseDouble(value); i++){
  //       result = 0.5 * (result + a / result);
  //     }
  //     return (int)result;
  //   }

  //Testing methods
  public static void main(String[] args) {
//    System.out.println("Testing RealNumbers");
//    System.out.println(containsVariable("72"));
//    System.out.println(containsVariable("7x032942943"));


     String a = "4";
     String b = "2";
//     System.out.println(add(a,b)); //6
//     System.out.println(add("11x",b)); //11x+2
//     System.out.println(add("11x","12x")); //23x
//     System.out.println(add(a,"x"));//4+x
//     System.out.println(add("11x","12y"));//11x+12y
//     System.out.println(subtract(a,b)); //2
//     System.out.println(subtract("11x",b)); //11x -2
//     System.out.println(subtract("11x","12x")); //-x
//     System.out.println(subtract(a,"x")); //4-x
//     System.out.println(subtract("11x","12y")); //11x-12y
//     System.out.println(multiply(a,b)); //8
//     System.out.println(multiply("11x",b)); //22x
//     System.out.println(multiply("11x","12x")); //132x^2
//     System.out.println(multiply(a,"x")); //4x
//     System.out.println(multiply("11x","12y")); //132xy
      System.out.println(divide(a,b)); //2
      System.out.println(divide("11x",b)); //5x
      System.out.println(divide("11x","12x")); //0x^2
      System.out.println(divide(a,"x")); //4x
      System.out.println(divide("11x","12y")); //0xy
//     System.out.println("9".GCF("15")); //3
//     System.out.println("100".GCF("1")); //1
//     System.out.println(sqrt("4")); //2
   }
}
