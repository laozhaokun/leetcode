package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月30日 下午8:21:13
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

	For example,
	[1,1,2] have the following unique permutations:
	[1,1,2], [1,2,1], and [2,1,1].
 */
public class PermutitionsII {
	public List<List<Integer>> permuteUnique(int[] num) {
		if (num == null)
			return null;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num.length == 0)
			return result;
		Arrays.sort(num);
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
				isused[i] = false;
				current.remove(current.size() - 1);
				while (i + 1 < num.length && num[i + 1] == num[i])
					i++;
			}
		}
	}
}
