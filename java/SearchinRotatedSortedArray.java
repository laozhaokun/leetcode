package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月26日 上午10:41:45
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */
public class SearchinRotatedSortedArray {
	public int search(int[] A, int target) {
		int low = 0, high = A.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (target == A[mid])
				return mid;
			if (A[mid] > A[low]) {
				if (target >= A[low] && target < A[mid])
					high = mid - 1;
				else
					low = mid + 1;
			} else if(A[mid] < A[low]){
				if (target <= A[high] && target > A[mid])
					low = mid + 1;
				else
					high = mid - 1;
			}else
				low += 1;
		}
		return -1;
	}
}
