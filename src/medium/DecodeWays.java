/**  
 * @Title: DecodeWays.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月22日 下午3:16:56
 */
package medium;

import java.util.Arrays;

/**
 * @ClassName: DecodeWays
 * @Description: 注意不可解码的非法情况 数字0的不合理出现
 * @author: Evapandora
 * @date: 2016年2月22日 下午3:16:56
 */
public class DecodeWays {
	
	public int numDecodings(String s) {
        if(s.length()==0||s.charAt(0)=='0'){
        	return 0;
        }
        if(s.length()==1){
        	return 1;
        }
        int ways[]=new int[s.length()+1];
        ways[0]=1;
        ways[1]=1;
        char pre=s.charAt(0),ele;
        for(int i=1;i<s.length();i++){
        	ele=s.charAt(i);
        	if((pre=='1')||(pre=='2'&&ele>='0'&&ele<='6')){
        		if(ele=='0'){
        			ways[i+1]=ways[i-1];
        		}else{
        			ways[i+1]=ways[i]+ways[i-1];
        		}
        	}else{
        		if(ele=='0'){
        			ways[i+1]=0;
        		}else{
        			ways[i+1]=ways[i];
        		}
        	}
        	pre=ele;
        }
//        System.out.println(Arrays.toString(ways));
        return ways[s.length()];
    }

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		DecodeWays a=new DecodeWays();
		System.out.println(a.numDecodings(""));
		System.out.println(a.numDecodings("0"));
		System.out.println(a.numDecodings("18"));
		System.out.println(a.numDecodings("28"));
		System.out.println(a.numDecodings("1271012"));
	}

}
