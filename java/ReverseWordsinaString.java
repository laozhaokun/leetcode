package leetcode;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 下午5:31:28
 * Given an input string, reverse the string word by word.
	For example,
	Given s = "the sky is blue",
	return "blue is sky the".
	Clarification:
	What constitutes a word?
	A sequence of non-space characters constitutes a word.
	Could the input string contain leading or trailing spaces?
	Yes. However, your reversed string should not contain leading or trailing spaces.
	How about multiple spaces between two words?
	Reduce them to a single space in the reversed string.
 */
public class ReverseWordsinaString {
	  public String reverseWords(String s) {
		  if(s.trim() == "")
			  return null;
	        String str[] = s.trim().split("\\s+");
	        StringBuilder sb = new StringBuilder();
	        int len = str.length;
	        for(int i=len-1;i>=0;i--){
	        	if(str[i] == " ")
	        		continue;
	        	sb.append(str[i]+" ");
	        }
	        return sb.toString().trim();
	    }

	  public static void main(String[] args) {
		  String ret = new ReverseWordsinaString().reverseWords("   a   b ");
		  String ret1 = new ReverseWordsinaString().reverseWords("the     sky is blue");
		  System.out.println(ret + "\n"+ ret1);
	}
}
