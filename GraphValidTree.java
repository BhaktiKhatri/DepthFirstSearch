package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Leetcode 261. Graph Valid Tree
 * https://leetcode.com/problems/graph-valid-tree/description/
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 * For example: Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear
 * together in edges.
 * @author NisuBhakti
 * Explanation and Code from: @jocelynayoga https://leetcode.com/problems/graph-valid-tree/discuss/69042/AC-Java-Graph-DFS-solution-with-adjacency-list
 * The total complexity should be O(|V| + |E|)
 * Because in the function of finding loop, we look through all the edge ONCE. After that, we visit all the nodes to see if they are visited or not. 
 * This will also cost O(|V|)
 */

public class GraphValidTree {

	/*
	 * To tell whether a graph is a valid tree, we have to:
	 * Make sure there is no cycle in the graph - this has to be a none-cyclic graph;
	 * Make sure every node is reached - this has to be a connected graph;
	 * https://www.youtube.com/watch?v=rFf4mXWbb9U
	 */
    public static boolean validTree(int n, int[][] edges) {
    	printEdges(edges);
    	System.out.println("n: "+n);
    	
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        System.out.println("graph: "+graph);

        // initialize adjacency list.
        for(int i=0; i<edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        System.out.println("graph: "+graph);
        
        Set<Integer> visited = new HashSet<>();

        // do DFS from vertex 0, after one round DFS, if there is no loop and visited contains all the vertices, it is a tree
        boolean res = dfs(-1, 0, visited, graph);
        System.out.println("res: "+res+" visited: "+visited);
        
        if(!res) { 
        	return res;
        }
        return visited.size() == n ? true : false;
    }

    /*
     * When visited[v] == true, it's possible that v is the parent's parent in the previous hasCycle method, which means
		parent->v and v->parent are the same edge. It's obvious they are not a loop, right? That's why we have visited[v] && parent != v here
		We just need to filter this special case: visited[v] && parent == v.
		
		For every visited vertex v, if there is an adjacent vertex u such that u is already visited and it is not parent of v, then there is a cycle
		in the graph. IF we don't find such an adjacent vertex for any vertex, we say there is no cycle 
     */
    public static boolean dfs(int parent, int vertex, Set<Integer> visited, List<List<Integer>> graph) {
        System.out.println("parent: "+parent+" vertex: "+vertex+" visited: "+visited+" graph: "+graph);
    	
    	visited.add(vertex);
        List<Integer> subs = graph.get(vertex);
        
        System.out.println("visited: "+visited+" subs: "+subs);
        
        for(int v: subs) {
        	System.out.println("v: "+v+" parent: "+parent+" visited: "+visited);
            
        	// if v is vertex's parent, continue
            if(v == parent) { 	//no self loop i.e 0 -> 1 and 1 -> 0 are same edge; i.e we came to 1 from 0 so don't do dfs(0) from 1 again
            	continue; 
            }
            
            // if v is not vertex's parent, and v is visited, that presents there is a cycle in this graph
            if(visited.contains(v)) {
            	return false;
            }
            
            boolean res = dfs(vertex, v, visited, graph);
            System.out.println("res: "+res+" v: "+v+" vertex: "+vertex+" parent: "+parent);
            
            if(!res) {
            	return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}}; // {{0, 1}, {0, 2}, {0, 3}, {1, 4}}; //
		System.out.println(validTree(n, edges));
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
