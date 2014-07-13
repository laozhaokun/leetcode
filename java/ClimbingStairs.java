package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月13日 上午10:25:48
 * You are climbing a stair case. It takes n steps to reach to the top.
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?	
 */
public class ClimbingStairs {
	public static void main(String[] args) {
		int ret1 = new ClimbingStairs().climbStairs1(10);
		int ret = new ClimbingStairs().climbStairs(10);
		System.out.println(ret1 + "\t" + ret);
	}
	public int climbStairs1(int n) {
		if(n < 0)
			return 0;
		if(n <= 1)
			return 1;
		return climbStairs1(n - 1) + climbStairs1(n - 2);
	}

	public int climbStairs(int n) {
		if (n == 0 || n == 1)
			return 1;
		int prev = 1;
		int current = 1;
		for (int i = 2; i <= n; i++) {
			int temp = current + prev;
			prev = current;
			current = temp;
		}
		return current;
	}
}
