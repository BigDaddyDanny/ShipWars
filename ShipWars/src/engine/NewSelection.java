package engine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import components.Engines;
import components.Hull;
import components.Shield;
import components.Turret;
import game_components.Button;

public class NewSelection extends BasicGameState {

	private float previewPercent = 95f;

	private static final Image BACKGROUND = Resources.getImage("SpaceBackground1");

	private final int SELECTION_BAR_SIZE = 250;
	private final int BOXES = 4;
	private final int VERTICAL_BOX_SIZE = (int) (Engine.getHeight() / BOXES);
	private float scale = (Engine.getHeight() * (0.01f * previewPercent)) / Hull.STANDARD_SIZE[1];
	private Button[] upArrows;
	private Button[] downArrows;
	private Button done;
	// The 2nd and 3rd of each array is utter garbage and only serve to test name
	// output for selection
	private Hull[] hulls = { ComponentLoader.getHull(0), ComponentLoader.getHull(1), ComponentLoader.getHull(2) };
	private Shield[] shields = { ComponentLoader.getShield(0), ComponentLoader.getShield(1),
			ComponentLoader.getShield(2) };
	private Engines[] engines = { ComponentLoader.getEngine(1), ComponentLoader.getEngine(2), ComponentLoader.getEngine(3) };
	private Turret[] turrets = { ComponentLoader.getTurret(0), ComponentLoader.getTurret(1),
			ComponentLoader.getTurret(2) };
	private int hullI = 0, shieldI = 0, engineI = 0, turretI = 0, mx, my;
	private int displayBoxW;
	private int[] hullCoords;
	private int[] turretCoords;
	private int[] shieldCoords;
	private int[] engineCoords;

	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {

		hullCoords = new int[2];
		shieldCoords = new int[2];
		engineCoords = new int[2];
		turretCoords = new int[2];
		displayBoxW = Engine.getWidth() - SELECTION_BAR_SIZE;

		upArrows = new Button[BOXES];
		downArrows = new Button[BOXES];
		for (int i = 0; i < BOXES; i++) {
			upArrows[i] = new Button(Resources.getImage("upArrow"), 0, i * VERTICAL_BOX_SIZE,
					Resources.getImage("upArrowHover"), Resources.getImage("upArrow"));
			downArrows[i] = new Button(Resources.getImage("downArrow"), 0,
					((i + 1) * VERTICAL_BOX_SIZE) - Resources.getImage("downArrow").getHeight(),
					Resources.getImage("downArrowHover"), Resources.getImage("downArrow"));
		}
		done = new Button(Resources.getImage("done"), Engine.getWidth()-Resources.getImage("done").getWidth()-20, Engine.getHeight()-Resources.getImage("done").getHeight()-20, Resources.getImage("doneHover"), Resources.getImage("done"));

	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {

		mx = Engine.getMouseX();
		my = Engine.getMouseY();
		
		

		//----------------------------TEST-------------------------------------
		if (gc.getInput().isKeyDown(Input.KEY_LSHIFT)) {
			if (gc.getInput().isKeyDown(Input.KEY_UP))
				previewPercent += 1f;
			if (gc.getInput().isKeyDown(Input.KEY_DOWN))
				previewPercent -= 1f;
		}

		scale = (Engine.getHeight() * (0.01f * previewPercent)) / Hull.STANDARD_SIZE[1];
		//----------------------------TEST-------------------------------------
		
		

		hullCoords[0] = (int) ((SELECTION_BAR_SIZE + displayBoxW / 2)
				- (hulls[hullI].getSprite().getWidth() * scale / 2));
		hullCoords[1] = (int) (Engine.getHeight() / 2 - (hulls[hullI].getSprite().getHeight() * scale / 2));
		shieldCoords[0] = (int) (hullCoords[0] + hulls[hullI].getShieldCoords()[0] * scale
				- shields[shieldI].getSprite().getWidth() * scale / 2);
		shieldCoords[1] = (int) (hullCoords[1] + hulls[hullI].getShieldCoords()[1] * scale
				- shields[shieldI].getSprite().getHeight() * scale / 2);
		turretCoords[0] = (int) (hullCoords[0] + hulls[hullI].getTurretCoords()[0] * scale
				- turrets[turretI].getSprite().getWidth() * scale / 2);
		turretCoords[1] = (int) (hullCoords[1] + hulls[hullI].getTurretCoords()[1] * scale
				- turrets[turretI].getSprite().getHeight() * scale / 2);
		engineCoords[0] = (int) (hullCoords[0] + hulls[hullI].getEngineCoords()[0] * scale
				- engines[engineI].getSprite().getWidth() * scale / 2);
		engineCoords[1] = (int) (hullCoords[1] + hulls[hullI].getEngineCoords()[1] * scale
				- engines[engineI].getSprite().getHeight() * scale / 2);

		if (upArrows[0].isClicked(mx, my, gc)) {
			hullI = hullI < hulls.length - 1 ? hullI + 1 : 0;
		}
		if (upArrows[1].isClicked(mx, my, gc)) {
			shieldI = shieldI < shields.length - 1 ? shieldI + 1 : 0;
		}
		if (upArrows[2].isClicked(mx, my, gc)) {
			engineI = engineI < engines.length - 1 ? engineI + 1 : 0;
		}
		if (upArrows[3].isClicked(mx, my, gc)) {
			turretI = turretI < turrets.length - 1 ? turretI + 1 : 0;
		}

		if (downArrows[0].isClicked(mx, my, gc)) {
			hullI = hullI > 0 ? hullI - 1 : hulls.length - 1;
		}
		if (downArrows[1].isClicked(mx, my, gc)) {
			shieldI = shieldI > 0 ? shieldI - 1 : shields.length - 1;
		}
		if (downArrows[2].isClicked(mx, my, gc)) {
			engineI = engineI > 0 ? engineI - 1 : engines.length - 1;
		}
		if (downArrows[3].isClicked(mx, my, gc)) {
			turretI = turretI > 0 ? turretI - 1 : turrets.length - 1;
		}
		if (done.isClicked(mx, my, gc)) {
			s.enterState(States.GAME);
		}

	}

	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		BACKGROUND.draw(0, 0, Engine.getWidth(), Engine.getHeight());
		Resources.getImage("color").draw(0, 0, SELECTION_BAR_SIZE, Engine.getHeight());

		hulls[hullI].getSprite().draw(hullCoords[0], hullCoords[1], scale);
		shields[shieldI].getSprite().draw(shieldCoords[0], shieldCoords[1], scale);
		turrets[turretI].getSprite().draw(turretCoords[0], turretCoords[1], scale);
		engines[engineI].getSprite().draw(engineCoords[0], engineCoords[1], scale);

		for (int i = 0; i < BOXES; i++) {
			upArrows[i].isHovering(mx, my);
			downArrows[i].isHovering(mx, my);
			upArrows[i].render(g);
			downArrows[i].render(g);
		}
		done.isHovering(mx, my);
		done.render(g);
		g.drawString(hulls[hullI].getName(), 20, VERTICAL_BOX_SIZE / 2 - 10);
		g.drawString(shields[shieldI].getName(), 20, (VERTICAL_BOX_SIZE) + VERTICAL_BOX_SIZE / 2 - 10);
		g.drawString(engines[engineI].getName(), 20, (2 * VERTICAL_BOX_SIZE) + VERTICAL_BOX_SIZE / 2 - 10);
		g.drawString(turrets[turretI].getName(), 20, (3 * VERTICAL_BOX_SIZE) + VERTICAL_BOX_SIZE / 2 - 10);

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return States.NEW_SELECTION;
	}

}
