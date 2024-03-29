package hackerrank.solutions.LinkedLists.exercise;

import hackerrank.codelibrary.LinkedListNode;

public class SumLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
		if (l1 == null & l2 == null && carry == 0) {
			return null;
		}
		LinkedListNode result = new LinkedListNode();
		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}
		result.data = value % 10; // Second digit of number
		/*
		 * Recurse
		 */
		if (l1 != null || l2 !=null) {
			LinkedListNode more = addLists(l1 == null ? null : l1.next,
								 l2 == null ? null: l2.next,
								 value >= 10 ? 1 : 0);
			result.setNext(more);
		}
		return result;
	}
	
	class PartialSum {
		public LinkedListNode sum = null;
		public int carry = 0;
	}
	
	LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		int len1 = getCount(l1);
		int len2 = getCount(l2);
		/*
		 * Pad the shorter lists with zeros - see note (1)
		 */
		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1 - len2);
		}
		/*
		 * Add lists
		 */
		PartialSum sum = addListsHelper(l1, l2);
		/*
		 * If there was a carry value left over, insert this in the front of the list.
		 * Otherwise, just return the linked list.
		 */
		if (sum.carry == 0) {
			return sum.sum;
		} else {
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}
	
	PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		/*
		 * Add smaller digits recursively
		 */
		PartialSum sum = addListsHelper(l1.next, l2.next);
		/*
		 * Add carry to current data
		 */
		int val = sum.carry + l1.data + l2.data;
		/*
		 * Insert sum of current digits
		 */
		LinkedListNode full_result = insertBefore(sum.sum, val % 10);
		/*
		 * Return sum so far, and the carry value
		 */
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}
	/*
	 * Pad the list with zeros
	 */
	LinkedListNode padList(LinkedListNode l, int padding) {
		LinkedListNode head = l;
		for (int i = 0; i < padding; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}
	/*
	 * Helper function to insert node in the front of a linked list
	 */
	LinkedListNode insertBefore(LinkedListNode list, int data) {
		LinkedListNode node = new LinkedListNode(data);
		if (list != null) {
			node.next = list;
		}
		return node;
	}
	
	public int getCount(LinkedListNode l) { 
        LinkedListNode temp = l; 
        int count = 0; 
        while (temp != null) { 
            count++; 
            temp = temp.next; 
        } 
        return count; 
    }	

}
