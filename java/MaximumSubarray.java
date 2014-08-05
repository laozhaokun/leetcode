package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月5日 下午9:03:55
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
	public static int maxSubArray(int[] A) {
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			if (sum < 0)
				sum = 0;
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

	public static int maxSubArray1(int[] A) {
		int max = A[0];
		int sum[] = new int[A.length];
		sum[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
			max = Math.max(max, sum[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] ary = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int max = maxSubArray(ary);
		System.out.println(max);
	}
}
