package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月10日 上午9:16:18
 * Given a collection of numbers, return all possible permutations.
	
	For example,
	[1,2,3] have the following permutations:
	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {
	public List<List<Integer>> permute(int[] num) {
		if (num == null)
			return null;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num.length == 0)
			return result;
		permute(num, new boolean[num.length], new ArrayList<Integer>(), result);
		return result;
	}

	public void permute(int[] num, boolean[] isused,
			ArrayList<Integer> current, List<List<Integer>> result) {
		if (current.size() == num.length) {
			result.add(new ArrayList<Integer>(current));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (!isused[i]) {
				isused[i] = true;
				current.add(num[i]);
				permute(num, isused, current, result);
				current.remove(current.size() - 1);
				isused[i] = false;
			}
		}
	}
}
