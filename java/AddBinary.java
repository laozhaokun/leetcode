package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月20日 上午9:00:14
 * Given two binary strings, return their sum (also a binary string).
	For example,
	a = "11"
	b = "1"
	Return "100".
 */
public class AddBinary {
	public static String addBinary(String a, String b) {
		StringBuilder ar = new StringBuilder(a).reverse();
		StringBuilder br = new StringBuilder(b).reverse();
		StringBuilder result = new StringBuilder();
		int len = Math.max(a.length(), b.length());
		int carry = 0;//进位
		for (int i = 0; i < len; i++) {
			int t1 = (i >= a.length() ? 0 : (ar.charAt(i) - '0'));
			int t2 = (i >= b.length() ? 0 : (br.charAt(i) - '0'));
			int t3 = t1 + t2 + carry;
			carry = t3 / 2;
			t3 = t3 % 2;
			result.append(t3);
		}
		if (carry != 0)
			result.append(carry);
		result.reverse();
		return result.toString();
	}
    public static void main(String[] args) {
		System.out.println(addBinary("11","1"));
		System.out.println('0');
	}
}
