package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月12日 上午10:57:32
 * Given an index k, return the kth row of the Pascal's triangle.

	For example, given k = 3,
	Return [1,3,3,1].
	
	Note:
	Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {
	public static void main(String[] args) {
		List<Integer> li = getRow(4);
		for(Integer i : li)
			System.out.print(i+"\t");
	}

	public static List<Integer> getRow(int rowIndex) {
		if (rowIndex < 0)
			return null;

		List<Integer> result = new ArrayList<Integer>(rowIndex + 1);
		result.add(1);

		for (int i = 1; i <= rowIndex; i++) {
			int temp1 = 1;
			for (int j = 1; j < i; j++) {
				int temp2 = result.get(j); 
				result.set(j, temp1 + temp2);
				temp1 = temp2;
			}
			result.add(1); 
		}

		return result;
	}
}
