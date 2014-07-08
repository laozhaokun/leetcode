package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月8日 上午8:40:41
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
	public static void main(String[] args) {
		String ret = longestCommonPrefix(new String[]{"a","b"});
		System.out.println(ret);
	}

	public static String longestCommonPrefix(String[] strs){
		int len = strs.length;
		if(len <= 0)
			return "";
		if(len == 1)
			return strs[0];
		int minlen = strs[0].length();
		String temp = strs[0];
		//找出一个长度最短的字符串
		for(int i=1;i<len;i++){
			if(strs[i].length() < minlen){
				minlen = strs[i].length();
				temp = strs[i];
			}
		}
		int i=0,j = 0;
		StringBuffer buf = new StringBuffer();
		while(j < temp.length()){
			for(i=0;i<strs.length;i++){
				if(strs[i].charAt(j) != temp.charAt(j))
					break;
			}
			if(i < len)
				break;
			buf.append(temp.charAt(j));
			j++;
		}
		return buf.toString();
	}
}
