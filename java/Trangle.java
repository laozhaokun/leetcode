package leetcode;

import java.util.List;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月13日 上午9:04:02
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

	For example, given the following triangle
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Trangle {
	//不对的解法
	public int minimumTotal1(List<List<Integer>> triangle) {
		int sum = 0;
		for (int i = 0; i < triangle.size(); i++) {
			int min = triangle.get(i).get(0);
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if (triangle.get(i).get(j) < min)
					min = triangle.get(i).get(j);
			}
			sum += min;
		}
		return sum;
	}

	public int minimumTotal2(List<List<Integer>> triangle) {
		int rowLen = triangle.size();
		// dp数组用来存储每一格子的最优解
		int[][] sum = new int[rowLen][rowLen]; // 最底下一行
		List<Integer> last = triangle.get(triangle.size() - 1);
		for (int i = 0; i < last.size(); i++) {
			sum[rowLen - 1][i] = last.get(i);
		} // Bottom-up DP
		for (int i = rowLen - 2; i >= 0; i--) {
			List<Integer> row = triangle.get(i);
			for (int j = 0; j <= i; j++) {
				sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j + 1])
						+ row.get(j);
			}
		}
		return sum[0][0];
	}
	public int minimumTotal(List<List<Integer>> triangle) {
	    for(int i = triangle.size() - 2; i >= 0; i--)
	    {
	        for(int j = 0; j < triangle.get(i).size(); j++)
	        {
	            triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
	        }
	    }
	    return triangle.get(0).get(0);
	}
}
