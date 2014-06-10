package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月10日 上午10:49:19 
 * Follow up for "Remove Duplicates": What
 *          if duplicates are allowed at most twice?
 * 
 *          For example, Given sorted array A = [1,1,1,2,2,3],
 * 
 *          Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesfromSortedArrayII {
	public static int removeDuplicates(int[] A) {
		LinkedHashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
		for (int i = 0; i < A.length; i++) {
			if (map.containsKey(A[i])){
				map.put(A[i], map.get(A[i]) + 1);
				System.out.println("A[" + i + "] = " + A[i]);
			}
			else{
				map.put(A[i], 1);
				System.out.println("A[" + i + "] = " + A[i]);
			}
		}
		System.err.println("------------------");
		for (Map.Entry<Integer,Integer> m : map.entrySet()){
			System.out.print( "," + m.getKey() + "\t + " +  m.getValue()+ "\n");
		}
		int sum=0;
		for (Map.Entry<Integer,Integer> m : map.entrySet()){
			if(m.getValue() >2)
				sum += 2;
			else
				sum += m.getValue();
			System.out.print("sum = " + sum + "," + m.getKey() + "\t + " +  m.getValue()+ "\n");
		}
		System.err.println("------------------");
			int i=0;
			for (Map.Entry<Integer,Integer> m : map.entrySet()){
				if(m.getValue() > 1){
					int temp = A[i++] = m.getKey();
					System.out.println("i = " + i + " A[i] = " + A[i]);
					A[i] = temp;
					System.out.println("i+1 = " + (i+1) + " A[i+1] = " + A[i+1]);
				}else{
					A[i] = m.getKey();
					System.out.println("else i = " + i + " A[i] = " + A[i]);
				}
				i++;
			}
		for(int j=0;j<sum;j++)
			System.out.print(A[j] + "\t\n");
		return sum;
	}
	public static int removeDuplicates1(int[] A) {
		LinkedHashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
		for (int i = 0; i < A.length; i++) {
			if (map.containsKey(A[i])){
				map.put(A[i], map.get(A[i]) + 1);
				System.out.println("A[" + i + "] = " + A[i]);
			}
			else{
				map.put(A[i], 1);
				System.out.println("A[" + i + "] = " + A[i]);
			}
		}
		System.err.println("------------------");
		for (Map.Entry<Integer,Integer> m : map.entrySet()){
			System.out.print( "," + m.getKey() + "\t + " +  m.getValue()+ "\n");
		}
		int sum=0;
		for (Map.Entry<Integer,Integer> m : map.entrySet()){
			if(m.getValue() >2)
				sum += 2;
			else
				sum += m.getValue();
			System.out.print("sum = " + sum + "," + m.getKey() + "\t + " +  m.getValue()+ "\n");
		}
		System.err.println("------------------");
			int i=0;
			for (Map.Entry<Integer,Integer> m : map.entrySet()){
				if(m.getValue() > 1){
					int temp = A[i++] = m.getKey();
					System.out.println("i = " + i + " A[i] = " + A[i]);
					A[i] = temp;
					System.out.println("i+1 = " + (i+1) + " A[i+1] = " + A[i+1]);
				}else{
					A[i] = m.getKey();
					System.out.println("else i = " + i + " A[i] = " + A[i]);
				}
				i++;
			}
		for(int j=0;j<sum;j++)
			System.out.print(A[j] + "\t\n");
		return sum;
    }
	public static void main(String[] args) {
		int ret = removeDuplicates1(new int[]{-1,0,0,0,0,3,3});
		System.out.println("------------------");
		System.out.println("A.length = " + ret);
	}
}
