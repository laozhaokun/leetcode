package leetcode;



/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月19日 上午9:58:53
 * Given a binary tree, flatten it to a linked list in-place.
	
	For example,
	Given
	
	         1
	        / \
	       2   5
	      / \   \
	     3   4   6
	The flattened tree should look like:
	   1
	    \
	     2
	      \
	       3
	        \
	         4
	          \
	           5
	            \
	             6
 */
public class FlattenBinaryTreetoLinkedList {
	//recursion
	public void flatten1(TreeNode root) {
		if(root == null)
			return;
		flatten(root.left);
		flatten(root.right);
		TreeNode tmp = root;
		if(tmp.left == null)
			return;
		else
			tmp = tmp.left;
		while(tmp.right != null)
			tmp = tmp.right;
		tmp.right = root.right;
		root.right = root.left;
		root.left = null;
	}
	public void flatten(TreeNode root){
		while(root != null){
			if(root.left != null){
				TreeNode tmp = root.left;
				while(tmp.right != null)
					tmp = tmp.right;
				tmp.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}
    // Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
