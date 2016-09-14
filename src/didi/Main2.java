package didi;

import java.util.Arrays;
import java.util.Scanner;

//餐馆 不允许拼桌
public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] temp = in.nextLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		int[] table = new int[N];
		temp = in.nextLine().split(" ");
		for (int i = 0; i < temp.length; i++)
			table[i] = Integer.parseInt(temp[i]);
		Arrays.sort(table);
		int[] cost = new int[M];
		int[] gain = new int[M];
		for (int i = 0; i < M; i++) {
			temp = in.nextLine().split(" ");
			cost[i] = Integer.parseInt(temp[0]);
			gain[i] = Integer.parseInt(temp[1]);
		}
		boolean[] used = new boolean[N];
		int use = 0;
		int[] res = new int[1];
		backtrace(table, used, use, cost, gain, 0, 0, res);
		System.out.println(res[0]);

	}

	private static void backtrace(int[] table, boolean[] used, int use, int[] cost, int[] gain, int index, int money,
			int[] res) {
		if (use == table.length || index == cost.length) {
			res[0] = Math.max(res[0], money);
			return;
		}
		backtrace(table, used, use, cost, gain, index + 1, money, res);
		for (int i = 0; i < table.length; i++) {
			if (used[i])
				continue;
			if (table[i] < cost[index])
				continue;
			used[i] = true;
			backtrace(table, used, use + 1, cost, gain, index + 1, money + gain[index], res);
			used[i] = false;
		}
	}

}
/*
3 5
2 4 2
1 3
3 5
3 7
5 9
1 10
*/