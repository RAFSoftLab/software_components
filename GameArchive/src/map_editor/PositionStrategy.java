package map_editor;

import java.awt.Graphics;
import java.io.ObjectInputStream.GetField;

/**
 * The {@code PositionStrategy} is the simplest implementation of {@code MapRenderStrategy}.This strategy 
 * only draw map fields at position(x*filedWidth,y*filedHeight) without any scaling and other image 
 * transformations.
 * 
 * 
 * @author Comexetina
 *
 */

public class PositionStrategy implements MapRenderStrategy
{

	/**
	 * Implementation of {@code MapRenderStrategy} method for this strategy
	 */
	@Override
	public void renderMapToScreen(Graphics g, Map map) 
	{
		for(int i=0;i<map.getMap().length;i++)
		{
			
			for(int j=0;j<map.getMap()[i].length;j++)
			{
				int index;
				if(map.getMap()[i][j].contains("#"))
				{
					String values[]=map.getMap()[i][j].split("#");
					index=Integer.parseInt(values[0]);
				}
				else
				{
				index=Integer.parseInt(map.getMap()[i][j]);
				}
				if(index<0)
				{
					continue;
				}
				//System.out.print(map.getMap()[i/32][j/32]);
				System.out.println(map.getFieldWidth());
				System.out.println(map.getBackgraundImages().get(index).getWidth());
				g.drawImage(map.getBackgraundImages().get(index),j*map.getFieldWidth(),i*map.getFieldHeight(),null);
			}
			//System.out.println();
			
		}
	}

	/**
	 * Implementation of {@code MapRenderStrategy} method for this strategy
	 */
	@Override
	public void setSpritesPosition(Map map) 
	{
		for(int i=0;i<map.getMap().length;i++)
		{
			
			for(int j=0;j<map.getMap()[i].length;j++)
			{
				int index;
				if(map.getMap()[i][j].contains("#"))
				{
					String values[]=map.getMap()[i][j].split("#");
					index=Integer.parseInt(values[1]);
				}
				else
				{
					continue;
				}
				
				
				map.getSpriteList().get(index).setX(j*map.getFieldWidth());
				map.getSpriteList().get(index).setY(i*map.getFieldHeight());
			}
				
				
				
			}
	}

	
	

}
