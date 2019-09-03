package DepthFirstSearch;

import java.util.Arrays;

/*
 * 529. Minesweeper
 * https://leetcode.com/problems/minesweeper/
 * Explanation and Code from: @iamone14 https://leetcode.com/problems/minesweeper/discuss/99841/Straight-forward-Java-solution
 */

public class Minesweeper {
	
	/*
	 	This is a typical Search problem, either by using DFS or BFS. Search rules:
		
		DFS:
		If click on a mine ('M'), mark it as 'X', stop further search.
		If click on an empty cell ('E'), depends on how many surrounding mine:
		2.1 Has surrounding mine(s), mark it with number of surrounding mine(s), stop further search.
		2.2 No surrounding mine, mark it as 'B', continue search its 8 neighbors.
	 */
    public static char[][] updateBoard(char[][] board, int[] click) {
        System.out.println("click: "+Arrays.toString(click));
    	
    	int x = click[0];
        int y = click[1];
        
        System.out.println("x: "+x+" y: "+y+" board[x][y]: "+board[x][y]);
        
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        
        dfs(board, x, y);
        return board;
    }
    
    private static void dfs(char[][] board, int x, int y) {
    	System.out.println("x: "+x+" y: "+y);
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'E') 
        	return;
        
        System.out.println("x: "+x+" y: "+y+" board[x][y]: "+board[x][y]);
        
        int mines = findMines(board, x, y);
        System.out.println("mines: "+mines);
        
        if(mines == 0) {
            board[x][y] = 'B';
            
            for(int i=-1; i<=1; i++) {
               for(int j=-1; j<=1; j++) {
            
            	   System.out.println("i: "+i+" j: "+j+" (x+i): "+(x+i)+" (y+j): "+(y+j));
            	   
                    dfs(board, x + i, y + j);
                }
            }
        }
        else 
        	board[x][y] = (char)('0' + mines);
    }
    
    private static int findMines(char[][] board, int x, int y) {
        int num = 0;
        
        System.out.println("x: "+x+" y: "+y+" board[x][y]: "+board[x][y]);
        
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
            	
            	System.out.println("i: "+i+" j: "+j+" (x+i): "+(x+i)+" (y+j): "+(y+j));
                
            	int x1 = x + i, y1 = y + j;
                
                if (x1 < 0 || y1 < 0 || x1 >= board.length || y1 >= board[0].length) 
                	continue;
                
                System.out.println("x1: "+x1+" y1: "+y1+" board[x1][y1]: "+board[x1][y1]);
                
                if (board[x1][y1] == 'M') 
                    num++;
            }
        }
        return num;
    }

	
	public static void main(String[] args) {
		char[][] board = {  {'E', 'E', 'E', 'E', 'E'},
							{'E', 'E', 'M', 'E', 'E'},
							{'E', 'E', 'E', 'E', 'E'},
							{'E', 'E', 'E', 'E', 'E'}};
		int[] click = {3, 0};
		
		System.out.println(updateBoard(board, click));
	}

}
