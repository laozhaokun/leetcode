package leetcode;

/**
 * @author:zhaohf@asiainfo.com
 * @date:2014年11月20日 下午1:30:49
 * @Description: TODO
 * 动态规划状态转移方程：dp[m][n] = dp[m][n-1] + dp[m-1][n]，其中dp[m][n]表示到达网格[m][n]时有多少条唯一的路径
 */
public class UniquePaths {
	public int uniquePaths(int m, int n) {
		if (m == 0 || n == 0)
			return 1;
		int dp[][] = new int[m][n];
		for (int r = 0; r < m; r++)
			dp[r][0] = 1;
		for (int c = 0; c < n; c++)
			dp[0][c] = 1;
		for (int r = 1; r < m; r++) {
			for (int c = 1; c < n; c++)
				dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
		}
		return dp[m - 1][n - 1];
	}
}
