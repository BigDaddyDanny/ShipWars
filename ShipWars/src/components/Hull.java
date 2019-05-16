package components;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;

public class Hull extends Component{
	
	private int maxHealth;
	private int health;
	private Polygon bounds;
	private int[] coords;// in x, y format, engines -> shield -> turret
	//coords needed so place that player can interact with modules is clear
	
	public Hull(Image s, String n, Polygon b, int[] c, int x, int y, int max) {
		super(s, n, x, y);

		maxHealth = max;
		health = maxHealth;
		bounds = b;
		coords = c;
		
	}
	
	public void update() {
		
	}
	
	public void damage(int dmg){
		if(health > 0) {
			health -= dmg;
		}
	}
	
	public void heal(int amt) {
		health += amt;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public Polygon getBounds() {
		return bounds;
	}
	
	public int[] getEngineCoords() {
		return new int[] {coords[0], coords[1]};
	}
	
	public int[] getShieldCoords() {
		return new int[] {coords[2], coords[3]};
	}
	
	public int[] getTurretCoords() {
		return new int[] {coords[4], coords[5]};
	}

}
