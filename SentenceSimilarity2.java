package DepthFirstSearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 737. Sentence Similarity II
 * https://leetcode.com/problems/sentence-similarity-ii/description/
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.
 * For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
 * Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.
 * Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
 * Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.
 * Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 * Note: The length of words1 and words2 will not exceed 1000. The length of pairs will not exceed 2000. The length of each pairs[i] will be 2.
 * The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 * Explanation and Code from: @alexander https://leetcode.com/problems/sentence-similarity-ii/discuss/109752
 * @author NisuBhakti
 * Google
 * Medium
 */

public class SentenceSimilarity2 {

	public static boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) 
        	return false;
        
        System.out.println("words1: "+Arrays.toString(words1));
        System.out.println("words2: "+Arrays.toString(words2));
        
        for(int i=0; i<pairs.length; i++) {
        	System.out.print(Arrays.toString(pairs[i]));
        }
        
        System.out.println();
        Map<String, String> m = new HashMap<>();
        for (String[] p : pairs) {
            String parent1 = find(m, p[0]);
            String parent2 = find(m, p[1]);
            
            System.out.println("parent1: "+parent1+" parent2: "+parent2);
            if (!parent1.equals(parent2)) 
            	m.put(parent1, parent2);
        }

        for (int i = 0; i < words1.length; i++) {
        	System.out.println("words1[i]: "+words1[i]+" words2[i]: "+words2[i]);
        	String afind = find(m, words1[i]);
        	String bfind = find(m, words2[i]);
        	
        	System.out.println("afind: "+afind+" bfind: "+bfind);
            //if (!words1[i].equals(words2[i]) && !afind.equals(bfind)) {
        	if(!afind.equals(bfind)) {
            	return false;
            }
        }
        
        return true;
    }

    public static String find(Map<String, String> m, String s) {
    	System.out.println("s: "+s);
        if (!m.containsKey(s)) 
        	m.put(s, s);
        System.out.println("m: "+m);
        return s.equals(m.get(s)) ? s : find(m, m.get(s));
    }
	
	public static void main(String[] args) {
		String[] words1 = {"great", "acting", "skills"};
		String[] words2 = {"fine", "drama", "talent"};
		String[][] pairs = {{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}};
		
		System.out.println(areSentencesSimilarTwo(words1, words2, pairs));
	}

}
