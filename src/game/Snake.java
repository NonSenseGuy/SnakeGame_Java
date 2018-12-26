package game;



public class Snake {
	final int MOVE = 20;
	private Direction dir;
	private Node head;
	
	public Snake(int x, int y) {
		head = new Node(x,y);
		dir = Direction.STOP;
	}
	
	public Node getHead() {
		return head;
	}
	
	public Direction getDir() {
		return dir;
	}
	
	public void setDir(Direction d) {
		dir = d;
	}
	
	public void addToTail() {
		Node aux = getLast();
		Node n = new Node(aux.getX(), aux.getY()+20);
		aux.setNext(n);
	}
	
	public Node getLast() {
		Node aux = head;
		while(aux.getNext() != null) {
			aux = aux.getNext();
		}
		return aux;
	}
	
	public void moveVertical(int dist) {
		Node aux = head.getNext();
		int x = head.getX();
		int y = head.getY();
		head.setY(y+dist);
		while(aux != null) {
			int auxX = aux.getX();
			int auxY = aux.getY();
			aux.setX(x);
			aux.setY(y);
			x = auxX;
			y = auxY;
			aux = aux.getNext();
		}
	}
	
	
	public void moveHorizontal(int dist) {
		Node aux = head.getNext();
		int x = head.getX();
		int y = head.getY();
		head.setX(x+dist);
		while(aux != null) {
			int auxX = aux.getX();
			int auxY = aux.getY();
			aux.setX(x);
			aux.setY(y);
			x = auxX;
			y = auxY;
			aux = aux.getNext();
		}
	}
	
	@Override
	public String toString() {
		return "posX = " + head.getX() + "\nPosY = " + head.getY();
	}
	
}
