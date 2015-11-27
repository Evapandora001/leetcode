package hard;

import java.util.Arrays;

/**
 * '?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 *
 */
public class WildcardMatching {

	public static void main(String[] args) {
		WildcardMatching a=new WildcardMatching();
		System.out.println(a.isMatch("aa","a"));
		System.out.println(a.isMatch("aa","ab?"));
		System.out.println(a.isMatch("aa","a?"));
		System.out.println(a.isMatch("aa","aa?"));
		System.out.println(a.isMatch("ab","?*"));
		System.out.println(a.isMatch("abc","c*abc"));
		System.out.println(a.isMatch("abc","a*"));
		System.out.println(a.isMatch("abcbd","a*bd"));
		System.out.println(a.isMatch("abcb","a*bd"));
	}
	
    public boolean isMatch(String s, String p) {
    	if(p.equals("*")) return true;
    	boolean[][] match=new boolean[s.length()+1][p.length()+1];
    	match[0][0]=true;
    	for(int i=0;i<=s.length();i++){
    		for(int j=1;j<=p.length();j++){
    			if(p.charAt(j-1)!='*'){
    				match[i][j]=(i>0)&&match[i-1][j-1]&&(p.charAt(j-1)=='?'||s.charAt(i-1)==p.charAt(j-1));
    			}else{
    				if(i==0&&j==1) match[0][1]=true;
    				match[i][j]=(match[i][j-1])// * means empty
    						||(i>0&&match[i-1][j]);//* covers 1 or more character
    			}
    		}
    	}
    	return match[s.length()][p.length()];
    }

}
