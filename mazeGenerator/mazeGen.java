package mazeGenerator;

import java.io.PrintStream;

public class mazeGen {
	
	final static int EAST = 1; // 0001
	final static int NORTH = 2; // 0010
	final static int WEST = 4; // 0100
	final static int SOUTH = 8; // 1000
	
	public static int [][] mazeEncodeAndDecode (int height, int width, int[] previous){
		
		int cells[][] = new int[height][width]; // initially all cells have four walls
		for (int row = 0; row < height; row++){
			for (int column = 0; column < width; column++){
				cells[row][column] = 0xF; // bit code = 1111
			}
		}
		
		for (int row = 0; row < height; row++){
			for (int column = 0; column < width; column++){
				int v = row*width + column;
				int parent = previous[v];
				if (parent >= 0) { // if vertex has parent
					int r0 = parent / width;
					int c0 = parent % width;
					if (c0 == column + 1) {
						cells[row][column] &= ~EAST; // clear EAST bit (~EAST = 1110)
						cells[r0][c0] &= ~WEST; // clear WEST bit (~WEST = 1011)
					}
					if (r0 == row + 1){
						cells[row][column] &= ~SOUTH; // clear SOUTH bit (~SOUTH = 1000)
						cells[r0][c0] &= ~NORTH; // clear NORTH bit (~NORTH = 0010)
					}
					if (c0 == column - 1){
						cells[row][column] &= ~WEST;
						cells[r0][c0] &= ~EAST;
					}
					if (r0 == row - 1){
						cells[row][column] &= ~NORTH;
						cells[r0][c0] &= ~SOUTH;
					}
				}
			}
		}
		int startRow = (int) (Math.random()*width);
		int exitRow = (int) (Math.random()*width);

		cells[startRow][0] &= ~WEST;
		cells[exitRow][width-1] &= ~EAST;
		
		return cells;
	}
	
	public static void main(String[] args) {
		int W, H;
		String fname;
		if (args.length != 3) {
			W = 100;
			H = 101;
			fname = "maze100x101.txt";
		} else {
			W = Integer.parseInt(args[0]);
			H = Integer.parseInt(args[1]);
			if (W < 5 || H < 5) {
				System.err.println("bogus size!");
				return;
			}
			fname = args[2];
		}
		
		mazeGraph mazeGraph = new mazeGraph(W,H);
		int [] parent = graphSearch.DFS(mazeGraph,0);
		int [][] cells = mazeGen.mazeEncodeAndDecode(H, W, parent);
		
		try {
			PrintStream ps = new PrintStream(fname);
			ps.println(W + " " + H);
			for (int row = 0; row < H; row++) {
				for (int column = 0; column < W; column++) {
					ps.print(cells[row][column] + " ");
				}
				ps.println();
			}
			ps.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}