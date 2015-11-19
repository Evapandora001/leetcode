package hard;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
    	if(s.length()==0) return 0;
    	int start=0,end=s.length()-1;
    	while(start<s.length()&&s.charAt(start)!='(') start++;
    	while(end>=0&&s.charAt(end)!=')') end--;
    	if(end<=start) return 0;
    	int maxLen=0;
    	for(int i=start;i<=end;i++){
    		if(s.charAt(i)!='(') continue;
    		int len=0,lCount=0,rCount=0;
    		for(int j=i;j<=end;j++){
        		char ele=s.charAt(j);
        		if(ele=='('){
        			lCount++;
        		}else{
        			if(rCount<lCount){
        				rCount++;
        				if(lCount==rCount){
        					len=lCount*2;
        				}
        			}else{
        				if(len>maxLen) maxLen=len;
        				break;
        			}
        		}
    		}
    		if(len>maxLen) maxLen=len;
    	}
        return maxLen;
    }

	public static void main(String[] args) {
		LongestValidParentheses a=new LongestValidParentheses();
//		System.out.println(a.longestValidParentheses(")()())"));
//		System.out.println(a.longestValidParentheses("))())(((()))"));
		System.out.println(a.longestValidParentheses(""));
//		System.out.println(a.longestValidParentheses("("));
//		System.out.println(a.longestValidParentheses(")"));
	}

}
