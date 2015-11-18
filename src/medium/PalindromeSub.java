package medium;


/**
 *最长回文子串
 */
public class PalindromeSub {
    public String longestPalindrome(String s) {
    	int max=1,start=0;
    	boolean p[][]=new boolean[s.length()][s.length()];
    	for(int i=0;i<s.length();i++){
    		p[i][i]=true;
    	}
    	for(int i=0;i<s.length()-1;i++){
    		if(s.charAt(i+1)==s.charAt(i)){
    			p[i][i+1]=p[i][i];
    			start=i;
    			max=2;
    		}
    	}
    	
    	for(int len=3;len<=s.length();len++){//最大回文子串 为 自己本身
    		for(int i=0;i<=s.length()-len;i++){
    			if(s.charAt(i)==s.charAt(i+len-1)&&p[i+1][i+len-2]){
    				p[i][i+len-1]=true;
    				max=len;
    				start=i;
    			}
    		}
    	}
    	
    	return s.substring(start, start+max);
    }


	public static void main(String[] args) {
		PalindromeSub a=new PalindromeSub();
		System.out.println(a.longestPalindrome("ccc"));
	}

}
