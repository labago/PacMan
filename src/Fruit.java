import java.awt.Color;

import idraw.*;
import geometry.*;


public class Fruit {
	String name;
	String dir = "Right";
	int points;
	Posn loc;
	int holdTime;
	boolean activated = false;
	public Fruit(String name, int points, Posn loc, int holdTime,
			boolean activated) {
		this.name = name;
		this.points = points;
		this.loc = loc;
		this.holdTime = holdTime;
		this.activated = activated;
	}
	
	
	
	public void moveLeft(){
		this.loc.x = this.loc.x - 1;
	}
	
	public void moveRight(){
		this.loc.x = this.loc.x + 1;
	}
	
	public void moveDown(){
		this.loc.y = this.loc.y + 1;
	}
	
	public void moveUp(){
		this.loc.y = this.loc.y - 1;
	}
	
	public void draw(Canvas c){
		if(this.name.equals("Cherry")){
			c.drawLine(new Posn(this.loc.x - 7, this.loc.y + 5), new Posn(this.loc.x + 3, this.loc.y - 8), Color.black);
			c.drawLine(new Posn(this.loc.x + 7, this.loc.y + 5), new Posn(this.loc.x, this.loc.y - 4), Color.black);
			c.drawDisk(new Posn(this.loc.x - 7, this.loc.y + 5), 5, Color.red);
			c.drawDisk(new Posn(this.loc.x + 7, this.loc.y + 5), 5, Color.red);
		}
		
		if(this.name.equals("Strawberry")){
			c.drawRect(new Posn(this.loc.x, this.loc.y - 5), 2, 3, Color.white);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 4), 2, 3, Color.white);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 3), 2, 3, Color.green);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 2), 2, 3, Color.green);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 1), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 1), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 2), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 3), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 4), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 5), 2, 3, Color.red);
			
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 4), 2, 3, Color.green);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 3), 2, 3, Color.green);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 2), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 1), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y), 2, 3, Color.white);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 1), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 2), 2, 3, Color.white);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 3), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 4), 2, 3, Color.white);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 5), 2, 3, Color.red);
			
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 4), 2, 3, Color.green);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 3), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 2), 2, 3, Color.white);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 1), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 1), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 2), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 3), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 4), 2, 3, Color.red);
			
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 4), 2, 3, Color.green);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 3), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 2), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 1), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y), 2, 3, Color.white);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 1), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 2), 2, 3, Color.white);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 3), 2, 3, Color.red);
			
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 3), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 2), 2, 3, Color.white);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 1), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y + 1), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y + 2), 2, 3, Color.red);
			
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 2), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 1), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y), 2, 3, Color.red);
			
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 4), 2, 3, Color.green);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 3), 2, 3, Color.green);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 2), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 1), 2, 3, Color.white);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 1), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 2), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 3), 2, 3, Color.white);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 4), 2, 3, Color.red);
			
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 4), 2, 3, Color.green);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 3), 2, 3, Color.white);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 2), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 1), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y), 2, 2, Color.red);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 1), 2, 2, Color.white);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 2), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 3), 2, 3, Color.red);
			
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 4), 2, 3, Color.green);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 3), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 2), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 1), 2, 3, Color.white);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y + 1), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y + 2), 2, 3, Color.red);
			
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 2), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 1), 2, 3, Color.red);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y), 2, 3, Color.red);		
		}
		
		if(this.name.equals("Orange")){
			c.drawRect(new Posn(this.loc.x, this.loc.y - 7), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 6), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 5), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 4), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 3), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x, this.loc.y), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 3), 2, 4, Color.orange);
			
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 6), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 4), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 3), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 3), 2, 4, Color.orange);
			
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 5), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 4), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 3), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 3), 2, 4, Color.orange);
			
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 5), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 4), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 3), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 2), 2, 4, Color.orange);
			
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 4), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 3), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y + 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y + 2), 2, 4, Color.orange);
			
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 3), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y), 2, 4, Color.orange);
			
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 7), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 6), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 4), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 3), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 3), 2, 4, Color.orange);
			
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 7), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 5), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 4), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 3), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 2), 2, 4, Color.orange);
			
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 4), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 3), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y + 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y + 2), 2, 4, Color.orange);
			
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 3), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y), 2, 4, Color.orange);
	}

		if(this.name.equals("Apple")){
			c.drawRect(new Posn(this.loc.x, this.loc.y - 6), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 5), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 4), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 3), 2, 4, Color.red);
			
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 5), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 4), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 3), 2, 4, Color.red);
			
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 6), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 5), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 4), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 4), 2, 4, Color.red);
			
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 6), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 5), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 4), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 3), 2, 4, Color.white);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 4), 2, 4, Color.red);
			
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 6), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 4), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 2), 2, 4, Color.white);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 1), 2, 4, Color.white);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y + 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y + 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y + 3), 2, 4, Color.red);
			
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y + 1), 2, 4, Color.red);
			
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 5), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 4), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 4), 2, 4, Color.red);
			
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 5), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 4), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 4), 2, 4, Color.red);
			
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 4), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y + 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y + 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y + 3), 2, 4, Color.red);
			
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y + 1), 2, 4, Color.red);	
		}
		if(this.name.equals("Grapes")){
			c.drawLine(new Posn(this.loc.x - 7, this.loc.y + 5), new Posn(this.loc.x + 3, this.loc.y - 8), Color.black);
			c.drawLine(new Posn(this.loc.x + 7, this.loc.y + 5), new Posn(this.loc.x, this.loc.y - 4), Color.black);
			c.drawDisk(new Posn(this.loc.x - 7, this.loc.y + 5), 5, new Purple());
			c.drawDisk(new Posn(this.loc.x + 7, this.loc.y + 5), 5, new Purple());
		}
		
		if(this.name.equals("Galaxian Boss")){
			c.drawRect(new Posn(this.loc.x, this.loc.y - 5), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 4), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 1), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x, this.loc.y), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 3), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 4), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 5), 2, 4, Color.yellow);
			
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 4), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y), 2, 4, Color.yellow);
			
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 2), 2, 4, Color.blue);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 3), 2, 4, Color.blue);
			
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 1), 2, 4, Color.blue);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 2), 2, 4, Color.blue);
			
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y), 2, 4, Color.blue);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y + 1), 2, 4, Color.blue);
			
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 4), 2, 4, Color.blue);
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 3), 2, 4, Color.blue);
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 2), 2, 4, Color.blue);
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 1), 2, 4, Color.blue);
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y), 2, 4, Color.blue);
			
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 4), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y), 2, 4, Color.yellow);
			
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 3), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 2), 2, 4, Color.blue);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 3), 2, 4, Color.blue);
			
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 2), 2, 4, Color.red);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y + 1), 2, 4, Color.blue);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y + 2), 2, 4, Color.blue);
			
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y), 2, 4, Color.blue);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y + 1), 2, 4, Color.blue);
			
			c.drawRect(new Posn(this.loc.x + 10, this.loc.y - 4), 2, 4, Color.blue);
			c.drawRect(new Posn(this.loc.x + 10, this.loc.y - 3), 2, 4, Color.blue);
			c.drawRect(new Posn(this.loc.x + 10, this.loc.y - 2), 2, 4, Color.blue);
			c.drawRect(new Posn(this.loc.x + 10, this.loc.y - 1), 2, 4, Color.blue);
			c.drawRect(new Posn(this.loc.x + 10, this.loc.y), 2, 4, Color.blue);
		}
		if(this.name.equals("Bell")){
			c.drawRect(new Posn(this.loc.x, this.loc.y - 6), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 5), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 4), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 3), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x, this.loc.y), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 3), 2, 4, Color.black);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 4), 2, 4, Color.black);
			c.drawRect(new Posn(this.loc.x, this.loc.y + 5), 2, 4, Color.black);
			
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 5), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 4), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 3), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 3), 2, 4, Color.gray);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 4), 2, 4, Color.gray);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 5), 2, 4, Color.gray);
			
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 4), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 3), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 3), 2, 4, Color.black);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 4), 2, 4, Color.gray);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 5), 2, 4, Color.gray);
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 6), 2, 4, Color.gray);
			
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 3), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 2), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 3), 2, 4, Color.black);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 4), 2, 4, Color.black);
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 5), 2, 4, Color.gray);
			
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y + 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y + 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y + 3), 2, 4, Color.black);
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y + 4), 2, 4, Color.yellow);
			
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y + 1), 2, 4, Color.orange);
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y + 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y + 3), 2, 4, Color.black);
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y + 4), 2, 4, Color.yellow);
			
			c.drawRect(new Posn(this.loc.x - 12, this.loc.y + 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x - 12, this.loc.y + 3), 2, 4, Color.yellow);
			
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 6), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 5), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 4), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 3), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 2), 2, 4, Color.gray);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 3), 2, 4, Color.black);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 4), 2, 4, Color.black);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 5), 2, 4, Color.yellow);
			
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 6), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 5), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 4), 2, 4, Color.gray);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 3), 2, 4, Color.gray);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 2), 2, 4, Color.gray);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 3), 2, 4, Color.black);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 4), 2, 4, Color.black);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 5), 2, 4, Color.yellow);
			
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 7), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 6), 2, 4, Color.white);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 5), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 4), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 3), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 2), 2, 4, Color.gray);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 1), 2, 4, Color.gray);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y), 2, 4, Color.gray);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y + 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y + 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y + 3), 2, 4, Color.black);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y + 4), 2, 4, Color.black);
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y + 5), 2, 4, Color.yellow);
			
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 6), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 5), 2, 4, Color.white);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 4), 2, 4, Color.white);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 3), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y + 1), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y + 2), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y + 3), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y + 4), 2, 4, Color.black);
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y + 5), 2, 4, Color.yellow);
			
			c.drawRect(new Posn(this.loc.x + 10, this.loc.y + 3), 2, 4, Color.yellow);
			c.drawRect(new Posn(this.loc.x + 10, this.loc.y + 4), 2, 4, Color.yellow);
		}
		if(this.name.equals("Peach")){
			c.drawRect(new Posn(this.loc.x, this.loc.y - 7), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 6), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 5), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x, this.loc.y - 4), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x, this.loc.y - 3), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x, this.loc.y - 2), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x, this.loc.y - 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x, this.loc.y), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x, this.loc.y + 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x, this.loc.y + 2), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x, this.loc.y + 3), 2, 4, new Peach());
			
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 6), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 4), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 3), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 2), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y - 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 2), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 2, this.loc.y + 3), 2, 4, new Peach());
			
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 5), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 4), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 3), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 2), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y - 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 2), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 4, this.loc.y + 3), 2, 4, new Peach());
			
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 5), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 4), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 3), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 2), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y - 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 6, this.loc.y + 2), 2, 4, new Peach());
			
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 4), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 3), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 2), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y - 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y + 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 8, this.loc.y + 2), 2, 4, new Peach());
			
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 3), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 2), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x - 10, this.loc.y), 2, 4, new Peach());
			
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 7), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 6), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 4), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 3), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 2), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y - 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 2), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 2, this.loc.y + 3), 2, 4, new Peach());
			
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 7), 2, 4, Color.green);
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 5), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 4), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 3), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 2), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y - 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 4, this.loc.y + 2), 2, 4, new Peach());
			
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 4), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 3), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 2), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y - 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y + 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 6, this.loc.y + 2), 2, 4, new Peach());
			
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 3), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 2), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y - 1), 2, 4, new Peach());
			c.drawRect(new Posn(this.loc.x + 8, this.loc.y), 2, 4, new Peach());
		
		}		
	}
}
