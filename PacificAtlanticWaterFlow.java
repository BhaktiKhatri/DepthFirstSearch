package DepthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * 417. Pacific Atlantic Water Flow
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * Note: The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * Explanation and Code from: @star1993 https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/90733/Java-BFS-and-DFS-from-Ocean
 */

public class PacificAtlanticWaterFlow {

	//DFS
	/*
	 * Start DFS from each boundary.
	 * Then find common visited node.
	 */
	public static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<int[]>();
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int n = matrix.length, m = matrix[0].length;
        boolean[][]pacific = new boolean[n][m];
        boolean[][]atlantic = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
        	System.out.println("i: "+i);
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);	//left row 0-4
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m-1); //right row 0-4
        }
        
        for(int i=0; i<m; i++) {
        	System.out.println("i: "+i);
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i); //top column 0-4
            dfs(matrix, atlantic, Integer.MIN_VALUE, n-1, i); //bottom 
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) { 
                System.out.println("i: "+i+" j: "+j+" pacific[i][j]: "+pacific[i][j]+" atlantic[i][j]: "+atlantic[i][j]);
            	
                if(pacific[i][j] && atlantic[i][j])  {
                    res.add(new int[] {i, j});
                }
            }
        }
        return res;
    }
    
    public static int[][]dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public static void dfs(int[][]matrix, boolean[][]visited, int height, int x, int y) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        System.out.println("height: "+height+" x: "+x+" y: "+y+" m: "+m+" n: "+n);
        
        if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || height > matrix[x][y])
            return;
        																		//height < matrix[x][y] i.e 1<2 else return if 5 > 4 i.e height > matrix[x][y]			
        System.out.println("height: "+height+" matrix[x][y]: "+matrix[x][y]);	//water can flow from 1->2 or 2->2 and not from 5->4
        
        visited[x][y] = true;
        
        for(int[] d: dir) {
        	System.out.println("x: "+x+" y: "+y+" d[0]: "+d[0]+" d[1]: "+d[1]);
            dfs(matrix, visited, matrix[x][y], x+d[0], y+d[1]);
        }
    }
	
	public static void main(String[] args) {
		int[][] matrix = {  {1,2,2,3,5},
							{3,2,3,4,4},
							{2,4,5,3,1},
							{6,7,1,4,5},
							{5,1,1,2,4}
						 };
		printMatrix(matrix);
		System.out.println(pacificAtlantic(matrix));
	}

	public static void printMatrix(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(" "+matrix[i][j]);
			}
			System.out.println();
		}
	}
}
