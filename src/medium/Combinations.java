/**  
 * @Title: Combinations.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月25日 上午10:13:05
 */
package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Combinations
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月25日 上午10:13:05
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> res=new LinkedList<List<Integer>>();
    	if(k>n){
    		return res;
    	}
    	LinkedList<Integer> ele=new LinkedList<Integer>();
    	if(k==n){
        	for(int i=1;i<=n;i++){
        		ele.add(i);
        	}
        	res.add(ele);
    		return res; 
    	}
    	
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
