package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月9日 下午3:34:46
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

	For example, given
	s = "leetcode",
	dict = ["leet", "code"].
	
	Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		boolean flag = wordBreak("leetcode",dict);
		System.out.println(flag);
	}

	//dp[i] 代表 字符串(j,i)能被分词否
	public static boolean wordBreak(String s, Set<String> dict) {
		int length = s.length();
		boolean[] dp = new boolean[length + 1];
		dp[0] = true;
		for (int i = 1; i <= length; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[length];
	}

	public static boolean wordBreak1(String s, Set<String> dict) {
		if(dict.size() <= 0)
			return false;
		int len = s.length();
		if(len <= 0)
			return true;
		boolean flag = false;
		for(int i=1;i<=len;i++){
			String tmp = s.substring(0, i);
			if(dict.contains(tmp)){
				if(tmp.length() == len)
					return true;
			}
			flag = wordBreak(s.substring(i),dict);
		}
		return flag;
	}
}
