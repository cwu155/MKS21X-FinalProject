//Graphing goes here! Work in progress ;/

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Graph {

	public static void main(String[] args) throws IOException {
      int width = 1600;
      int height = 800;

	    //Initializes entire graph.
	    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2d= bufferedImage.createGraphics();
	    g2d.setColor(Color.white);
      g2d.fillRect(0, 0, width, height);


	    //Initializes x-axis and y-axis.
      g2d.setColor(Color.black);
	    g2d.drawLine(-width, height/2 , width, height/2);
      g2d.drawLine(width/2, -height, width/2, height);

	    //Apparently releases any system resources that it's using?
	    g2d.dispose();

	    //Save graph as a JPG file.
	    File file = new File("myimage.jpg");
	    ImageIO.write(bufferedImage, "jpg", file);

	}

}
