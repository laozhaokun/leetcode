package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月21日 下午7:25:05
 */
public class StringtoInteger {
	public static int atoi1(String str) {
		str = str.trim();
		if(str.isEmpty())
			return 0;
		char[] ch = str.toCharArray();
		for(int i=1;i<ch.length;i++){
			if(!Character.isDigit(ch[i])){
				str = str.substring(0, i);
				break;
			}
		}
		ch = str.toCharArray();
		int ret = 0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[0] == '-') {
				ret = ret * 10 - (ch[i + 1] - 48);
				if (i == ch.length - 2)
					break;
			} else if (ch[0] == '+') {
				ret = ret * 10 + (ch[i + 1] - 48);
				if (i == ch.length - 2)
					break;
			} else {
				ret = ret * 10 + (ch[i] - 48);
			}
		}
		return ret;
	}

	public static int atoi(String str) {
		int max = Integer.MAX_VALUE;
		int min = -Integer.MIN_VALUE;
		long result = 0;
		str = str.trim();
		int len = str.length();
		if (len < 1)
			return 0;
		int start = 0;
		boolean neg = false;

		if (str.charAt(start) == '-' || str.charAt(start) == '+') {
			if (str.charAt(start) == '-')
				neg = true;
			start++;
		}

		for (int i = start; i < len; i++) {
			char ch = str.charAt(i);

			if (ch < '0' || ch > '9')
				break;
			result = 10 * result + (ch - '0');
			if (!neg && result > max)
				return max;
			if (neg && -result < min)
				return min;

		}
		if (neg)
			result = -result;

		return (int) result;
	}

	public static void main(String[] args) {
		System.out.println(atoi("+-1"));
	}
}
