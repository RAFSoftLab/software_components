package game_physics;

/**
 * The class {@code CoRectangle} represents the rectangle type of {@code CollisionBox}.This is the simplest
 * and most used type of collision box. It represents the rectangle around the sprite.
 * 
 * @see CollisionBox
 * @author Comexetina
 */
public class CoRectangle implements CollisionBox
{
	
	/**
	 * The x coordinate of the upper left corner of the {@code CoRectangle}
	 */
	private int x;
	/**
	 * The y coordinate of the upper left corner of the {@code CoRectangle}
	 */
	private int y;
	/**
	 * The width of the {@code Rectangle}
	 */
	private int width;
	/**
	 * The height of the {@code Rectangle}
	 */
	private int height;
	
	
	/**
	 * Class constructor
	 * @param x The x coordinate of the upper left corner of the {@code CoRectangle}
	 * @param y The y coordinate of the upper left corner of the {@code CoRectangle}
	 * @param width The width of the {@code Rectangle}
	 * @param height The height of the {@code Rectangle}
	 */
	public CoRectangle(int x,int y,int width,int height) 
	{
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	
	/**
	 * Implementation of the {@link CollisionBox#isCollide(CollisionBox)} method for this class.
	 */
	@Override
	public boolean isCollide(CollisionBox otherBox) 
	{	
		if(otherBox instanceof CoRectangle)
		{
			CoRectangle otherRectangle=(CoRectangle)otherBox;
			return CollisionUtility.recAndRecCollide(x, y,width,height,otherRectangle.getX(),
					otherRectangle.getY(),otherRectangle.getWidth(),otherRectangle.getHeight());
		}
		if(otherBox instanceof CoCircle)
		{
			CoCircle circle=(CoCircle)otherBox;
			return CollisionUtility.circleAndRectangleCollide(circle.getCenterX(),
					circle.getCenterY(),circle.getR(),x,y,width,height);
		}
		if(otherBox instanceof CoMesh)
		{
			CoMesh otherMesh=(CoMesh)otherBox;
			return CollisionUtility.meshAndRectangleCollide(otherMesh.getImage(), otherMesh.getX(),
					otherMesh.getY(),x,y,width,height);
					
		}
		return false;
	}
	
	

	/**
	 * toString() method
	 */
	@Override
	public String toString() 
	{
		return ("("+x+","+y+")"+","+"("+(x+width)+","+(y+height)+")");
	}


	/**
	 * Implementation of the {@link CollisionBox#update(int, int)} method for this class.
	 */
	@Override
	public void update(int x, int y) 
	{
		this.x=x;
		this.y=y;
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

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	

}
