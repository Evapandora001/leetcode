/**  
 * @Title: SimplifyPath.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月18日 下午4:08:31  
 */
package medium;

import java.util.Stack;

/**
 * @ClassName: SimplifyPath
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月18日 下午4:08:31
 */
public class SimplifyPath {
	/**
	 * 
For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
/.====>/       /..+====>/    
	 */
	
    public String simplifyPath(String path) {
    	String res="";
    	Stack<String> pathStack=new Stack<String>();
    	int start=0;
    	int end=0;
    	while((end=path.indexOf("/",start))!=-1){
    		String ele=path.substring(start,end+1);
    		if(ele.equals("./")){
    			;
    		}else{
    			if(ele.equals("../")){
        			if(pathStack.isEmpty()||pathStack.peek().equals("../")){
        				pathStack.push(ele);
        			}else{
        				if(pathStack.peek().equals("/")){
            				;
            			}else{
            				pathStack.pop();
            			}
        			}
        		}else{
        			pathStack.push(ele);
        		}
    		}
    		end++;
    		while(end<path.length()&&path.charAt(end)=='/'){
    			end++;
    		}
    		start=end;
    	}
    	if(start<path.length()){
    		String tail=path.substring(start);
    		if(tail.equals(".")){
    			;
    		}else{
    			if(tail.equals("..")){
    				if(pathStack.isEmpty()||pathStack.peek().equals("../")){
        				pathStack.push(tail);
        			}else{
        				if(pathStack.peek().equals("/")){
            				;
            			}else{
            				pathStack.pop();
            			}
        			}
        		}else{
        			pathStack.push(tail);
        		}
    		}
    	}
    	while(pathStack.isEmpty()==false){
    		res=pathStack.pop()+res;
    	}
    	if(res.length()>1&&res.charAt(res.length()-1)=='/'){
    		res=res.substring(0,res.length()-1);
    	}
        return res;
    }

	public static void main(String[] args) {
		SimplifyPath a=new SimplifyPath();
//		System.out.println(a.simplifyPath(""));
//		System.out.println(a.simplifyPath("/"));
//		System.out.println(a.simplifyPath("/////"));
//		System.out.println(a.simplifyPath("/home/"));
//		System.out.println(a.simplifyPath("/a/./b/../../c/"));
		System.out.println(a.simplifyPath("/../......"));
		System.out.println(a.simplifyPath("/../."));
		System.out.println(a.simplifyPath("/../.."));
		System.out.println(a.simplifyPath("/home//foo/."));
		System.out.println(a.simplifyPath("/home//foo/.."));
		System.out.println(a.simplifyPath("/home//foo/..."));
//		System.out.println(a.simplifyPath("/home//foo/"));
//		System.out.println(a.simplifyPath("..//..//"));

	}

}
