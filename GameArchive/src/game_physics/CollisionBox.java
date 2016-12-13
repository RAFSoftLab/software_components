package game_physics;

import game_graphics.Sprite2D;
import game_main.GameWindow;

/**
 * The {@code CollisionBox} represents the area around the {@code Sprite2D} or other game object.
 * If this area intersect with other collision box, user get that information. When user get that information
 * he can decide what he want to do with that object(for example if object collide with wall it stop moving).
 * Collision box can have multiple variants of shape and shape is difference between implementations of
 * this interface. 
 * Best way to use Collision box is to add it to {@code Sprite2D} or to other game object.
 * 
 * @see Sprite2D
 * 
 * 
 * 
 * @author Comexetina
 *
 */

public interface CollisionBox 
{
	/**
	 * This method check intersection of two object which implements this interface. Best place to use this
	 * method is inside {@link GameWindow#update()} because user will get information of intersection 
	 * in each frame.
	 * 
	 * 
	 * @param otherBox collision box with which we check collision
	 * @return true if intersection exist or false if intersection not exist
	 */
	public boolean isCollide(CollisionBox otherBox);
	
	/**
	 * This method updating the position of the collision box. If {@code Sprite2D} or other game object change 
	 * position his collision box must change position too. 
	 * Best place to use this method is inside update method of game object which contain this collision box.
	 * 
	 * @param x coordinate x of parent object
	 * @param y coordinate y of parrent object
	 */
	public void update(int x,int y);
}
