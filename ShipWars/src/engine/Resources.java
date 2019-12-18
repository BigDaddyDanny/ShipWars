package engine;
import java.util.HashMap;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Resources {
	
	private static HashMap<String, Image> images;
	
	public Resources(){
		
		images = new HashMap<String, Image>();
		
		try {
			
			images.put("SpaceBackground1", loadImage("resources/space_background.png"));
			images.put("BioBoomer", loadImage("resources/turrets/BioBoomer.png"));
			images.put("pewPewGun", loadImage("resources/turrets/pew_pew_gun.png"));
			images.put("bioBonker", loadImage("resources/turrets/bio_bonker.png"));
			images.put("greyHull", loadImage("resources/hulls/grey_hull.png"));
			images.put("redHull", loadImage("resources/hulls/red_hull.png"));
			images.put("blueHull", loadImage("resources/hulls/blue_hull.png"));
			images.put("ExampleShield", loadImage("resources/shields/ExampleShield.png"));
			images.put("lightShield", loadImage("resources/shields/light_shield.png"));
			images.put("energyShield", loadImage("resources/shields/energy_shield.png"));
			images.put("ExampleEngine", loadImage("resources/engines/ExampleEngine.png"));
			images.put("fastEngine", loadImage("resources/engines/fastEngine.png"));
			images.put("ionEngine", loadImage("resources/engines/IonEngine.png"));
			images.put("bioEngine", loadImage("resources/engines/BioEngine.png"));
			images.put("character1", loadImage("resources/characters/character1.png"));
			images.put("title", loadImage("resources/ship_wars_title.png"));
			images.put("upArrow", loadImage("resources/up_arrow.png"));
			images.put("downArrow", loadImage("resources/down_arrow.png"));
			images.put("done", loadImage("resources/done.png"));
			images.put("join", loadImage("resources/join.png"));
			images.put("host", loadImage("resources/host.png"));
			images.put("upArrowHover", loadImage("resources/up_arrow_hover.png"));
			images.put("downArrowHover", loadImage("resources/down_arrow_hover.png"));
			images.put("doneHover", loadImage("resources/done_hover.png"));
			images.put("joinHover", loadImage("resources/join_hover.png"));
			images.put("hostHover", loadImage("resources/host_hover.png"));
			images.put("color", loadImage("resources/color.png"));
			
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
	
	private Image loadImage(String path) throws SlickException {		
		return new Image(path, false, Image.FILTER_NEAREST);
	}
	
	public static Image getImage(String name) {
		return images.get(name).copy();
	}

}
