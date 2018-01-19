package hackerrank.sorting;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TheFullCountingSort {

	static Item[] countingSort(Item[] arr) {
		List<Item>[] counter = new List[100];
        
        for (int i = 0; i < arr.length; i++) {
			if (counter[arr[i].value] == null) {
				counter[arr[i].value] = new LinkedList<Item>();
			}
			counter[arr[i].value].add(arr[i]);
		}
        
        int I = 0;
        for (int i = 0; i < counter.length; i++) {
			if (counter[i] != null) {
				for (Iterator<Item> it = counter[i].iterator(); it.hasNext();) {
					arr[I++] = it.next();
				}
			}
		}
        
        return arr;
    }
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        Item[] arr = new Item[n];
        for (int a0 = 0; a0 < n; a0++) {
            int x = in.nextInt();
            String s = in.next();
            arr[a0] = new Item(x, s, a0 < n/2);
        }
        in.close();
        
        Item[] result = countingSort(arr);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
        		output.append( (result[i].firstHalf ? "-" : result[i].str) + (i != result.length - 1 ? " " : ""));
        }
        output.append("");
        System.out.println(output.toString());
    }
	
	static class Item {
		int value;
		String str;
		boolean firstHalf;
		
		Item(int v, String s, boolean fh) {
			value = v;
			str = s;
			firstHalf = fh;
		}
	}
}
