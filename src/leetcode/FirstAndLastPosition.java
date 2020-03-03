package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstAndLastPosition {

	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[] {-1, -1};
		}
		return new int[] {binaryStart(nums, target), binaryEnd(nums, target)};
    }
	
	private int binaryStart(int[] nums, int target) {
		int i = 0, j = nums.length - 1, mid;
		
		while (i < j) {
			mid = (i+j)/2;
			if (target > nums[mid]) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		
		if (nums[i] == target) {
			return i;
		} else {
			if (i+1 < nums.length && nums[i+1] == target) {
				return i+1;
			} else {
				return -1;
			}
		}
	}
	
	private int binaryEnd(int[] nums, int target) {
		int i = 0, j = nums.length - 1, mid;
		
		while (i < j) {
			mid = (i+j)/2;
			if (target < nums[mid]) {
				j = mid - 1;
			} else {
				i = mid + 1;
			}
		}
		
		if (nums[i] == target) {
			return i;
		} else {
			if (i-1 >= 0 && nums[i-1] == target) {
				return i-1;
			} else {
				return -1;
			}
		}
	}
	
	public static void main(String[] args) {
		FirstAndLastPosition sol = new FirstAndLastPosition();
		assertEquals(sol.searchRange(new int[] {5,7,7,8,8,10}, 8), new int[] {3,4});
		assertEquals(sol.searchRange(new int[] {5,7,7,8,8,10}, 6), new int[] {-1,-1});
		assertEquals(sol.searchRange(new int[] {1,2,3,4,5,6}, 1), new int[] {0,0});
		assertEquals(sol.searchRange(new int[] {1,1,1,1,1}, 1), new int[] {0,4});
		assertEquals(sol.searchRange(new int[] {5,7,7,8,8,10}, 10), new int[] {5,5});
		assertEquals(sol.searchRange(new int[] {5,7,7,8,8,10}, 11), new int[] {-1,-1});
		
		assertEquals(sol.searchRange(new int[] {}, 11), new int[] {-1,-1});
		
		assertEquals(sol.searchRange(new int[] {11}, 11), new int[] {0, 0});
	}
	
	public static void assertEquals(int[] a, int[] b) {
		if (Arrays.equals(a, b)) {
			System.out.println("Test case passed");
			return;
		}
		throw new RuntimeException(Arrays.toString(a) + " is not equals to " + Arrays.toString(b));
	}
}
