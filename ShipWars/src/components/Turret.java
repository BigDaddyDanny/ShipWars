package components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/*
 * - bullets should be fired from this class since it is the one that has it's x,y coords to be properly able to shoot as well as the dmg and
 * 		fireChance which the bullet needs
 */

public class Turret extends Component{
	
	private int angle;
	
	private double dmg;
	private double fireChance;
	
	/*
	 * @param fc should be between 0 - 1 with 1 being 100% chance of fire
	 * 
	 */
	public Turret(Image s, String n, int x, int y, double d, double fc) {
		super(s, n, x, y);
		
	
		dmg = d;
		fireChance = fc;
		angle = 0;
		
	}
	
	public void update() {
				
		sprite.setRotation(angle);
		
	}

}
