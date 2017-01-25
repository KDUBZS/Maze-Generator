package mazeGenerator;

import java.util.ArrayList;
import java.util.Stack;

public class graphSearch {
    
	public static int[] DFS(mazeGraph G, int start) {
        boolean[] visited = new boolean[G.numVerts()];
        int[] previous = new int[G.numVerts()];
        Stack<Integer> stack = new Stack<>();
        int visitCount = 1;
        
        stack.push(start);
        visited[start] = true;
        previous[start] = -1;
        
        while (visitCount < G.numVerts()) {
            ArrayList<Integer> neighbors = G.adjacents(start);
            ArrayList<Integer> unvisited = new ArrayList<>();
            for (int j : neighbors){
                if (visited[j] == false) {
                    unvisited.add(j);
                }
            }
            
            if (!unvisited.isEmpty()) {
            	int randNeighbor = (int) (Math.random() * unvisited.size());
                int w = unvisited.get(randNeighbor);
                visited[w] = true;
                visitCount++;
                previous[w] = start;
                stack.push(w);
                start = w;
            } else {
                start = stack.pop(); // back tracking
            }
        }
        return previous;
    }
}
