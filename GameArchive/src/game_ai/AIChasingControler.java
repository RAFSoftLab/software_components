package game_ai;

import game_graphics.Sprite2D;
import game_physics.CollisionUtility;
import game_physics.Vector2;

/**
 * The function of {@code AIChasingControler} is to make one Sprite2D to follow second one.This is can be used
 * in many situation in games.For example to make enemies follow player.
 * The only user must do is to add controller to {@code Sprite2D} and set target to follow.
 * 
 * 
 * @author Comexetina
 *
 */

public class AIChasingControler extends AIControler
{

	/**
	 * @param source {@code Sprite2D} on which controller is attached.
	 * @param target target {@code Sprite2D}
	 * @param speed movement speed
	 */
	public AIChasingControler(Sprite2D source, Sprite2D target,int speed) 
	{
		this.source=source;
		this.target=target;
		this.speed=speed;
	}

	/**
	 * Implementation of {@link AIControler#update()} method for this class.
	 * 
	 */
	@Override
	public void update() 
	{
		double distance=CollisionUtility.distance(source.getX(),source.getY(),target.getX(),target.getY());
		int vx=(int)((target.getX()-source.getX())*speed/distance);
		int vy=(int)((target.getY()-source.getY())*speed/distance);
		source.setX(source.getX()+vx);
		source.setY(source.getY()+vy);
		
	}
}
