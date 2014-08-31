package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月30日 下午8:44:24
 * Divide two integers without using multiplication, division and mod operator.
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		long absdividend = Math.abs((long) dividend);
		long absdivisor = Math.abs((long) divisor);
		int quotient = 0;
		while (absdividend >= absdivisor) {
			long temp = absdivisor;
			for (int i = 1; absdividend >= temp; i <<= 1, temp <<= 1) {
				absdividend -= temp;
				quotient += i;
			}
		}
		return ((dividend < 0) ^ (divisor < 0)) ? -quotient : quotient;
	}
}
