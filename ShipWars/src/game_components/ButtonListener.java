package game_components;

import org.lwjgl.input.Mouse;

import engine.Engine;

public class ButtonListener extends Thread {

	public static int x = 0, y = 0;

	public void run() {

		while (true) {
			x = Mouse.getX();
			y = Engine.getHeight() - Mouse.getY() - 1;
		}
	}
	
}
