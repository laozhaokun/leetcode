package leetcode;

import java.util.List;



/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月30日 下午6:18:28
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergekSortedLists {
	public ListNode mergeKLists(List<ListNode> lists){
		if(lists == null)
			return null;
		return mergeLists(lists,0,lists.size()-1);
	}
	public ListNode mergeLists(List<ListNode> lists,int start,int end) {
		if(start > end)
			return null;
		if(start==end)
			return lists.get(start);
		if(start+1 == end)
			return mergeTwoLists(lists.get(start),lists.get(end));
		int mid = (start+end)/2;
		return mergeTwoLists(mergeLists(lists,start,mid),mergeLists(lists,mid+1,end));
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode p1 = l1, p2 = l2, dummy = new ListNode(-1), p = dummy;
		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}
		if (p1 != null)
			p.next = p1;
		if (p2 != null)
			p.next = p2;
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
