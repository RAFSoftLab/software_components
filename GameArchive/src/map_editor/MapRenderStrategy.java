package map_editor;

import java.awt.Graphics;

/**
 * This interface represent abstract strategy for map rendering.The classes which implements this interface
 * represents concrete strategies for map rendering.
 * 
 * 
 * 
 * @author Comexetina
 *
 */
public interface MapRenderStrategy 
{
	/**
	 * Render background images to screen
	 * @param g graphics
	 * @param map map
	 */
	void renderMapToScreen(Graphics g,Map map);
	/**
	 * Set positions of active sprites
	 * @param map map
	 */
	void setSpritesPosition(Map map);
}
