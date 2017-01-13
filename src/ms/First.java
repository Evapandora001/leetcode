/**  
 * @Title: First.java
 * @Prject: leetcode
 * @Package: ms
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年10月10日 下午7:07:40
 */
package ms;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName: First
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年10月10日 下午7:07:40
 */
public class First {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			int ele = in.nextInt();
			if (stack.isEmpty()) {
				stack.add(ele);
			} else {
				int pre = stack.peek();
				if (((pre & 1) ^ (ele & 1)) == 1) {
					stack.pop();
				} else {
					stack.add(ele);
				}
			}
		}
		System.out.println(stack.size());
	}

}
