package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月10日 下午12:29:34 Given a non-negative number represented
 *          as an array of digits, plus one to the number. The digits are stored
 *          such that the most significant digit is at the head of the list.
 */
public class PlusOne {
	public static int[] plusOne(int[] digits) {
		int i = digits.length - 1;
		for (; i >= 0; --i) {
			if (digits[i] != 9) {
				digits[i] += 1;
				break;
			} else
				digits[i] = 0;
		}
		if (i < 0) {
			int[] temp = new int[digits.length + 1];
			temp[0] = 1;
			for (int j = 0; j < digits.length; j++)
				temp[j + 1] = digits[j];
			return temp;
		}
		return digits;
	}

	public static void main(String[] args) {
		int ret[] = plusOne(new int[] { 1,9 });
		for (int i : ret)
			System.out.println(i);
	}
}
