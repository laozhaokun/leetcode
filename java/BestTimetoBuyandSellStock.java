package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月11日 下午7:00:54
 */
public class BestTimetoBuyandSellStock {
	public static void main(String[] args) {
		int ret = maxProfit(new int[]{1,2,4,3,5,7,6});
		System.out.println(ret);
	}
	public static int maxProfit(int[] prices){
		int len = prices.length;
		if(len <= 1)
			return 0;
		int min = prices[0],max = 0;
		for(int i=1;i<len;i++){
			int profit = prices[i] - min;
			if(max < profit)
				max = profit;
			if(min > prices[i])
				min = prices[i];
		}
		return max;
	} 
	//timeout
	public static int maxProfit1(int[] prices){
		int len = prices.length;
		if(len <= 1)
			return 0;
		int max = 0;
		for(int i=0;i<len;i++){
			for(int j=i+1;j<len;j++){
				int profit = prices[j] - prices[i];
				if(max < profit)
					max = profit;
			}
		}
		return max;
	}
}
