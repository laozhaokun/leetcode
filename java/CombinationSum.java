package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:zhaohf@asiainfo.com
 * @date:2014年11月13日 下午7:53:20
 * @Description: TODO
 */
public class CombinationSum {
	private List<Integer> list = new  ArrayList<Integer>();
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if(candidates.length == 0)
			return result;
		Arrays.sort(candidates);
		dfs(candidates,target,0);
		return result;
	}
	public void dfs(int[] candidates,int target,int index){
		if(target < 0)
			return;
		if(target == 0){
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i=index;i<candidates.length;i++){
			if(i>0 &&candidates[i] == candidates[i-1])
				continue;
			list.add(candidates[i]);
			dfs(candidates,target-candidates[i],i);
			list.remove(list.size()-1);
		}
	}
}
