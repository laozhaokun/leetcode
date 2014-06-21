package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月21日 下午6:44:11
 * Reverse digits of an integer.
	Example1: x = 123, return 321
	Example2: x = -123, return -321
 */
public class ReverseInteger {
	public static int reverse(int x) {
		int ret = 0;
		while (x != 0) {
			System.out.println(ret + "\t" + x);
			ret = ret * 10 + x % 10;
			System.out.println(ret + "\t" + x);
			x /= 10;
			System.out.println(ret + "\t" + x);
			System.out.println("---------------");
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(reverse(-192));
	}
}
