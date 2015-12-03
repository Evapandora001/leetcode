/**  
 * @Title: PlusOne.java
 * @Prject: leetcode
 * @Package: easy
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月3日 上午11:13:02
 */
package easy;

import java.util.Arrays;

/**
 * @ClassName: PlusOne
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月3日 上午11:13:02
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
    	if(digits.length==0) return new int[]{1};
        int[] res=new int[digits.length+1];
        for(int i=digits.length-1;i>=0;--i){
        	digits[i]=digits[i]+1;
        	if(digits[i]>=10){
        		digits[i]=digits[i]-10;
        		res[i+1]=digits[i];
        	}else{
        		return digits;
        	}
        }
        res[0]=1;
        return res;
    }
    
	public static void main(String[] args) {
		PlusOne a=new PlusOne();
		System.out.println(Arrays.toString(a.plusOne(new int[]{})));
		System.out.println(Arrays.toString(a.plusOne(new int[]{9})));
		System.out.println(Arrays.toString(a.plusOne(new int[]{1,9,9})));
	}

}
