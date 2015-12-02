/**  
 * @Title: UniquePaths.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月2日 下午12:15:09
 */
package medium;

/**
 * @ClassName: UniquePaths
 * @Description: Dynamic Programming
 * @author: Evapandora
 * @date: 2015年12月2日 下午12:15:09
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
    	if(m==1||n==1) return 1;
        int[][] pathNum=new int[m][n];
        for(int i=0;i<m;i++){
        	pathNum[i][0]=1;
        }
        for(int i=0;i<n;i++){
        	pathNum[0][i]=1;
        }
        for(int i=1;i<m;i++){
        	for(int j=1;j<n;j++){
        		pathNum[i][j]=pathNum[i-1][j]+pathNum[i][j-1];
        	}
        }
        return pathNum[m-1][n-1];
    }
    
	public static void main(String[] args) {
		UniquePaths a=new UniquePaths();
		System.out.println(a.uniquePaths(3,3));

	}

}
