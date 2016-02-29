/**  
 * @Title: WordLadder.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月26日 上午10:12:48
 */
package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @ClassName: WordLadder
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月26日 上午10:12:48
 */
public class WordLadder {
	
	public boolean hit(String a, String b){
		if(a.equals(b)){
			return true;
		}
        for(int i=0; i<a.length(); i++){
        	if(a.charAt(i)!=b.charAt(i)){
        		if(i==a.length()-1 || a.substring(i+1).equals(b.substring(i+1))){
        			return true;
        		}else{
        			return false;
        		}
        	}
        }
        return true;
    }

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		LinkedList<Integer> res=new LinkedList<Integer>();
		res.add(4);
		res.add(3);
		res.add(2);
		res.add(1);
		System.out.println(res.toString());
		
//		res.remove(2);
//		res.remove(1);
		res.remove(1);
		System.out.println(res.toString());
		ArrayList<ArrayList<Integer>> res2=new ArrayList<ArrayList<Integer>>();
		
	}
	
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue=new LinkedList<String>();
        int level=0;
        queue.add(beginWord);
        while(!queue.isEmpty()){
        	level++;
            int len=queue.size();
            while((len--)!=0){
                char[] ele=queue.poll().toCharArray();
                for(int i=0; i<ele.length; i++){
                    char original=ele[i];
                    for(int j=0; j<26; j++){
                        ele[i]=(char)('a'+j);
                        String newEle=new String(ele);
                        if(newEle.equals(endWord)){
                            return level+1;
                        }
                        if(wordList.contains(newEle)){
                            queue.add(newEle);
                            wordList.remove(newEle);
                        }
                        ele[i]=original;
                    }
                }
            }
        }
        return 0;
    }
	
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> preRes=new LinkedList<List<String>>();
        List<List<String>> curRes=new LinkedList<List<String>>();

        List<String> element=new ArrayList<String>();
        element.add(beginWord);
        preRes.add(element);
        
        boolean finished=false;

        while(preRes.size()!=0){
            for(List<String> preList : preRes){
                String s=preList.get(preList.size()-1);
                char[] ele=s.toCharArray();
                for(int i=0; i<ele.length; i++){
                    char original=ele[i];
                    for(int j=0; j<26; j++){
                        ele[i]=(char)('a'+j);
                        String newEle=new String(ele);
                        if(newEle.equals(endWord)){
                            List<String> newList=new ArrayList<String>(preList);
                            newList.add(endWord);
                            curRes.add(newList);
                            finished=true;
                        }
                        if(wordList.contains(newEle)){
                            List<String> newList=new ArrayList<String>(preList);
                            newList.add(newEle);
                            wordList.remove(newEle);
                            curRes.add(newList);
                        }
                    }
                    ele[i]=original;
                }
                
            }
            if(finished){
                return curRes;
            }
            preRes.clear();
            preRes.addAll(curRes);
            curRes.clear();
        }
        return curRes;
    }
	
}
