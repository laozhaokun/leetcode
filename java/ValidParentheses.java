package leetcode;

import java.util.Stack;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月17日 上午9:09:25
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
	public boolean isValid(String s){
		int len = s.length();
		if(len <= 1)
			return false;
		if(s.charAt(0) == ')' || s.charAt(0)==']' || s.charAt(0)=='}')
			return false;
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<len;i++){
			if(s.charAt(i) == '(' || s.charAt(i)=='[' || s.charAt(i)=='{')
				stack.push(s.charAt(i));
			else{
				if(stack.size() == 0)
					return false;
				if(s.charAt(i) == ')')
					if(stack.peek() != '(')
						return false;
				if(s.charAt(i) == ']')
					if(stack.peek() != '[')
						return false;
				if(s.charAt(i) == '}')
					if(stack.peek() != '{')
						return false;
				stack.pop();
			}
		}
		return stack.size() == 0;
	}
}
