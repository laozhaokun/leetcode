package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月12日 上午9:53:29
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 */
public class ValidPalindrome {
	public static void main(String[] args) {
		isPalindrome("A man,a plan 5.");
	}
	public static boolean isPalindrome(String s) {
		if(s.isEmpty())
			return true;
		//过滤字母数字之外的字符
		StringBuffer buf = new StringBuffer();
		for(int i=0;i<s.length();i++){
			if(Character.isLetterOrDigit(s.charAt(i)))
				buf.append(s.charAt(i));
		}
		String tmp = buf.toString().toLowerCase();
		for(int i=0;i<tmp.length();i++){
			if(tmp.charAt(i) != tmp.charAt(tmp.length() - i - 1))
				return false;
		}
		return true;
	}
}
