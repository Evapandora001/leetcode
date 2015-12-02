/**  
 * @Title: MinimumPathSum.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月2日 下午10:26:23  
 */
package medium;

/**
 * @ClassName: MinimumPathSum
 * @Description: dynamic programming
 * @author: Evapandora
 * @date: 2015年12月2日 下午10:26:23
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
    	if(grid.length==0) return 0;
    	int m=grid.length,n=grid[0].length;
    	int[][] minSum=new int[m][n];
    	minSum[0][0]=grid[0][0];
    	for(int i=1;i<m;i++){
    		minSum[i][0]=minSum[i-1][0]+grid[i][0];
    	}
    	for(int i=1;i<n;i++){
    		minSum[0][i]=minSum[0][i-1]+grid[0][i];
    	}
    	for(int i=1;i<m;i++){
    		for(int j=1;j<n;j++){
    			minSum[i][j]=Integer.min(minSum[i-1][j],minSum[i][j-1])+grid[i][j];
    		}
    	}
    	
        return minSum[m-1][n-1];
    }
    
	public static void main(String[] args) {
		MinimumPathSum a=new MinimumPathSum();
		System.out.println(a.minPathSum(new int[][]{{1,2,3},{1,2,2},{0,0,1}}));
	}

}
