package tests;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean[] nums = new boolean[1000];
		// 2 is the first prime
		for (int i = 2; i < nums.length; i++) {
			if (!nums[i]) {
				int seed = i;
				for (int j = 2; j * seed < nums.length; j++)
					nums[j * seed] = true;
			}
		}
		HashSet<Integer> seeds = new HashSet<Integer>();
		LinkedList<Integer> ele = new LinkedList<Integer>();
		for (int i = 2; i < nums.length; i++)
			if (!nums[i]) {
				seeds.add(i);
				ele.add(i);
			}
		int N = Integer.parseInt(in.nextLine());
		int count = 0;
		for (int a : ele) {
			int b = N - a;
			if (b < a)
				break;
			if (seeds.contains(b)) {
				System.out.println(a + " \t" + b);
				count++;
			}
		}
		System.out.println(count);
	}

}
