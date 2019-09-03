package DepthFirstSearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Leetcode 332. Reconstruct Itinerary
 * https://leetcode.com/problems/reconstruct-itinerary/description/
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * Note: If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Explanation and Code from: https://www.programcreek.com/2015/03/leetcode-reconstruct-itinerary-java/
 * @author NisuBhakti
 * Google
 * Medium
 */

public class ReconstructItinerary {

	//This is an application of Hierholzer’s algorithm to find a Eulerian path.
	//PriorityQueue should be used instead of TreeSet, because there are duplicate entries.
	
	public static HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
	public static LinkedList<String> result = new LinkedList<String>();
 
	public static List<String> findItinerary(String[][] tickets) {
		System.out.println();
		
		for(String[] ticket: tickets) {
			System.out.println("ticket: "+Arrays.toString(ticket)+" ticket[0]: "+ticket[0]);
			
			if(!map.containsKey(ticket[0])) {
				PriorityQueue<String> queue = new PriorityQueue<String>();
				map.put(ticket[0], queue);
			}
			map.get(ticket[0]).offer(ticket[1]);
		}
		System.out.println("map: "+map);
 
		dfs("JFK");
		return result;
	}
 
	public static void dfs(String s) {
		PriorityQueue<String> queue = map.get(s);
		System.out.println("queue: "+queue+" s: "+s);
		
		while(queue != null && !queue.isEmpty()) {
			System.out.println("queue: "+queue.peek());
			dfs(queue.poll());
		}
		System.out.println("result: "+result+" s: "+s);
		result.addFirst(s);
	}
	
	public static void main(String[] args) {
		String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		//{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
		
		for(int i=0; i<tickets.length; i++) {
			System.out.print(Arrays.toString(tickets[i]));
		}
		System.out.println(findItinerary(tickets));
	}
}