package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * @ClassName: NQueens
 * @Description: 任两个皇后都不能处于同一条横行、纵行或斜线上
 * @author: lenovo
 * @date: 2015年12月1日 上午11:13:08
 */
public class NQueens {
	
//    public List<List<String>> solveNQueens(int n) {
//    	List<List<String>> res=new ArrayList<List<String>>();
//    	ArrayList<String> ele=new ArrayList<>();
//    	boolean[] rows=new boolean[n];
//    	boolean[] cols=new boolean[n];
//    	int count=0;
//    	nQueens(rows,cols,count,ele,res);
//    	return res;
//    }
//
//	public void nQueens(boolean[] rows, boolean[] cols, int count, ArrayList<String> ele, List<List<String>> res) {
//		if(count==rows.length){
//			res.add(new ArrayList<String>(ele));
//			return;
//		}
//		for(int i=0;i<rows.length;i++){
//			int row=count;
//			int col=i;
//			if(rows[row]||cols[col]||isSameline(rows.length,row,col,ele)) continue;
//			rows[row]=true;
//			cols[i]=true;
//			ele.add(getQ(i,rows.length));
//			nQueens(rows, cols, count+1, ele, res);
//			rows[row]=false;
//			cols[i]=false;
//			ele.remove(ele.size()-1);
//		}
//	}
//	public String getQ(int hit, int length) {
//		String s="";
//		for(int i=0;i<length;i++){
//			if(i==hit){
//				s+='Q';
//			}else{
//				s+='.';
//			}
//		}
//		return s;
//	}
//
///**
// * @Title: isSameline
// * @Description: 判断斜线上有没有Queen
// * @param n
// * @param row
// * @param col
// * @param ele
// * @return
// * @return: boolean
// */
//	public boolean isSameline(int n,int row, int col,ArrayList<String> ele) {
//		int line=row-1;
//		int left=col-1;
//		while(line>=0&&left>=0){
//			if(ele.get(line).charAt(left)=='Q'){
//				return true;
//			}
//			line--;
//			left--;
//		}
//		line=row-1;
//		int right=col+1;
//		while(line>=0&&right<n){
//			if(ele.get(line).charAt(right)=='Q'){
//				return true;
//			}
//			line--;
//			right++;
//		}
//		return false;
//	}

	public static void main(String[] args) {
		NQueens a=new NQueens();
		List<List<String>> res=a.solveNQueens(4);
		System.out.println(res.size());
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i).toString());
		}
	}
	
    public List<List<String>> solveNQueens(int n) {
    	List<List<String>> res=new ArrayList<List<String>>();
    	char[][] ele=new char[n][n];
    	for(int i=0;i<n;i++){
    		for(int j=0;j<n;j++){
    			ele[i][j]='.';
    		}
    	}
    	boolean[] rows=new boolean[n];
    	boolean[] cols=new boolean[n];
    	int count=0;
    	nQueens(rows,cols,count,ele,res);
    	return res;
    }

	public void nQueens(boolean[] rows, boolean[] cols, int count, char[][] ele, List<List<String>> res) {
		if(count==rows.length){
			ArrayList<String> a=new ArrayList<>();
			for(int i=0;i<ele.length;i++){
				a.add(new String(ele[i]));
			}
			res.add(a);
			return;
		}
		for(int i=0;i<rows.length;i++){
			int row=count;
			int col=i;
			if(rows[row]||cols[col]||isSameline(row,col,ele)) continue;
			rows[row]=true;
			cols[i]=true;
			ele[row][col]='Q';
			nQueens(rows, cols, count+1, ele, res);
			rows[row]=false;
			cols[i]=false;
			ele[row][col]='.';
		}
	}
/**
 * @Title: isSameline
 * @Description: 判断斜线上有没有Queen
 * @param n
 * @param row
 * @param col
 * @param ele
 * @return
 * @return: boolean
 */
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

}
