package medium;

import java.util.Arrays;

public class RotateImage {
	/**
	 * @param matrix
	 * 方阵瞬时间旋转90 相当于 先 转置，然后 按行 reverse 
	 *  n*n方阵      (i,j)---顺时针90°-->(j,       n-1-i)
	 *  					   ---顺时针90°-->(n-1-i,n-1-j)
	 *  					   ---顺时针90°-->(n-1-j,i)
	 *  				       ---顺时针90°-->(i,       j)
	 */
	
	/*
	 * 一步到位
		int n = matrix.size();
		for(int i = 0; i < n/2; ++i)
			for(int j = i; j < n-1-i; ++j){
				int t = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = t;
			}
	 */
    public void rotate(int[][] matrix) {
    	int temp=0;
    	// transposition
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<i;j++){
        		temp=matrix[i][j];
        		matrix[i][j]=matrix[j][i];
        		matrix[j][i]=temp;
        	}
        }
        // reverse row by row
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix.length/2;j++){
        		temp=matrix[i][j];
        		matrix[i][j]=matrix[i][matrix.length-1-j];
        		matrix[i][matrix.length-1-j]=temp;
        	}
        }
    }

	public static void main(String[] args) {
		int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		(new RotateImage()).rotate(matrix);
		for(int i=0;i<matrix.length;i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

}
