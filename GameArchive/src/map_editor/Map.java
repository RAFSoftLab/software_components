package map_editor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import game_graphics.Sprite2D;

/**
 * The function of {@code Map} class is to fill screen background with smaller images and set positions of
 * game objects.To use this class user must fill its matrix({@link #map},{@link #spriteList} and 
 * {@link #backgraundImages}.The value before # at matrix[y][x] is the index of image in {@link #backgraundImages}
 * which will be draw at position(x*filedWidth,y*filedHeight).The value after is the index of {@code Sprite2D}
 * in {@link #spriteList} which move to position(x*filedWidth,y*filedHeight).
 * 
 * 
 * 
 * @author Comexetina
 *
 */

public class Map 
{
	
	/**
	 * Map matrix
	 */
	private String[][] map;
	/**
	 * map width
	 */
	private int width;
	/**
	 * map height
	 */
	private int height;
	/**
	 * field width
	 */
	private int fieldWidth;
	/**
	 * field height
	 */
	private int fieldHeight;
	
	/**
	 * The list of sprite
	 */
	private ArrayList<Sprite2D> spriteList;
	/**
	 * The list of background images
	 */
	private ArrayList<BufferedImage> backgraundImages;
	/**
	 * The strategy for rendering fields to screen
	 */
	private MapRenderStrategy mapRenderStrategy;
	
	private boolean isScaled;
	
	/**
	 * Class constructor
	 * 
	 * @param fieldWidth the width of map field
	 * @param fieldHeight the height of map field
	 * @param width the width of map
	 * @param height the height of map
	 */
	public Map(int fieldWidth,int fieldHeight,int width,int height)
	{
		this.fieldWidth=fieldWidth;
		this.fieldHeight=fieldHeight;
		this.width=width;
		this.height=height;
		backgraundImages=new ArrayList<BufferedImage>();
	}
	
	/**
	 * Class consructor
	 * 
	 * @param map1 map matrix
	 * @param fieldWidth the width of map field
	 * @param filedheight the height of map field
	 * @param width the width of map
	 * @param height the height of map
	 */
	public Map(String map1[][],int fieldWidth,int filedheight,int width,int height) 
	{
		map=new String[map1.length][map1[0].length];
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[i].length;j++)
			{
				map[i][j]=map1[i][j];
			}
		}
		spriteList=new ArrayList<Sprite2D>();
		this.fieldWidth=fieldWidth;
		this.fieldHeight=filedheight;
		this.width=width;
		this.height=height;
		backgraundImages=new ArrayList<BufferedImage>();
	}
	
	/**
	 * This method render backgroundimages({@link #backgraundImages}) to screen
	 * @param g graphics
	 */
	public void renderMapToScreen(Graphics g)
	{
		mapRenderStrategy.renderMapToScreen(g,this);
	}
	
	/**
	 * This method set positions of sprite from spriteListe({@link #spriteList})
	 */
	public void setSpritePosition()
	{
		mapRenderStrategy.setSpritesPosition(this);
	}
	

	
	
	
	
	
	
	

	/**
	 * @return the map
	 */
	public String[][] getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(String[][] map) {
		this.map = map;
	}

	/**
	 * @return the fieldWidth
	 */
	public int getFieldWidth() {
		return fieldWidth;
	}

	/**
	 * @param fieldWidth the fieldWidth to set
	 */
	public void setFieldWidth(int fieldWidth) {
		this.fieldWidth = fieldWidth;
	}

	/**
	 * @return the fieldHeight
	 */
	public int getFieldHeight() {
		return fieldHeight;
	}

	/**
	 * @param fieldHeight the fieldHeight to set
	 */
	public void setFieldHeight(int fieldHeight) {
		this.fieldHeight = fieldHeight;
	}

	/**
	 * @return the spriteList
	 */
	public ArrayList<Sprite2D> getSpriteList() {
		return spriteList;
	}

	/**
	 * @param spriteList the spriteList to set
	 */
	public void setSpriteList(ArrayList<Sprite2D> spriteList) {
		this.spriteList = spriteList;
	}

	/**
	 * @param arg0 element to add
	 * @return if successful
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	public boolean add(Sprite2D arg0) {
		return spriteList.add(arg0);
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
	 * @return the backgraundImages
	 */
	public ArrayList<BufferedImage> getBackgraundImages() {
		return backgraundImages;
	}

	/**
	 * @param backgraundImages the backgraundImages to set
	 */
	public void setBackgraundImages(ArrayList<BufferedImage> backgraundImages) {
		this.backgraundImages = backgraundImages;
	}

	/**
	 * @param e element to add
	 * @return if successful
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	public boolean add(BufferedImage e) {
		return backgraundImages.add(e);
	}

	/**
	 * @param mapRenderStrategy the mapRenderStrategy to set
	 */
	public void setMapRenderStrategy(MapRenderStrategy mapRenderStrategy) {
		this.mapRenderStrategy = mapRenderStrategy;
	}

	/**
	 * @return the isScaled
	 */
	public boolean isScaled() {
		return isScaled;
	}

	/**
	 * @param isScaled the isScaled to set
	 */
	public void setScaled(boolean isScaled) {
		this.isScaled = isScaled;
	}
	
	
	
	

}
