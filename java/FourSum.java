package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月23日 下午4:21:07
 * Given an array S of n integers, are there elements a, b, c,
 *  and d in S such that a + b + c + d = target?
 *   Find all unique quadruplets in the array which gives the sum of target.

	Note:
	Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
	The solution set must not contain duplicate quadruplets.
	    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
	
	    A solution set is:
	    (-1,  0, 0, 1)
	    (-2, -1, 1, 2)
	    (-2,  0, 0, 2)
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int len = num.length;
		if (len < 4)
			return list;
		Arrays.sort(num);
		Set set = new HashSet();
		int j = 0, k = 0, m = 1;
		for (int i = 0; i < len - 3; i++) {
			for (m = i + 1; m < len - 2; m++) {
				int left = target - (num[i] + num[m]);
				j = m + 1;
				k = len - 1;
				while (j < k) {
					if (num[j] + num[k] == left) {
						List<Integer> li = new ArrayList<Integer>();
						li.add(num[i]);
						li.add(num[m]);
						li.add(num[j]);
						li.add(num[k]);
						if (set.add(li))
							list.add(li);
						j++;
						k--;
					} else if (num[j] + num[k] < left)
						j++;
					else
						k--;
				}
			}
		}
		return list;
	}
}
