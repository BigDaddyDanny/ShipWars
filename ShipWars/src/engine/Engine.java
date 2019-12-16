package engine;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Engine extends StateBasedGame{
	
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static int width = screenSize.width < 1336? screenSize.width: 1336;
    private static int height = screenSize.height < 768? screenSize.height: 768;
    private static boolean isFullscreen = false;
    
    public Engine(){
        super("Ship Wars");
    }

    public static void main(String [] args){
        try{
        	
            AppGameContainer app;
            if(isFullscreen) {
            	app = new AppGameContainer(new ScalableGame(new Engine(), screenSize.width, screenSize.height, true));
            	app.setDisplayMode(screenSize.width, screenSize.height, false);
            	app.setFullscreen(true);
            	width = screenSize.width;
            	height = screenSize.height;
            	System.out.println("Width: " + width + ", Height: " + height);
            }else {
            	app = new AppGameContainer(new ScalableGame(new Engine(), width, height, true));
            	app.setFullscreen(false);
            	app.setDisplayMode(width, height, false);
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
        addState(new GabesTestScene());
        addState(new NewSelection());
	}
	
	public static int getHeight() {
		return height;
	}
	
	public static int getWidth() {
		return width;
	}
	
	public static int getMouseX() {
		return Mouse.getX();
	}
	
	public static int getMouseY() {
		return height-Mouse.getY()-1;
	}
}