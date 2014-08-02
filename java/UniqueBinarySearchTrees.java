package leetcode;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年8月2日 下午2:08:43
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

	For example,
	Given n = 3, there are a total of 5 unique BST's.
	
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
 */
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if(n == 1 || n == 0)
			return 1;
		else{
			int num = 0;
			for(int i=1;i<=n;i++)
				num += numTrees(i - 1) * numTrees(n - i);
			return num;
		}
	}
}
