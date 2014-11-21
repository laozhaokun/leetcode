package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:zhaohf@asiainfo.com
 * @date:2014年11月20日 下午7:47:00
 * @Description: TODO
 */
public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] S) {
		if (S == null)
			return null;
		Arrays.sort(S);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<List<Integer>> temp = new ArrayList<List<Integer>>();
		for (int i = S.length - 1; i >= 0; i--) {
			if (i == S.length - 1 || S[i] != S[i + 1] || temp.size() == 0) {
				temp = new ArrayList<List<Integer>>();
				for (int j = 0; j < list.size(); j++)
					temp.add(new ArrayList<Integer>(list.get(j)));
			}
			for (List<Integer> t : temp)
				t.add(0, S[i]);
			if (i == S.length - 1 || S[i] != S[i + 1]) {
				ArrayList<Integer> t = new ArrayList<Integer>();
				t.add(S[i]);
				temp.add(t);
			}
			for (List<Integer> t : temp) {
				list.add(new ArrayList<Integer>(t));
			}
		}
		list.add(new ArrayList<Integer>());
		return list;
	}
}
