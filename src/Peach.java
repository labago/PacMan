
import colors.*;

import java.awt.Color;

/**
 * To represent the color Purple
 * 
 * @author Jonathan Lane and Richard Eldridge
 *
 */
public class Peach implements IColor{
	Color color;
	
	/**
	 * Constructor
	 */
	Peach(){
		this.color = new Color(205, 51, 51);
	}

	/**
	 * return this color
	 */
	@Override
	public Color thisColor() {
		return new Color(205, 51, 51);
	}

}