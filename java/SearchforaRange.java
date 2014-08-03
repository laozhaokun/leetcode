package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月2日 下午2:25:26
 * Given a sorted array of integers, find the starting and ending position of a given target value.
	
	Your algorithm's runtime complexity must be in the order of O(log n).
	
	If the target is not found in the array, return [-1, -1].
	
	For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4].
 */
public class SearchforaRange {
	public int[] searchRange(int[] A, int target) {
		int result[] = new int[] { -1, -1 };
		int len = A.length;
		if (len <= 0)
			return result;
		int separator = -1;
		int left = 0, right = len - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (A[middle] > target)
				right = middle - 1;
			else if (A[middle] < target)
				left = middle + 1;
			else {
				separator = middle;
				break;
			}
		}
		if (separator == -1)
			return result;
//找到左边界
		left = 0;
		right = separator;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (A[middle] == target)
				right = middle - 1;
			else
				left = middle + 1;
		}
		result[0] = left;
//找到右边界
		left = separator;
		right = len - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (A[middle] == target)
				left = middle + 1;
			else
				right = middle - 1;
		}
		result[1] = right;
		return result;
	}
}
