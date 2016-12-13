package game_main;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game_graphics.Sprite2D;
import game_physics.Vector2;

/**
 * This class represent the game object in player control.It contains {@code Sprite2D},control buttons and
 * other necessarily parameters.It has integrated functionality to move in all directions, user only need 
 * to select button for each direction.The position is represent with {@code Vector2}.Component x of
 * vector is x coordinate of player and component y is y coordinate of player.
 * 
 * @see Sprite2D
 * @see Vector2
 * 
 * @author Comexetina
 *
 */

public class Player implements KeyListener
{
	/**
	 * The player sprite
	 */
	private Sprite2D sprite;
	/**
	 * Position of the player upper left corner
	 */
	private Vector2 position;
	/**
	 * Movement speed
	 */
	private int speed;
	
	/**
	 * Key for moving left
	 */
	private int levo;
	/**
	 * Key for moving right
	 */
	private int desno;
	/**
	 * Key for moving up
	 */
	private int gore;
	/**
	 * Key for moving down
	 */
	private int dole;
	
	/**
	 * Class constructor
	 * 
	 * @param sprite The player sprite
	 * @param positoin Position of the player upper left corner
	 * @param speed Movement speed
	 */
	public Player(Sprite2D sprite,Vector2 positoin,int speed)
	{
		this.sprite=sprite;
		this.position=positoin;
		this.speed=speed;
	}
	
	/**
	 * Add this key listener to gameWindow root parent
	 * @param gameWindow playes game window
	 */
	public void playerAddListener(GameWindow gameWindow)
	{
		Container parrent=gameWindow.getParent();
		while(parrent.getParent()!=null)
		{
			parrent=parrent.getParent();
		}
		parrent.addKeyListener(this);
	}
	
	/**
	 * Update players sprite and position
	 */
	public void update()
	{
		sprite.update();
		position.setX(sprite.getX());
		position.setY(sprite.getY());
	}
	
	/**
	 * Draw player to scrren
	 * @param g graphhics
	 */
	public void draw(Graphics g)
	{
		sprite.draw(g);
	}
	

	/**
	 * Implementation of KeyListener method.
	 * Move player in all directions.
	 */
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode()==levo)
		{
			sprite.setX(sprite.getX()-speed);
		}
		if(e.getKeyCode()==desno)
		{
			sprite.setX(sprite.getX()+speed);
		}
		if(e.getKeyCode()==gore)
		{
			sprite.setY(sprite.getY()-speed);
		}
		if(e.getKeyCode()==dole)
		{
			sprite.setY(sprite.getY()+speed);
		}
			
	}

	/**
	 * Implementation of KeyListener method.
	 * 
	 */
	@Override
	public void keyReleased(KeyEvent e) 
	{
			
	}

	/**
	 * Implementation of KeyListener method.
	 * 
	 */
	@Override
	public void keyTyped(KeyEvent e) 
	{
			
	}

	/**
	 * @return the sprite
	 */
	public Sprite2D getSprite() {
		return sprite;
	}

	/**
	 * @param sprite the sprite to set
	 */
	public void setSprite(Sprite2D sprite) {
		this.sprite = sprite;
	}

	/**
	 * @return the position
	 */
	public Vector2 getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Vector2 position) {
		this.position = position;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the levo
	 */
	public int getLevo() {
		return levo;
	}

	/**
	 * @param levo the levo to set
	 */
	public void setLevo(int levo) {
		this.levo = levo;
	}

	/**
	 * @return the desno
	 */
	public int getDesno() {
		return desno;
	}

	/**
	 * @param desno the desno to set
	 */
	public void setDesno(int desno) {
		this.desno = desno;
	}

	/**
	 * @return the gore
	 */
	public int getGore() {
		return gore;
	}

	/**
	 * @param gore the gore to set
	 */
	public void setGore(int gore) {
		this.gore = gore;
	}

	/**
	 * @return the dole
	 */
	public int getDole() {
		return dole;
	}

	/**
	 * @param dole the dole to set
	 */
	public void setDole(int dole) {
		this.dole = dole;
	}




}