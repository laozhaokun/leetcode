package leetcode;

import java.util.ArrayList;
import java.util.List;


public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		for(int i=0;i<9;i++){
			List<Character> list = new ArrayList<Character>();
			for(int j=0;j<9;j++)
				list.add(board[i][j]);
			if(!isValid(list))
				return false;
		}
		for(int i=0;i<9;i++){
			List<Character> list = new ArrayList<Character>();
			for(int j=0;j<9;j++)
				list.add(board[j][i]);
			if(!isValid(list))
				return false;
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				List<Character> list = new ArrayList<Character>();
				for(int k=0;k<3;k++){
					for(int l=0;l<3;l++){
						list.add(board[i*3+k][j*3+l]);
					}
				}
				if(!isValid(list))
					return false;
			}
		}
		return true;
	}
	private boolean isValid(List<Character> list){
		for(Character ch : list){
			if(ch != '.')
				if(list.indexOf(ch) != list.lastIndexOf(ch))
					return false;
		}
		return true;
	}
}
