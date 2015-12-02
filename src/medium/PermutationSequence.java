/**  
 * @Title: PermutationSequence.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月2日 上午9:18:18
 */
package medium;

import java.util.ArrayList;

/**
 * @ClassName: PermutationSequence
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月2日 上午9:18:18
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
    	String res="";
    	int factorial=1;//如果建立 factorial数组便会超时
        ArrayList<Integer> ele=new ArrayList<>();
        for(int i=1;i<n;i++){
        	factorial=factorial*i;
        	ele.add(i);
        }
        ele.add(n);
        k--;
        int index=n-1;
        while(index!=0){
        	int target=k/factorial;
        	res+=ele.get(target);
        	
        	ele.remove(target);
        	k=k%factorial;
        	factorial=factorial/index;
        	index--;
        }
        res+=ele.get(0);
        return res;
    }
    
	public static void main(String[] args) {
		PermutationSequence a=new PermutationSequence();
		System.out.println(a.getPermutation(3,5));
	}

}
