package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月22日 上午11:22:19
 */
public class ReverseNodesinkGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k <= 1)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		int count = 0;
		ListNode pre = dummy,current = head;
		while (current != null) {
			count++;
			ListNode post = current.next;
			if(count == k){
				pre = reverse(pre,post);
				count = 0;
			}
			current = post;
		}
		return dummy.next;
	}
	
	ListNode reverse(ListNode pre,ListNode post){
		ListNode dummy = pre.next;
		ListNode current = dummy.next;
		while(current != post){
			ListNode next = current.next;
			current.next = pre.next;
			pre.next = current;
			current = next;
		}
		dummy.next = post;
		return dummy;
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
