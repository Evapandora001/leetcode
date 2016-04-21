/**  
 * @Title: IntegerSum.java
 * @Prject: leetcode
 * @Package: exercise
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年4月19日 下午4:44:10
 */
package exercise;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName: IntegerSum
 * @Description: 一个整数 有多少种 拆分方式
 * @author: Evapandora
 * @date: 2016年4月19日 下午4:44:10
 */
public class IntegerSum {

	public LinkedList<String> sumList(int n) {
		LinkedList<String> res = new LinkedList<String>();
		backTrace(1, n, new LinkedList<Integer>(), res);
		return res;
	}

	public void backTrace(int start, int n, LinkedList<Integer> ele, LinkedList<String> res) {
		if (n == 0) {
			res.add(ele.toString());
			return;
		}
		if (n < start) {
			return;
		}

		for (int i = start; i <= n; i++) {
			ele.add(i);
			backTrace(i, n - i, ele, res);
			ele.removeLast();
		}
	}

	public static void main(String[] args) {
		IntegerSum a = new IntegerSum();
//		System.out.println(a.sumList(1));
//		System.out.println(a.sumList(2));
//		System.out.println(a.sumList(3));
//		System.out.println(a.sumList(26).size());
//		String s = "23        ";
//		System.out.println(Arrays.toString(s.split(" +")));
		System.out.println(Puzzle("a@.a@dh"));

	}
	
	public static Boolean Puzzle(String s) {
        String regex = "[a-zA-Z0-9_-]+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        return s.matches(regex);
    }

}
