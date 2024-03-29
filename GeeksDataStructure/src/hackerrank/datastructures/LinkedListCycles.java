/**
 * Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
 * A node is defined as:
 * class Node {
 * 		int data;
 * 		Node next;
 * }
 */
package hackerrank.datastructures;

import hackerrank.datastructures.LinkedList.Node;

public class LinkedListCycles {
	
	boolean hasCycle(Node head) {
		if (head == null) return false;
		Node fast = head.next;
		Node slow = head;
		while (fast != null && fast.next != null && slow != null) {
			if (fast == slow) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
