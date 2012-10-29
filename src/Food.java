import java.awt.Color;

import idraw.*;
import geometry.*;

public class Food {
	Posn loc;
	
	public Food(Posn loc) {
		this.loc = loc;
	}
	
	public void draw(Canvas c){
		c.drawDisk(this.loc, 3, Color.white);
	}
	

}
