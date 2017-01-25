package mazeGenerator;

import java.util.ArrayList;

public class mazeGraph implements Graph {
	private int width;
	private int height;
	
	public mazeGraph (int width,int height){
		this.width = width;
		this.height = height;
	}
	
	public int numVerts(){
		return width*height;
	}
	
	public ArrayList<Integer> adjacents(int v){
		int row = v / width;
		int column = v % width;

		ArrayList<Integer> neighbor = new ArrayList<Integer>();
		
		if (column > 0){
			neighbor.add ((row*width) + (column-1));
		}
		if (column < width-1){
			neighbor.add((row*width) + (column+1));
		}
		if (row > 0){
			neighbor.add((row-1)*width + column);
		}
		if (row < height-1){
			neighbor.add((row+1)*width + column);
		}
	return neighbor;
	}
}