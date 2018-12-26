package game;

import javax.swing.JOptionPane;

import gui.GUI;

public class MovementThread extends Thread {
	
	private final int MOVE = 20;
	Game game;
	GUI gui;
	
	public MovementThread(Game g, GUI gui) {
		game = g;
		this.gui = gui;
	}
	
	public void run() {
		Snake s = game.getSnake();
		while(!game.isGameOver()) {
			if(s.getHead().getX() > game.WIDTH || s.getHead().getX() < 0 || s.getHead().getY() < 0 || s.getHead().getY() > game.HEIGHT) {
				game.setGameOver(true);
				JOptionPane.showMessageDialog(null, "Game over");
				
			}
			switch(s.getDir()) {
			case DOWN:
				s.moveVertical(MOVE);
				break;
			case LEFT:
				s.moveHorizontal(-MOVE);
				break;
			case RIGHT:
				s.moveHorizontal(MOVE);
				break;
			case STOP:
				s.moveHorizontal(0);
				break;
			case UP:
				s.moveVertical(-MOVE);
				break;
			default:
				break;
			}
			if(s.getHead().getX() == game.getFruitX() && s.getHead().getY() == game.getFruitY()) {
				System.out.println("Eaten");
				s.addToTail();
				game.genFruit();
			}
			try {
				Thread.sleep(300);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			gui.repaint();
		}
		
		
	}
	
	
}
