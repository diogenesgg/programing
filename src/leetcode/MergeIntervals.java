package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		
        Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
        
        int total = intervals.length;
        
        for (int i = 1; i < intervals.length; i++) {
        		int[] current = intervals[i];
        		int[] prev = intervals[i-1];
        		
        		if (prev[1] >= current[0]) {
        			intervals[i][0] = prev[0];
        			intervals[i][1] = Math.max(prev[1], current[1]);
        			intervals[i-1] = null;
        			total--;
        		}
        }
        
        int[][] sol = new int[total][2];

        for (int i = 0, j = 0; i < intervals.length; i++) {
	    		if (intervals[i] != null) {
	    			sol[j++] = intervals[i];
	    		}
	    }
        
        return sol;
    }
	
	public static void main(String[] args) {
		MergeIntervals merge = new MergeIntervals();
		
		int[][] sol = merge.merge(new int[][] {{1,3},{2,6},{8,10},{15,18}});
		
		System.out.println(Arrays.toString(sol));
	}
}
