package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月19日 下午8:59:12
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal1(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
        if(root == null)
        	return list;
        list.addAll(postorderTraversal1(root.left));
        list.addAll(postorderTraversal1(root.right));
        list.add(root.val);
        return list;
    }
    public List<Integer> postorderTraversal(TreeNode root){
    	List<Integer> list = new ArrayList<Integer>();
    	if(root == null)
    		return list;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);//最后访问
    	while(!stack.isEmpty()){
    		TreeNode current = stack.peek();//取出根节点
    		//根节点无子节点
    		if(current.left == null && current.right == null){
    			list.add(current.val);
    			stack.pop();
    		}
    		if(current.left != null){
    			stack.push(current.left);
    			current.left = null;
    			continue;
    		}
    		if(current.right != null){
    			stack.push(current.right);
    			current.right = null;
    			continue;
    		}
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
