package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月23日 上午11:01:54
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:

	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	For example,
	
	Consider the following matrix:
	
	[
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
	Given target = 3, return true.
 */
public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int m = matrix.length;
		int n = matrix[0].length;
		int start = 0;
		int end = m * n - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int x = mid / n;
			int y = mid % n;
			if (matrix[x][y] == target)
				return true;
			if (matrix[x][y] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return false;
	}
}
