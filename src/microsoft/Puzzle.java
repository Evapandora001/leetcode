/**  
 * @Title: Puzzle.java
 * @Prject: leetcode
 * @Package: microsoft
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年4月23日 下午2:29:13  
 */
package microsoft;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName: Puzzle
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年4月23日 下午2:29:13
 */
public class Puzzle {
	


    public static int index = 0;
    public static String[] Puzzle(int n) {
        int len = catalan(n);
        String[] res = new String[len];
    	String s="";
    	generate(n,n,s,res);
        return res;
    }
    public static int catalan(int n){
         if(n == 0)    return 1;
         else return (4*n-2)*catalan(n-1)/(n+1);
     }
    
	public static void generate(int leftNum,int rightNum,String s,String[] res){
		if(leftNum==0&&rightNum==0){
			res[index++] = s;
			return;
		}
		if(leftNum>0){
			generate(leftNum-1, rightNum, s+"(", res);
		}
		if(rightNum>leftNum){
			generate(leftNum, rightNum-1, s+")", res);
		}
    }
	public static void main(String[] args) {
		System.out.println(Arrays.toString(Puzzle(4)));
	}

}
