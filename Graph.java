//Graphing goes here! Work in progress ;/
import java.util.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Graph {
  public static StringTokenizer st;

  public static int width = 600;
  public static int height = 600;

  public static String m, b;
  public static List<Double> xCoords = new ArrayList<Double>();
  public static List<Double> yCoords = new ArrayList<Double>();
  public static List<Token> Tokens = new ArrayList<Token>();
  public static String[] Stringss;
  //public static List<String> Strings = new ArrayList<String>();

  //y = mx + b
  //y = 2x + 0

  //Splits the equation into separate entities.
  public static void split(String equation){
    // st = new StringTokenizer(equation);
    // while(st.hasMoreTokens()) {
    //   Token newToken = new Token(st.nextToken(), 1);
    //   Tokens.add(newToken);
    // }
    Stringss = equation.split(" ");

  }

  //Checks to see if the token is numeric.
  public static boolean isNumber(Token inputToken){
    try {
        double token = Double.parseDouble(inputToken.getString());
        } catch (NumberFormatException nfe) {
          return false;
        }
      return true;
  }

  //Identifies the slope and y-intercept.
  public static void setVars(){
    // for (int i = 0; i < Tokens.size(); i++){
    //   if (isNumber(Tokens.get(i)) && i != Tokens.size()-1){
    //     m = (Tokens.get(i).getString());
    //   }
    // }
    //     b = (Tokens.get(Tokens.size()-1).getString());
      m = Stringss[2];
      b = Stringss[Stringss.length-1];
    }

  //Add x-coordinates and y-coordinates to separate arrays.
  public static void addCoordinates(String equation){

    //Add x-coordinates
    //Double i = (width * -1.0);
    //while (i < width){xCoords.add(i); i++;}

    //Add x-coordinates
    for (Double i = 0.0; i < Double.valueOf(width); i++){
      xCoords.add(i);
    }

    //Add y-coordinates
    for (Double i = Double.valueOf(height); i > 0.0; i--){
      Double ans = (Double.parseDouble(m) * i) + Double.parseDouble(b);
      yCoords.add(ans);
    }
  }



  //Initializes entire graph.
  public static void init(){
    try {

      BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      Graphics2D g2d= bufferedImage.createGraphics();
      g2d.setColor(Color.white);
      g2d.fillRect(0, 0, width, height);


      //Initializes x-axis and y-axis.
      g2d.setColor(Color.black);
      g2d.drawLine(0, height/2 , width, height/2);
      g2d.drawLine(width/2, 0, width/2, height);


      //Actually plots graph.
        int placeHolder = 0;
        int rgb = new Color(255, 0, 0).getRGB();
         for (int i = 1; i < width; i++){
           bufferedImage.setRGB((int)Math.round(yCoords.get(i)), (int)Math.round(xCoords.get(i)), rgb);
        //   placeHolder += 1;
          }

      //Apparently releases any system resources that it's using?
      g2d.dispose();

      //Save graph as a JPG file.
      File file = new File("myimage.jpg");
      ImageIO.write(bufferedImage, "jpg", file);

      } catch (IOException e) {}
    }


	public static void main(String[] args){
    split("y = 1 x + 0");
    setVars();


    addCoordinates("y = 1 x + 0");
      System.out.println(xCoords.size());
      System.out.println(yCoords.size());
    init();

    //for (Double thing : xCoords){System.out.println(thing);}
    System.out.println(xCoords.size());
	}
}
