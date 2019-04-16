package engine;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Resources {
	
	private static Map<String, Image> images;
	
	Resources(){
		images = new HashMap<String, Image>();
		
		try {
			images.put("space_background1", new Image("resources/space_background.png"));
			
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
	
	private Image loadImage(String path) throws SlickException {
		return new Image(path , false, Image.FILTER_NEAREST);
	}
	
	public static Image getImage(String name) {
		return images.get(name);
	}

}
