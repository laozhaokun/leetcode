package leetcode;

import java.util.Arrays;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月23日 下午3:03:39
 * Given an array S of n integers, 
 * find three integers in S such that the sum is closest to a given number, target.
 *  Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		int min = Integer.MAX_VALUE;
		int result = 0;
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				int minus = Math.abs(sum - target);
				if (minus == 0)
					return sum;
				if (minus < min) {
					min = minus;
					result = sum;
				}
				if (sum <= target)
					j++;
				else
					k--;
			}
		}
		return result;
	}
}
