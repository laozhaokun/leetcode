package leetcode;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年9月14日 上午11:10:40
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder,int[] postorder) {
		return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
	}
	
	public TreeNode buildTree(int[] inorder,int startin,int endin,int[] postorder,int startpost,int endpost){
		if(startpost>endpost || startin>endin)
			return null;
		int pivot = postorder[endpost];
		int index = 0;
		for(;index<=endin;index++){
			if(inorder[index]==pivot)
				break;
		}
		TreeNode root = new TreeNode(pivot);
		root.left = buildTree(inorder,startin,index-1,postorder,startpost,startpost+index-(startin+1));
		root.right = buildTree(inorder,index+1,endin,postorder,startpost+index-startin,endpost-1);
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
