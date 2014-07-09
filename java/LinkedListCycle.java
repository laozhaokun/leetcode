package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月9日 下午1:13:01
 * Given a linked list, determine if it has a cycle in it.
	Follow up:
	Can you solve it without using extra space?
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		ListNode fast = head,slow = head;
		if(head == null || head.next == null)
			return false;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				return true;
		}
		return false; 
	}

	// Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
