package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月23日 下午7:46:28
 * Given an array of integers, every element appears twice except for one. Find that single one.
	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
	public static void main(String[] args) {
		int a[] = {2,2,4,3,3};
		singleNumber(a);
	}
	public int singleNumber1(int[] A) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<A.length;i++){
			if(map.get(A[i]) != null)
				map.put(A[i], map.get(A[i])+ 1);
			else
				map.put(A[i], 1);
		}
		for(Map.Entry<Integer,Integer> m : map.entrySet())
			if(m.getValue() == 1)
				return m.getKey();
		return -1;
	}
	
	public static  int singleNumber(int[] A) {
		int temp = 0;
		for(int i=0;i<A.length;i++){
			System.out.println("temp = " + temp + "\tA[" + i + "]=" + A[i]);
			temp ^= A[i];
			System.out.println("temp = " + temp + "\n------------------");
		}
		return temp;
	}
}
