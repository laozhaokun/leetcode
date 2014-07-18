package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月17日 上午9:35:00
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

	For example, given n = 3, a solution set is:
	
	"((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {
	public static void main(String[] args) {
		List<String> list =generateParenthesis(3);
		for(String s : list)
			System.out.println(s);
	}
	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		helper(list,"",0,0,n);
		return list;
	}
	public static void helper(List<String> list,String s,int left,int right,int n){
		if(left < right)
			return;
		if(left == n && right==n){
			list.add(s);
			return;
		}
		if(left == n){
			helper(list,s+")",left,right+1,n);
			return;
		}
		helper(list,s+"(",left+1,right,n);
		helper(list,s+")",left,right+1,n);
	}
}
