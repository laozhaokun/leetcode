package leetcode;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月12日 下午4:36:11
 * Given a binary tree and a sum, determine if the tree 
 * has a root-to-leaf path such that adding up all the 
 * values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		int temp = sum - root.val;
		if (temp == 0 && root.left == null && root.right == null)
			return true;
		return hasPathSum(root.left, temp) || hasPathSum(root.right, temp);
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
