package engine;

import java.awt.Dimension;
import java.awt.Toolkit;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Engine extends StateBasedGame{
	
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static int height = 480;
    private static int width = 640;
    private static boolean isFullscreen = true;
    
    public Engine(){
        super("Ship Wars");
    }

    public static void main(String [] args){
        try{
        	//randomComment
            AppGameContainer app = new AppGameContainer(new Engine());
            if(isFullscreen) {
            	app.setDisplayMode(screenSize.width, screenSize.height, false);
            	app.setFullscreen(true);
            	width = screenSize.width;
            	height = screenSize.height;
            }else {
            	app.setFullscreen(false);
            	app.setDisplayMode(height, width, false);
            }
            
            app.start();
        }
        catch (SlickException e){
            e.printStackTrace();
        }
    }

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		gc.setTargetFrameRate(30);
    	gc.setAlwaysRender(true);
    	gc.setShowFPS(false);
        gc.setVSync(true);
        gc.setMaximumLogicUpdateInterval(25);
        gc.setMinimumLogicUpdateInterval(5);

        new Resources();
        
        addState(new Intro());
        addState(new Game());
        addState(new Selection());
	}
	
	public static int getHeight() {
		return height;
	}
	
	public static int getWidth() {
		return width;
	}
}