package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月8日 上午10:31:02
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSum {
	public static void main(String[] args) {
		List<List<Integer>> list = threeSum(new int[]{-15,10,0,-2,14,-1,-10,-14,10,12,6,-6,10,2,-11,-9,2,13,2,-9,-14,-12,-10,-12,13,13,-10,-3,2,-11,3,-6,6,10,7,5,-13,4,-2,12,1,-11,14,-4,6,-12,-6,-14,8,11,-8,1,7,-3,5,5,-13,10,9,-3,6,-10,6,-3,7,-9,-13,9,10,0,-1,-11,4,-10,-8,-13,-15,2,-12,8,-2,-12,-14,-10,-8,6,2,-5,-7,-11,7,14,-6,-10,-12,8,-4,-10,-5,14,-3,9,-12,8,14,-13});
		for(List<Integer> li : list){
			for(Integer l : li)
				System.out.print(l + "\t");
			System.out.println();
		}
	}

	public static List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int len = num.length;
		if (len < 3)
			return list;
		Arrays.sort(num);
		Set set = new HashSet();
		int j = 0, k = 0;
		for (int i = 0; i < len - 2; i++) {
			int target = -num[i];
			j = i + 1;
			k = len - 1;
			while (j < k) {
				if (num[j] + num[k] == target) {
					List<Integer> li = new ArrayList<Integer>();
					li.add(num[i]);
					li.add(num[j]);
					li.add(num[k]);
					if (set.add(li))
						list.add(li);
					j++;
					k--;
				} else if (num[j] + num[k] < target)
					j++;
				else
					k--;
			}
		}
		return list;
	}
}
