/**  
 * @Title: ReverseBits.java
 * @Prject: leetcode
 * @Package: easy
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年3月4日 下午2:50:22
 */
package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: ReverseBits
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年3月4日 下午2:50:22
 */
public class ReverseBits {
	
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32 ; i++){
            res = (res << 1) + (n & 1);
            n = (n >> 1);
        }
        return res;
    }
    
    public int hammingWeight(int n) {
        int hamWeight = 0;
        for(int i = 0; i < 32; i++){
            if((n & 1) == 1){
                hamWeight++;
            }
            n = n >>> 1;
        }
        return hamWeight;
    }

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		ReverseBits a = new ReverseBits();
//		System.out.println(a.reverseBits(2));
//		System.out.println(a.reverseBits(4));
//		System.out.println(a.reverseBits(1027));
//		System.out.println(a.reverseBits(43261596));//964176192
//		System.out.println(a.hammingWeight(11));
		Set<Integer> test = new HashSet<Integer>();
	}


}
