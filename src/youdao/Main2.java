/**  
 * @Title: Main.java
 * @Prject: leetcode
 * @Package: wangyi
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年8月2日 下午7:40:29  
 */
package youdao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int iter = Integer.parseInt(in.nextLine());
		HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		while (iter-- != 0) {
			// n（1<=n<=100000）
			int N = Integer.parseInt(in.nextLine());
			int[] nums = new int[N];
			queue.clear();
			for (int i = 0; i < N; i++) {
				nums[i] = i + 100000 + 1;
				queue.offer(nums[i]);
			}
			dict.clear();
			int seed = 1;
			while (!queue.isEmpty()) {
				int x = queue.peek(); // 取出当前队头的值x
				queue.poll(); // 弹出当前队头
				queue.offer(x); // 把x放入队尾
				x = queue.peek(); // 取出这时候队头的值
				dict.put(x, seed); // 输出x
				seed++;
				queue.poll(); // 弹出这时候的队头
			}
			System.out.print(dict.get(nums[0]));
			for (int i = 1; i < N; i++) {
				System.out.print(" " + dict.get(nums[i]));
			}
			System.out.println();
		}
	}

}