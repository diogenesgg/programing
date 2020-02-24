package leetcode;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import java.util.TreeMap;

public class ShuffleAnArray {

	private int[] original;
	private int[] nums;
	
	private Random random = new Random();
	
	public ShuffleAnArray(int[] nums) {
		this.nums = nums;
        this.original = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
    		this.nums = this.original.clone();
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
	    	for (int i = 0; i < this.nums.length; i++) {
	    		int indexToSwape = random.nextInt(this.nums.length - i) + i;
	    		int aux = this.nums[i];
	    		this.nums[i] = this.nums[indexToSwape];
	    		this.nums[indexToSwape] = aux;
	    	}
	    	return this.nums;
    }
    
    public static void main(String[] args) {
    		ShuffleAnArray sol = new ShuffleAnArray(new int[] {1,2,5,3,4}); 
    		System.out.println(Arrays.toString(sol.shuffle()));
	}
}
