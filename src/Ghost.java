import java.awt.Color;



import idraw.*;
import geometry.*;

public class Ghost {
	String name;
	Color color;
	String dir;
	Posn loc;
	boolean caged;
	int timeLeftCaged;
	boolean goLeft = false;
	boolean goRight = false;
	boolean check = false;
	boolean left = false;
	boolean up = false;
	boolean right = false;
	int speed;
	boolean edible = false;
	
	
	public Ghost(String name, Color color, String dir, Posn loc, boolean caged, int timeLeftCaged, int speed) {
		this.name = name;
		this.color = color;
		this.dir = dir;
		this.loc = loc;
		this.caged = caged;
		this.timeLeftCaged = timeLeftCaged;
		this.speed = speed;
	}

	public Ghost(String dir, Posn loc) {
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
	
	public void drawNormal(Canvas c){
		c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 5), 20, 15, this.color);
		c.drawDisk(new Posn(this.loc.x, this.loc.y), 10, this.color);
		
		if(this.dir.equals("Right")){
		c.drawDisk(new Posn(this.loc.x + 7, this.loc.y - 2), 3, Color.WHITE);
		}
		if(this.dir.equals("Left")){
			c.drawDisk(new Posn(this.loc.x - 7, this.loc.y - 2), 3, Color.WHITE);
		}
		if(this.dir.equals("Up")){
			c.drawDisk(new Posn(this.loc.x - 4, this.loc.y - 5), 2, Color.WHITE);
			c.drawDisk(new Posn(this.loc.x + 5, this.loc.y  - 5), 2, Color.WHITE);
		}
		if(this.dir.equals("Down")){
			c.drawDisk(new Posn(this.loc.x - 4, this.loc.y + 4), 2, Color.WHITE);
			c.drawDisk(new Posn(this.loc.x  + 5, this.loc.y + 4), 2, Color.WHITE);
		}
	}
	
	public void drawEdibleBlue(Canvas c){
		c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 5), 20, 15, Color.BLUE);
		c.drawDisk(new Posn(this.loc.x, this.loc.y), 10, Color.blue);
		
		if(this.dir.equals("Right")){
		c.drawDisk(new Posn(this.loc.x + 7, this.loc.y - 2), 3, Color.WHITE);
		}
		if(this.dir.equals("Left")){
			c.drawDisk(new Posn(this.loc.x - 7, this.loc.y - 2), 3, Color.WHITE);
		}
		if(this.dir.equals("Up")){
			c.drawDisk(new Posn(this.loc.x - 4, this.loc.y - 5), 2, Color.WHITE);
			c.drawDisk(new Posn(this.loc.x + 5, this.loc.y  - 5), 2, Color.WHITE);
		}
		if(this.dir.equals("Down")){
			c.drawDisk(new Posn(this.loc.x - 4, this.loc.y + 4), 2, Color.WHITE);
			c.drawDisk(new Posn(this.loc.x  + 5, this.loc.y + 4), 2, Color.WHITE);
		}
	}
	
	public void drawEdibleWhite(Canvas c){
		c.drawRect(new Posn(this.loc.x - 10, this.loc.y - 5), 20, 15, Color.white);
		c.drawDisk(new Posn(this.loc.x, this.loc.y), 10, Color.white);
		
		if(this.dir.equals("Right")){
		c.drawDisk(new Posn(this.loc.x + 7, this.loc.y - 2), 3, Color.black);
		}
		if(this.dir.equals("Left")){
			c.drawDisk(new Posn(this.loc.x - 7, this.loc.y - 2), 3, Color.black);
		}
		if(this.dir.equals("Up")){
			c.drawDisk(new Posn(this.loc.x - 4, this.loc.y - 5), 2, Color.black);
			c.drawDisk(new Posn(this.loc.x + 5, this.loc.y  - 5), 2, Color.black);
		}
		if(this.dir.equals("Down")){
			c.drawDisk(new Posn(this.loc.x - 4, this.loc.y + 4), 2, Color.black);
			c.drawDisk(new Posn(this.loc.x  + 5, this.loc.y + 4), 2, Color.black);
		}
	}
}
