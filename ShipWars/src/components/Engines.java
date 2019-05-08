package components;

import org.newdawn.slick.Image;

public class Engines extends Component{
	
	private double dodgeChance;
	
	/*
	 * @param dc should be number between 0 - 1 where 1 represents 100% chance to dodge
	 */
	public Engines(Image s, String n, int x, int y, double dc) {
		super(s, n, x, y);
		
		dodgeChance = dc;
	}
	
	public void update() {
		
	}
	
	public double getDodgeChance() {
		return dodgeChance;
	}
	
}
