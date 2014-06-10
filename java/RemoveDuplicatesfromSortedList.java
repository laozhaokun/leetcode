package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月10日 下午2:02:28 Given a sorted linked list, delete all
 *          duplicates such that each element appear only once. For example,
 *          Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList {
	public static void main(String[] args) {
		new RemoveDuplicatesfromSortedList().run();
	}

	public void run() {
		ListNode ln = new ListNode(1);
		ln.next = new ListNode(1);
		ln.next.next = new ListNode(2);
		ListNode ln1 = deleteDuplicates(ln);
		while (ln1 != null) {
			int value = ln1.val;
			System.out.println("val = " + value);
			ln1 = ln1.next;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode p = head;
		while (p != null && p.next != null) {
			if (p.val == p.next.val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}

		return head;
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
