package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月28日 下午7:57:03
 * Given a roman numeral, convert it to an integer.
	Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomantoInteger {
	public int romanToInt(String s) {
		Map<Character, Integer> romans = new HashMap<Character, Integer>();
		romans.put('I', 1);
		romans.put('V', 5);
		romans.put('X', 10);
		romans.put('L', 50);
		romans.put('C', 100);
		romans.put('D', 500);
		romans.put('M', 1000);
		char[] ch = s.toCharArray();
		int num = 0, val = 0;
		for (int i = 0; i < ch.length; i++) {
			val = romans.get(ch[i]);
			if (i == ch.length - 1 || romans.get(ch[i + 1]) <= val)
				num += val;
			else
				num -= val;
		}
		return num;
	}
	public int romanToInt1(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); ++i) {
			int numi = char2int(s.charAt(i));

			if (i == (s.length() - 1)) {
				sum += numi;
			} else if (numi >= char2int(s.charAt(i + 1))) {
				sum += numi;
			} else {
				sum -= numi;
			}
		}
		return sum;
	}

	int char2int(char x) {
		int val = 0;
		switch (x) {
		case 'I':
			val = 1;
			break;
		case 'V':
			val = 5;
			break;
		case 'X':
			val = 10;
			break;
		case 'L':
			val = 50;
			break;
		case 'C':
			val = 100;
			break;
		case 'D':
			val = 500;
			break;
		case 'M':
			val = 1000;
			break;
		}
		return val;
	}
}
