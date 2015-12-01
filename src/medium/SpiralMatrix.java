package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: SpiralMatrix
 * @Description: recursion
 * @author: Evapandora
 * @date: 2015年12月1日 下午4:01:09
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> res=new LinkedList<Integer>();
    	if(matrix==null||matrix.length==0) return res;
    	walkSpiralOrder(0,0,matrix.length,matrix[0].length,matrix,res);
    	return res;
    }

	public boolean walkSpiralOrder(int startRow,int startCol, int m, int n, int[][] matrix, List<Integer> res) {
		if(m==0||n==0) return true;
		if(m==1){
			for(int i=0;i<n;i++){
				res.add(matrix[startRow][startCol+i]);
			}
			return true;
		}
		if(n==1){
			for(int i=0;i<m;i++){
				res.add(matrix[startRow+i][startCol]);
			}
			return true;
		}
		//-->
		for(int i=0;i<n;i++){
			res.add(matrix[startRow][startCol+i]);
		}
		//↓
		for(int i=1;i<m;i++){
			res.add(matrix[startRow+i][startCol+n-1]);
		}
		//<--
		for(int i=n-2;i>=0;i--){
			res.add(matrix[startRow+m-1][startCol+i]);
		}
		//↑
		for(int i=m-2;i>=1;i--){
			res.add(matrix[startRow+i][startCol]);
		}
		if(walkSpiralOrder(startRow+1, startCol+1, m-2, n-2, matrix, res)){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		SpiralMatrix a=new SpiralMatrix();
		System.out.println(a.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}).toString());
		System.out.println(a.spiralOrder(new int[][]{{1,2,3,4,5},{6,7,8,9,10}}).toString());
	}

}
