/**  
 * @Title: Main.java
 * @Prject: leetcode
 * @Package: wangyi
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年8月2日 下午7:40:29  
 */
package wangyi;

import java.util.HashMap;
/**
 * @ClassName: Main
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年8月2日 下午7:40:29
 */
import java.util.Scanner;

public class Main2 {
	class Ele {
		int rowAdd;
		int col;

		public Ele(int rowAdd, int col) {
			this.rowAdd = rowAdd;
			this.col = col;
		}
	}

	public static void main(String[] args) {
		Main2 help = new Main2();
		Scanner in = new Scanner(System.in);
		String[] data = in.nextLine().split(" ");
		int N = Integer.parseInt(data[0]);
		int M = Integer.parseInt(data[1]);
		data = in.nextLine().split(" ");
		int[] nums = new int[data.length];
		for (int i = 0; i < nums.length; i++)
			nums[i] = data[i].length();
		data = null;

		HashMap<Integer, Ele> dict = new HashMap<Integer, Ele>();
		int row = 1, col = 0;
		boolean blank = false;
		for (int ite = 0; ite < N; ++ite) {
			int preRow = row, key = col;
			if(dict.containsKey(key)){
				Ele info = dict.get(key);
				row += info.rowAdd;
				col = info.col;
				continue;
			}
			for (int i = 0; i < nums.length; i++) {
				if (blank) {
					if (col == M) {
						row++;
						col = 1;
					} else {
						col++;
					}
					blank = false;
				}
				if (col + nums[i] <= M) {
					col += nums[i];
				} else {
					row++;
					col = 0;
					i--;
					continue;
				}
				blank = true;
			}
//			System.out.println(row + " " + col);
			dict.put(key, help.new Ele(row - preRow, col));
		}
		System.out.println(row + " " + col);
	}
}