/**  
 * @Title: PalindromePartitioning.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年3月1日 上午9:47:11
 */
package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: PalindromePartitioning
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年3月1日 上午9:47:11
 */
public class PalindromePartitioning {
	
	public List<List<String>> partition(String s) {
        List<List<String>> res=new LinkedList<List<String>>();
        List<String> ele=new LinkedList<String>();
        backtrace(s, ele, res);
        return res;
    }
    
    public void backtrace(String s, List<String> ele, List<List<String>> res){
        if(s == null || s.length()==0){
            res.add(new LinkedList<String>(ele));
            return;
        }
        for(int i=0; i<s.length();i++){
            if(isPalindrome(s.substring(0 , i+1))){
                ele.add(s.substring(0 , i+1));
                backtrace(s.substring(i+1), ele, res);
                ele.remove(ele.size()-1);
            }
        }
    }
    

	private boolean isPalindrome(String s) {
		int left=0, right=s.length()-1;
		while(left<right){
			if(s.charAt(left) != s.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		PalindromePartitioning a=new PalindromePartitioning();
		List<List<String>> res=a.partition("");
		for(List<String> ele : res){
			System.out.println(ele.toString());
		}
		System.out.println();
		
		res=a.partition("a");
		for(List<String> ele : res){
			System.out.println(ele.toString());
		}
		System.out.println();
		
		res=a.partition("abaa");
		for(List<String> ele : res){
			System.out.println(ele.toString());
		}
		System.out.println();
	}

}
