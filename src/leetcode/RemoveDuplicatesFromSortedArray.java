package leetcode;

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
        int size = nums.length;
        
        for (int i = 0, j = 0; i < nums.length; i++) {
        		if (i + 1 < nums.length) {
                if (nums[i] != nums[i+1]) {
                		j++;
                		nums[j] =  nums[i+1];
                } else {
                		size--;
                }
            }
        }
        
        return size;
    }
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray sol = new RemoveDuplicatesFromSortedArray();
		
		int[] a1 = new int[] {1,1,2};
		assertEquals(sol.removeDuplicates(a1), 2);
		assertEquals(a1, new int[] {1, 2});
		
		int[] a2 = new int[] {0,0,1,1,1,2,2,3,3,4};
		assertEquals(sol.removeDuplicates(a2), 5);
		assertEquals(a2, new int[] {0, 1, 2, 3, 4});
		
		int[] a3 = new int[] {};
		assertEquals(sol.removeDuplicates(a3), 0);
		assertEquals(a3, new int[] {});
		
		int[] a4 = new int[] {1,1,1,1,1,1,1,1};
		assertEquals(sol.removeDuplicates(a4), 1);
		assertEquals(a4, new int[] {1});
		
		int[] a5 = new int[] {1,1,1,1,1,1,1,2};
		assertEquals(sol.removeDuplicates(a5), 2);
		assertEquals(a5, new int[] {1, 2});
		
		int[] a6 = new int[] {1,2,2,2,2,2,2,2};
		assertEquals(sol.removeDuplicates(a6), 2);
		assertEquals(a6, new int[] {1, 2});
	}
	
	public static void assertEquals(int a, int b) {
		if (a != b) throw new RuntimeException("sizes do not match");
		System.out.println("sizes match!");
	}
	
	public static void assertEquals(int[] a, int[] b) {
		for (int i = 0; i < b.length;  i++) {
			if (a[i] != b[i]) throw new RuntimeException("Arrays do not match");
		}
		System.out.println("Arrays Match");
	}
}
