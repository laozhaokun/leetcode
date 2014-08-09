package leetcode;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月9日 下午3:37:29
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBST(num,0,num.length - 1);
	}
	public TreeNode sortedArrayToBST(int[] num,int start,int end) {
		if(start > end)
			return null;
		int mid = (start + (end-start))/2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = sortedArrayToBST(num,start,mid-1);
		node.right = sortedArrayToBST(num,mid+1,end);
		return node;
	}
    // Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
