package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@author:zhaohf@asiainfo.com
 *@date:2014年11月17日 下午3:01:20
 *@Description: TODO
 */
public class CombinationSumII {
	public static void main(String[] args) {
		List<List<Integer>> list = new CombinationSumII().combinationSum2(new int[]{10,1,2,7,6,1,5},8);
		for(List<Integer> li : list){
			for(Integer i : li)
				System.out.print(i + "\t");
			System.out.println();
		}
	}
    private List<Integer> list = new  ArrayList<Integer>();
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		if(num.length == 0)
			return result;
		Arrays.sort(num);
		dfs(num,target,0);
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
			if(i>index && candidates[i] == candidates[i-1])
				continue;
			list.add(candidates[i]);
			dfs(candidates,target-candidates[i],i+1);
			list.remove(list.size()-1);
		}
	}
}
