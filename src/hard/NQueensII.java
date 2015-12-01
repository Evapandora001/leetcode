package hard;
/**
 * @ClassName: NQueensII
 * @Description: TODO
 * @author: lenovo
 * @date: 2015年12月1日 下午1:15:04
 */
public class NQueensII {
	public int total;
    public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int totalNQueens(int n) {
    	boolean[] rows=new boolean[n];
    	boolean[] cols=new boolean[n];
    	char[][] ele=new char[n][n];
    	int count=0;
    	setTotal(0);
    	countNQueens(rows,cols,count,ele);
    	return getTotal();
    }

	public void countNQueens(boolean[] rows, boolean[] cols, int count, char[][] ele) {
		if(count==rows.length){
			setTotal(getTotal()+1);
			return;
		}
		for(int i=0;i<rows.length;i++){
			int row=count;
			int col=i;
			if(rows[row]||cols[col]||isSameline(row,col,ele)) continue;
			rows[row]=true;
			cols[i]=true;
			ele[row][col]='Q';
			countNQueens(rows, cols, count+1, ele);
			rows[row]=false;
			cols[i]=false;
			ele[row][col]='.';
		}
	}
	
	public boolean isSameline(int row, int col,char[][] ele) {
		int line=row-1;
		int left=col-1;
		while(line>=0&&left>=0){
			if(ele[line][left]=='Q'){
				return true;
			}
			line--;
			left--;
		}
		line=row-1;
		int right=col+1;
		while(line>=0&&right<ele.length){
			if(ele[line][right]=='Q'){
				return true;
			}
			line--;
			right++;
		}
		return false;
	}
	public static void main(String[] args) {
		NQueensII a=new NQueensII();
		System.out.println(a.totalNQueens(0));
		System.out.println(a.totalNQueens(1));
		System.out.println(a.totalNQueens(2));
		System.out.println(a.totalNQueens(3));
		System.out.println(a.totalNQueens(4));
		System.out.println(a.totalNQueens(5));
		System.out.println(a.totalNQueens(6));
		System.out.println(a.totalNQueens(7));
		System.out.println(a.totalNQueens(8));
	}

}
