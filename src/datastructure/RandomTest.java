/**  
 * @Title: RandomTest.java
 * @Prject: leetcode
 * @Package: datastructure
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年8月12日 下午11:32:55  
 */
package datastructure;

/**
 * @ClassName: RandomTest
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年8月12日 下午11:32:55
 */
public class RandomTest {
	public static void main(String[] args) {
		java.util.Random r = new java.util.Random(10);
		for (int i = 0; i < 10; i++) {
			System.out.println(r.nextInt());
		}
	}

}
