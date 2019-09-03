package DepthFirstSearch;

/**
 * Leetcode 129. Sum Root to Leaf Numbers
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number. 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123. Find the total sum of all root-to-leaf numbers.
 * For example,
 *    1
 *   / \
 *  2   3
 * The root-to-leaf path 1->2 represents the number 12. The root-to-leaf path 1->3 represents the number 13. Return the sum = 12 + 13 = 25.
 * Explanation and Code from: https://leetcode.com/problems/sum-root-to-leaf-numbers/discuss/
 * @author NisuBhakti
 * Medium
 */

public class SumRootToLeafNumbers {

	TreeNode root;
	
	public static int sumNumbers(TreeNode root) {
		return sum(root, 0);
	}

	public static int sum(TreeNode root, int sum) {
		if(root == null) { 
			return 0;
		}
		
		System.out.println("root: "+root.val+" sum: "+sum);
		
		if(root.right == null && root.left == null) { 
			return sum*10 + root.val;
		}
		
		return sum(root.left, sum*10 + root.val) + sum(root.right, sum*10 + root.val);
	}
	
	public static void main(String[] args) {
		SumRootToLeafNumbers tree = new SumRootToLeafNumbers();
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		
		System.out.println(sumNumbers(tree.root));
	}

}
