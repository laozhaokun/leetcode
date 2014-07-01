package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月1日 上午10:08:14
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

	You may assume no duplicates in the array.
	
	Here are few examples.
	[1,3,5,6], 5 → 2
	[1,3,5,6], 2 → 1
	[1,3,5,6], 7 → 4
	[1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] test = {1,3,5,6};
		System.out.println(searchInsert(test,0));
	}
	public static int searchInsert(int[] A, int target) {
		int index = -1;
		for(int i=0;i<A.length;i++){
			if(A[i] == target)
				return i;
		}
		for(int i=0;i<A.length;i++){
			if(A[0] > target)
				return 0;
			else if(A[A.length -1] < target)
				return A.length;
			else if(A[i] < target && A[i+1] > target)
				return i+1;
		}
		return index;
	}
}
