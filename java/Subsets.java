package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:zhaohf@asiainfo.com
 * @date:2014年11月20日 下午6:15:31
 * @Description: TODO
 */
public class Subsets {

	public List<List<Integer>> subsets(int[] S) {
		if (S == null)
			return null;
		Arrays.sort(S);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(new ArrayList<Integer>());
		for (int s : S)
			helper(list, s);
		return list;
	}

	public void helper(List<List<Integer>> lists, int val) {
		for (int i = 0; i < lists.size(); i++) {
			List<Integer> tmp = new ArrayList<Integer>(lists.get(i));
			tmp.add(val);
			lists.add(tmp);
		}
	}
}
