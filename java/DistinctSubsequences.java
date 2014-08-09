package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月9日 上午10:56:12
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
	
	A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
	
	Here is an example:
	S = "rabbbit", T = "rabbit"
	
	Return 3.
 */
public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		int lens = S.length();
		int lent = T.length();
		int[][] dp = new int[lent + 1][lens + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= lent; i++)
			dp[i][0] = 0;
		for (int i = 1; i <= lens; i++)
			dp[0][i] = 1;
		for (int i = 1; i <= lent; i++) {
			for (int j = 1; j <= lens; j++) {
				dp[i][j] = dp[i][j - 1];
				if (T.charAt(i - 1) == S.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
			}
		}
		return dp[lent][lens];
	}
}
