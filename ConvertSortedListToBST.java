package DepthFirstSearch;
import DepthFirstSearch.LinkedList.ListNode;
import DepthFirstSearch.LinkedList;

/**
 * Leetcode 109. Convert Sorted List to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example: Given the sorted linked list: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * Explanation and Code from: @JosephTao https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/discuss/35476/Share-my-JAVA-solution-1ms-very-short-and-concise.
 * Zenefits
 * Medium
 */
public class ConvertSortedListToBST {

	public static TreeNode sortedListToBST(ListNode head) {
		if(head == null) {
			return null;
		}
		return toBST(head, null);
	}
	
	public static TreeNode toBST(ListNode head, ListNode tail) {
		//System.out.println("head: "+head.data+" tail: "+tail);
		
		ListNode slow = head;
		ListNode fast = head;
		
		if(head != null && tail != null)
			System.out.println("head: "+head.data+" tail: "+tail.data);
		
		if(head == tail) { 
			return null;
		}
		
		System.out.println("slow: "+slow.data+" fast: "+fast.data);
		
		while(fast != tail && fast.next != tail) {
			System.out.println("slow: "+slow.data+" fast: "+fast.data);
			
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast != null)
			System.out.println("slow: "+slow.data+" fast: "+fast.data);
		else 
			System.out.println("slow: "+slow.data+" fast: "+fast);
		
		TreeNode root = new TreeNode(slow.data);
		System.out.println("root: "+root.val+" head: "+head.data+" slow: "+slow.data);
		
		root.left = toBST(head, slow);

		if(tail != null && slow.next != null)
			System.out.println("slow.next: "+slow.next.data+" tail: "+tail.data);
		else 
			System.out.println("slow.next: "+slow.next+" tail: "+tail);
		
		root.right = toBST(slow.next, tail);
		
		return root;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.head = new ListNode(-10);
		ListNode second = new ListNode(-3);
		ListNode third = new ListNode(0);
		ListNode forth = new ListNode(5);
		ListNode fifth = new ListNode(9);
		
		list.head.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		
		System.out.println("list: "+list.head.data+" -> "+list.head.next.data+" -> "+list.head.next.next.data+" -> "+list.head.next.next.next.data+" -> "+list.head.next.next.next.next.data);
		System.out.println(sortedListToBST(list.head).val);
		
		System.out.println();
	}

}
