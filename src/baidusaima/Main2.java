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

public class Main2 {

	public static void main(String[] args) {
		Main2 aMain2 = new Main2();
		aMain2.start();
	}

	public void start() {
		Scanner in = new Scanner(System.in);
		int inter = Integer.parseInt(in.nextLine());
		int sum = 0;
		String name = "";
		int max = -1;
		while (inter-- != 0) {
			String string = in.nextLine();
			int money = countValue(string);
			sum += money;
			if (money > max) {
				max = money;
				name = string.split(" ")[0];

			}
		}
		System.out.println(name);
		System.out.println(max);
		System.out.println(sum);
	}

	public int countValue(String s) {
		int money = 0;
		String[] tmp = s.trim().split(" ");
		// String name = tmp[0];
		int a = Integer.parseInt(tmp[1]);
		int b = Integer.parseInt(tmp[2]);
		String c = tmp[3];
		String d = tmp[4];
		int x = Integer.parseInt(tmp[5]);
		if (a > 80 && x > 0)
			money += 8000;
		if (a > 85 && b > 80)
			money += 4000;
		if (a > 90)
			money += 2000;
		if (a > 80 && d.equals("Y"))
			money += 1000;
		if (b > 80 && c.equals("Y"))
			money += 850;

		return money;
	}

}