package kang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int SUM = in.nextInt();
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = in.nextInt();
		}
		Arrays.sort(nums);
		int[] res = new int[1];
		backtrace(nums, SUM, new ArrayList<Integer>(), 0, res);
		System.out.println(res[0]);
	}

	public static void backtrace(int[] nums, int sum, ArrayList<Integer> path, int index, int[] res) {
		if (sum < 0)
			return;
		if (sum == 0 && path.size() != 0) {
			System.out.println(path);
			res[0]++;
			return;
		}
		for (int i = index; i < nums.length; i++) {
			if (nums[i] > sum)
				return;
			path.add(i);
			backtrace(nums, sum - nums[i], path, i + 1, res);
			path.remove(path.size() - 1);
		}
	}
}
