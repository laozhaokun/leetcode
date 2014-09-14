package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年9月14日 上午11:34:43
 * Given a binary tree, find the maximum path sum.

	The path may start and end at any node in the tree.
	
	For example:
	Given the below binary tree,
	
	       1
	      / \
	     2   3
	Return 6.
 */
public class BinaryTreeMaximumPathSum {
	int max = 0;
	public int maxPathSum(TreeNode root) {
		max = (root == null) ? 0 : root.val;
		max(root);
		return max;
	}

	public int max(TreeNode node) {
		if (node == null)
			return 0;
		int left = Math.max(0, max(node.left));
		int right = Math.max(0, max(node.right));
		max = Math.max(node.val + left + right, max);
		return node.val + Math.max(left, right);
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
