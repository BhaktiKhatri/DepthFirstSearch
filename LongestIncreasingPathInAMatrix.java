package DepthFirstSearch;

public class LongestIncreasingPathInAMatrix {

	public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public static int longestIncreasingPath(int[][] matrix) {
	    if(matrix.length == 0)
	    	return 0;
	    int m = matrix.length;
	    int n = matrix[0].length;
	    int[][] cache = new int[m][n];
	    int max = 1;
	    for(int i = 0; i < m; i++) {
	        for(int j = 0; j < n; j++) {
	        	System.out.println("i: "+i+" j: "+j);
	            int len = dfs(matrix, i, j, m, n, cache);
	            System.out.println("len: "+len);
	            max = Math.max(max, len);
	            System.out.println("max: "+max);
	        }
	    }   
	    return max;
	}

	public static int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
	    if(cache[i][j] != 0)
	    	return cache[i][j];
	    int max = 1;
	    for(int[] dir: dirs) {
	        int x = i + dir[0];
	        int y = j + dir[1];
	        
	        if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) 
	        	continue;
	        else
	        	System.out.println("i: "+i+" j: "+j+" x: "+x+" y: "+y+" matrix[x][y]: "+matrix[x][y]+" matrix[i][j]: "+matrix[i][j]);
	        int len = 1 + dfs(matrix, x, y, m, n, cache);
	        max = Math.max(max, len);
	    }
	    cache[i][j] = max;
	    return max;
	}
	
	public static void main(String[] args) {
		int[][] nums = {
		                 {3,4,5},
		                 {3,2,6},
		                 {2,2,1}
					   };
		System.out.println(longestIncreasingPath(nums));
	}

}
