package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月30日 上午9:11:46
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	
	Do not allocate extra space for another array, you must do this in place with constant memory.
	
	For example,
	Given input array A = [1,1,2],
	
	Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesfromSortedArray {
	public static void main(String[] args) {
		int []A = {1,1,2};
		System.out.println(removeDuplicates(A));
	}

	public static int removeDuplicates(int[] A) {
		int len = A.length;
		if(len <= 0)
			return -1;
		int j = 0;
		for(int i=1;i<len;i++){
			if(A[j] == A[i])
				continue;
			else
				A[++j] = A[i];
		}
		return j+1;
	}
}
