package leetcode;

public class MedianOfTwoSortedArrays {
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 1};
		int[] nums2 = new int[] {1, 1};
		
		MedianOfTwoSortedArrays sol = new MedianOfTwoSortedArrays();
		System.out.println(sol.findMedianSortedArrays(nums1, nums2));
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int i = 0;
        int j = nums1.length;
        int halfSize = (nums1.length + nums2.length) / 2;
        boolean even = (nums1.length + nums2.length) % 2 == 0;
        
        while (i <= j) {
            int cutPoint1 = (j + i) / 2;
            int cutPoint2 = halfSize - cutPoint1;
            
            int min1 = cutPoint1 - 1 >= 0 ? nums1[cutPoint1 - 1] : Integer.MIN_VALUE;
            int max1 = cutPoint1 < nums1.length ? nums1[cutPoint1] : Integer.MAX_VALUE;
            
            int min2 = cutPoint2 - 1 >= 0 ? nums2[cutPoint2 - 1] : Integer.MIN_VALUE;
            int max2 = cutPoint2 < nums2.length ? nums2[cutPoint2] : Integer.MAX_VALUE;
            
            if (min1 <= max2 && min2 <= max1) {
                //found!
                if (even) {
                    return (Math.max(min1, min2) + Math.min(max1, max2)) / 2.0;
                } else {
                    return Math.min(max1, max2);
                }
            } else if (min1 > max2) {
            		j = cutPoint1 - 1;
            } else {
            		i = cutPoint1 + 1;
            }
        }
        
        return -1;
    }
}
