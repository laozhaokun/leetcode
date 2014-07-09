package leetcode;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月9日 下午1:38:34
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
	Follow up:
	Can you solve it without using extra space?
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head,slow = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				break;
		}
		if(fast == null || fast.next == null )
			return null;
		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
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
