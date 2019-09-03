package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 323. Number of Connected Components in an Undirected Graph
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
 * Example 1: Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 *      0          3
 *      |          |
 *      1 --- 2    4 
 * Output: 2
 * 
 * Example 2: Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 * 
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 * Output:  1
 * Note: You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * Explanation and Code from: @xuyirui https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/discuss/77578/Java-concise-DFS
 * Time : O(V + E)
 * Space: O(V + E), (E is at most V^2 for sure)
 * DFS is O(V) for both time and space, because basically you just DFS every vertex, and the Map and Set in DFS is just a reference.
 */

public class NumberOfConnectedComponentsInUndirectedGraph {
	
	/*
	 * start dfsVisit with sources 0-n-1, count number of unvisited sources
	 * For others the thinking is if you run DFS from each of the nodes, all connected components will be visited if they are a part of the initial node
	 * to be explored. If not then there is some other connected component to be found from another node. Once the DFS finishes we increment the count because
	 * this means we're exploring another set of connected components.
	 */
	public static int countComponents(int n, int[][] edges) {
        if (n <= 1)
            return n;
        
        System.out.println("n: "+n);
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        System.out.println("map: "+map);
        
        for(int[] edge : edges) {
        	System.out.println("edge: "+Arrays.toString(edge)+" map: "+map);
            
        	map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        
        for(int i = 0; i < n; i++) {
        	System.out.println("i: "+i+" visited: "+visited+" count: "+count);
            
        	if(visited.add(i)) {
                dfsVisit(i, map, visited);
                count++;
            }
        }
        System.out.println("count: "+count);
        
        return count;
    }
    
    private static void dfsVisit(int i, Map<Integer, List<Integer>> map, Set<Integer> visited) {
    	System.out.println("i: "+i+" map: "+map+" visited: "+visited);
        
    	for(int j: map.get(i)) {
    		System.out.println("j: "+j+" visited: "+visited);
            
    		if(visited.add(j)) {
                dfsVisit(j, map, visited);
    		}
        }
    }
	
	public static void main(String[] args) {
		int n = 5; //2;
		int[][] edges =  {{0, 1}, {1, 2}, {3, 4}}; //{{1,0}};
		printEdges(edges);
		System.out.println(countComponents(n, edges));
	}
	
	public static void printEdges(int[][] edges) {
		for(int i=0; i<edges.length; i++) {
			for(int j=0; j<edges[0].length; j++) {
				System.out.print(" "+edges[i][j]);
			}
			System.out.println();
		}
	}

}
