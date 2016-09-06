package didi;

import java.util.Scanner;

//连续最大和
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		long pre = 0, max = 0;
		for (int i = 0; i < N; i++) {
			int ele = in.nextInt();
			if (i == 0) {
				pre = ele;
				max = ele;
				continue;
			}
			if (ele <= 0) {
				if (pre <= 0) {
					pre = ele;
				} else {
					pre = pre + ele;
				}
			} else {
				if (pre <= 0) {
					pre = ele;
				} else {
					pre = pre + ele;
				}
			}
			max = Math.max(max, pre);

		}
		System.out.println(max);
	}

}