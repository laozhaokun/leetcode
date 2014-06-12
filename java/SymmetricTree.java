package leetcode;


/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月12日 下午5:18:03
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		return isSymmetric(root,root);
		
	}
	public boolean isSymmetric(TreeNode left,TreeNode right) {
		if(left == null && right == null)
			return true;
		else if(left == null || right == null)
			return false;
		return left.val == right.val && isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
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
