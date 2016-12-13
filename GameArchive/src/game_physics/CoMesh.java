package game_physics;

import java.awt.Color;
import java.awt.image.BufferedImage;
/**
 * The class {@code CoMesh} represents the mesh type of {@code CollisionBox}.
 * This is the most complex type of the collision box. Whit this type of box user gets most precisely
 * collision detection, but collision check algorithm has very big time complexity.
 * @see CollisionBox
 */



public class CoMesh implements CollisionBox
{
	
	/**
	 * The x coordinate of the upper left corner of the image {@link CoMesh#image}
	 */
	private int x;
	/**
	 * The y coordinate of the upper left corner of the image {@link CoMesh#image}
	 */
	private int y;
	/**
	 *The image of the {@code CoMesh}
	 */
	private BufferedImage image;
	
	/**
	 * Class constructor
	 * 
	 * @param image mesh image
	 * @param x The x coordinate of the upper left corner of the image {@link CoMesh#image}
	 * @param y The y coordinate of the upper left corner of the image {@link CoMesh#image}
	 */
	public CoMesh(BufferedImage image,int x,int y) 
	{
		this.x=x;
		this.y=y;
		this.image=image;
	}
	
	/**
	 * Implementation of the {@link CollisionBox#isCollide(CollisionBox)} method for this class.
	 */
	@Override
	public boolean isCollide(CollisionBox otherBox) 
	{
		if(otherBox instanceof CoMesh)
		{
			CoMesh otherMesh=(CoMesh)otherBox;
			return CollisionUtility.meshAndMeshCollide(image, x, y,otherMesh.getImage(),otherMesh.getX(),otherMesh.getY());
		}
		if(otherBox instanceof CoRectangle)
		{
			CoRectangle otherRectangle=(CoRectangle)otherBox;
			return CollisionUtility.meshAndRectangleCollide(image,x, y,otherRectangle.getX(),
					otherRectangle.getY(),otherRectangle.getWidth(),otherRectangle.getHeight());
		}
		if(otherBox instanceof CoCircle)
		{
			CoCircle otherCircle=(CoCircle)otherBox;
			return CollisionUtility.meshAndCircleCollide(image, x, y,otherCircle.getCenterX(),
					otherCircle.getCenterY(),otherCircle.getR());
		}
		return false;
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
	 * @return the image
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}

	

	

}
