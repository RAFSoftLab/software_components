package game_physics;

/**
 * The class {@code CoCircle} represents the circle type of {@code CollisionBox}.This is good solution
 * for the circle images.It represents the circle around the sprite.
 * 
 * @see CollisionBox
 */

public class CoCircle implements CollisionBox
{

	/**
	 * The x coordinate of the circle {@code CoCircle} center
	 */
	private int centerX;
	/**
	 * The y coordinate of the circle {@code CoCircle} center
	 */
	private int centerY;
	/**
	 * The radius of the circle {@code CoCircle}
	 */
	private int r;
	
	/**
	 * Class constructor
	 * @param centerX x coordinate of the circle center
	 * @param centerY y coordinate of the circle center
	 * @param r radius of the circle center
	 */
	public CoCircle(int centerX,int centerY,int r) 
	{
		this.centerX=centerX;
		this.centerY=centerY;
		this.r=r;
	}
	
	/**
	 * Implementation of the {@link CollisionBox#isCollide(CollisionBox)} method for this class.
	 */
	@Override
	public boolean isCollide(CollisionBox otherBox)
	{		
		if(otherBox instanceof CoCircle)
		{
			CoCircle otherCircle=(CoCircle)otherBox;
			return CollisionUtility.circleAndCircleCollide(centerX,centerY,r,otherCircle.getCenterX(),otherCircle.getCenterY(),otherCircle.getR());
		}
		if(otherBox instanceof CoRectangle)
		{
			CoRectangle otherRectangle=(CoRectangle)otherBox;
			return CollisionUtility.circleAndRectangleCollide(centerX,
					centerY,r,otherRectangle.getX(),otherRectangle.getY(),otherRectangle.getWidth(),otherRectangle.getHeight());
		}
		if(otherBox instanceof CoMesh)
		{
			CoMesh otherMesh=(CoMesh)otherBox;
			return CollisionUtility.meshAndCircleCollide(otherMesh.getImage(), otherMesh.getX(),
					otherMesh.getY(),centerX,centerY,r);
		}
		return false;
	}
	
	/**
	 * Implementation of the {@link CollisionBox#update(int, int)} method for this class.
	 */
	@Override
	public void update(int x, int y) 
	{
		this.centerX=x+r;
		this.centerY=y+r;
	}

	/**
	 * toString() method
	 */
	@Override
	public String toString() 
	{
		return "("+this.centerX+","+this.centerY+")"+" r:"+r;
	}

	/**
	 * @return the centerX
	 */
	public int getCenterX() {
		return centerX;
	}

	/**
	 * @param centerX the centerX to set
	 */
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	/**
	 * @return the centerY
	 */
	public int getCenterY() {
		return centerY;
	}

	/**
	 * @param centerY the centerY to set
	 */
	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	/**
	 * @return the r
	 */
	public int getR() {
		return r;
	}

	/**
	 * @param r the r to set
	 */
	public void setR(int r) {
		this.r = r;
	}

	

}
