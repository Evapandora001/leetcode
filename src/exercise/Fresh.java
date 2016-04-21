/**  
 * @Title: Fresh.java
 * @Prject: leetcode
 * @Package: exercise
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月5日 上午11:27:11  
 */
package exercise;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * @ClassName: Fresh
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月5日 上午11:27:11
 */
public class Fresh {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		String a=null;
		System.out.println(a == null);
//		a="ab";
//		System.out.println(a.substring(2));
////		int [] aa=null;
////		System.out.println(aa.length);
//		LinkedHashMap<Integer, Integer> test = new LinkedHashMap<Integer, Integer>();
//		test.put(1, 1);
//		test.put(2, 2);
//		System.out.println(test.toString());
		test();
		
	}
	
	public static void test(){
		List<Integer> list = Arrays.asList(1,2,3);
		Iterator<Integer> it = list.iterator(); 
		Iterator<Integer> it2 = it; 
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it2.next());
	}
	
	

}
