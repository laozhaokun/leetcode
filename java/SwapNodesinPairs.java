package leetcode;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月27日 上午10:42:56
 * Given a linked list, swap every two adjacent nodes and return its head.

	For example,
	Given 1->2->3->4, you should return the list as 2->1->4->3.
	
	Your algorithm should use only constant space. 
	You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesinPairs {
	public ListNode swapPairs1(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode back = head;
		while (back != null) {
			if (back.next != null) {
				int val = back.val;
				back.val = back.next.val;
				back.next.val = val;
				back = back.next.next;
			} else
				break;
		}
		return head;
	}

	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		while (head != null && head.next != null) {
			ListNode tmp = head.next.next;
			pre.next = head.next;
			head.next.next = head;
			head.next = tmp;
			pre = head;
			head = tmp;
		}
		return dummy.next;
	}
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
