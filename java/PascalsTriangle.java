package leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月12日 上午10:11:56
 * Given numRows, generate the first numRows of Pascal's triangle.
	For example, given numRows = 5,
	Return
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]
 */
public class PascalsTriangle {
	public static void main(String[] args) {
		List<List<Integer>> list = generate(5);
		for(List<Integer> li : list){
			for(Integer i : li)
				System.out.print(i+"\t");
			System.out.println();
		}
	}

	public static List<List<Integer>> generate1(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(numRows < 1)
			return list;
		for(int i=0;i<numRows;i++){
			List<Integer> li = new ArrayList<Integer>();
			for(int j=0;j<=i;j++){
				if(j == 0)
					li.add(1);
				else if(j < i){
					int num = list.get(i - 1).get(j - 1) + list.get(i - 1).get(j);
					li.add(num);
				}else if(j == i)
					li.add(1);
			}
			list.add(li);
		}
		return list;
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (numRows < 1)
			return list;
		for (int i = 0; i < numRows; i++) {
			List<Integer> li = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				li.add(Integer.valueOf(cnk(i, j) + ""));
			}
			list.add(li);
		}
		return list;
	}

	//求组合数
	public static BigInteger cnk(int n, int k) {
		BigInteger fenzi = new BigInteger("1");
		BigInteger fenmu = new BigInteger("1");
		for (int i = n - k + 1; i <= n; i++) {
			String s = Integer.toString(i);
			BigInteger stobig = new BigInteger(s);
			fenzi = fenzi.multiply(stobig);
		}
		for (int j = 1; j <= k; j++) {
			String ss = Integer.toString(j);
			BigInteger stobig2 = new BigInteger(ss);
			fenmu = fenmu.multiply(stobig2);
		}
		BigInteger result = fenzi.divide(fenmu);
		return result;
	}
}
