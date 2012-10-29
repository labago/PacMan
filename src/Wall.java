import java.awt.Color;


import idraw.*;
import geometry.*;


public class Wall {
	Color color = Color.blue;
	Posn loc;
	int height;
	int width;
	
	public Wall(Color color, Posn loc, int height, int width) {
		this.color = color;
		this.loc = loc;
		this.height = height;
		this.width = width;
	}
	
	public void draw(Canvas c){
		c.drawRect(this.loc, this.width, this.height, Color.BLACK);
		//c.drawRect(new Posn(this.loc.x + 7, this.loc.y + 7), this.width - 15, this.height - 15, Color.BLUE);
		c.drawLine(new Posn(this.loc.x, this.loc.y), new Posn(this.loc.x + this.width, this.loc.y), this.color);
		c.drawLine(new Posn(this.loc.x, this.loc.y), new Posn(this.loc.x, this.loc.y + this.height), this.color);
		c.drawLine(new Posn(this.loc.x, this.loc.y + this.height), new Posn(this.loc.x + this.width, this.loc.y + this.height), this.color);
		c.drawLine(new Posn(this.loc.x + this.width, this.loc.y), new Posn(this.loc.x + this.width, this.loc.y + this.height), this.color);

		// second coating
		c.drawLine(new Posn(this.loc.x, this.loc.y + 1), new Posn(this.loc.x + this.width, this.loc.y + 1), this.color);
		c.drawLine(new Posn(this.loc.x + 1, this.loc.y), new Posn(this.loc.x + 1, this.loc.y + this.height), this.color);
		c.drawLine(new Posn(this.loc.x, this.loc.y + this.height - 1), new Posn(this.loc.x + this.width, this.loc.y + this.height - 1), this.color);
		c.drawLine(new Posn(this.loc.x + this.width - 1, this.loc.y), new Posn(this.loc.x + this.width - 1, this.loc.y + this.height), this.color);
		
	}
	

}
