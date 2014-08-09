package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月9日 下午3:12:31 You are given an n x n 2D matrix
 *          representing an image.
 * 
 *          Rotate the image by 90 degrees (clockwise).
 * 
 *          Follow up: Could you do this in-place?
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		int len = matrix.length;
		for (int i = 0; i < len / 2; i++) {
			for (int j = i; j < len - i - 1; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[len - j - 1][i];
				matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
				matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
				matrix[j][len - i - 1] = tmp;
			}
		}
	}
}
