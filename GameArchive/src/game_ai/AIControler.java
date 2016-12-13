package game_ai;

import game_graphics.Sprite2D;
import game_main.GameWindow;
import game_physics.Vector2;

/**
 * The main function of {@code AIControler} class is to add simple artificial intelligence to game.
 * User can attach controller to {@code Sprite2D} and bring artificial intelligence
 * to it.Different subclasses of this class can bring different behavior to the {@code Sprite2D}.
 * 
 * @see Sprite2D
 * 
 * 
 * @author Comexetina
 *
 */


public abstract class AIControler 
{
	
	/**
	 * {@code Sprite2D} on which controller is attached.
	 */
	protected Sprite2D source;
	/**
	 * target of controller
	 */
	protected Sprite2D target;
	/**
	 * source moving speed.
	 */
	protected int speed;
	/**
	 * set controller on or off
	 */
	protected boolean eneabled;
	
	/**
	 * class constructor
	 */
	public AIControler()
	{
		
	}
	
	/**
	 * 
	 * @param source {@code Sprite2D} on which controller is attached.
	 * @param target target {@code Sprite2D}
	 * @param speed movement speed
	 */
	public AIControler(Sprite2D source,Sprite2D target,int speed)
	{
		this.source=source;
		this.target=target;
		this.speed=speed;
	}
	
	/**
	 * Calculate x and y component of{@link #source} speed and change {@link #source} position.
	 * Best place to use this method is inside {@link Sprite2D#update()} because controller calculate
	 * speed and change position of the  that Sprite2D in each frame.
	 * in each frame.
	 */
	public abstract void update();

	/**
	 * @return the source
	 */
	public Sprite2D getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(Sprite2D source) {
		this.source = source;
	}

	/**
	 * @return the target
	 */
	public Sprite2D getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(Sprite2D target) {
		this.target = target;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the eneabled
	 */
	public boolean isEneabled() {
		return eneabled;
	}

	/**
	 * @param eneabled the eneabled to set
	 */
	public void setEneabled(boolean eneabled) {
		this.eneabled = eneabled;
	}

	
}
