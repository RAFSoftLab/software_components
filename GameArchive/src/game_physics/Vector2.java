package game_physics;

/**
 * This class represent 2 dimensional Vector who have two components x and y.
 * @author Comexetina
 *
 */

public class Vector2 
{
	
	/**
	 * Vector x component
	 */
	private int x;
	/**
	 * Vector y component
	 */
	private int y;
	
	/**
	 * Class constructor
	 */
	public Vector2() 
	{
	
	}
	
	/**
	 * Class constructor
	 * 
	 * @param x x component value
	 * @param y y component value
	 */
	public Vector2(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Copy constructor
	 * @param otherVector2 copy vector
	 */
	public Vector2(Vector2 otherVector2)
	{
		this.x=otherVector2.x;
		this.y=otherVector2.y;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	
}
