package leetcode;

import java.util.*;

class RandomizedSet {
    
    private List<Integer> elements = new ArrayList<>();
    private Map<Integer, Integer> pos = new HashMap<>();
    private Random random = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (pos.containsKey(val)) {
            return false;
        } else {
            elements.add(val);
            pos.put(val, elements.size() - 1);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (pos.containsKey(val)) {
        		int idxToRemove = pos.get(val);
            int last = elements.get(elements.size() - 1);
            elements.set(idxToRemove, last);
            elements.remove(elements.size()-1);
            pos.remove(val);
            pos.put(last, idxToRemove);
            
            return true;
        } else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return elements.get(random.nextInt(elements.size()));
    }
    
    public static void main(String[] args) {
    		RandomizedSet set = new RandomizedSet();
    		System.out.println(set.remove(0));
    		System.out.println(set.remove(0));
    		System.out.println(set.insert(0));
    		System.out.println(set.getRandom());
    		System.out.println(set.remove(0));
    		System.out.println(set.insert(0));
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */