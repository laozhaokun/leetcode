package leetcode;

import java.util.Arrays;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月7日 上午9:56:14
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianofTwoSortedArrays {
	public static void main(String[] args) {
		int A[] = {};
		int B[] = {1};
		double ret = findMedianSortedArrays(A,B);
		System.out.println(ret);
	}

	public static double findMedianSortedArrays(int[] a, int[] b) {
		int m = a.length, n = b.length;
		int median = (m + n) / 2;
		if ((m + n) % 2 == 1) // Single median
			return findKthElement(a, b, median);
		else
			// Average of two medians
			return (findKthElement(a, b, median) + findKthElement(a, b,
					median - 1)) / 2.0;
	}

	private static double findKthElement(int[] a, int[] b, int k) {
		int m = a.length, n = b.length;
		int aStart = 0, bStart = 0; // Keep track of the starting index of both
									// arrays under consideration
		int ka, kb;
		while (true) {
			if (aStart == m) // a is empty; find the k-th element in b
				return b[bStart + k];
			if (bStart == n) // b is empty; find the k-th element in a
				return a[aStart + k];
			if (k == 0) // Find the smallest element
				return Math.min(a[aStart], b[bStart]);
			// Set the indices of the elements under consideration
			if (k == 1) { // A special case when k/2-1 < 0
				ka = aStart;
				kb = bStart;
			} else { // Make sure the indices are within the boundaries
				ka = Math.min(m - 1, aStart + k / 2 - 1);
				kb = Math.min(n - 1, bStart + k / 2 - 1);
			}

			// Adjust k and the start index according to the relationship
			// between a[ka] and b[kb]
			if (a[ka] <= b[kb]) { // Any Element in a[aStart...ka] cannot be the one
				k -= ka - aStart + 1;
				aStart = ka + 1;
			} else { // Any Element in b[bStart...kb] cannot be the one
				k -= kb - bStart + 1;
				bStart = kb + 1;
			}
		}
	}

	public static double findMedianSortedArrays1(int A[], int B[]) {
		int AB[] = new int[A.length + B.length];
		for (int i = 0; i < A.length; i++) {
			AB[i] = A[i];
		}
		for (int i = 0; i < B.length; i++) {
			AB[A.length + i] = B[i];
		}
		Arrays.sort(AB);
		double median = AB.length % 2 == 1 ? AB[AB.length >> 1] : (AB[(AB.length - 1) >> 1] + AB[AB.length >> 1]) / 2.0;
		return median;
	}
}
