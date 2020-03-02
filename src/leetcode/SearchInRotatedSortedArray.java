package leetcode;

public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
		
		if (nums.length == 0) {
			return -1;
		}
		
		int maxIndex = findPivot(nums);
		
		if (maxIndex != nums.length - 1) {
			return Math.max(binarySearch(nums, target, 0, maxIndex), binarySearch(nums, target, maxIndex+1, nums.length - 1));
		} else {
			return binarySearch(nums, target, 0, nums.length - 1);
		}
    }
	
	public int binarySearch(int[] nums, int target, int i, int j) {
		int middle;
		
		while (i < j) {
			middle = (i+j)/2;
			if (target > nums[middle]) {
				i = (middle + 1);
			} else if (target < nums[middle]) {
				j = middle - 1;
			} else {
				return middle;
			}
		}
		
		if (nums[i] == target) {
			return i;
		} else {
			return -1;
		}
	}
    
	//index for the greatest element
    private int findPivot(int[] nums) {
        int i = 0, j = nums.length - 1, middle;
        
        while (j-i > 1) {
            middle = (i+j)/2;
            if (nums[i] > nums[middle]) {
                j = middle;
            } else {
                i = middle;
            }
        }
        
        return (i+1 < nums.length && nums[i+1] > nums[i]) ? i + 1: i;
    }
    
    public static void main(String[] args) {
//    		System.out.println(new SearchInRotatedSortedArray().findPivot(new int[] {0,1,2,3,4,5}) + "=5");
//		System.out.println(new SearchInRotatedSortedArray().findPivot(new int[] {1,2,3,4,5,0}) + "=4");
//		System.out.println(new SearchInRotatedSortedArray().findPivot(new int[] {2,3,4,5,0,1}) + "=3");
//		System.out.println(new SearchInRotatedSortedArray().findPivot(new int[] {3,4,5,0,1,2}) + "=2");
//		System.out.println(new SearchInRotatedSortedArray().findPivot(new int[] {4,5,0,1,2,3}) + "=1");
//		System.out.println(new SearchInRotatedSortedArray().findPivot(new int[] {5,0,1,2,3,4}) + "=0");
    	
    		System.out.println(new SearchInRotatedSortedArray().search(new int[] {5,0,1,2,3,4}, 5) + "=0");
    		System.out.println(new SearchInRotatedSortedArray().search(new int[] {5,0,1,2,3,4}, 0) + "=1");
    		System.out.println(new SearchInRotatedSortedArray().search(new int[] {5,0,1,2,3,4}, 1) + "=2");
    		System.out.println(new SearchInRotatedSortedArray().search(new int[] {5,0,1,2,3,4}, 2) + "=3");
    		System.out.println(new SearchInRotatedSortedArray().search(new int[] {5,0,1,2,3,4}, 3) + "=4");
    		System.out.println(new SearchInRotatedSortedArray().search(new int[] {5,0,1,2,3,4}, 4) + "=5");
    	
    		System.out.println(new SearchInRotatedSortedArray().search(new int[] {4,5,6,7,0,1,2}, 0) + "=4");
    	
    		System.out.println(new SearchInRotatedSortedArray().search(new int[] {4}, 0) + "=-1");
    		System.out.println(new SearchInRotatedSortedArray().search(new int[] {4}, 4) + "=0");
    		System.out.println(new SearchInRotatedSortedArray().search(new int[] {4}, 4) + "=0");
    		
    		System.out.println(new SearchInRotatedSortedArray().search(new int[] {1,3}, 0) + "=-1");
	}
}
