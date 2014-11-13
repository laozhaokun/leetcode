package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaohf
 *Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */

public class MinStack {
	private List<Integer> stack = new ArrayList<Integer>();
	private List<Integer> minstack = new ArrayList<Integer>();
	public void push(int x) {
		stack.add(x);
		if(minstack.isEmpty() || minstack.get(minstack.size()-1) >= x)
			minstack.add(x);
	}

	public void pop() {
		if(stack.isEmpty())
			return;
		int tmp = stack.remove(stack.size()-1);
		if(!minstack.isEmpty() && tmp == minstack.get(minstack.size()-1))
			minstack.remove(minstack.size()-1);
	}

	public int top() {
		if(!stack.isEmpty())
			return stack.get(stack.size()-1);
		return -1;
	}

	public int getMin() {
		if(!minstack.isEmpty())
			return minstack.get(minstack.size()-1);
		return -1;
	}
}
