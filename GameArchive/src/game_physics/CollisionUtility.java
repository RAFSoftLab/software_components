package game_physics;

import java.awt.Color;
import java.awt.image.BufferedImage;


/**
 * This is utility class for collision.It contains methods for collision functionalities.
 * 
 * @author Comexetina
 *
 */
public final class CollisionUtility 
{
	private CollisionUtility() 
	{
		
	}
	
	/**
	 * Calculate distance between two points in the plane.
	 * 
	 * 
	 * @param x1 first point x coordinate
	 * @param y1 first point y coordinate
	 * @param x2 second point x coordinate
	 * @param y2 second point y coordinate
	 * @return distance between two points
	 */
	public static double distance(int x1,int y1,int x2,int y2)
	{
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	
	/**
	 * Check intersection between two rectangles.
	 * 
	 * 
	 * @param x upper left corner x coordinate of first rectangle
	 * @param y upper left corner y coordinate of first rectangle
	 * @param width first rectangle width
	 * @param height first rectangle height
	 * @param otherX upper left corner x coordinate of second rectangle
	 * @param otherY left corner y coordinate of second rectangle
	 * @param otherWidth second rectangle width
	 * @param otherHeight second rectangle height
	 * @return true if intersection exist or false if not exist
	 */
	public static boolean recAndRecCollide(int x,int y,int width,int height,int otherX,int otherY,int otherWidth,int otherHeight)
	{	
		int x2=x+width;
		int y2=y+height;
		int otherX2=otherX+otherWidth;
		int otherY2=otherY+otherHeight;
		if(x>otherX2||x2<otherX||y>otherY2||y2<otherY)
		{
			return false;
		}	
		return true;	
	}
	
	/**
	 * /**
	 * Check intersection between two circles.
	 * 
	 * 
	 * @param centerX coordinate x of center of first circle
	 * @param centerY coordinate y of center of first circle
	 * @param r radius of first circle
	 * @param otherCenterX  coordinate x of center of second circle
	 * @param otherCenterY  coordinate y of center of second circle
	 * @param otherR radius of second circle
	 * @return true if intersection exist or false if not exist
	 */
	public static boolean circleAndCircleCollide(int centerX,int centerY,int r,int otherCenterX,int otherCenterY,int otherR)
	{
		if(distance(centerX,centerY,otherCenterX,otherCenterY)<(otherR+r))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * 
	 * @param centerX coordinate x of center of circle
	 * @param centerY coordinate y of center of circle
	 * @param r radius of circle
	 * @param x upper left corner x coordinate of rectangle
	 * @param y upper left corner y coordinate of rectangle
	 * @param width rectangle width
	 * @param height rectangle height
	 * @return true if intersection exist or false if not exist
	 */
	public static boolean circleAndRectangleCollide(int centerX,int centerY,int r,int x,int y,int width,int height)
	{
		int deltaX=centerX-Math.max(x,Math.min(centerX,x+width));
		int deltaY=centerY-Math.max(y,Math.min(centerY,y+height));
		return (deltaX*deltaX+deltaY*deltaY)<(r*r);
	}
	
	/**
	 * Checking transparency of pixel with (x,y) position on image.
	 * 
	 * @param image mesh image
	 * @param x coordinate x of pixel
	 * @param y coordinate y of pixel
	 * @return true if pixel is transparent or false if not transparent
	 */
	public static boolean isTransparent(BufferedImage image,int x,int y)
	{
		Color color=new Color(image.getRGB(x,y),true);
		if(color.getAlpha()==0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param image fist mesh image
	 * @param x first mesh x coordinate
	 * @param y first mesh y coordinate
	 * @param otherImage second mesh image
	 * @param otherX second mesh x coordinate
	 * @param otherY second mesh y coordinate
	 * @return true if intersection exist or false if not exist
	 */
	public static boolean meshAndMeshCollide(BufferedImage image,int x,int y,BufferedImage otherImage,int otherX,int otherY)
	{
		if(!recAndRecCollide(x,y,image.getWidth(),image.getHeight(),otherX,otherY,otherImage.getWidth(),otherImage.getHeight()))
		{
			return false;
		}
		int startX=Math.max(x,otherX);
		int endX=Math.min(x+image.getWidth(),otherX+otherImage.getWidth());
		
		int startY=Math.max(y,otherY);
		int endY=Math.min(y+image.getHeight(),otherY+otherImage.getHeight());
		
		for(int i=startY;i<endY;i++)
		{
			for(int j=startX;j<endX;j++)
			{
				if(!isTransparent(image,j-x,i-y) && !isTransparent(otherImage,j-otherX,i-otherY))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param image of mesh
	 * @param x coordinate of mesh
	 * @param y coordinate of mesh
	 * @param centerX coordinate x of center of circle
	 * @param centerY coordinate y of center of circle
	 * @param r radius of circle
	 * @return true if intersection exist or false if not exist
	 */
	public static boolean meshAndCircleCollide(BufferedImage image,int x,int y,int centerX,int centerY,int r)
	{
		
		int newX,newY;
		newX=centerX-r;
		newY=centerY-r;
		if(!CollisionUtility.recAndRecCollide(x, y,image.getWidth(),image.getHeight(),newX,
				newY,2*r,2*r))
		{
			return false;
		}
		int startX=Math.max(x,newX);
		int endX=Math.min(x+image.getWidth(),newX+2*r);
		
		int startY=Math.max(y,newY);
		int endY=Math.min(y+image.getHeight(),newY+2*r);
		for(int i=startY;i<endY;i++)
		{
			for(int j=startX;j<endX;j++)
			{
				if(!CollisionUtility.isTransparent(image,j-x,i-y))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param image of mesh
	 * @param x coordinate of mesh
	 * @param y coordinate of mesh
	 * @param recX upper left corner x coordinate of rectangle
	 * @param recY upper left corner y coordinate of rectangle
	 * @param recWidth rectangle width
	 * @param recHeight rectangle height
	 * @return true if intersection exist or false if not exist
	 */
	public static boolean meshAndRectangleCollide(BufferedImage image,int x,int y,int recX,int recY,int recWidth,int recHeight)
	{
		
		if(!CollisionUtility.recAndRecCollide(x, y,image.getWidth(),image.getHeight(),recX,recY,recWidth,recHeight))
		{
			return false;
		}
		int startX=Math.max(x,recX);
		int endX=Math.min(x+image.getWidth(),recX+recWidth);
		
		int startY=Math.max(y,recY);
		int endY=Math.min(y+image.getHeight(),recY+recHeight);
		for(int i=startY;i<endY;i++)
		{
			for(int j=startX;j<endX;j++)
			{
				if(!CollisionUtility.isTransparent(image,j-x,i-y))
				{
					return true;
				}
			}
		}
		return false;
	}
	
}
