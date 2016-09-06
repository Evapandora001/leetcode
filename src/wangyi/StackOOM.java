/**  
 * @Title: Test.java
 * @Prject: leetcode
 * @Package: wangyi
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年8月9日 上午10:38:49  
 */
package wangyi;

public class StackOOM {
	static int count = 0;
	public static int increment(int i){
		count++;
		return increment(i);
	}
	
	public static void main(String[] args) {
		int begin = 0;
		try {
			increment(begin);
		} catch (Exception e) {
			System.out.println("catch" + count);
		}finally{
			System.out.println(count);
			//21943
		}
	}
}
