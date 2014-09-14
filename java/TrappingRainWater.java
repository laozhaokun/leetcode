package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年9月13日 下午8:00:42
 */
public class TrappingRainWater {
	public static void main(String[] args) {
		int sum = trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
		System.out.println(sum);
	}

	public static int trap(int[] A){
		int len = A.length;
		if(len <= 2)
			return 0;
		int higest = A[0],high_index = 0;
		for(int i=0;i<len;i++){
			int tmp = A[i];
			if(higest < tmp){
				higest = A[i];
				high_index = i;
			}
		}
		int sum = 0;
		int maxl = A[0],maxr = A[len-1];
		for(int i=0;i<high_index;i++){
			if(A[i] > maxl)
				maxl = A[i];
			else
				sum += maxl - A[i];
		}
		for(int i=len-1;i>high_index;i--){
			if(A[i] >maxr)
				maxr = A[i];
			else
				sum += maxr-A[i];
		}
		return sum;
	}
}
