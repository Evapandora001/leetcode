/**  
 * @Title: WordSearch.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月26日 下午2:43:19  
 */
package medium;

/**
 * @ClassName: WordSearch
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月26日 下午2:43:19
 */
public class WordSearch {
	
	
    public boolean exist(char[][] board, String word) {
    	if(board.length==0){
    		if(word.equals("")){
    			return true;
    		}else{
    			return false;
    		}
    	}
    	int total=board.length*board[0].length;
    	if(total<word.length()){
    		return false;
    	}
    	boolean[][] use=new boolean[board.length][board[0].length];
    	boolean flag=false;
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[0].length;j++){
    			if(board[i][j]==word.charAt(0)){
    				use[i][j]=true;
    				flag=backtracing(i,j, use, word.substring(1), board);
    				if (flag) {
						return true;
					}
    				use[i][j]=false;
    			}
    		}
    	}
    	return false;
    }

	/**
	 * @Title: backtracing
	 * @Description: TODO
	 * @param i
	 * @param use
	 * @param word
	 * @param board
	 * @return
	 * @return: boolean
	 */
	private boolean backtracing(int i,int j, boolean[][] use, String word, char[][] board) {
		if(word.length()==0){
			return true;
		}
		if(i-1>=0&&use[i-1][j]==false&&board[i-1][j]==word.charAt(0)){//up
			use[i-1][j]=true;
			if(backtracing(i-1, j, use, word.substring(1), board)){
				return true;
			}
			use[i-1][j]=false;
		}
		if(i+1<board.length&&use[i+1][j]==false&&board[i+1][j]==word.charAt(0)){//down
			use[i+1][j]=true;
			if(backtracing(i+1, j, use, word.substring(1), board)){
				return true;
			}
			use[i+1][j]=false;
		}
		if(j-1>=0&&use[i][j-1]==false&&board[i][j-1]==word.charAt(0)){//left
			use[i][j-1]=true;
			if(backtracing(i, j-1, use, word.substring(1), board)){
				return true;
			}
			use[i][j-1]=false;
		}
		if(j+1<board[0].length&&use[i][j+1]==false&&board[i][j+1]==word.charAt(0)){//right
			use[i][j+1]=true;
			if(backtracing(i, j+1, use, word.substring(1), board)){
				return true;
			}
			use[i][j+1]=false;
		}
		return false;
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		WordSearch a=new WordSearch();
		char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(a.exist(board,"ABCCED"));
		System.out.println(a.exist(board,"SEE"));
		System.out.println(a.exist(board,"ABB"));
	}

}
