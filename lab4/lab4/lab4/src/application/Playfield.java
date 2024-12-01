package application;

public class Playfield {
	private final int size;
	private MatrixNode[][] playfield;
	
	public Playfield(int size) {
		this.size = size;
		playfield = new MatrixNode[size][size];
	}
	
	public MatrixNode[] get(int i) {
		if(i > size) return null;
		return playfield[i];
	}
	
	public MatrixNode get(int i, int j) {
		if(i > size || j > size) return null;
		return playfield[i][j];
	}
	
	public void set(MatrixNode el, int i, int j) {
		if(i > size || j > size) return;
		playfield[i][j] = el;
	}
	
	public void setValue(Integer el, int i, int j) {
		if(i > size || j > size) return;
		playfield[i][j].setValue(el.toString());
	}
	
	public int length() {
		return size;
	}
	
	public int width() {
		return size;
	}
}
