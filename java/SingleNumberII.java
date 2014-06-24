package leetcode;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月24日 下午12:59:29
 * Given an array of integers, every element appears three times except for one. Find that single one.
	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {
	public int singleNumber(int[] A) {
		int ret = 0;
		for (int i = 0; i < 32; i++) {
			int tmp = 0;
			for (int j = 0; j < A.length; j++) {
				tmp += ((A[j] >> i) & 1);
			}
			ret |= ((tmp % 3) << i);
		}
		return ret;
	}
	
	/*
	 * ones   代表第i位只出现一次的掩码变量
		twos  代表第i位只出现两次次的掩码变量
		threes  代表第i位只出现三次的掩码变量
	 */
	public int singleNumber1(int[] A) {
		int ones = 0, twos = 0;
		for (int i = 0; i < A.length; i++) {
			twos = twos | (ones & A[i]);
			ones = ones ^ A[i];
			//把出现了3次的位置设置为0,取反
			int threes = ~(ones & twos);
			ones &= threes;
			twos &= threes;
		}
		return ones;
	}
}
