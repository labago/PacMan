import geometry.*;
import idraw.*;


public class Numbers {
	Posn loc;
	int value;
	int displayTime;
	
	public Numbers(Posn loc, int value, int displayTime) {
		this.loc = loc;
		this.value = value;
		this.displayTime = displayTime;
	}
	
	
	public void draw(Canvas c){
		c.drawString(this.loc, new Integer(this.value).toString());
	}
	
	
	
	

}
