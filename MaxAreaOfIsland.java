package DepthFirstSearch;

/**
 * Leetcode 695. Max Area of Island
 * https://leetcode.com/problems/max-area-of-island/description/
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * Explanation and Code from: Leetcode 695. Max Area of Island
 * @author NisuBhakti
 * Time Complexity: O(ij)
 * Intuit
 * Easy
 */

public class MaxAreaOfIsland {

	//The idea is to count the area of each island using dfs. During the dfs, we set the value of each point in the island to 0
	public static int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 1) {
					maxArea = Math.max(maxArea, areaOfIsland(i, j, grid));
				}
			}
		}
		return maxArea;
	}
	
	public static int areaOfIsland(int i, int j, int[][] grid) {
		if(i>=0 && i<grid.length && j>=0 && j <grid[0].length && grid[i][j] == 1) {
			grid[i][j] = 0;
			return 1 + areaOfIsland(i+1, j, grid) + areaOfIsland(i-1, j, grid) + areaOfIsland(i, j-1, grid) + areaOfIsland(i, j+1, grid);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
		        {1,1,1,1,0},
		        {1,1,0,1,0},
		        {1,1,0,0,0},
		        {0,0,0,0,0},
	        };
		System.out.println(maxAreaOfIsland(matrix));
	}
}
