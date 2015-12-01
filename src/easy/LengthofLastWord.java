/**  
 * @Title: LengthofLastWord.java
 * @Prject: leetcode
 * @Package: easy
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月1日 下午11:11:57  
 */
package easy;

/**
 * @ClassName: LengthofLastWord
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月1日 下午11:11:57
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
    	if(s.length()==0||s.split(" ").length==0){
    		return 0;
    	}
    	int count=0;
    	boolean end=true;
    	for(int i=s.length()-1;i>=0;--i){
    		if(end&&s.charAt(i)==' '){
    			continue;
    		}
    		if(end){
    			end=false;
    		}
    		if(s.charAt(i)==' '){
    			break;
    		}
    		count++;
    	}
    	return count;
    }
	public static void main(String[] args) {
		LengthofLastWord a=new LengthofLastWord();
		System.out.println(a.lengthOfLastWord("  "));
	}

}
