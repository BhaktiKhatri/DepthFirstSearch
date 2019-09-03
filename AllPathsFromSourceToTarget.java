package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 797. All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
 * Example: Input: [[1,2], [3], [3], []]; Output: [[0,1,3],[0,2,3]] 
 * Explanation: The graph looks like this:
 *  	0--->1
 *  	|    |
 *  	v    v
 *  	2--->3
 *  There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 *  Note: The number of nodes in the graph will be in the range [2, 15].
 *  You can print different paths in any order, but you should keep the order of nodes inside one path.
 *  Explanation and Code from: @stevenlli https://leetcode.com/problems/all-paths-from-source-to-target/discuss/118713/Java-DFS-Solution
 */

public class AllPathsFromSourceToTarget {

	//One dfs solution is to traverse the graph from start node to the end, and keep track of each node along the path. Each node can be visited many times when it has multiple indegree.
	//acyclic graph means node won't be repeated
	//we don't have to check to see if we have seen a node before because it is an acyclic graph
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
					
        path.add(0);
        dfsSearch(graph, 0, res, path);
					
        System.out.println("path: "+path+" res: "+res);
        return res;
    }

    private static void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
    	System.out.println("node: "+node+" path: "+path);
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        System.out.println("node: "+node+" graph[node]: "+graph[node]);
        
        for(int nextNode: graph[node]) {
        	System.out.println("nextNode: "+nextNode);
            
        	path.add(nextNode);
            System.out.println("1 nextNode: "+nextNode+" path: "+path);
        	
        	dfsSearch(graph, nextNode, res, path);
        	System.out.println("2 nextNode: "+nextNode+" path: "+path);
        	
            path.remove(path.size() - 1);
            System.out.println("3 nextNode: "+nextNode+" path: "+path);
        }
    }

	public static void main(String[] args) {
		int[][] graph = {{1,2}, {3}, {3}, {}};
		printGraph(graph);
		System.out.println(allPathsSourceTarget(graph));
	}
	
	public static void printGraph(int[][] graph) {
		for(int i=0; i<graph.length; i++) {
			System.out.println(" "+Arrays.toString(graph[i]));
		}
	}

}
