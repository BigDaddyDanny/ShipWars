package components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
/*
 * - should, in the future, implement way to render the shield on the screen
 */

public class Shield extends Component{
	
	private int maxHealth;
	private int health;
	private double rechargeRate;
	
	public Shield(Image s, String n, int x, int y, int h, double recharge) {
		super(s, n, x, y);
		
		rechargeRate = recharge;
		maxHealth = h;
		health = maxHealth;
		
	}
	
	public void render(Graphics g) {
		
		if(health > 0) {
			sprite.drawCentered(getX(), getY());
		}
		
	}
	
	public void update() {
		
	}
	
	public void damage(int dmg) {
		health -= dmg;
		
		if(health < 0) {
			health = 0;
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public double getRecharge() {
		return rechargeRate;
	}

}
