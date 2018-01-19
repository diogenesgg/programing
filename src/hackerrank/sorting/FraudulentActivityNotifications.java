package hackerrank.sorting;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
 * 
 * @author diogenes
 *
 */
public class FraudulentActivityNotifications {

	static int activityNotifications(int[] expenditure, int d) {
        // Complete this function
		SortedMap<Item, Boolean> firstHalf = new TreeMap<>();
		SortedMap<Item, Boolean> secondHalf = new TreeMap<>();
		
		Deque<Item> queue = new LinkedList<>();
		int notifications = 0;
		
		for (int i = 0; i < expenditure.length; i++) {
			Item nextItem = new Item(expenditure[i], i);
			
			if (queue.size() < d) {
				insertItem(firstHalf, secondHalf, queue, nextItem);
			} else {
				//now let's get the median and compare with next digit
				double median = 0;
				if (firstHalf.size() > secondHalf.size()) {
					median = firstHalf.lastKey().value;
				} else if (secondHalf.size() > firstHalf.size()) {
					median = secondHalf.firstKey().value;
				} else {
					median = (firstHalf.lastKey().value + secondHalf.firstKey().value) / 2.0;
				}
				if (nextItem.value > 2 * median || Math.abs(nextItem.value - (2 * median)) <= 0.000001) {
					notifications++;
				}
				
				//removing first number in queue;
				Item toRemove = queue.pop();
				if (firstHalf.containsKey(toRemove)) {
					firstHalf.remove(toRemove);
				} else if (secondHalf.containsKey(toRemove)) {
					secondHalf.remove(toRemove);
				}
				
				insertItem(firstHalf, secondHalf, queue, nextItem);
			}
		}
		
		return notifications;
    }

	private static void insertItem(SortedMap<Item, Boolean> firstHalf, SortedMap<Item, Boolean> secondHalf,
			Deque<Item> queue, Item nextItem) {
		queue.add(nextItem);
		if (firstHalf.isEmpty() || nextItem.value <= firstHalf.lastKey().value) {
			firstHalf.put(nextItem, true);
		} else if (secondHalf.isEmpty() || nextItem.value >= secondHalf.firstKey().value) {
			secondHalf.put(nextItem, true);
		}
		
		//balancing both halfs
		if (firstHalf.size() - secondHalf.size() >= 2) {
			Item poped = firstHalf.lastKey();
			firstHalf.remove(poped);
			secondHalf.put(poped, true);
		} else if (secondHalf.size() - firstHalf.size() >= 2) {
			Item poped = secondHalf.firstKey();
			secondHalf.remove(poped);
			firstHalf.put(poped, true);
		}
	}
	
	static class Item implements Comparable<Item> {
		
		int value;
		int index;
		
		public Item(int v, int i) {
			value = v;
			index = i;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + index;
			result = prime * result + value;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Item other = (Item) obj;
			if (index != other.index)
				return false;
			if (value != other.value)
				return false;
			return true;
		}

		@Override
		public int compareTo(Item o) {
			if (this.value != o.value) {
				return this.value - o.value;
			}
			return this.index - o.index;
		}
		
		@Override
		public String toString() {
			return this.value+"";
		}
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenditure = new int[n];
        for(int expenditure_i = 0; expenditure_i < n; expenditure_i++){
            expenditure[expenditure_i] = in.nextInt();
        }
        int result = activityNotifications(expenditure, d);
        System.out.println(result);
        in.close();
    }
}
