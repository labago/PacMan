
import colors.*;

import java.awt.Color;

/**
 * To represent the color Purple
 * 
 * @author Jonathan Lane and Richard Eldridge
 *
 */
public class Purple implements IColor{
	Color color;
	
	/**
	 * Constructor
	 */
	Purple(){
		this.color = new Color(0, 75, 150);
	}

	/**
	 * return this color
	 */
	@Override
	public Color thisColor() {
		return new Color(138, 43, 226);
	}

}