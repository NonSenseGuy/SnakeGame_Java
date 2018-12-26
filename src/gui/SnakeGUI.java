package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game.*;

@SuppressWarnings("serial")
public class SnakeGUI extends JPanel{
	private GUI gui;
	private Game game;
	
	public SnakeGUI(GUI gui) {
		this.gui = gui;
		game = gui.getGame();
		setFocusable(true);
		addKeyListener(new KeyInput(this));
			
	}
	
	public void paintComponent(Graphics g) {
		paintFruit(g);
		paintSnake(g);
	}
	
	public void paintSnake(Graphics g) {
		g.setColor(Color.yellow);
		Node aux = game.getSnake().getHead();
		while(aux != null) {
			g.fillRect(aux.getX(), aux.getY(), 20, 20);
			aux = aux.getNext();
		}
		
		
	}
	
	public void paintFruit(Graphics g) {
		g.setColor(Color.magenta);
		g.fillRect(game.getFruitX(), game.getFruitY(), 20, 20);
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A) {
			game.getSnake().setDir(Direction.LEFT);
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			game.getSnake().setDir(Direction.RIGHT);
		}else if(e.getKeyCode() == KeyEvent.VK_W) {
			game.getSnake().setDir(Direction.UP);
		}else if(e.getKeyCode() == KeyEvent.VK_S) {
			game.getSnake().setDir(Direction.DOWN);
		}else if(e.getKeyCode() == KeyEvent.VK_P) {
			game.setGameOver(false);
		}else if(e.getKeyCode() == KeyEvent.VK_R) {
			gui.restartGame();
			JOptionPane.showMessageDialog(null, "Game restarted");
		}
	}


}
