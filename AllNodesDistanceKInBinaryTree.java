package DepthFirstSearch;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

/*
 * 863. All Nodes Distance K in Binary Tree
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 * Example 1: Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 * Explanation and Code from: Approach 2: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solution/
 * Time Complexity: O(N), where N is the number of nodes in the given tree.
 * Space Complexity: O(N) 
 */

public class AllNodesDistanceKInBinaryTree {

    	TreeNode root;
        static List<Integer> ans;
        static TreeNode target;
        static int K;
        
        public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        	System.out.println("root: "+root.val+" target: "+target.val+" K: "+K);
            
        	ans = new LinkedList<Integer>();
        	AllNodesDistanceKInBinaryTree.target = target;
        	AllNodesDistanceKInBinaryTree.K = K;
            
            dfs(root);
            System.out.println("ans: "+ans);
            
            return ans;
        }

        // Return vertex distance from node to target if exists, else -1
        // Vertex distance: the number of vertices on the path from node to target
        public static int dfs(TreeNode node) {
            if (node == null) {
                return -1;
            }
            else if (node == target) {
            	System.out.println("node: "+node.val);
                subtree_add(node, 0);
                return 1;
            } 
            else {
            	System.out.println("node: "+node.val+" ans: "+ans);
                
            	int L = dfs(node.left);
                int R = dfs(node.right);
                System.out.println("L: "+L+" R: "+R+" ans: "+ans);
                
                if(L != -1) {
                    if(L == K) { 
                    	ans.add(node.val);
                    }
                    subtree_add(node.right, L + 1);
                    return L + 1;
                } 
                else if (R != -1) {
                    if(R == K) { 
                    	ans.add(node.val);
                    }
                    subtree_add(node.left, R + 1);
                    return R + 1;
                } 
                else {
                    return -1;
                }
            }
        }

        // Add all nodes 'K - dist' from the node to answer.
        public static void subtree_add(TreeNode node, int dist) {
            if(node == null) { 
            	return;
            }
            System.out.println("node: "+node.val+" dist: "+dist+" ans: "+ans);
            
            if(dist == K) {
                ans.add(node.val);
            }
            else {
                subtree_add(node.left, dist + 1);
                subtree_add(node.right, dist + 1);
            }
        }
	
	public static void main(String[] args) {
		 AllNodesDistanceKInBinaryTree tree = new AllNodesDistanceKInBinaryTree();
	     tree.root = new TreeNode(3);
	     tree.root.left = new TreeNode(5);
	     tree.root.right = new TreeNode(1);
	     tree.root.left.left = new TreeNode(6);
	     tree.root.left.right = new TreeNode(2);
	     tree.root.left.right.left = new TreeNode(7);
	     tree.root.left.right.right = new TreeNode(4);
	     tree.root.right.left = new TreeNode(0);
	     tree.root.right.right = new TreeNode(8);
	     
	     System.out.println(distanceK(tree.root, tree.root.left, 2));
	}

}
