/**  
 * @Title: ClimbingStairs.java
 * @Prject: leetcode
 * @Package: easy
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月3日 下午12:42:57
 */
package easy;

/**
 * @ClassName: ClimbingStairs
 * @Description: 2====>  (0) 2 & 1 1
 * @author: Evapandora
 * @date: 2015年12月3日 下午12:42:57
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
    	if(n==0) return 0;
    	if(n==1) return 1;
    	if(n==2) return 2;
    	int[] step=new int[n+1];
    	step[1]=1;
    	step[2]=2;
    	for(int i=3;i<=n;i++){
    		step[i]=step[i-1]+step[i-2];
    	}
    	return step[n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
