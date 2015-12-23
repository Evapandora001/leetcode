/**  
 * @Title: SetMatrixZeroes.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月23日 下午12:30:31
 */
package medium;

import java.util.HashMap;

import javax.swing.text.StyledEditorKit.BoldAction;

/**
 * @ClassName: SetMatrixZeroes
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月23日 下午12:30:31
 */
public class SetMatrixZeroes {
	
    public void setZeroes(int[][] matrix) {
    	int m=matrix.length;
    	if(m==0){
    		return;
    	}
    	int n=matrix[0].length;
    	boolean[] col=new boolean[n];
    	boolean zero=false,flag=false;
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++){
    			if(!zero){
    				if(matrix[i][j]==0){
    					col[j]=true;
    					flag=true;
        			}
    			}else{
    				matrix[i][j]=0;//set current row to zero
    			}
    		}
    		if(flag){
    			zero=true;
				i--;//set current row to zero
				flag=false;
    		}else{
    			zero=false;
    		}
    	}
    	for(int j=0;j<n;j++){
    		if(!col[j]){
    			continue;
    		}
    		for(int i=0;i<m;i++){
    			matrix[i][j]=0;
    		}
    	}
    	return;
    }

	public static void main(String[] args) {
		SetMatrixZeroes a=new SetMatrixZeroes();
		int[][] matrix={{1,1,2},{1,1,4}};
		a.setZeroes(matrix);
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println();
		}
	}

}
