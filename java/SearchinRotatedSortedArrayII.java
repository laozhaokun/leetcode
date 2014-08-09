package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月9日 上午10:32:07
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 */
public class SearchinRotatedSortedArrayII {
	public boolean search1(int[] A, int target) {
		int low = 0, high = A.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == A[mid])
				return true;
			if (A[mid] > A[low]) {
				if (target >= A[low] && target <= A[mid])
					high = mid - 1;
				else
					low = mid + 1;
			} else if (A[mid] < A[low]) {
				if (target >= A[mid] && target <= A[high])
					low = mid + 1;
				else
					high = mid - 1;
			} else
				low += 1;
		}
		return false;
	}
}
