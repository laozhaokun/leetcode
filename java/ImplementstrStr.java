package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月16日 上午8:48:21 Implement strStr().
 * 
 *          Returns a pointer to the first occurrence of needle in haystack, or
 *          null if needle is not part of haystack.
 */
public class ImplementstrStr {
	public static void main(String[] args) {
		String str = strStr("mabdabc", "abc");
		System.out.println(str);
	}

	public static String strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return null;
		}
		int i, j;
		for (i = 0; i < haystack.length() - needle.length() + 1; i++) {
			for (j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j))
					break;
			}
			if (j == needle.length())
				return haystack.substring(i);
		}
		return null;
	}
}
