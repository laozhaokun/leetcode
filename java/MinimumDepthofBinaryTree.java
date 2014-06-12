package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月11日 下午7:00:51 Given a binary tree, find its minimum
 *          depth. The minimum depth is the number of nodes along the shortest
 *          path from the root node down to the nearest leaf node.
 */
public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int a = minDepth(root.left);
		int b = minDepth(root.right);
		if (a == 0)
			return b + 1;
		if (b == 0)
			return a + 1;
		return Math.min(a, b) + 1;
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
