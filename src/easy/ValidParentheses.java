package easy;

import java.util.Stack;
//'(', ')', '{', '}', '[' and ']'
public class ValidParentheses {
    public boolean isValid(String s) {
    	Stack<Integer> a=new Stack<Integer>();
    	Stack<Integer> b=new Stack<Integer>();
    	Stack<Integer> c=new Stack<Integer>();
    	for(int i=0;i<s.length();i++){
    		char now=s.charAt(i);
    		switch (now) {
			case '(':a.push(i);break;
			case '{':b.push(i);break;
			case '[':c.push(i);break;
			case ')':{
				if(a.isEmpty()) return false;
				int o=a.pop();
				int p=b.isEmpty()?-1:b.peek();
				int q=c.isEmpty()?-1:c.peek();
				if(!(o>p&&o>q))	return false;
				break;
			}
			case '}':{
				if(b.isEmpty()) return false;
				int o=b.pop();
				int p=a.isEmpty()?-1:a.peek();
				int q=c.isEmpty()?-1:c.peek();
				if(!(o>p&&o>q))	return false;
				break;
			}
			case ']':{
				if(c.isEmpty()) return false;
				int o=c.pop();
				int p=b.isEmpty()?-1:b.peek();
				int q=a.isEmpty()?-1:a.peek();
				if(!(o>p&&o>q))	return false;
				break;
			}
			}
    	}
        if(a.isEmpty()&&b.isEmpty()&&c.isEmpty()){
        	return true;
        }
        return false;
    }

	public static void main(String[] args) {
		ValidParentheses a=new ValidParentheses();
		System.out.println(a.isValid("{{{"));
		System.out.println(a.isValid("{[(})}"));
		System.out.println(a.isValid("{[]}{}[]"));
		System.out.println(a.isValid("{[()]}"));
	}

}
