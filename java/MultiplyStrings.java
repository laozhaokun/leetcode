package leetcode;

/**
 * @author:zhaohf@asiainfo.com
 * @date:2014年11月18日 下午3:30:00
 * @Description: TODO
 */
public class MultiplyStrings {
	public static void main(String[] args) {
		String ret = new MultiplyStrings().multiply("12","12");
		System.out.println(ret);
	}
	public String multiply(String num1, String num2) {
		if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
			return "";
		if(num1.charAt(0) == '0' || num2.charAt(0) == '0')
			return "0";
		int num = 0;
		StringBuilder builder = new StringBuilder();
		for(int i=num1.length() + num2.length();i>0;i--){
			for(int j=Math.min(i-1,num1.length());j>0;j--){
				if(i - j <= num2.length())
					num += (int)(num1.charAt(j-1)-'0') * (int)(num2.charAt(i-1-j)-'0');
			}
			if(i != 1 || num >0)
				builder.append(num%10);
			num /= 10;
		}
		return builder.reverse().toString();
	}
}
