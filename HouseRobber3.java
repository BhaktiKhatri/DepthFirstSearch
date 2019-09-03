package DepthFirstSearch;

import java.util.Arrays;

/**
 * Leetcode 337. House Robber III
 * https://leetcode.com/problems/house-robber-iii/description/
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * Example 1:
 *    3
 *   / \
 *   2   3
 *    \   \ 
 *     3   1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7
 * Example 2:
 *     3
 *    / \
 *   4   5
 *  / \   \ 
 * 1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 * Explanation and Code from: https://leetcode.com/problems/house-robber-iii/discuss/79330
 * Time Complexity: O(N)
 * Uber, Amazon
 * Medium
 */

public class HouseRobber3 {
	
	TreeNode root;
		/*
					1
				   / \
				 2    3
				/ \  / \ 
			   4  5  6  7
		*/
	public static int rob(TreeNode root) {
	    int[] res = robSub(root);
	    return Math.max(res[0], res[1]);
	}

	public static int[] robSub(TreeNode root) {
	    if(root == null) { 
	    	return new int[2];
	    }
	    
	    System.out.println("root: "+root.val);
	    
	    int[] left = robSub(root.left);		//left[grandchild, child] i.e [5,2] [9,2]		//left[0] - sum of child; left[1] - root
	    int[] right = robSub(root.right);	//right[grandchild, child] i.e [6,4] [13,3]		//right[0] - sum of child; right[1] - root
	    int[] res = new int[2];

	    System.out.println("left: "+Arrays.toString(left));
	    System.out.println("right: "+Arrays.toString(right));
	    
	    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);		//when root is not robbed
	    res[1] = root.val + left[0] + right[0];									//when root is robbed
	    
	    System.out.println("res: "+Arrays.toString(res));
	    
	    return res;
	}
	
	public static void main(String[] args) {
		HouseRobber3 rob = new HouseRobber3();
		
		rob.root = new TreeNode(1);
		rob.root.left = new TreeNode(2);
		rob.root.left.left = new TreeNode(4);
		rob.root.left.right = new TreeNode(5);
		rob.root.right = new TreeNode(3);
		rob.root.right.left = new TreeNode(6);
		rob.root.right.right = new TreeNode(7);
		
		/*
		 	 1
		    / \
		  2    3
		 / \  / \ 
		4  5  6  7
		 */
		
		System.out.println("sum: "+rob(rob.root));
	}

}
