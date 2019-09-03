package DepthFirstSearch;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/redundant-connection-ii/discuss/108045?page=1   http://codegists.com/snippet/java/redundantconnectionunionfindjava_bilbo3000_java
 * @author NisuBhakti
 *
 */

public class RedundantConnection2 {

	public static int[] findRedundantDirectedConnection(int[][] edges) {
		
		// Because the length of 2D array is between [3, 1000]
        // So there are at most 2000 items, we can create an array 
        // of size 2001 so we can represent number using index w/o 
        // converting
		int[] parent = new int[edges.length+1];
		
		// Initialize all fields to -1
        Arrays.fill(parent, -1);
        
        // Going through each edges and see if two vertices are in
        // the same subset
        for (int[] edge : edges) {
        	System.out.println("edge: "+Arrays.toString(edge)+" edge[0]: "+edge[0]+" edge[1]: "+edge[1]);
        	
            int rep1 = find(parent, edge[0]);
            int rep2 = find(parent, edge[1]);
             
            System.out.println("rep1: "+rep1+" rep2: "+rep2+" parent: "+Arrays.toString(parent));
            if (rep1 == rep2) {
                // Both vertices have the same representative
                // Meaning they are in the same subset
                return new int[] {edge[0], edge[1]};
            }
             
            // Two vertices are in two different subsets, join them!
            union(parent, rep1, rep2);
        }
        
        return new int[] {}; 
    }
	
	/*
     * The find method of Union-Find
     * For the given element, it finds its subset's representative
     * Note that representative does not have parent, representative 
     * also represents the subset. 
     * (a.k.a. which subset the element belongs to)
     */
	public static int find(int[] parent, int x) {
		System.out.println("x: "+x+" parent: "+Arrays.toString(parent)+" parent[x]: "+parent[x]);
        while (parent[x] != -1) {
            x = parent[x]; 
        }
        System.out.println("x: "+x);
        return x; 
    }
		
	/*
     * The union method of Union-Find
     * It joins two representatives. 
     * (a.k.a. union two subsets)
     */
	public static void union(int[] parent, int a, int b) {
		System.out.println("a: "+a+" b: "+b+" parent: "+Arrays.toString(parent)+" parent[a]: "+parent[a]);
        parent[a] = b; 
    }
	
	public static void main(String[] args) {
		int[][] edges = {{1,2}, {1,3}, {2,3}};
		
		for(int i=0; i<edges.length; i++)
			System.out.println(Arrays.toString(edges[i]));
		
		System.out.println("ans: "+Arrays.toString(findRedundantDirectedConnection(edges)));
	}

}
