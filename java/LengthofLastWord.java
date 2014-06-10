package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月10日 上午10:06:33
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
	If the last word does not exist, return 0.
	
	Note: A word is defined as a character sequence consists of non-space characters only.
	
	For example, 
	Given s = "Hello World",
	return 5.
 */
public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		if(s.trim().equals(""))
			return 0;
        String[] str = s.split("\\s+");
        int len = str.length;
        return str[len-1].length();
    }
	public static void main(String[] args) {
		int ret = new LengthofLastWord().lengthOfLastWord("");
		System.out.println(ret);
	}
}
