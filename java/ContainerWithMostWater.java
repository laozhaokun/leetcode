package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月7日 下午6:06:45
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container,
 *  such that the container contains the most water.
	Note: You may not slant the container.
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int area = 0;
		int i = 0, j = height.length - 1;
		while (i < j) {
			area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
			if (height[i] > height[j])
				j--;
			else
				i++;
		}
		return area;
	}
}
