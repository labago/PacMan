import java.awt.Color;


import idraw.*;
import geometry.*;

public class PacMan {
	boolean gender = false;
	String dir;
	Posn loc;
	
	public PacMan(boolean gender, String dir, Posn loc) {
		this.gender = gender;
		this.dir = dir;
		this.loc = loc;
	}
	
	public void moveLeft(){
		this.loc.x = this.loc.x - 1;
	}
	
	public void moveRight(){
		this.loc.x = this.loc.x + 1;
	}
	
	public void moveUp(){
		this.loc.y = this.loc.y - 1;
	}
	
	public void moveDown(){
		this.loc.y = this.loc.y + 1;
	}
	
	public void move(String dir){
		if (dir.equals("Left")){
			this.moveLeft();
		}
		
		if (dir.equals("Right")){
			this.moveRight();
		}
		
		if (dir.equals("Up")){
			this.moveUp();
		}
		
		if (dir.equals("Down")){
			this.moveDown();
		}
	}
	
	public void drawOpen(Canvas c){
		c.drawDisk(this.loc, 10, Color.yellow);
		
		if(this.dir.equals("Up")){
		c.drawRect(new Posn(this.loc.x - 3, this.loc.y - 9), 7, 10, Color.BLACK);
		if(this.gender){
		c.drawCircle(new Posn(this.loc.x + 7, this.loc.y + 7), 4, Color.red);
		c.drawCircle(new Posn(this.loc.x + 7, this.loc.y + 7), 3, Color.red);
		c.drawCircle(new Posn(this.loc.x + 7, this.loc.y + 7), 2, Color.red);
		}
		}
		
		if(this.dir.equals("Down")){
		c.drawRect(new Posn(this.loc.x - 3, this.loc.y), 7, 10, Color.BLACK);
		if(this.gender){
			c.drawCircle(new Posn(this.loc.x + 7, this.loc.y - 7), 4, Color.red);
			c.drawCircle(new Posn(this.loc.x + 7, this.loc.y - 7), 3, Color.red);
			c.drawCircle(new Posn(this.loc.x + 7, this.loc.y - 7), 2, Color.red);
			}
		}
		
		if(this.dir.equals("Right")){
		c.drawRect(new Posn(this.loc.x, this.loc.y - 3), 10, 7, Color.BLACK);
		if(this.gender){
			c.drawCircle(new Posn(this.loc.x - 7, this.loc.y - 7), 4, Color.red);
			c.drawCircle(new Posn(this.loc.x - 7, this.loc.y - 7), 3, Color.red);
			c.drawCircle(new Posn(this.loc.x - 7, this.loc.y - 7), 2, Color.red);
			}
		}
		
		if(this.dir.equals("Left")){
			c.drawRect(new Posn(this.loc.x - 9, this.loc.y - 3), 10, 7, Color.BLACK);
			if(this.gender){
				c.drawCircle(new Posn(this.loc.x + 7, this.loc.y - 7), 4, Color.red);
				c.drawCircle(new Posn(this.loc.x + 7, this.loc.y - 7), 3, Color.red);
				c.drawCircle(new Posn(this.loc.x + 7, this.loc.y - 7), 2, Color.red);
				}
		}
	}
	
	public void drawClosed(Canvas c){
		c.drawDisk(this.loc, 10, Color.yellow);
		
		if(this.dir.equals("Up")){
		if(this.gender){
			c.drawCircle(new Posn(this.loc.x + 7, this.loc.y + 7), 4, Color.red);
			c.drawCircle(new Posn(this.loc.x + 7, this.loc.y + 7), 3, Color.red);
			c.drawCircle(new Posn(this.loc.x + 7, this.loc.y + 7), 2, Color.red);
			}
		}
		
		if(this.dir.equals("Right")){
			if(this.gender){
				c.drawCircle(new Posn(this.loc.x - 7, this.loc.y - 7), 4, Color.red);
				c.drawCircle(new Posn(this.loc.x - 7, this.loc.y - 7), 3, Color.red);
				c.drawCircle(new Posn(this.loc.x - 7, this.loc.y - 7), 2, Color.red);
				}
			}
		
		if(this.dir.equals("Left")){
			if(this.gender){
				c.drawCircle(new Posn(this.loc.x + 7, this.loc.y - 7), 4, Color.red);
				c.drawCircle(new Posn(this.loc.x + 7, this.loc.y - 7), 3, Color.red);
				c.drawCircle(new Posn(this.loc.x + 7, this.loc.y - 7), 2, Color.red);
				}
			}
		
		if(this.dir.equals("Down")){
			if(this.gender){
				c.drawCircle(new Posn(this.loc.x + 7, this.loc.y - 7), 4, Color.red);
				c.drawCircle(new Posn(this.loc.x + 7, this.loc.y - 7), 3, Color.red);
				c.drawCircle(new Posn(this.loc.x + 7, this.loc.y - 7), 2, Color.red);
				}
			}
	}

}
