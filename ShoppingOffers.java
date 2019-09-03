package DepthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode 638. Shopping Offers
 * https://leetcode.com/problems/shopping-offers/description/
 * In LeetCode Store, there are some kinds of items to sell. Each item has a price.
 * However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.
 * You are given the each item's price, a set of special offers, and the number we need to buy for each item. The job is to output the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers.
 * Each special offer is represented in the form of an array, the last number represents the price you need to pay for this special offer, other numbers represents how many specific items you could get if you buy this offer.
 * You could use any of special offers as many times as you want.
 * Example 1: Input: [2,5], [[3,0,5],[1,2,10]], [3,2]; Output: 14
 * Explanation:  There are two kinds of items, A and B. Their prices are $2 and $5 respectively. 
 * In special offer 1, you can pay $5 for 3A and 0B. In special offer 2, you can pay $10 for 1A and 2B. 
 * You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
 * Example 2: Input: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]; Output: 11
 * Explanation: The price of A is $2, and $3 for B, $4 for C. You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C.
 * You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C. 
 * You cannot add more items, though only $9 for 2A ,2B and 1C.
 * Note: There are at most 6 kinds of items, 100 special offers. For each item, you need to buy at most 6 of them. You are not allowed to buy more items than you want, even if that would lower the overall price.
 * Explanation and Code from: Approach2 Using Recursion with memoization https://leetcode.com/problems/shopping-offers/solution/
 * @author NisuBhakti
 * Google
 * Medium
 */

public class ShoppingOffers {

	    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
	    	System.out.println("in shoppingOffers() price: "+price+" special: "+special+" needs: "+needs);
	        Map<List<Integer>,Integer> map = new HashMap<List<Integer>,Integer>(); //key-needs; value-money
	        return shopping(price, special, needs, map);
	    }
	    
	    public static int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> map) {
	    	System.out.println(" in shopping() price: "+price+" special: "+special+" needs: "+needs+" map: "+map);
	    	
	    	if (map.containsKey(needs))
	            return map.get(needs);
	        
	        int j = 0;
	        int res = dot(needs, price);
	        
	        for (List<Integer> s: special) {
	            ArrayList<Integer> clone = new ArrayList<Integer>(needs);
	            for (j=0; j<needs.size(); j++) {
	            	
	                int diff = clone.get(j) - s.get(j);
	                System.out.println("clone.get(j): "+clone.get(j)+" s.get(j): "+s.get(j)+" diff: "+diff);
	                
	                if (diff < 0)
	                    break;
	                clone.set(j, diff);
	            }
	            System.out.println("j: "+j);
	            if (j == needs.size())
	                res = Math.min(res, s.get(j) + shopping(price, special, clone, map));
	        }
	        System.out.println("needs: "+needs+" res: "+res);
	        map.put(needs, res);
	        return res;
	    }
	    
	    public static int dot(List <Integer> needs, List<Integer> price) {
	        System.out.println("in dot() needs: "+needs+" price: "+price);
	    	int sum = 0;
	        for (int i = 0; i < needs.size(); i++) {
	            sum = sum + needs.get(i) * price.get(i);
	        }
	        return sum;
	    }

	public static void main(String[] args) {
		List<Integer> price = new ArrayList<Integer>();
		price.add(2);
		price.add(5);
		
		List<Integer> needs = new ArrayList<Integer>();
		needs.add(3);
		needs.add(2);
		
		List<Integer> offers = new ArrayList<>();
		offers.add(3);
		offers.add(0);
		offers.add(5);
		
		List<List<Integer>> special = new ArrayList<List<Integer>>();
		special.add(offers);
		
		List<Integer> offers1 = new ArrayList<>();
		offers1.add(1);
		offers1.add(2);
		offers1.add(10);

		special.add(offers1);
		
		System.out.println(shoppingOffers(price, special, needs));
	}

}
