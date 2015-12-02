/**  
 * @Title: UniquePathsII.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月2日 下午10:07:17  
 */
package medium;

/**
 * @ClassName: UniquePathsII
 * @Description: dynamic programming
 * @author: Evapandora
 * @date: 2015年12月2日 下午10:07:17
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1) return 0;
        int[][] pathNum=new int[m][n];
        pathNum[0][0]=1;
        for(int i=1;i<m;i++){
        	if(obstacleGrid[i][0]==0){
        		pathNum[i][0]=pathNum[i-1][0];
        	}else{
        		pathNum[i][0]=0;
        	}
        }
        for(int i=1;i<n;i++){
        	if(obstacleGrid[0][i]==0){
        		pathNum[0][i]=pathNum[0][i-1];
        	}else{
        		pathNum[0][i]=0;
        	}
        }
        for(int i=1;i<m;i++){
        	for(int j=1;j<n;j++){
        		if(obstacleGrid[i][j]==1){
        			pathNum[i][j]=0;
        			continue;
        		}
        		pathNum[i][j]=pathNum[i-1][j]+pathNum[i][j-1];
        	}
        }
        return pathNum[m-1][n-1];
    }
    
	public static void main(String[] args) {
		UniquePathsII a=new UniquePathsII();
		System.out.println(a.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,0,0},{0,0,1}}));

	}

}
