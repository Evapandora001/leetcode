 package hard;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
    	if(s.length()==0) return 0;
    	if((s.contains("(")&&s.contains(")"))==false) return 0; 
    	int start=0,end=s.length()-1;
    	while(s.charAt(start)!='(') start++;
    	while(end>start&&s.charAt(end)!=')') end--;
    	if(end==start) return 0;
    	int maxLen=0;
    	Stack<Integer> left=new Stack<Integer>();
    	left.push(start);
    	for(int i=start+1;i<=end;i++){
    		if(s.charAt(i)=='('){
    			left.push(i);
    		}else{
    			if(left.isEmpty()){
    				while(i<end&&s.charAt(i)!='(') i++;
    				left.push(i);
    				start=i;
    			}else{
    				left.pop();
    				if(left.isEmpty()){
    					if(maxLen<i-start+1) maxLen=i-start+1;
    				}else{
    					if(maxLen<i-left.peek()) maxLen=i-left.peek();//match to the pre-(
    				}
    			}
    		}

    	}
        return maxLen;
    }

	public static void main(String[] args) {
		LongestValidParentheses a=new LongestValidParentheses();
		System.out.println(a.longestValidParentheses(")()()(()))"));
		System.out.println(a.longestValidParentheses("))())(((()))"));
		System.out.println(a.longestValidParentheses(""));
		System.out.println(a.longestValidParentheses("("));
		System.out.println(a.longestValidParentheses(")"));
	}

}
