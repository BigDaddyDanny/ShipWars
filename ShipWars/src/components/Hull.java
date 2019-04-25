package components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Hull implements Sprite{
	
	private int maxHealth;
	private int health;
	private Image sprite;
	private int x;
	private int y;
	
	public Hull(Image s, int x, int y, int max) {
		
		this.x = x;
		this.y = y;
		sprite = s;
		maxHealth = max;
		health = maxHealth;
		
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		sprite.drawCentered(x, y);
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
