/**  
 * @Title: Main.java
 * @Prject: leetcode
 * @Package: wangyi
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年8月2日 下午7:40:29  
 */
package wangyi;


import java.util.*;

/**
 *
 * @author zkf
 *
 */

public class Main3 {
	private static class Num implements Comparable<Num>{
		final long num;
		int cnt = 0;
		private Num(long num) {
			this.num = num;
		}

		@Override
		public int compareTo(Num o) {
			return Integer.compare(o.cnt, cnt);
		}
	}
//	private static final Comparator<Num> cntComp = new Comparator<Num>() {
//		@Override
//		public int compare(Num o1, Num o2) {
//			return Integer.compare(o2.cnt, o1.cnt);
//		}
//	};
	private static final Comparator<Num> numComp = new Comparator<Num>() {
		@Override
		public int compare(Num o1, Num o2) {
			return Long.compare(o1.num, o2.num);
		}
	};

	private int n;
	private Map<Long, Num> numMap = new HashMap<Long, Num>();
	private List<Num> numList = new LinkedList<Num>();
	private PriorityQueue<Num> queue = new PriorityQueue<Num>();
	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				n = scanner.nextInt();
				for (int i = 0; i < n; i++) {
					long l = scanner.nextLong();
					Num num = numMap.get(l);
					if (num == null) {
						num = new Num(l);
						numMap.put(l, num);
					}

					num.cnt++;
				}
				numList.clear();
				numList.addAll(numMap.values());
				Collections.sort(numList, numComp);

				queue.clear();
				queue.addAll(numList);
				if (queue.peek().cnt * 2 - 1 > n) {
					System.out.println(-1);
				} else {
					sortAndPrint();
				}
			}
		}
	}

	private void sortAndPrint() {
		int rem = n;
		long prev = Long.MAX_VALUE;
		while (!numList.isEmpty()) {
			Num num = queue.peek();

			if (num.cnt * 2 - 1 == rem) {
				queue.poll();
				num.cnt--;

				if (num.cnt == 0)
					numList.remove(num);
				else
					queue.add(num);
			} else {
				int idx = 0;
				num = numList.get(idx);
				if (rem != n && num.num == prev) {
					num = numList.get(++idx);
				}

				queue.remove(num);
				num.cnt--;
				if (num.cnt == 0)
					numList.remove(idx);
				else
					queue.add(num);
			}

			rem--;
			prev = num.num;
			System.out.print(num.num);
			if (rem != 0)
				System.out.print(' ');
			else
				System.out.println();
		}
	}

	public static void main(String[] args) {
		new Main3().deal();
	}
}
