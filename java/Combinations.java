package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月15日 上午9:26:08
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

	For example,
	If n = 4 and k = 2, a solution is:
	
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
 */
public class Combinations {
	public static void main(String[] args) {
		List<List<Integer>> list = new Combinations().combine(4, 2);
		for (List<Integer> li : list) {
			for (Integer l : li) {
				System.out.print(l + "\t");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> combine(int n, int k) {
		return combine(1, n + 1, k);
	}

	public List<List<Integer>> combine(int low, int upper, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (k == 1) {
			for (int i = low; i < upper; i++) {
				List<Integer> r = new ArrayList<Integer>();
				r.add(i);
				result.add(r);
			}
			return result;
		}
		for (int i = low; i < upper; i++) {
			List<List<Integer>> r = combine(i + 1, upper, k - 1);
			for (List<Integer> a : r) {
				a.add(0, i);
			}
			result.addAll(r);
		}
		return result;
	}
}
