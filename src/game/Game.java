package game;
import java.util.Random;



/*
 * Poner puntajes
 * Margen de perdida
 * No poder volver a tocar a la serpiente
 * fluidez
 */
public class Game{
	final int WIDTH = 600;
	final int HEIGHT = 600;
	
	private boolean gameOver;
	private Snake snake;
	private int fruitX, fruitY, score;
	

	public Game(){
		genFruit();
		this.snake = new Snake(WIDTH/2-20, HEIGHT/2-20);
		this.score = 0;
	}
	
	public Snake getSnake() {
		return snake;
	}
	
	public int getFruitX() {
		return fruitX;
	}
	
	public int getFruitY() {
		return fruitY;
	}
	
	public int getScore() {
		return score;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

//	public void moveSnake(Direction d){
//		switch(d) {
//		case STOP:
//			snake.moveHorizontal(0);
//			System.out.println("Stop");
//		case LEFT:
//			snake.moveHorizontal(-MOVE);
//			System.out.println("LEFT");
//		case RIGHT:
//			snake.moveHorizontal(MOVE);
//		case UP:
//			snake.moveVertical(MOVE);
//		case DOWN:
//			snake.moveVertical(-MOVE);
//		}
//	}

  public void genFruit(){
	  Random r = new Random();
	  fruitX = r.nextInt(WIDTH - 40);
	  fruitY = r.nextInt(HEIGHT - 40);
	  fruitX = round(fruitX);
	  fruitY = round(fruitY);
  }
  
  public int round(int x) {
	  int res = x%20;
	  if(res > 10) {
		  x+= (20-res);
	  }else {
		  x-= res;
	  }
	  return x;
  }
  

}
