package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月9日 下午12:13:00
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode newHead = new ListNode(-1);
		ListNode pre = newHead;
		ListNode current = head;
		while(current != null){
			pre = newHead;
			while(pre.next != null && pre.next.val < current.val)
				pre = pre.next;
			ListNode next = current.next;
			current.next = pre.next;
			pre.next = current;
			current = next;
		}
		return newHead.next;
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
