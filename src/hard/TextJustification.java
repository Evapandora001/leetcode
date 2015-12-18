/**  
 * @Title: TextJustification.java
 * @Prject: leetcode
 * @Package: hard
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月3日 下午1:39:22
 */
package hard;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: TextJustification
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月3日 下午1:39:22
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> res=new LinkedList<String>();
    	int len=0;
    	int count=0;
    	LinkedList<String> line=new LinkedList<String>();
    	String ele="";
    	for(int i=0;i<words.length;i++){
    		String word=words[i].trim();
//    		if(word.equals("")){//no need maxWidth can be zero
//    			continue;
//    		}
    		if(len==0){
    			len=word.length();
    			count++;
    			line.add(word);
    			continue;
    		}
    		if(len+1+word.length()<=maxWidth){
    			len+=1+word.length();
    			count++;
    			line.add(word);
    		}else{
    			if(count==1){
    				ele=words[i-1]+space(maxWidth-len);
    			}else{
    				int extraSpace=maxWidth-len;
        			int even=extraSpace/(count-1);//while divide, zero must be considered!
        			int extra=extraSpace%(count-1);
        			Iterator<String> iterator=line.iterator();
        			while(iterator.hasNext()){
        				ele+=iterator.next();
        				count--;
        				if(count!=0){
        					int spaceNum=even+1;
        					if(extra!=0){
        						spaceNum++;
        						extra--;
        					}
        					ele+=space(spaceNum);
        				}
        			}
    			}
    			res.add(ele);
    			line.clear();
    			len=0;
    			count=0;
    			ele="";
    			i--;
    		}
    	}
    	if(line.size()!=0){
    		Iterator<String> iterator=line.iterator();
			while(iterator.hasNext()){
				ele+=iterator.next();
				count--;
				if(count!=0){
					ele+=" ";
				}
			}
			ele+=space(maxWidth-len);
			res.add(ele);
    	}
        return res;
    }
	/**
	 * @Title: space
	 * @Description: space generate
	 * @param spaceNum
	 * @return: String
	 */
	public String space(int spaceNum) {
		String res="";
		while(spaceNum!=0){
			res+=" ";
			spaceNum--;
		}
		return res;
	}
	public static void main(String[] args) {
		TextJustification a=new TextJustification();
		String[] words={""};
		int maxWidth=0;
		for(String ele:a.fullJustify(words, maxWidth)){
			System.out.println(ele);
		}

	}

}
