package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年9月14日 上午9:16:54
 * Given preorder and inorder traversal of a tree, construct the binary tree.
	
	Note:
	You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
	}
	
	public TreeNode buildTree(int[] preorder,int startpre,int endpre,int[] inorder,int startin,int endin){
		if(startpre>endpre || startin>endin)
			return null;
		int pivot = preorder[startpre];
		int index = 0;
		for(index=startin;index<=endin;index++){
			if(inorder[index]==pivot)
				break;
		}
		TreeNode root = new TreeNode(pivot);
		root.left = buildTree(preorder,startpre+1,startpre+(index-startin),inorder,startin,index-1);
		root.right = buildTree(preorder,startpre+(index-startin)+1,endpre,inorder,index+1,endin);
		return root;
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
