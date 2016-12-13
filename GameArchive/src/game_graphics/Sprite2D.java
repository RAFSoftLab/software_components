package game_graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game_ai.AIControler;
import game_physics.CoCircle;
import game_physics.CoRectangle;
import game_physics.CollisionBox;

/**
 * This class represent 2D sprite which can have some attachments({@code CollisionBox or} or 
 * {@code AIControler}).
 * 
 * 
 * @see CollisionBox
 * @see AIControler
 * 
 * @author Comexetina
 *
 */

public class Sprite2D
{
	
	/**
	 * image of the {@code Sprite2D}
	 */
	private BufferedImage image;
	/**
	 * upper left corner x coordinate of the {@code Sprite2D}
	 */
	private int x;
	/**
	 * upper left corner y coordinate of the {@code Sprite2D}
	 */
	private int y;
	/**
	 * width of the {@code Sprite2D}
	 */
	private int width;
	/**
	 * height coordinate of the {@code Sprite2D}
	 */
	private int height;
	/**
	 * collisionBox of the {@code Sprite2D}
	 */
	private CollisionBox collisionBox;
	/**
	 * aiControler of the {@code Sprite2D}
	 */
	private AIControler aiControler;
	
	/**
	 * Class constructor
	 * @param path the path of image
	 * @param x the upper left  x coordinate of {@code Sprite2D}
	 * @param y the upper left y coordinate of {@code Sprite2D}
	 * @param width  width of the {@code Sprite2D}
	 * @param height  height of the {@code Sprite2D}
	 */
	public Sprite2D(String path,int x,int y,int width,int height) 
	{
		try {
			image=ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		collisionBox=new CoRectangle(x, y,width,height);
	}
	
	/**
	 * Class constructor
	 * @param image image of the {@code Sprite2D}
	 * @param x x the upper left  x coordinate of {@code Sprite2D}
	 * @param y y the upper left y coordinate of {@code Sprite2D}
	 * @param width width  width of the {@code Sprite2D}
	 * @param height height  height of the {@code Sprite2D}
	 */
	public Sprite2D(BufferedImage image,int x,int y,int width,int height) 
	{
		
		this.image=image;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		collisionBox=new CoRectangle(x, y,width,height);
	}
	
	/**
	 * Call update methods of attachments({@code CollisionBox or} and 
     * {@code AIControler}).
	 */
	public void update()
	{
		if(collisionBox!=null)
		{
			this.getCollisionBox().update(x, y);
		}
		this.getCollisionBox().update(x,y);
		if(aiControler!=null)
		{
			aiControler.update();
		}
	}
	
	/**
	 * Draw image{@link #image} to screen
	 * @param g graphics
	 */
	public void draw(Graphics g) 
	{
		g.drawImage(image,x,y,null);	
	}

	
	/**
	 * The function of this method is to get subimage of big image.User can use this to get all
	 * animation frames from spriteSheet.Only thing user need to do is to width and height of frame
	 * and set column and row in SpriteSheeh. 
	 *  
	 * 
	 * @param spriteSheet big image
	 * @param col column of sprite sheet
	 * @param row row of sprite sheet
	 * @param width of subimage
	 * @param height of subimage
	 * @return subimage
	 */
	public static BufferedImage cutImage(BufferedImage spriteSheet,int col,int row,int width,int height)
	{
		BufferedImage img=spriteSheet.getSubimage(col*width,row*height,width,height);
		return img;
	}
	
	/**
	 * Load the image.
	 * 
	 * @param path the path of image
	 * @return the image
	 * @throws IOException exception
	 */
	public static BufferedImage loadImage(String path) throws IOException
	{
		if(path==null||path.isEmpty())
		{
			System.out.println("Path is null");
			return null;
		}
		
		BufferedImage image=ImageIO.read(new File(path));
		return image;
	}
	
	/**
	 * 
	 * @param originalImage image before scaling
	 * @param fw factor x
	 * @param fh factor y
	 * @return scaled image
	 */
	public static BufferedImage scaleImage(BufferedImage originalImage,float fw,float fh)
	{
		int width=originalImage.getWidth();
		int height=originalImage.getHeight();
		BufferedImage scaledImage = new BufferedImage((int)(width*fw),(int)(height*fh), BufferedImage.TYPE_INT_ARGB);
		AffineTransform at = new AffineTransform();
		at.scale(fw,fh);
		AffineTransformOp scaleOp = 
		   new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		
		
		scaledImage=scaleOp.filter(originalImage,scaledImage);
		System.out.println(scaledImage);
		return scaledImage;
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

	/**
	 * @return the collisionBox
	 */
	public CollisionBox getCollisionBox() {
		return collisionBox;
	}

	/**
	 * @param collisionBox the collisionBox to set
	 */
	public void setCollisionBox(CollisionBox collisionBox) {
		this.collisionBox = collisionBox;
	}

	/**
	 * @return the aiControler
	 */
	public AIControler getAiControler() {
		return aiControler;
	}

	/**
	 * @param aiControler the aiControler to set
	 */
	public void setAiControler(AIControler aiControler) {
		this.aiControler = aiControler;
	}
	
}
