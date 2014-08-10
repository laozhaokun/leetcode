package leetcode;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月10日 上午8:43:26
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		int len = 0;
		ListNode tmp = head;
		while (tmp != null) {
			tmp = tmp.next;
			len++;
		}
		return sortedListToBST(head, len);
	}

	public TreeNode sortedListToBST(ListNode head, int len) {
		if (len <= 0)
			return null;
		int mid = (1 + len) / 2;
		ListNode p = head;
		int tmp = mid - 1;
		while (tmp > 0) {
			p = p.next;
			tmp--;
		}
		TreeNode root = new TreeNode(p.val);
		root.left = sortedListToBST(head, mid - 1);
		root.right = sortedListToBST(p.next, len - mid);
		return root;
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

	// Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
