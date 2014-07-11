package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月11日 下午2:09:21
 */
public class PalindromePartitioning {
	
	public static void main(String[] args) {
		List<List<String>> list = partition1("cdd");
		for(List<String> li : list){
			for(String l : li)
				System.out.print(l + "\t");
			System.out.println();
		}
		System.out.println(list.size());
	}

	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		ArrayList<String> r = new ArrayList<String>();
		int length = s.length();
		boolean[][] map = new boolean[length][length];
		findPartition(s, 0, ret, r, map);
		return ret;
	}

	private void findPartition(String s, int start,
			ArrayList<ArrayList<String>> ret, ArrayList<String> r,
			boolean[][] map) {
		int length = s.length();
		if (start == length && r.size() != 0) {
			ArrayList<String> clone = new ArrayList<String>(r);
			ret.add(clone);
		} else {
			for (int j = start; j < length; j++) {
				if (start == j
						|| (j - start > 1 && s.charAt(start) == s.charAt(j) && map[start + 1][j - 1])
						|| (j - start == 1 && s.charAt(start) == s.charAt(j))) {
					map[start][j] = true;
					r.add(s.substring(start, j + 1));
					findPartition(s, j + 1, ret, r, map);
					r.remove(r.size() - 1);
				}
			}
		}
	}
	public static List<List<String>> partition1(String s) {
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> li = new ArrayList<String>();
		int len = s.length();
		if(len == 0)
			return list;
		for(int i=0;i<len;i++){
			li.add(s.charAt(i)+"");
		}
		list.add(li);
		if(len == 1)
			return list;
		List<String> li1 = new ArrayList<String>();
		boolean flag = false;
		for(int i=0;i<len;i++){
			for(int j=i+1;j<len;j++){
				String sub = s.substring(i, j+1);
				if(isPalindrome(sub)){
					flag = true;
					li1.add(sub);
				}
			}
		}
		if(flag)
			list.add(li1);
		return list;
	}
	public static boolean isPalindrome(String s){
		int len = s.length();
		if(len <= 1)
			return true;
		for(int i=0;i<len;i++){
			if(s.charAt(i) != s.charAt(len - i - 1))
				return false;
		}
		return true;
	}
}
