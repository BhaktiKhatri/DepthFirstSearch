package DepthFirstSearch;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Time Complexity: O(n)
 * For explanation refer http://www.ideserve.co.in/learn/create-a-balanced-bst-from-a-sorted-array
 * @author NisuBhakti
 *
 */


/* Refer from here
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * Example 1: Input: [1,2,3]
 *        1
 *       / \
 *      2   3
 * Output: 6
 * Example 2: Input: [-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: 42
 * Explanation and Code from: @wei-bung https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java
 * Microsoft, Baidu
 * Medium
 */

class Node1 {
	int val;
	Node1 left;
	Node1 right;
	
	public Node1(int data) {
		val = data;
	}
}

public class MaximumPathSum {
	
	int maxValue;
	Node1 root;
	
	/*
	 * Here's my ideas:
	 * A path from start to end, goes up on the tree for 0 or more steps, then goes down for 0 or more steps. Once it goes down, it can't go up. Each path has a highest node, which is also the lowest common ancestor of all other nodes on the path.
	 * A recursive method maxPathDown(TreeNode node) (1) computes the maximum path sum with highest node is the input node, update maximum if necessary (2) returns the maximum sum of the path that can be extended to input node's parent.

		   -10
		   / \
		  9  20
		    /  \
		   15   7
	 */

    public int maxPathSum(Node1 root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    /*
     				10
     			 /		\
     			2		 10
     		  /  \		   \
     		 20   1		   -25
     		 			  /   \
     		 			 3		4
     		 			 
	maxValue is the value which recording whether this current root is the final root, so we use left + right + node.val. But to the upper layer(after return statement), we cannot choose both left and right brunches, so we need to select the larger one, so we use max(left, right) + node.val to prune the lower brunch.
	In the end, very elegant solution
	
	It will give you -1 as expected.
	What it does is it looks at current node's left branch and right branch, and it compares the values from left branch and right branch with 0, respectively.
	The reason that it compares with 0 is simple: if its less than 0, that means we should not connect current node with that branch, since it will decrease the value of the path that goes through current node anyway. In other words, if both branch have negative values, then it's better just not to connect current node with any of the branch (simply take current node's value alone).
     */
    
    private int maxPathDown(Node1 node) {
        if (node == null) 
        	return 0;
        System.out.println("node: "+node.val);
        
        int left = Math.max(0, maxPathDown(node.left));
        System.out.println("left: "+left);
        
        int right = Math.max(0, maxPathDown(node.right));
        System.out.println("right: "+right);
        
        maxValue = Math.max(maxValue, left + right + node.val);
        System.out.println("maxValue: "+maxValue);
        
        return Math.max(left, right) + node.val;
    }
    
    public static void main(String args[]) {
    	MaximumPathSum tree = new MaximumPathSum();

    	tree.root = new Node1(10);
        tree.root.left = new Node1(2);
        tree.root.right = new Node1(10);
        tree.root.left.left = new Node1(20);
        tree.root.left.right = new Node1(1);
        tree.root.right.right = new Node1(-25);
        tree.root.right.right.left = new Node1(3);
        tree.root.right.right.right = new Node1(4);

//    	  tree.root = new Node1(-10);
//        tree.root.left = new Node1(9);
//        tree.root.right = new Node1(20);
//        tree.root.right.left = new Node1(15);
//        tree.root.right.right = new Node1(7);

        int maxSum = tree.maxPathSum(tree.root);
        System.out.println("max path sum: "+maxSum);
    	
    }
}
