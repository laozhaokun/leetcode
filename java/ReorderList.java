package leetcode;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月19日 下午9:26:57
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
	reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
	You must do this in-place without altering the nodes' values.
	For example,
	Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		printList(n1);

//		ListNode n = reverse(n1);
		reorderList(n1);

		printList(n1);
	}

	public static void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			System.out.println("slow: "+ slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode second = slow.next;
		slow.next = null;
		second = reverse(second);
		ListNode p1 = head;
		ListNode p2 = second;

		// merge two lists here
		while (p2 != null) {
			ListNode temp1 = p1.next;
			ListNode temp2 = p2.next;

			p1.next = p2;
			p2.next = temp1;

			p1 = temp1;
			p2 = temp2;
		}
	}

	public static ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = head, current = head.next;
		while (current != null) {
			ListNode temp = current.next;
			current.next = pre;
			pre = current;
			current = temp;
		}
		head.next = null;
		return pre;
	}

	public static void printList(ListNode n) {
		while (n != null) {
			System.out.print(n.val);
			n = n.next;
		}
		System.out.println();
	}
}
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
