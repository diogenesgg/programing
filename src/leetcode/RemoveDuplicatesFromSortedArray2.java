package leetcode;

public class RemoveDuplicatesFromSortedArray2 {

	public int removeDuplicates(int[] nums) {
	       //sliding window? suppose it should be length 3
	       int window = 3, aux;
	       int duplicates = 0;
	       for (int i = 0; i + window -1 < nums.length - duplicates;){
	           if (nums[i] == nums[i+1] && nums[i+1] == nums[i+2]) {
	               swap(i+2, nums.length - 1 - duplicates, nums);
	               duplicates++;
	           } else {
	               if (nums[i+2] < nums[i+1]) {
	                   swap(i+2, i+1, nums);
	                   if (nums[i+1] < nums[i]) {
	                       swap(i+1, i, nums);
	                       i--;
	                   }
	                   i--;
	               } else {
	                   i++;
	               }
	           }
	       }
	        
	       return nums.length - duplicates;
	    }
	         
	    private void swap(int i, int j, int[] nums) {
	        int aux = nums[i];
	        nums[i] = nums[j];
	        nums[j] = aux;
	    }
}
