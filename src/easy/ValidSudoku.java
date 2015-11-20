package easy;

import java.util.HashMap;

/**
 *Valid Sudoku should obey Three rules
 *1.every row 1-9 occur only zere or once  
 *2.every column 1-9 occur only zere or once  
 *3. every 9 sub-boxes of the grid  1-9 occur only zere or once  
 */

public class ValidSudoku {
	//'.' means empty
    public boolean isValidSudoku(char[][] board) {
    	if(board.length!=9||board[0].length!=9) return false;
    	for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			char key=board[i][j];
    			if(key=='.') continue;
    			
    		}
    	}
    	return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
