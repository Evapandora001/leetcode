package hard;

import java.util.Arrays;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
    	int count=0;
    	boolean[][] row=new boolean[9][9];
    	boolean[][] column=new boolean[9][9];
    	boolean[][] grids=new boolean[9][9];
    	for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			char key=board[i][j];
    			if(key=='.'){
    				count++;
    				continue;
    			}
    			int grid=i/3*3+j/3;
    			row[key-'1'][i]=true;
    			column[key-'1'][j]=true;
    			grids[key-'1'][grid]=true;
    		}
    	}
    	sudoku(row,column,grids,count,board);
    }

	public void sudoku(boolean[][] row, boolean[][] column, boolean[][] grids, int count, char[][] board) {
		if(count==0) return;
		for(int num=0;num<9;num++){
			for(int i=0;i<9;i++){
				if(row[num][i]==true) continue;
				for(int j=0;j<9;j++){
					if(column[num][j]==true) continue;
					int grid=i/3*3+j/3;
					if(grids[num][grid]==true) continue;
					//get a valid insert-position
					row[num][i]=true;
					column[num][j]=true;
					grids[num][grid]=true;
					board[i][j]=(char) (num+'1');
					System.out.println(i+"#"+j+"#"+board[i][j]);
					count--;
					sudoku(row, column, grids, count, board);
				}
			}
		}
	}

	public static void main(String[] args) {
		SudokuSolver a=new SudokuSolver();
		char[][] board=new char[][]{".9748....".toCharArray(),"7........".toCharArray(),".2.1.9...".toCharArray(),
			"..7...24.".toCharArray(),".64.1.59.".toCharArray(),".98...3..".toCharArray(),
			"...8.3.2.".toCharArray(),"........6".toCharArray(),"...2759..".toCharArray()};
			a.solveSudoku(board);
			for(int i=0;i<9;i++){
				System.out.println(Arrays.toString(board[i]));
			}
	}

}
