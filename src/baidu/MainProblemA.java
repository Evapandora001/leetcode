/**  
 * @Title: Main.java
 * @Prject: leetcode
 * @Package: baidu
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年4月21日 下午8:22:22  
 */
package baidu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainProblemA {

	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
		Scanner scan = null;
		try {
			scan = new Scanner(new File("baidu//data"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scan.hasNext()) {
			int N = Integer.parseInt(scan.nextLine().trim());
			char[] dict = scan.nextLine().trim().toCharArray();
			while ((N--) != 0) {
				String[] temp = scan.nextLine().trim().split(" ");
				int a = Integer.parseInt(temp[0].trim()) - 1;
				int b = Integer.parseInt(temp[1].trim()) - 1;
				if (a > b) {
					a ^= b;
					b ^= a;
					a ^= b;
				}
				int res = 1;
				for (int i = a; i <= b; i++) {
					int ele = ((int) (dict[i]) - 28) % 9973;
					res = (res * ele) % 9973;
				}
				System.out.println(res);
			}
		}
	}
}
