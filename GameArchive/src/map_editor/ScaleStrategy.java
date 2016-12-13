package map_editor;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import game_graphics.AnimatedSprite2D;
import game_graphics.Sprite2D;
import game_physics.CoRectangle;

/**
* The {@code ScaleStrategy} is the implementation of {@code MapRenderStrategy}.This strategy scale
* all background images({@link Map#getBackgraundImages()}) and sprites({@link Map#getSpriteList()})
* before drawing.After scaling size of all images and sprites will be equal to map field size.
* 
* 
* @author Comexetina
*
*/

public class ScaleStrategy implements MapRenderStrategy
{

	
	
	

	/**
	 * Implementation of {@code MapRenderStrategy} method for this strategy
	 */
	@Override
	public void renderMapToScreen(Graphics g, Map map) 
	{
		
		String mapp[][]=map.getMap();
		ArrayList<BufferedImage> backgroundImages=map.getBackgraundImages();
		if(map.isScaled()==false)
		{
			
		for(int i=0;i<backgroundImages.size();i++)
		{
			System.out.println("Usao");
			float fw=(float)map.getFieldWidth()/backgroundImages.get(i).getWidth();
			float fh=(float)map.getFieldHeight()/backgroundImages.get(i).getHeight();
			backgroundImages.set(i,Sprite2D.scaleImage(backgroundImages.get(i),fw,fh));
			map.setScaled(true);
		}
		}
		for(int i=0;i<map.getMap().length;i++)
		{
			
			for(int j=0;j<map.getMap()[i].length;j++)
			{
				int index;
				if(mapp[i][j].contains("#"))
				{
					String values[]=mapp[i][j].split("#");
					index=Integer.parseInt(values[0]);
				}
				else
				{
				index=Integer.parseInt(mapp[i][j]);
				}
				if(index<0)
				{
					continue;
				}
				
				
				
				//System.out.println("Spolja"+backgroundImages.get(index).getWidth());
				g.drawImage(backgroundImages.get(index),j*map.getFieldWidth(),i*map.getFieldHeight(),null);
			}
		}
		
		
		
			
	}

	/**
	 * Implementation of {@code MapRenderStrategy} method for this strategy
	 */
	@Override
	public void setSpritesPosition(Map map) 
	{
		String mapp[][]=map.getMap();
		ArrayList<Sprite2D> sprites=map.getSpriteList();
		
			
		
		for(int i=0;i<mapp.length;i++)
		{
			
			for(int j=0;j<mapp[i].length;j++)
			{
				int index;
				if(mapp[i][j].contains("#"))
				{
					String values[]=mapp[i][j].split("#");
					index=Integer.parseInt(values[1]);
				}
				else
				{
					continue;
				}
				//System.out.println(map.getSpriteList().get(index));
				sprites.get(index).setX(j*map.getFieldWidth());
				sprites.get(index).setY(i*map.getFieldHeight());
				float fw=(float)map.getFieldWidth()/sprites.get(index).getWidth();
				float fh=(float)map.getFieldHeight()/sprites.get(index).getHeight();
				sprites.get(index).setWidth(map.getFieldWidth());
				sprites.get(index).setHeight(map.getFieldHeight());
				sprites.get(index).setCollisionBox(new CoRectangle(sprites.get(index).getX(),sprites.get(index).getY(),
						sprites.get(index).getWidth(),sprites.get(index).getHeight()));
				if(sprites.get(index) instanceof AnimatedSprite2D)
				{
					
					AnimatedSprite2D sprite=(AnimatedSprite2D)sprites.get(index);
					for(int k=0;k<sprite.getFrameCount();k++)
					{
						//System.out.println("Frame"+frame);
						sprite.getFrames()[k]=Sprite2D.scaleImage(sprite.getFrames()[k],fw,fh);
					}
					
				}
				else
				{
					sprites.get(index).setImage(Sprite2D.scaleImage(sprites.get(index).getImage(),fw,fh));
				}
			}
		
	    }	

     }
	
}
