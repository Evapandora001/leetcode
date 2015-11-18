package medium;

import java.util.HashMap;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
    	int max=0,count=0,startValue=0;
    	HashMap<Character, Integer> sub=new HashMap<Character,Integer>();
    	for(int i=0;i<s.length();i++){
    		if(sub.containsKey(s.charAt(i))&&sub.get(s.charAt(i))>=startValue){
    			if(max<count){
    				max=count;
    			}
    			startValue=sub.get(s.charAt(i))+1;
    			count=i-sub.get(s.charAt(i));
    			sub.put(s.charAt(i),i);
    		}else{
    			count++;
    			sub.put(s.charAt(i),i);
    			}
    	}
		if(max<count){
			max=count;
		}
        return max;
    }

	public static void main(String[] args) {
		LongestSubString a=new LongestSubString();
		System.out.println(a.lengthOfLongestSubstring("abc"));
		System.out.println(a.lengthOfLongestSubstring("abcdb123"));
		System.out.println(a.lengthOfLongestSubstring("aaaaabaaa"));

	}

}
