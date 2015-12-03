/**  
 * @Title: Sqrtx.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月3日 下午12:50:18
 */
package medium;

/**
 * @ClassName: Sqrtx
 * @Description: 必须考虑越界情况  注意+ *
 * @author: Evapandora
 * @date: 2015年12月3日 下午12:50:18
 */
public class Sqrtx {

    public int mySqrt(int x) {
        if(x<=0) return 0;
        int left=0,right=x;
        while(left<=right){
        	int mid=(left+right)/2;
        	if((double)(mid)*(double)(mid)>=Integer.MAX_VALUE){
        		right=mid-1;
        		continue;
        	}
        	int temp=mid*mid;
        	if(temp==x) return mid;
        	if(temp<x){
        		left=mid+1;
        	}else{
        		right=mid-1;
        	}
        }
        return left-1;
    }
    
	public static void main(String[] args) {
		Sqrtx a=new Sqrtx();
		System.out.println(a.mySqrt(2147395599));
		System.out.println(a.mySqrt(2147483647));
		System.out.println(a.mySqrt(9));
		System.out.println(a.mySqrt(10));
		System.out.println(a.mySqrt(11));
		System.out.println(a.mySqrt(12));
		System.out.println(a.mySqrt(13));
		System.out.println(a.mySqrt(14));
		System.out.println(a.mySqrt(15));
		System.out.println(a.mySqrt(16));
	}

}
