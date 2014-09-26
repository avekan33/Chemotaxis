import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 //declare bacteria variables here 
 Bacteria [] colony;
 int mousX, mousY;
 int siz;
 public void setup()   
 {     
 	//initialize bacteria variables here
 	siz = 200;
 	size(500,500);
 	colony = new Bacteria[siz];
 	for(int i=0; i<colony.length;i++)
 	{
 		colony[i] = new Bacteria();
 	}
 	mousX = 0;
 	mousY = 0;
 }  
 public void mousePressed()
 {
 	mousX = mouseX;
 	mousY = mouseY;
 } 
 public void draw()   
 {    
 	//move and show the bacteria\
 	background(0);
 	for(int j = 0; j<colony.length;j++)
 	{
 		colony[j].walk();
 		colony[j].show();
 		eatChecker(colony[j]);
 	}
 	pizza(mousX, mousY);
 }  
public void pizza(int x,int y)
{
 	fill(124,77,48);
 	ellipse(x, y, 28,28);
 	fill(255,255,0);
 	ellipse(x,y,22,22);
 	fill(255,0,0);
 	ellipse(x+4, y-6, 4,4); 
 	ellipse(x-4, y-6, 4,4);
 	ellipse(x-4, y+5, 4,4);
 	ellipse(x+4, y+5, 4,4);
 	ellipse(x-6, y-1, 4,4);
 	ellipse(x+6, y, 4,4);
 	ellipse(x,y-1, 4,4); 
 	fill(255,255,0,20);
 	ellipse(x,y,80,80);
 	fill(255,255,0,30);
 	ellipse(x,y,60,60);
 	fill(255,255,0,40);
 	ellipse(x,y,40,40);
 	fill(255,255,0);
 	textAlign(CENTER);
 	textSize(30);
 	text("Pizza Chase!",250, 440);
 	fill(0,255,0);
 	text("Created by Averal Kandala",250, 40);
 }
 public void eatChecker(Bacteria bat)
 {
 	if(bat.x == mousX && bat.y == mousY)
 	{
 		bat.r = (int)(Math.random()*256);
 		bat.g = (int)(Math.random()*256); 		
 		bat.b = (int)(Math.random()*256);
 		bat.x = 250;
 		bat.y = 250;
 		textAlign(CENTER);
 		textSize(100);
 		text("NOM",250,250);
 	}
 }

 class Bacteria    
 {     
 	int x;
 	int y;
 	int xBias, yBias;
 	int r,g,b;
 	Bacteria()
 	{
 		x = (int)(Math.random()*70+200); 		
 		y = (int)(Math.random()*70+200);
 		r = (int)(Math.random()*256);
 		g = (int)(Math.random()*256); 		
 		b = (int)(Math.random()*256);
 		xBias = 0;
 		yBias = 0;
 	}
 	public void walk()
 	{
 		//Biased
 		if(mousX > x)
 		{
 			xBias = -1;
 		}
 		else if(mousX < x)
 		{
 			xBias = -2;
 		}
 		else
 		{
 			xBias = 0;
 		}
 		if(mousY > y)
 		{
 			yBias = -1;
 		}
 		else if(mousY < y)
 		{
 			yBias = -2;
 		}
 		else
 		{
 			yBias = 0;
 		}
 		x += (int)(Math.random()*4)+xBias;
 		y += (int)(Math.random()*4)+yBias;
 	}
 	public void show()
 	{
 		noStroke();
 		fill(r,g,b);
 		ellipse(x,y,8,8);
 		fill(r,g,b,30);
 		ellipse(x,y,20,20);
 	}  
 }    
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
