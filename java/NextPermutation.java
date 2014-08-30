package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月30日 下午6:55:36
 * Implement next permutation,
 *  which rearranges numbers into the lexicographically next greater permutation of numbers.
	
	If such arrangement is not possible, 
	it must rearrange it as the lowest possible order (ie, sorted in ascending order).
	
	The replacement must be in-place, do not allocate extra memory.
	
	Here are some examples. 
	Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	1,2,3 → 1,3,2
	3,2,1 → 1,2,3
	1,1,5 → 1,5,1
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
		int len = num.length, i = 0, j = 0;
		for (i = len - 2; i >= 0; i--) {
			if (num[i] >= num[i + 1])
				continue;
			for (j = len - 1; j > i; j--) {
				if (num[j] > num[i])
					break;
			}
			break;
		}
		if (i >= 0) {
			int temp = num[i];
			num[i] = num[j];
			num[j] = temp;
		}
		int end = len - 1;
		int start = i + 1;
		while (start < end) {
			int temp = num[start];
			num[start] = num[end];
			num[end] = temp;
			start++;
			end--;
		}
	}

}
