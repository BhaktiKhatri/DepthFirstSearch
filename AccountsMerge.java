package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class DSU {
    int[] parent;
    public DSU() {
        parent = new int[10001];
        for (int i = 0; i <= 10000; ++i)
            parent[i] = i;
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}

public class AccountsMerge {

	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap<String, String>();
        Map<String, Integer> emailToID = new HashMap<String, Integer>();
        int id = 0;
        
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id++);
                }
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }

        Map<Integer, List<String>> ans = new HashMap<Integer, List<String>>();
        
        for (String email: emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            ans.computeIfAbsent(index, x-> new ArrayList()).add(email);
        }
        for (List<String> component: ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList(ans.values());
    }
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("John");
		list.add("johnsmith@mail.com");
		list.add("john00@mail.com");
		
		List<List<String>> accounts = new ArrayList<>();
		accounts.add(list);
		
		list.clear();
		list.add("John");
		list.add("johnnybravo@mail.com");
		accounts.add(list);
		
		list.clear();
		list.add("John");
		list.add("johnsmith@mail.com");
		list.add("john_newyork@mail.com");
		accounts.add(list);
		
		list.clear();
		list.add("Mary");
		list.add("mary@mail.com");
		accounts.add(list);
		
		System.out.println(accountsMerge(accounts));
	}

}
