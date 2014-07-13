package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月11日 下午7:50:44
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStockIII {
	public static void main(String[] args) {
		int ret = maxProfit(new int[]{1,2,4,3,5,7,6});
		System.out.println(ret);
	}

	public static int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;
		int f[] = new int[prices.length];
		int g[] = new int[prices.length];
		for (int i = 1, valley = prices[0]; i < prices.length; ++i) {
			valley = Math.min(valley, prices[i]);
			f[i] = Math.max(f[i - 1], prices[i] - valley);
		}
		for (int i = prices.length - 2, peak = prices[prices.length - 1]; i >= 0; --i) {
			peak = Math.max(peak, prices[i]);
			g[i] = Math.max(g[i], peak - prices[i]);
		}
		int max_profit = 0;
		for (int i = 0; i < prices.length; ++i)
			max_profit = Math.max(max_profit, f[i] + g[i]);
		return max_profit;
	}
}
