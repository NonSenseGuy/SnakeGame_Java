package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import game.Game;
import game.MovementThread;

public class GUI extends JFrame{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static int WIDTH = 600;
	public final static int HEIGHT = 600;
	private SnakeGUI snakeGUI;
	private Game game;
	private MovementThread mt;

	public GUI(){
		setTitle("Snake");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		game = new Game();
		mt = new MovementThread(game,this);
		mt.start();
		snakeGUI = new SnakeGUI(this);
		add(snakeGUI);
		Color c = new Color(51, 51 ,51);
		setBackground(c);
		
		
    }
	
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public void restartGame() {
		game = new Game();
		mt = new MovementThread(game,this);
		mt.start();	
	}
	
	public static void main(String[] args) {
		GUI g = new GUI();
		g.setVisible(true);
	}
}
