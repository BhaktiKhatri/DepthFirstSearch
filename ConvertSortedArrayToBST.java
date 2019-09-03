package DepthFirstSearch;

import java.util.Arrays;

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
public class ConvertSortedArrayToBST {

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int data) {
			val = data;
		}
	}
	
	public TreeNode sortedArrayToBST(int[] num) {
        if(num.length == 0) {
            return null;
        }
        
        System.out.println(Arrays.toString(num));
        
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

	//concept here is to make the middle element of the array as root and then go to its left and right subtree respectively. Then in its left subtree, middle element
	//of the array is made root again and go to its left and right subtree respectively. Similarly for right subtree.
    public TreeNode helper(int[] num, int low, int high) {
        if(low > high) { 
            return null;
        }
        
        System.out.println("low: "+low+" high: "+high);
        
        int mid = (low + high) / 2;
        System.out.println("mid: "+mid);
        
        TreeNode root = new TreeNode(num[mid]);
        System.out.println("root: "+root.val);
        
        root.left = helper(num, low, mid - 1);
        
        if(root.left != null)
        	System.out.println("root: "+root.val+" root.left: "+root.left.val);
        else
        	System.out.println("root: "+root.val+" root.left: "+root.left);
        
        root.right = helper(num, mid + 1, high);
        
        if(root.right != null)
        	System.out.println("root: "+root.val+" root.right: "+root.right.val);
        else 
        	System.out.println("root: "+root.val+" root.right: "+root.right);
        
        return root;
    }
    
    public static void main(String args[]) {
    	//int[] arr = {1,2,3,4,5,6,7,8,9};
    	int[] arr = {-10,-3,0,5,9};
    	
    	ConvertSortedArrayToBST bst = new ConvertSortedArrayToBST();
    	bst.sortedArrayToBST(arr);
    	
    }
}
