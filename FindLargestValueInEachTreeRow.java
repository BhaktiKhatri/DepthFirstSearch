package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 515. Find Largest Value in Each Tree Row
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 * You need to find the largest value in each row of a binary tree. 
 * Example: Input: 
 *          1
 *         / \
 *        3   2
 *       / \   \  
 *      5   3   9 
 * Output: [1, 3, 9]
 * Explanation and Code from: https://leetcode.com/problems/find-largest-value-in-each-tree-row/discuss/98971
 * @author NisuBhakti
 * Medium
 * LinkedIn
 */

public class FindLargestValueInEachTreeRow {

	TreeNode root;
		
	public static List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
	
    public static void helper(TreeNode root, List<Integer> res, int depth) {
        if(root == null) 
            return;
        
        System.out.println("root: "+root.val+" depth: "+depth+" res: "+res);
        					
        if(depth == res.size()) {								//expand list size
            res.add(root.val);
        }
        else {
            res.set(depth, Math.max(res.get(depth), root.val));		//or set value
        }
        
        helper(root.left, res, depth + 1);
        helper(root.right, res, depth + 1);
    }
	
	public static void main(String[] args) {
		FindLargestValueInEachTreeRow tree = new FindLargestValueInEachTreeRow();
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(3);
		tree.root.left.left = new TreeNode(5);
		tree.root.left.right = new TreeNode(3);
		tree.root.right = new TreeNode(2);
		tree.root.right.right = new TreeNode(9);
		
		System.out.println(largestValues(tree.root));
	}

}
