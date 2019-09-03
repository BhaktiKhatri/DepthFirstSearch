package DepthFirstSearch;

public class CountIslands {

	final static int offset[] = {-1, 0, 1};
	
	public int numIslands(char grid[][]) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int countIslands = 0;
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				if(grid[i][j] == 1 && !visited[i][j]) {
					countIslands += 1;
					doDFS(grid, i,j, visited);
				}
			}
		}
		return countIslands;
	}
	
	public void doDFS(char[][] matrix, int i, int j, boolean[][] visited) {
		
		if(visited[i][j]) {
			return;
		}
		visited[i][j] = true;
		int xOffset, yOffset;
		
		for(int x=0; x<offset.length; x++) {
			xOffset = offset[x];
			for(int y=0; y<offset.length; y++) {
				yOffset = offset[y];
				
				if(xOffset == 0 && yOffset == 0)
					continue;
				
				if(neighbourExists(matrix, i+xOffset, j+yOffset) && (xOffset == 0 || yOffset == 0)) {
					doDFS(matrix, i+xOffset, j+yOffset, visited);
				}
			}
		}
	}
	
	public boolean neighbourExists(char[][] matrix, int i, int j) {
		if((i >= 0) && (i < matrix.length) && (j >= 0) && j < (matrix[0].length)) {
			if(matrix[i][j] == 1) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) 
    {
        char[][] matrix = {
                            {1, 1, 0, 0, 0},
                            {1, 1, 0, 0, 0},
                            {0, 0, 1, 0, 0},
                            {0, 0, 0, 1, 1},
                         };
        char[][] matrix1 = {
	        {1,1,1,1,0},
	        {1,1,0,1,0},
	        {1,1,0,0,0},
	        {0,0,0,0,0},
        };

        CountIslands islands = new CountIslands();

        System.out.println(islands.numIslands(matrix));
    }

}
