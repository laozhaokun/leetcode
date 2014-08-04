package leetcode;


/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月4日 下午9:04:31
 * Follow up for problem "Populating Next Right Pointers in Each Node".

	What if the given tree could be any binary tree? Would your previous solution still work?
	
	Note:
	
	You may only use constant extra space.
	For example,
	Given the following binary tree,
	         1
	       /  \
	      2    3
	     / \    \
	    4   5    7
	After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \    \
	    4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
		if(root == null)
			return;
		TreeLinkNode parent = root,pre,next;
		while(parent != null){
			pre = null;
			next = null;
			while(parent != null){
				if(next == null)
					next = (parent.left == null) ? parent.right : parent.left;
				if(parent.left != null){
					if(pre != null){
						pre.next = parent.left;
						pre = pre.next;
					}else
						pre = parent.left;
				}
				if(parent.right != null){
					if(pre != null){
						pre.next = parent.right;
						pre = pre.next;
					}else
						pre = parent.right;
				}
				parent = parent.next;
			}
			parent = next;
		}
	}

	// Definition for binary tree with next pointer.
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
