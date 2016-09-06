/**  
 * @Title: Main.java
 * @Prject: leetcode
 * @Package: wangyi
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年8月2日 下午7:40:29  
 */
package baidusaima;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main aMain = new Main();
		aMain.start();
	}

	public void start() {
		Scanner in = new Scanner(System.in);
		int interator = Integer.parseInt(in.nextLine());
		while (interator-- != 0) {
			int N = Integer.parseInt(in.nextLine());
			String[] data = in.nextLine().split(" ");
			int max = -1, count = 0;
			for (String ele : data) {
				int cur = Integer.parseInt(ele);
				if (cur > max) {
					count++;
					max = cur;
				}
			}
			System.out.println(count);
		}
	}

}