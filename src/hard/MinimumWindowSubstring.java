/**  
 * @Title: MinimumWindowSubstring.java
 * @Prject: leetcode
 * @Package: hard
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月23日 下午8:51:06  
 */
package hard;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;

import org.apache.log4j.Logger;

/**
 * @ClassName: MinimumWindowSubstring
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月23日 下午8:51:06
 */
public class MinimumWindowSubstring {
	Logger logger = Logger.getLogger(MinimumWindowSubstring.class.getName());
	/**
	 * S = "ADOBECODEBANC"
	 * T = "ABC"
	 * Minimum window is "BANC".
	 * Input:
"a"
"aa"
Output:
"a"
Expected:
""
	 * 
	 */
	
	//s 包含t 中所有元素即可， s=a t=aa  return a
//    public String minWindow(String s, String t) {
//    	if(t.equals("")){
//    		return "";
//    	}
//    	HashMap<Character,Integer> target=new HashMap<Character,Integer>();
//        for(int i=0;i<t.length();i++){
//        	if(!target.containsKey(t.charAt(i))){
//        		target.put(t.charAt(i),1);
//        	}
//        }
//    	if(target.size()==1){
//    		if(s.contains(t.charAt(0)+"")){
//    			return t.charAt(0)+"";
//    		}else{
//    			return "";
//    		}
//    	}
//        int[] cadidate=new int[s.length()];
//        HashMap<Character,Integer> hit=new HashMap<Character,Integer>();
//        int min=s.length(),start=0,insert=0,head=0,tail=0;
//        for(int i=0;i<s.length();i++){
//        	char ele=s.charAt(i);
//        	if(target.containsKey(ele)){
//        		if(hit.containsKey(ele)){//重复hit
//        			int old=hit.get(ele);
//        			if(old==start){
//        				start++;
//        				while(cadidate[start]==-1){
//        					start++;
//        				}
//        			}
//        			cadidate[old]=-1;//置成无效位数
//        			cadidate[insert]=i;
//        			hit.put(ele,insert);
//        			insert++;
//        		}else{
//        			cadidate[insert]=i;
//        			hit.put(ele,insert);
//        			insert++;
//        			if(hit.size()==target.size()){
//        				int len=i-cadidate[start]+1;
//        				if(len<min){
//        					min=len;
//        					head=cadidate[start];
//        					tail=i;
//        				}
//        				hit.remove(s.charAt(cadidate[start]));
//        				cadidate[start]=-1;
//        				start++;
//        				while(cadidate[start]==-1){
//        					start++;
//        				}
//        			}
//        		}
//        	}
//        }
//        if(head==tail){
//        	return "";
//        }
//        return s.substring(head, tail+1);
//    }

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		MinimumWindowSubstring a=new MinimumWindowSubstring();
		System.out.println(a.minWindow("ABC", "AC"));
		System.out.println(a.minWindow("AABBBBBBACBABBBBA", "A"));
		System.out.println(a.minWindow("AABBBBBBACBABBBBA", "ABAB"));
//		System.out.println(a.minWindow("a", "aaa"));
//		System.out.println(a.minWindow("", "abc"));
	}
	public String minWindow(String s, String t) {
    	if(t.equals("")||s.length()<t.length()){
    		return "";
    	}
    	if(s.equals(t)){
    		return s;
    	}
    	if(t.length()==1&&s.contains(t)){
    		return t;
    	}
    	HashMap<Character,Integer> target=new HashMap<Character,Integer>();
        for(int i=0;i<t.length();i++){
        	char key=t.charAt(i);
        	if(!target.containsKey(key)){
        		target.put(key,1);
        	}else{
        		target.put(key,target.get(key)+1);
        	}
        }
        int[] cadidate=new int[s.length()];
        HashMap<Character,LinkedList<Integer>> hit=new HashMap<Character,LinkedList<Integer>>();
        int min=s.length()+1,start=0,insert=0,head=0,tail=0,hitCount=0;//min 必须+1；输出最大可能是s本身
        boolean update=false;
        for(int i=0;i<s.length();i++){
        	char ele=s.charAt(i);
        	update=false;
        	if(target.containsKey(ele)){
        		if(hit.containsKey(ele)){//重复hit
        			LinkedList<Integer> value=hit.get(ele);
        			if(value.size()<target.get(ele)){//重复有效
        				hitCount++;
        				update=true;
        				value.add(insert);
        				hit.put(ele, value);
        				cadidate[insert]=i;
        				insert++;
        			}else{
        				int old=value.removeFirst();
        				if(old==start){
            				start++;
            				while(cadidate[start]==-1){
            					start++;
            				}
            			}
        				cadidate[old]=-1;//置成无效位数
            			cadidate[insert]=i;
            			value.add(insert);
            			hit.put(ele,value);
            			insert++;
        			}
        		}else{
        			cadidate[insert]=i;
        			LinkedList<Integer> value=new LinkedList<>();
        			value.add(insert);
        			hit.put(ele,value);
        			hitCount++;
        			update=true;
        			insert++;
        		}
        	}
        	logger.info(hitCount);
        	logger.info(Arrays.toString(cadidate));
        	if(update&&hitCount==t.length()){
				int len=i-cadidate[start]+1;
				if(len<min){
					min=len;
					head=cadidate[start];
					tail=i;
				}
				char key=s.charAt(cadidate[start]);
				LinkedList<Integer> value=hit.get(key);
				value.removeFirst();//去除顶点
				hitCount--;
				hit.put(key,value);
				cadidate[start]=-1;
				start++;//找到下一个有效位
				while(cadidate[start]==-1){
					start++;
				}
			}
        }
        if(head==tail){
        	return "";
        }
        return s.substring(head, tail+1);
    }

}
