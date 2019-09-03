package DepthFirstSearch;

import java.util.Arrays;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

	public static int countComponents(int n, int[][] edges) {
	    int[] roots = new int[n];
	    for(int i=0; i<n; i++) {
	    	System.out.println("i: "+i+" roots[i]: "+roots[i]);
	    	roots[i] = i; 
	    	System.out.println("roots[i]: "+roots[i]);
	    }
	    
	    System.out.println(Arrays.toString(roots));

	    for(int[] e : edges) {
	    	System.out.println(Arrays.toString(e));
	        int root1 = find(roots, e[0]);
	        int root2 = find(roots, e[1]);
	        
	        System.out.println("root1: "+root1+" root2: "+root2);
	        
	        if(root1 != root2) {  
	        	System.out.println("roots[root1]: "+roots[root1]+" n: "+n);
	            roots[root1] = root2;  // union
	            System.out.println("roots[root1]: "+roots[root1]);
	            n--;
	        }
	    }
	    return n;
	}

	public static int find(int[] roots, int id) {
		System.out.println("roots: "+Arrays.toString(roots)+" id: "+id+" roots[id]: "+roots[id]+" roots[roots[id]]: "+roots[roots[id]]);
	    while(roots[id] != id) {
	        roots[id] = roots[roots[id]];  // optional: path compression
	        id = roots[id];
	    }
	    System.out.println("id: "+id);
	    return id;
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
		for(int i=0; i<edges.length; i++)
			System.out.println(Arrays.toString(edges[i]));
		
		System.out.println(countComponents(n, edges));
	}

}
