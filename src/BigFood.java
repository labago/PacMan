import java.awt.Color;
import idraw.*;
import geometry.*;

public class BigFood {
	Posn loc;
	
	public BigFood(Posn loc) {
		this.loc = loc;
	}
	
	public void draw(Canvas c){
		c.drawDisk(this.loc, 6, Color.white);
	}
	

}
