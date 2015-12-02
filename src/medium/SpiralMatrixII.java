/**  
 * @Title: SpiralMatrixII.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月2日 上午8:51:03
 */
package medium;

import java.util.Arrays;

/**
 * @ClassName: SpiralMatrixII
 * @Description: Array
 * @author: Evapandora
 * @date: 2015年12月2日 上午8:51:03
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        if(n==0) return res;
        int end=n*n+1;
        int count=1;
        int startRow=0,startCol=0,row=n,col=n;
        while(count!=end){
        	//--->
        	for(int i=0;i<col;i++){
        		res[startRow][startCol+i]=count;
        		count++;
        	}
        	//↓
        	for(int i=1;i<row;i++){
        		res[startRow+i][startCol+col-1]=count;
        		count++;
        	}
        	//<---
        	for(int i=col-2;i>=0;i--){
        		res[startRow+row-1][startCol+i]=count;
        		count++;
        	}
        	//↑
        	for(int i=row-2;i>=1;i--){
        		res[startRow+i][startCol]=count;
        		count++;
        	}
        	row=row-2;
        	col=col-2;
        	startRow=startRow+1;
        	startCol=startCol+1;
        }
        return res;
    }

	public static void main(String[] args) {
		SpiralMatrixII a=new SpiralMatrixII();
		int[][] res=a.generateMatrix(3);
		for(int i=0;i<res.length;i++){
			System.out.println(Arrays.toString(res[i]));
		}
	}

}
