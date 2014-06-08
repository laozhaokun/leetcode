package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月8日 下午7:13:16
 * You are given two linked lists representing two non-negative numbers.
 *  The digits are stored in reverse order and each of their nodes contain a single digit. 
 *  Add the two numbers and return it as a linked list.
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
 */

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode result = new ListNode(0);
		ListNode temp = result;
		int sum = 0;
		while(l1 != null || l2 != null){
			if(l1 != null){
				sum += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				sum += l2.val;
				l2 = l2.next;
			}
			//对10取余，判断两数之和是否大于10
			temp.next = new ListNode(sum%10);
			temp = temp.next;
			//取进位的数，值为0,1
			sum /= 10;
		}
		if(sum >0)
			temp.next = new ListNode(sum);
		return result.next;
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
	public static void main(String[] args) {
		new AddTwoNumbers().run();
	}
	public  void run(){
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode ret = addTwoNumbers(l1,l2);
		
		System.out.println(ret.val);
		System.out.println(ret.next.val);
		System.out.println(ret.next.next.val);
	}
}
