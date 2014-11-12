package leetcode;

public class CountandSay {
	public static void main(String[] args) {
		System.out.println(countAndSay(2));
	}
	public static String countAndSay(int n) {
		if(n <= 0)
			return null;
		String str = "1";
		int count = 1;
		for(int i=0;i<n-1;i++){
			StringBuilder builder = new StringBuilder();
			for(int j=0;j<str.length();j++){
				if(j<str.length()-1 && str.charAt(j)==str.charAt(j+1))
					count++;
				else{
					builder.append(count + "" + str.charAt(j));
					count = 1;
				}
			}
			str = builder.toString();
		}
		return str;
	}

}
