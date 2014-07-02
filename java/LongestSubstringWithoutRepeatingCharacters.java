package leetcode;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月2日 上午10:54:22
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		int n = lengthOfLongestSubstring("abcabcbb");
		System.out.println(n);
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int maxlen = 1;
		boolean[] flag = new boolean[256];
		int start = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (flag[ch]) {
				maxlen = Math.max(maxlen, i - start);
				for (int j = start; j < i; j++) {
					if (s.charAt(j) == ch) {
						start = j + 1;
						break;
					}
					flag[s.charAt(j)] = false;
				}
			} else
				flag[ch] = true;
		}
		return Math.max(maxlen, s.length() - start);
	}
}
