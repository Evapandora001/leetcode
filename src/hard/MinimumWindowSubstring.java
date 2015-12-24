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
import java.util.TreeMap;

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
    	if(t.length()==1){
    		if(s.contains(t)){
    			return t;
    		}else{
    			return "";
    		}
    	}
    	HashMap<Character,Integer> target=new HashMap<Character,Integer>();
        for(int i=0;i<t.length();i++){
        	if(!target.containsKey(t.charAt(i))){
        		target.put(toString().charAt(i), target.size());
        	}
        }
        TreeMap<Character,Integer> hit=new TreeMap<Character,Integer>();
        int min=s.length(),start=0,end=0;
        for(int i=0;i<s.length();i++){
        	char ele=s.charAt(i);
        	if(target.containsKey(ele)){
        		if(hit.containsKey(ele)){//重复hit
        			hit.put(ele,i);
        		}else{
        			hit.put(ele,i);
        			if(hit.size()==target.size()){
        				int len=i;
        			}
        		}
        	}
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
