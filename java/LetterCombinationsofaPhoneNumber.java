package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月21日 下午3:42:19
 * Given a digit string, return all possible letter combinations that the number could represent.
 */
public class LetterCombinationsofaPhoneNumber {
	public static void main(String[] args) {
		List<String> list = letterCombinations("23");
		for (String li : list)
			System.out.println(li);
	}

	static final HashMap<Character, String> map = new HashMap<Character, String>() {
		{
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
		}
	};

	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		res.add("");

		for (int i = 0; i < digits.length(); i++) {
			List<String> tmp = new ArrayList<String>();
			for (String str : res) {
				String letters = map.get(digits.charAt(i));
				for (int j = 0; j < letters.length(); j++)
					tmp.add(str + letters.charAt(j));
			}
			res = tmp;
		}
		return res;
	}
}
