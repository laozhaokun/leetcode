package leetcode;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月12日 下午5:11:26
 * Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest
 path from the root node down to the farthest leaf node.
 */
public class MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int a = maxDepth(root.left);
		int b = maxDepth(root.right);
		if (a == 0)
			return b + 1;
		if (b == 0)
			return a + 1;
		return Math.max(a, b) + 1;
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
