package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月19日 下午8:36:02
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal1(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
        if(root == null)
        	return list;
        list.add(root.val);
        list.addAll(preorderTraversal1(root.left));
        list.addAll(preorderTraversal1(root.right));
        return list;
    }
    public List<Integer> preorderTraversal(TreeNode root){
    	List<Integer> list = new ArrayList<Integer>();
    	if(root == null)
    		return list;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	while(!stack.isEmpty()){
    		TreeNode node = stack.pop();
    		list.add(node.val);
    		
    		if(node.right != null)
    			stack.push(node.right);
    		if(node.left != null)
    			stack.push(node.left);
    	}
    	return list;
    }
    // Definition for binary tree
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
