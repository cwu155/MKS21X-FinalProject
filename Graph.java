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

  public static int width, height;
  public static String m, b;
  public static List<Double> xCoords = new ArrayList<Double>();
  public static List<Double> yCoords = new ArrayList<Double>();
  public static List<Token> Tokens = new ArrayList<Token>();

  //y = mx + b
  //y = 2x + 0

  //Splits the equation into separate entities.
  public static void split(String equation){
    st = new StringTokenizer(equation);
    while(st.hasMoreTokens()) {
      Token newToken = new Token(st.nextToken(), 1);
      Tokens.add(newToken);
    }
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
    for (int i = 0; i < Tokens.size(); i++){
      if (isNumber(Tokens.get(i)) && i != Tokens.size()-1){
        m = (Tokens.get(i).getString());
      }
    }
        b = (Tokens.get(Tokens.size()-1).getString());
    }

  //Evaluate y-coordinates, add x-coordinates and y-coordinates to separate arrays.
  public static void addCoordinates(String equation){
    split(equation);
    width = 4;

    //Add x-coordinates
    Double i = (width * -1.0);
    while (i < width){xCoords.add(i); i++;}

    //Add y-coordinates
    for (i = (width * -1.0); i < width; i++){
      Double ans = (Double.parseDouble(m) * i) + Double.parseDouble(b);
      yCoords.add(ans);
    }
  }


  //Initializes entire graph.
  public static void init(){
    try {
      width = 1600;
      height = 800;

      BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      Graphics2D g2d= bufferedImage.createGraphics();
      g2d.setColor(Color.white);
      g2d.fillRect(0, 0, width, height);


      //Initializes x-axis and y-axis.
      g2d.setColor(Color.black);
      g2d.drawLine(-width, height/2 , width, height/2);
      g2d.drawLine(width/2, -height, width/2, height);

      int rgb = new Color(0, 191, 255).getRGB();

      for (int i = 0; i < 800; i++){
        bufferedImage.setRGB(100, i, rgb);
      }

      //Apparently releases any system resources that it's using?
      g2d.dispose();

      //Save graph as a JPG file.

      File file = new File("myimage.jpg");
      ImageIO.write(bufferedImage, "jpg", file);

      } catch (IOException e) {}
    }


	public static void main(String[] args){
    //init();
    split("y = 2 x + 1");
    setVars();
    addCoordinates("y = 2 x + 1");

    //for (Token element : Tokens){System.out.println(element.getString());}
    for (Double xcoor : xCoords){System.out.println(xcoor);}
    for (Double ycoor : yCoords){System.out.println(ycoor);}
	}
}
