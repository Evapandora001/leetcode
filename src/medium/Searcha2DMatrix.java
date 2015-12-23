/**  
 * @Title: Searcha2DMatrix.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月23日 下午3:18:42
 */
package medium;

/**
 * @ClassName: Searcha2DMatrix
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月23日 下午3:18:42
 */
public class Searcha2DMatrix {
	
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0){
        	return false;
        }
        int n=matrix[0].length;
        int left=0,right=m-1,mid=0;
        while(left<=right){
        	mid=(left+right)/2;
        	if(matrix[mid][0]==target){
        		return true;
        	}else{
        		if(matrix[mid][0]<target){
        			left=mid+1;
        		}else{
        			right=mid-1;
        		}
        	}
        }
        int row=right;
        if(row==-1) return false;
        left=0;
        right=n-1;
        while(left<=right){
        	mid=(left+right)/2;
        	if(matrix[row][mid]==target){
        		return true;
        	}else{
        		if(matrix[row][mid]<target){
        			left=mid+1;
        		}else{
        			right=mid-1;
        		}
        	}
        }
        return false;
    }

	public static void main(String[] args) {
		Searcha2DMatrix a=new Searcha2DMatrix();
		int[][] matrix={{1,3,5},{7,9,11}};
		System.out.println(a.searchMatrix(matrix, 3));
	}

}
