package leetcode;

import java.util.ArrayList;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月10日 上午10:22:18
 * 
 *          Given an array and a value, remove all instances of that value in
 *          place and return the new length. The order of elements can be
 *          changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
	public static int removeElement(int[] A, int elem) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] == elem)
				continue;
			list.add(A[i]);
		}
		for (int i = 0; i < list.size(); i++)
			A[i] = list.get(i);
		return list.size();
	}

	public static void main(String[] args) {
		removeElement(new int[] { 4, 5 }, 4);
	}
}
