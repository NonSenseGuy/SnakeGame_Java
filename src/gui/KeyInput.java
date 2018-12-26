package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {
	
	private SnakeGUI game;
	
	public KeyInput(SnakeGUI s) {
		game = s;
	}
	
	public void keyPressed(KeyEvent e) {
		game.keyPressed(e);
	}
	


}
