/**  
 * @Title: MinimumWindowSubstring.java
 * @Prject: leetcode
 * @Package: hard
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月23日 下午8:51:06  
 */
package hard;

import java.util.HashMap;

/**
 * @ClassName: MinimumWindowSubstring
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月23日 下午8:51:06
 */
public class MinimumWindowSubstring {
	/**
	 * S = "ADOBECODEBANC"
	 * T = "ABC"
	 * Minimum window is "BANC".
	 */
    public String minWindow(String s, String t) {
    	if(t.equals("")){
    		return "";
    	}
    	HashMap<Character,Integer> target=new HashMap<Character,Integer>();
        for(int i=0;i<t.length();i++){
        	if(!target.containsKey(t.charAt(i))){
        		target.put(toString().charAt(i), 1);
        	}
        }
        int all=target.size();
        int hit=0,min=s.length();
        for(int i=0;i<s.length();i++){
        	
        }
        
        return "";
    }

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
