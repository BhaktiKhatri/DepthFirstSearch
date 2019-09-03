package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Leetcode 472. Concatenated Words
 * https://leetcode.com/problems/concatenated-words/description/
 * Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 * Example: Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"] Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * Note: The number of elements of the given array will not exceed 10,000. The length sum of elements in the given array will not exceed 600,000. 
 * All the input string will only include lower case letters. The returned elements order does not matter.
 * @author NisuBhakti
 *
 */

public class ConcatenatedWords {

	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
	    List<String> list = new ArrayList<String>();
	    Set<String> set = new HashSet<>(Arrays.asList(words));

	    for(String word : words) {
	    	System.out.println(word);
	        set.remove(word);
	        if(dfs(word, set, ""))
	        	list.add(word);
	        set.add(word);
	    }
	    return list;
	}

	public static boolean dfs(String word, Set<String> set, String previous) {
		System.out.println("word: "+word+" set: "+set+" previous: "+previous);
		
		if(!previous.equals("")) 
	    	set.add(previous);
		
	    if(set.contains(word)) 
	    	return true;
	    
	    System.out.println(" set: "+set);
	    
	    for(int i = 1; i < word.length(); i++) {
	    	System.out.println("i: "+i);
	        String prefix = word.substring(0,i);
	        System.out.println("prefix: "+prefix);
	        if(set.contains(prefix) && dfs(word.substring(i,word.length()), set, previous+prefix)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		System.out.println(findAllConcatenatedWordsInADict(words));
	}

}
