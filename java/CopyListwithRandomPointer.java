package leetcode;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月10日 下午6:51:28
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.
	Return a deep copy of the list.
 */
public class CopyListwithRandomPointer {
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return null;
		RandomListNode p = head;
		while(p != null){
			RandomListNode copy = new RandomListNode(p.label);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
		}
		p = head;
		while(p != null){
			if(p.random != null)
				p.next.random = p.random.next;
			p = p.next.next;
		}
		p = head;
		RandomListNode newHead = head.next;
		while(p != null){
			RandomListNode tmp = p.next;
			p.next = tmp.next;
			if(tmp.next != null)
				tmp.next = tmp.next.next;
			p = p.next;
		}
		return newHead;
	}

	// Definition for singly-linked list with a random pointer.
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}
}
