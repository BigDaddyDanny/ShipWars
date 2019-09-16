package engine;

import org.newdawn.slick.geom.Polygon;

import components.Engines;
import components.Hull;
import components.Shield;
import components.Turret;

public class ComponentLoader {

	private static final int TURRET_X = 800;
	private static final int TURRET_Y = 900;
	private static final int SHIELD_X = 1400;
	private static final int SHIELD_Y = 20;
	private static final int ENGINE_X = 650;
	private static final int ENGINE_Y = 20;
	private static final int HULL_X = 0;
	private static final int HULL_Y = 20;
	
	public static Turret getTurret(int id) {
		switch(id) {
		case 0:
			return new Turret(Resources.getImage("BioBoomer"), "Bio Boomer", TURRET_X, TURRET_Y, 5, 2);
		default:
			return new Turret(Resources.getImage("BioBoomer"), "Bio Boomer", TURRET_X, TURRET_Y, 5, 2);			
		}
	}
	
	public static Engines getEngine(int id) {
		switch(id) {
		case 0:
			return new Engines(Resources.getImage("ExampleEngine"), "Example Engine", ENGINE_X, ENGINE_Y, .5);
		default:
			return new Engines(Resources.getImage("ExampleEngine"), "Example Engine", ENGINE_X, ENGINE_Y, .5);			
		}
	}
	
	public static Shield getShield(int id) {
		switch(id) {
		case 0:
			return new Shield(Resources.getImage("ExampleShield"), "Example Shield", SHIELD_X, SHIELD_Y, 100, .2);
		default:
			return new Shield(Resources.getImage("ExampleShield"), "Example Shield", SHIELD_X, SHIELD_Y, 100, .2);			
		}
	}
	
	public static Hull getHull(int id) {
		switch(id) {
		case 0:// in x, y format, engines -> shield -> turret
			return new Hull(Resources.getImage("greyHull"), "Grey Hull", new Polygon(new float[] {0, 0, 0, 5, 5, 5, 5, 0}), new int[] {250, 720, 250, 400, 250, 150}, HULL_X, HULL_Y, 100);

		case 1:// in x, y format, engines -> shield -> turret
			return new Hull(Resources.getImage("redHull"), "Red Hull", new Polygon(new float[] {0, 0, 0, 5, 5, 5, 5, 0}), new int[] {250, 720, 250, 400, 250, 150}, HULL_X, HULL_Y, 100);

		case 2:// in x, y format, engines -> shield -> turret
			return new Hull(Resources.getImage("blueHull"), "Blue Hull", new Polygon(new float[] {0, 0, 0, 5, 5, 5, 5, 0}), new int[] {250, 720, 250, 400, 250, 150}, HULL_X, HULL_Y, 100);
		default:
			return new Hull(Resources.getImage("greyHull"), "Grey Hull", new Polygon(new float[] {0, 0, 0, 5, 5, 5, 5, 0}), new int[] {}, HULL_X, HULL_Y, 100);			
		}
	}
	
	
}
