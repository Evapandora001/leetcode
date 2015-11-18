package hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SubstringwithConcatenationofAllWords {
	
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new LinkedList<Integer>();
        int wordLen=words[0].length();
        int count=words.length;
        int length=wordLen*count;
        if(s.length()<length) return res;
        HashMap<String,Integer> wordCount=new HashMap<String,Integer>();//word:counts
        for(int i=0;i<words.length;i++){
        	if(wordCount.containsKey(words[i])){
        		wordCount.put(words[i],wordCount.get(words[i])+1);
        	}else{
        		wordCount.put(words[i],1);
        	}
        }
        for(int start=0;start<wordLen;start++){
        	HashMap<String, Integer> wordHit=new HashMap<String,Integer>();
        	int hit=0;
        	int index=start;
        	for(int i=start;index+length<=s.length()&&i+wordLen<=s.length();i+=wordLen){
        		String ele=s.substring(i,i+wordLen);
        		if(wordCount.containsKey(ele)){
        			if(wordHit.containsKey(ele)){
        				if(wordHit.get(ele)<wordCount.get(ele)){
        					wordHit.put(ele, wordHit.get(ele)+1);
        					hit++;
        				}else{
        					String temp="";
							while((temp=s.substring(index, index+wordLen)).equals(ele)==false){
        						wordHit.put(temp, wordHit.get(temp)-1);
        						hit--;
        						index+=wordLen;
        					}
        					index+=wordLen;
        				}
        			}else{
        				hit++;
        				wordHit.put(ele, 1);
        			}
					if(hit==count){
						res.add(index);
					}
        		}else{
        			index=i+wordLen;
        			wordHit.clear();
        			hit=0;
        		}
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		SubstringwithConcatenationofAllWords allWords=new SubstringwithConcatenationofAllWords();
		String s="barfoofoobarthefoobarman";
		String[] words ={"bar","foo","the"};
		System.out.println(allWords.findSubstring(s, words).toString());

	}
	
	/*
	 * For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"] each word has the same length

You should return the indices: [0,9].
	 */

}
