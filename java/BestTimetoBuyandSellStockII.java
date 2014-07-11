package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月11日 下午7:50:44
 */
public class BestTimetoBuyandSellStockII {
	public static void main(String[] args) {
		int ret = maxProfit(new int[]{1,2,4,3,5,7,6});
		System.out.println(ret);
	}
	public static int maxProfit(int[] prices){
		int len = prices.length;
		if(len <= 1)
			return 0;
		int sum = 0;
		for(int i=1;i<len;i++){
			int profit = prices[i] - prices[i - 1];
			if(profit > 0)
				sum += profit;
		}
		return sum;
	}
	public static int maxProfit1(int[] prices){
		int len = prices.length;
		if(len <= 1)
			return 0;
		int max = 0;
		T t = max(prices);
		while(true){
			max += t.max;
			if(t.ary.length <= 1)
				break;
			if(t.ary.length == 2){
				if(t.ary[1] < t.ary[0])
					break;
				else
					max += t.ary[1] - t.ary[0];
				break;
			}
			t = max(t.ary);
		}
		return max;
	}
	//每次的最大利润
	public static T max(int[] prices){
		int len = prices.length;
		if(len <= 1)
			return null;
		int min = prices[0],max = 0,largest = 0;
		for(int i=1;i<len;i++){
			int profit = prices[i] - min;
			if(max < profit){
				max = profit;
				largest = prices[i];
			}
			if(min > prices[i])
				min = prices[i];
		}
		System.out.println("min = " + min + "\tlargest = " + largest + "\tmax = "+ max);
		int[] a = delete(prices,min);
		int[] b = delete(a,largest);
		return new T(max,b);
	} 
	//删除数组中的某个元素
	public static int[] delete(int[] prices,int price){
		int len = prices.length;
		if(len <= 0 || price <= 0)
			return null;
		int[] ret = new int[len - 1];
		int index = 0;
		for(int i=0;i<len;i++){
			if(prices[i] == price){
				index = i;
				break;
			}
			ret[i] = prices[i];
		}
		for(int i=index;i<ret.length;i++){
			ret[i] = prices[i+1];
		}
		return ret;
	}
	static class T {
		int max;
		int[] ary;
		public T(int max,int[] ary){
			this.max = max;
			this.ary = ary;
		}
	}
}
