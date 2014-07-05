package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月5日 上午8:46:33
 * Given a string S, find the longest palindromic substring in S.
 *  You may assume that the maximum length of S is 1000, 
 *  and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String ret = longestPalindrome("vvdsdfabccba");
		System.out.println(ret);
	}

	public static String longestPalindrome(String s) {
		if (s.length() <= 1) 
			return s;

		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}

			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest;
	}

	public static String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1
				&& s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}
	//找出所有子串，并判断是否是回文串，每次记录长度
	public static String longestPalindrome1(String s) {
		String ret = "";
		int maxlen = 0;
		for(int i=0;i<s.length();i++){
			for(int j=i+1;j<s.length();j++){
				String temp = s.substring(i,j+1);
				int len = j - i;
				if(isPalindrome(temp)){
					if(len > maxlen){
						ret = temp;
						maxlen = len;
					}
				}
			}
		}
		return ret;
	}
	public static boolean isPalindrome(String s){
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;
	}
}
