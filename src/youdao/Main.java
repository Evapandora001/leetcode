/**  
 * @Title: Main.java
 * @Prject: leetcode
 * @Package: wangyi
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年8月2日 下午7:40:29  
 */
package youdao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	class LinkNode {
		int val;
		LinkNode next;

		public LinkNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		Main aMain = new Main();
		aMain.start();
	}

	private void start() {
//		Scanner in = new Scanner(System.in);
		Scanner in = null;
		try {
			in = new Scanner(new File("baidu//data"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int iter = Integer.parseInt(in.nextLine());
		while (iter-- != 0) {
			String[] data = in.nextLine().split(" ");
			int N = Integer.parseInt(data[0]);
			int K = Integer.parseInt(data[1]);
			// (1<=ai<=1000000000)
			// (1<=n,k<=100)
			data = in.nextLine().split(" ");
			LinkNode dummy = new LinkNode(-1);
			LinkNode p = dummy;
			for (String ele : data) {
				p.next = new LinkNode(Integer.parseInt(ele));
				p = p.next;
			}
			while (K-- != 0) {
				p = dummy;
				for (int i = 0; i < N; i++)
					p = p.next;
				LinkNode q = p.next;
				p.next = null;
				p = dummy.next;
				while (q != null) {
					LinkNode next = q.next;
					q.next = p.next;
					p.next = q;
					p = p.next.next;
					q = next;
				}
			}
			System.out.print(dummy.next.val);
			p = dummy.next.next;
			while (p != null) {
				System.out.print(" " + p.val);
				p = p.next;
			}
			System.out.print("\r\n");
		}
	}

}

//样例输入
//3
//3 1
//1 2 3 4 5 6
//3 2
//1 2 3 4 5 6
//2 2
//1 1 1 1
//样例输出
//1 4 2 5 3 6
//1 5 4 3 2 6
//1 1 1 1