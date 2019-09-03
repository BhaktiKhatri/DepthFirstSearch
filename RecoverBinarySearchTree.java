package DepthFirstSearch;

/**
 * 99. Recover Binary Search Tree
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 * http://www.ideserve.co.in/learn/how-to-recover-a-binary-search-tree-if-two-nodes-are-swapped
 * @author NisuBhakti
 * Compare is the current node and its previous node in the "in order traversal".
 */

public class RecoverBinarySearchTree {

	TreeNode firstStartPoint, lastEndPoint, prevNode;
	
	public void recoverTree(TreeNode root) {
		traverse(root);
		int val = firstStartPoint.val;
		firstStartPoint.val = lastEndPoint.val;
		lastEndPoint.val = val;
	}
	
	public void traverse(TreeNode root) {
		if(root == null)
			return;
		
		traverse(root.left);
		
		if(prevNode != null) {
			if(prevNode.val > root.val) {
				if(firstStartPoint == null) {
					firstStartPoint = prevNode;
				}
				lastEndPoint = root;
			}
		}
		prevNode = root;
		traverse(root.right);
	}
	
}
