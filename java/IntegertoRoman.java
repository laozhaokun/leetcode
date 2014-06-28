package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月28日 下午7:25:01
 * Given an integer, convert it to a roman numeral.
	Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegertoRoman {
	public static void main(String[] args) {
		intToRoman(1403);
//		System.out.println(d + "\t" + dd+ "\t" + ddd+ "\t" + dddd);
//		System.out.println(buf.toString());
	}
	public static String intToRoman(int num) {
		StringBuffer buf = new StringBuffer();
		int dddd = num / 1000;
		int ddd = num % 1000 / 100;
		int dd = num % 1000 % 100 / 10;
		int d = num % 1000 % 100 % 10;
		for(int i=0;i<dddd;i++)
			buf.append("M");
		
		if(ddd == 1)
			buf.append("C");
		else if(ddd == 2)
			buf.append("CC");
		else if(ddd == 3)
			buf.append("CCC");
		else if(ddd == 4)
			buf.append("CD");
		else if(ddd == 5)
			buf.append("D");
		else if(ddd == 6)
			buf.append("DC");
		else if(ddd == 7)
			buf.append("DCC");
		else if(ddd == 8)
			buf.append("DCCC");
		else if(ddd == 9)
			buf.append("CM");
		
		if(dd == 1)
			buf.append("X");
		else if(dd == 2)
			buf.append("XX");
		else if(dd == 3)
			buf.append("XXX");
		else if(dd == 4)
			buf.append("XL");
		else if(dd == 5)
			buf.append("L");
		else if(dd == 6)
			buf.append("LX");
		else if(dd == 7)
			buf.append("LXX");
		else if(dd == 8)
			buf.append("LXXX");
		else if(dd == 9)
			buf.append("XC");
		
		if(d == 1)
			buf.append("I");
		else if(d == 2)
			buf.append("II");
		else if(d == 3)
			buf.append("III");
		else if(d == 4)
			buf.append("IV");
		else if(d == 5)
			buf.append("V");
		else if(d == 6)
			buf.append("VI");
		else if(d == 7)
			buf.append("VII");
		else if(d == 8)
			buf.append("VIII");
		else if(d == 9)
			buf.append("IX");
		return buf.toString();
	}
}
