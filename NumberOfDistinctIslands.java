package DepthFirstSearch;

/*
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
	Input:
	11110
	11010
	11000
	00000
	Output: 1

	Example 2:
	Input:
	11000
	11000
	00100
	00011
	Output: 3
 * Explanation and Code from: @GrubenM https://leetcode.com/problems/number-of-islands/discuss/56359/Very-concise-Java-AC-solution
 * Time complexity: O(M×N) where M is the number of rows and N is the number of columns.
 * Space complexity: worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.
 */

public class NumberOfDistinctIslands {
	//Refer this
	public static int numDistinctIslands(int[][] grid) {
	    if(grid == null || grid.length == 0 || grid[0].length == 0) {
	        return 0;
	    }
	 
	    int m = grid.length;
	    int n = grid[0].length;
	 
	    System.out.println("m: "+m+" n: "+n);
	    int count=0;
	    
	    for(int i=0; i<m; i++) {
	        for(int j=0; j<n; j++) {
	        	System.out.println("i: "+i+" j: "+j+" grid[i][j]: "+grid[i][j]);
	            if(grid[i][j] == 1) {
	                count++;
	                merge(grid, i, j);
	            }
	        }
	    }
	    return count;
	}
	 
	public static void merge(int[][] grid, int i, int j) {
	    if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=1) {
	    	System.out.println("merge if i: "+i+" j: "+j);
	    	return;
	    }
	    else
	    	System.out.println("merge i: "+i+" j: "+j+" grid[i][j]: "+grid[i][j]);
	    	
	    grid[i][j]='X';	//0
	 
	    merge(grid, i-1, j);	//top
	    merge(grid, i+1, j);	//down
	    merge(grid, i, j-1);	//left
	    merge(grid, i, j+1);	//right
	}
	
	public static void main(String[] args) {
		int[][] grid = { {1,1,0,1,1},
						 {1,0,0,0,0},
						 {0,0,0,0,1},
						 {1,1,0,1,1}
						};
		System.out.println(numDistinctIslands(grid));
	}

	public static int numIslands(int[][] matrix) {
        int total = 0;

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
            	System.out.println("i: "+i+" j: "+j+" matrix[i][j]: "+matrix[i][j]);
            	
            	if(matrix[i][j] == 1 && ((i - 1) < 0 || matrix[i - 1][j] == 0) && ((j - 1) < 0 || matrix[i][j - 1] == 0)) {
            		total++;
            	}
            }
        }
        System.out.println("total: "+total);
        return total;
    }
}