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
			images.put("ExampleHull", loadImage("resources/hulls/ExampleHull.png"));
			images.put("ExampleShield", loadImage("resources/shields/ExampleShield.png"));
			images.put("ExampleEngine", loadImage("resources/engines/ExampleEngine.png"));
			
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
	
	private Image loadImage(String path) throws SlickException {		
		return new Image(path, false, Image.FILTER_NEAREST);
	}
	
	public static Image getImage(String name) {
		return images.get(name);
	}

}
