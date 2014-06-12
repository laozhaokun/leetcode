package leetcode;

import java.util.ArrayList;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月10日 下午8:09:09 Given two binary trees, write a function
 *          to check if they are equal or not. Two binary trees are considered
 *          equal if they are structurally identical and the nodes have the same
 *          value.
 */
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p != null && q != null){
			if(p.val == q.val)
				return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
			else
				return false;
		}else if(p == null && q == null)
			return true;
		else
			return false;
	}
	ArrayList<Integer> list = new ArrayList<Integer>();

	//按理来说此法亦可，但是judging过程中的input是[1,1] [1,#,1],于是出错，但是这个没法输入吧
	public boolean isSameTree1(TreeNode p, TreeNode q) {
		if ((p == null && q != null) || (p != null && q == null))
			return false;
		if (p == null && q == null)
			return true;
		ArrayList<Integer> list1 = midTraverse(p);
		list = new ArrayList<Integer>();// 重新初始化
		ArrayList<Integer> list2 = midTraverse(q);
		print(list1);
		print(list2);
		if (list1.size() != list2.size())
			return false;
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != list2.get(i))
				return false;
		}
		return true;
	}

	public void print(ArrayList<Integer> list) {
		for (Integer i : list)
			System.out.print(i + "\t");
		System.out.println("\n");
	}

	// 中序遍历
	public ArrayList<Integer> midTraverse(TreeNode root) {
		if (root != null) {
			midTraverse(root.left);
			list.add(root.val);
			midTraverse(root.right);
		}
		return list;
	}

	public static void main(String[] args) {
		new SameTree().test();
	}

	public void test() {
		TreeNode tn = new TreeNode(5);
		tn.left = new TreeNode(3);
		tn.right = new TreeNode(6);
		tn.left.left = new TreeNode(2);
		tn.left.right = new TreeNode(4);

		TreeNode tn2 = new TreeNode(5);
		tn2.left = new TreeNode(3);
		tn2.right = new TreeNode(7);
		tn2.right.left = new TreeNode(6);
		tn2.left.left = new TreeNode(2);
		tn2.left.right = new TreeNode(4);
		boolean b = isSameTree(tn, tn2);
		System.out.println(b);
		// ArrayList<Integer> list = midTraverse(tn);
		// ArrayList<Integer> list2 = midTraverse(tn2);
		// System.out.println(list == list2);
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
