package leetcode;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月3日 下午12:09:49
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
	public static void main(String[] args) {
		boolean f = isPalindrome(212);
		System.out.println(f);
	}

	public static boolean isPalindrome(int x) {
		int reverse = 0,temp = Math.abs(x);
		while( x != 0 )
		   {
		      reverse = reverse * 10;
		      reverse = reverse + x%10;
		      x = x/10;
		   }
		return reverse == temp;
	}

	public static boolean isPalindrome1(int x) {
		if(x / 10 == 0 && x >= 0)
			return true;
		String str = x + "";
		char ch[] = str.toCharArray();
		for(int i=0;i<ch.length / 2;i++){
			if(ch[i] != ch[ch.length - i - 1])
				return false;
		}
		return true;
	}
}
