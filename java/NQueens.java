package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public static void main(String[] args) {
		List<String[]> result = new NQueens().solveNQueens(5);
		for(String[] li:result){
			for(String str : li){
				System.out.println(str);
			}
			System.out.println("----------------");
		}
	}
	public List<String[]> solveNQueens(int n) {
		List<String[]> result = new ArrayList<String[]>();
		List<Integer> cols = new ArrayList<Integer>();
		if(n <= 0)
			return result;
		search(result,cols,n);
		return result;
	}
	public void search(List<String[]> result,List<Integer> cols,int n){
		if(cols.size() == n){
			result.add(draw(cols));
			return;
		}
		for(int col=0;col<n;col++){
			if(!isValid(cols,col))
				continue;
			cols.add(col);
			search(result,cols,n);
			cols.remove(cols.size()-1);
		}
	}
	
	public String[] draw(List<Integer> cols){
		String[] chess = new String[cols.size()];
		for(int i=0;i<chess.length;i++){
			chess[i] = "";
			for(int j=0;j<cols.size();j++){
				if(j==cols.get(i))
					chess[i] += "Q";
				else
					chess[i] += ".";
			}
		}
		return chess;
	}
	public boolean isValid(List<Integer> cols,int col){
		int row = cols.size();
		for(int i=0;i<row;i++){
			if(cols.get(i) == col)
				return false;
			if(i - cols.get(i) == row - col)
				return false;
			if(i+cols.get(i) == row+col)
				return false;
		}
		return true;
	}
}
