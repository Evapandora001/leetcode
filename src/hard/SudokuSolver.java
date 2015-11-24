package hard;

import java.util.Arrays;
import java.util.Stack;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
    	boolean[][] rows=new boolean[9][9];
    	boolean[][] columns=new boolean[9][9];
    	boolean[][] grids=new boolean[9][9];
    	Stack<Integer> rowNum=new Stack<Integer>();
    	Stack<Integer> colNum=new Stack<Integer>();
    	for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			char key=board[i][j];
    			if(key=='.'){
    				rowNum.push(i);
    				colNum.push(j);
    				continue;
    			}
    			int grid=i/3*3+j/3;
    			rows[key-'1'][i]=true;
    			columns[key-'1'][j]=true;
    			grids[key-'1'][grid]=true;
    		}
    	}
    	sudoku(rows,columns,grids,rowNum,colNum,board);
    }

	private boolean sudoku(boolean[][] rows, boolean[][] columns, boolean[][] grids, Stack<Integer> rowNum,
			Stack<Integer> colNum, char[][] board) {
		if(rowNum.size()==0){
			return true;//仅有唯一的解 提前结束
		}
		int row=rowNum.pop();
		int col=colNum.pop();
		int grid=row/3*3+col/3;
		for(int num=0;num<9;num++){//-遍历所有情况
			if(rows[num][row]||columns[num][col]||grids[num][grid])	continue;
			board[row][col]=(char)(num+'1');
			rows[num][row]=true;
			columns[num][col]=true;
			grids[num][grid]=true;
			if(sudoku(rows, columns, grids, rowNum, colNum, board))
				return true;
			//恢复现场---回溯
			rows[num][row]=false;
			columns[num][col]=false;
			grids[num][grid]=false;
		}
		//恢复现场--回溯
		rowNum.push(row);
		colNum.push(col);
		return false;
	}


	public static void main(String[] args) {
		SudokuSolver a=new SudokuSolver();
		char[][] board=new char[][]{"53..7....".toCharArray(),"6..195...".toCharArray(),".98....6.".toCharArray(),
			"8...6...3".toCharArray(),"4..8.3..1".toCharArray(),"7...2...6".toCharArray(),
			".6....28.".toCharArray(),"...419..5".toCharArray(),"....8..79".toCharArray()};
			for(int i=0;i<9;i++){
				System.out.println(Arrays.toString(board[i]));
			}
			a.solveSudoku(board);
			for(int i=0;i<9;i++){
				System.out.println(Arrays.toString(board[i]));
			}
	}

}
