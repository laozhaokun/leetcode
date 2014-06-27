package leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月27日 上午9:11:01
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	return
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
 */
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		dfs(root,sum,ret,list);
		return ret;
	}
	public void dfs(TreeNode root,int sum,List<List<Integer>> ret,List<Integer> list){
		if(root == null)
			return ;
		if(root.val == sum && root.left == null && root.right == null){
			list.add(root.val);
			List<Integer> temp = new ArrayList<Integer>(list);//拷贝一份
			ret.add(temp);
			list.remove(list.size() - 1);//再删除
			return ;
		}
		list.add(root.val);
		dfs(root.left,sum-root.val,ret,list);
		dfs(root.right,sum-root.val,ret,list);
		list.remove(list.size() - 1);
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
