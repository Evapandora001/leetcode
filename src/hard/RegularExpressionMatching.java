package hard;

public class RegularExpressionMatching {
	/**
	 * @param s 字符串s
	 * @param p 正则表达式p
	 * @return
	 * @Algorithm DP
	 */
    public boolean isMatch(String s, String p) {
    	boolean[][] dp=new boolean[s.length()+1][p.length()+1];
    	dp[0][0]=true;//s p all empty ,true
    	for(int i=0;i<=s.length();i++){//when s empty,match is possible
    		for(int j=1;j<=p.length();j++){//when p empty,only s empty  match
    			char regex=p.charAt(j-1);//current p to be matched
    			if(regex!='*'){
    				//current p match current s   p-1 match s-1
    				dp[i][j]=(i>=1)&&(dp[i-1][j-1])&&(regex=='.'||regex==s.charAt(i-1));
    			}else{
    				dp[i][j]=((j>=2)&&dp[i][j-2])//* means appear 0 times
    						||((i>=1)&&dp[i-1][j]&&(p.charAt(j-2)=='.'||p.charAt(j-2)==s.charAt(i-1)));//* means appear 1 more times
    			}
    			
    		}
    	}
    	return dp[s.length()][p.length()];
    }

	public static void main(String[] args) {
		RegularExpressionMatching a=new RegularExpressionMatching();
		System.out.println(a.isMatch("", "."));
		System.out.println(a.isMatch("", ".*"));
		System.out.println(a.isMatch("aab", "a*b"));
		System.out.println(a.isMatch("b", "a*ab"));
		System.out.println(a.isMatch("abc", ".*"));
	}

}
