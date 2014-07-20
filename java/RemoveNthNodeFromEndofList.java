package leetcode;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月20日 下午12:38:48
 * Given a linked list, remove the nth node from the end of list and return its head.
	
	For example,
	
	   Given linked list: 1->2->3->4->5, and n = 2.
	
	   After removing the second node from the end, the linked list becomes 1->2->3->5.
	Note:
	Given n will always be valid.
	Try to do this in one pass.
 */
public class RemoveNthNodeFromEndofList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slow = head, fast = head;
		if (head.next == null)
			return null;
		for (int i = 1; i <= n; i++)
			slow = slow.next;
		if (slow == null) {
			head = head.next;
			return head;
		}
		while (slow.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		fast.next = fast.next.next;
		return head;
	}
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
