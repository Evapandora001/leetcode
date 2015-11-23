package easy;

/**
 *Valid Sudoku should obey Three rules
 *1.every row 1-9 occur only zere or once  
 *2.every column 1-9 occur only zere or once  
 *3. every 9 sub-boxes of the grid  1-9 occur only zere or once  
 */
/*
 * O(n^2)
 */
public class ValidSudoku {
	//'.' means empty
    public boolean isValidSudoku(char[][] board) {
    	if(board==null||board.length!=9||board[0].length!=9) return false;
    	boolean[][] arrow=new boolean[9][9];
    	boolean[][] column=new boolean[9][9];
    	boolean[][] grids=new boolean[9][9];
    	for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			char key=board[i][j];
    			if(key=='.') continue;
    			int grid=i/3*3+j/3;
    			if(arrow[key-'1'][i]||column[key-'1'][j]||grids[key-'1'][grid]){//由于个数少，通过位置判断 是否存在，而不需要O(n)查找
    				return false;
    			}else{
    				arrow[key-'1'][i]=true;
    				column[key-'1'][j]=true;
    				grids[key-'1'][grid]=true;
    			}
    		}
    	}
    	return true;
    }

}
