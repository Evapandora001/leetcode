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
//    	boolean[] use=new boolean[n+1];
    	backTrack(1,ele,n,res,k);
        return res;
    }
	/**
	 * @Title: backTrack
	 * @Description: 
	 * @param i
	 * @param ele
	 * @param use
	 * @param n
	 * @param res
	 * @return: void
	 */
	private void backTrack(int start, LinkedList<Integer> ele, int n, List<List<Integer>> res,int k) {
		if(ele.size()==k){
			res.add(new LinkedList<Integer>(ele));
			return;
		}
		for(int i=start;i<=n;i++){
			ele.add(i);
			backTrack(i+1, ele, n, res, k);
			ele.remove(ele.size()-1);
		}
	}
	public static void main(String[] args) {
		Combinations a=new Combinations();
		List<List<Integer>> res=a.combine(5, 3);
		System.out.println(res.size());
		for(List<Integer> ele:res){
			System.out.println(ele);
		}
	}

}
