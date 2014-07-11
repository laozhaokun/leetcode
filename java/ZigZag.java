package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月6日 下午2:39:37
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
	
	P   A   H   N
	A P L S I I G
	Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	Write the code that will take a string and make this conversion given a number of rows:
	
	string convert(string text, int nRows);
	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZag {
	public String convert(String s, int nRows) {
		if (nRows <= 1)
			return s;
		StringBuffer buf = new StringBuffer();
		int period = 2 * nRows - 2;
		for (int i = 0; i < nRows; i++) {
			for (int j = i; j < s.length(); j += period) {
				buf.append(s.charAt(j));
				if (i != 0 && i != nRows - 1 && j + period - 2 * i < s.length())
					buf.append(s.charAt(j + period - 2 * i));
			}
		}
		return buf.toString();
	}

}