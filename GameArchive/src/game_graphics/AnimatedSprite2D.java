package game_graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * This class extend {@code Sprite2D} class and represent 2D animation.Using this class is very simple.
 * User only need select sprite sheet and set some parameters and animation will work. 
 * @author Comexetina
 *
 */


public class AnimatedSprite2D extends Sprite2D
{
	
	/**
	 * The array of animation frames.
	 */
	private BufferedImage[] frames;
	/**
	 * Number of columns in sprite sheet
	 */
	private int col;
	/**
	 * Number of rows in sprite sheet
	 */
	private int rows;
	/**
	 * Index of current frame in {@link #frames}
	 */
	private int currentFrame;
	/**
	 * Time when current game frame begins.
	 */
	private long startTime;
	/**
	 * Duration of each frame
	 */
	private long frameTime;
	/**
	 * Is all frames were showed
	 */
	private boolean playedonce;
	/**
	 * Number of frames
	 */
	private int frameCount;

	/**
	 * Class constructor
	 * 
	 * @param path path the path of sprite sheet
	 * @param x x the upper left  x coordinate of {@code Sprite2D}
	 * @param y y the upper left  x coordinate of {@code Sprite2D}
	 * @param col Number of columns in sprite sheet
	 * @param rows Number of rows in sprite sheet
	 * @param width frame width
	 * @param height frame width
	 * @param frameCount number of frames
	 */
	public AnimatedSprite2D(String path, int x, int y,int col,int rows,int width,int height,int frameCount) 
	{
		super(path, x, y,width,height);	
		this.col=col;
		frameTime=100;
		this.rows=rows;
		this.frameCount=frameCount;
		frames=new BufferedImage[col*rows];
		int brojac=0;
		//System.out.println(this.getImage());
		for(int i=0;i<col;i++)
		{
			for(int j=0;j<rows;j++)
			{
				if(brojac>=frameCount)
				{
					break;
				}
				frames[brojac++]=Sprite2D.cutImage(this.getImage(),i,j,width,height);
			}
		}
		currentFrame=0;
		startTime=System.nanoTime();
		playedonce=false;
	}
	
	/**
	 * Class constructor
	 * 
	 * @param image the sprite sheet
	 * @param x x the upper left  x coordinate of {@code Sprite2D}
	 * @param y y the upper left  x coordinate of {@code Sprite2D}
	 * @param col Number of columns in sprite sheet
	 * @param rows Number of rows in sprite sheet
	 * @param width frame width
	 * @param height frame width
	 * @param frameCount number of frames
	 */
	public AnimatedSprite2D(BufferedImage image, int x, int y,int col,int rows,int width,int height,int frameCount) 
	{
		super(image, x, y,width,height);	
		this.col=col;
		this.rows=rows;
		frameTime=100;
		this.frameCount=frameCount;
		frames=new BufferedImage[col*rows];
		int brojac=0;
		//System.out.println(this.getImage());
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(brojac>=frameCount)
				{
					break;
				}
				frames[brojac++]=Sprite2D.cutImage(this.getImage(),j,i,width,height);
			}
		}
		currentFrame=0;
		startTime=System.nanoTime();
		playedonce=false;
	}
		
	/**
	 * Update animation
	 */
	public void update() 
	{	
		super.update();
		long elapsedTime=(System.nanoTime()-startTime)/1000000;
		if(elapsedTime>frameTime)
		{
			currentFrame++;
			startTime=System.nanoTime();
		}
		if(currentFrame==frameCount)
		{
			currentFrame=0;
			playedonce=true;
		}	
	}

	/**
	 * Draw {@link #currentFrame to scrren}
	 */
	@Override
	public void draw(Graphics g) 
	{	
		g.drawImage(frames[currentFrame],getX(),getY(),null);
	}

	/**
	 * @return the frames
	 */
	public BufferedImage[] getFrames() {
		return frames;
	}

	/**
	 * @param frames the frames to set
	 */
	public void setFrames(BufferedImage[] frames) {
		this.frames = frames;
	}

	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * @return the currentFrame
	 */
	public int getCurrentFrame() {
		return currentFrame;
	}

	/**
	 * @param currentFrame the currentFrame to set
	 */
	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

	/**
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the frameTime
	 */
	public long getFrameTime() {
		return frameTime;
	}

	/**
	 * @param frameTime the frameTime to set
	 */
	public void setFrameTime(long frameTime) {
		this.frameTime = frameTime;
	}

	/**
	 * @return the playedonce
	 */
	public boolean isPlayedonce() {
		return playedonce;
	}

	/**
	 * @param playedonce the playedonce to set
	 */
	public void setPlayedonce(boolean playedonce) {
		this.playedonce = playedonce;
	}

	/**
	 * @return the frameCount
	 */
	public int getFrameCount() {
		return frameCount;
	}

	/**
	 * @param frameCount the frameCount to set
	 */
	public void setFrameCount(int frameCount) {
		this.frameCount = frameCount;
	}

}
