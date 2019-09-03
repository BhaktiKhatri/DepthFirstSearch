package DepthFirstSearch;

/**
 * Leetcode 547. Friend Circles
 * https://leetcode.com/problems/friend-circles/description/
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 * Example 1: Input: 
 *			[[1,1,0],
 *			 [1,1,0],
 *			 [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. The 2nd student himself is in a friend circle. So return 2.
 * Example 2: Input: 
 *			[[1,1,0],
 *			 [1,1,1],
 *			 [0,1,1]]
 *			Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 * Note: N is in range [1,200]. M[i][i] = 1 for all students. If M[i][j] = 1, then M[j][i] = 1.
 * Explanation from: https://www.youtube.com/watch?v=1XuCGYE56T0 Code from: https://leetcode.com/problems/friend-circles/solution/  
 * @author NisuBhakti
 * Time complexity : O(n^2) The complete matrix of size n^2​ is traversed; Space complexity : O(n), visited array of size n is used.
 * Bloomberg, Two Sigma
 * Medium
 */

public class FriendCircles {

	public static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
        	System.out.println("i: "+i+" j: "+j+" visited[j]: "+visited[j]+" M[i][j]: "+M[i][j]);
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
	
    public static int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
        	System.out.println("i: "+i+" visited[i]: "+visited[i]);
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		int[][] nums = {
		                {1,1,0},
		                {1,1,0},
		                {0,0,1}
					   };
		System.out.println(findCircleNum(nums));
	}

}
