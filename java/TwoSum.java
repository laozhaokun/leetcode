package leetcode;

import java.util.HashMap;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月6日 下午5:55:44
 * Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) 
are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
public class TwoSum {
	
	//Time Limit Exceeded
	public int[] twoSum1(int[] numbers, int target) {
		int[] ret = new int[2];
		for (int j = numbers.length-1; j >= 0; j--) {
			for (int i = 0; i < numbers.length && i<j; i++) {
				if (numbers[i] + numbers[j] == target) {
					ret[0] = i+1;
					ret[1] = j+1;
					break;
				}
			}
		}
		return ret;
	}
	
	public int[] twoSum(int[] numbers, int target){
		int[] ret = new int[2];
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<numbers.length;i++){
			Integer n = map.get(target - numbers[i]);
			if(n == null)
				map.put(numbers[i], i);
			if(n != null && n < i){
				ret[0] = n+1;
				ret[1] = i+1;
				break;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] input = { 3, 2, 4 ,1,6};
		int target = 5;
		int[] ret = new TwoSum().twoSum(input, target);
		for (int i = 0; i < ret.length; i++) {
			System.out.println("index" + i + " = " + ret[i]);
		}
	}
}
