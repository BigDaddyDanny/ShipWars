package components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Hull extends Component{
	
	private int maxHealth;
	private int health;

	
	public Hull(Image s, String n, int x, int y, int max) {
		super(s, n, x, y);

		maxHealth = max;
		health = maxHealth;
		
	}
	
	public void update() {
		
	}
	
	public void damage(int dmg){
		health -= dmg;
	}
	
	public void heal(int amt) {
		health += amt;
	}
	
	public int getHealth() {
		return health;
	}

}
