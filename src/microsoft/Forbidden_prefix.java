/**  
 * @Title: Forbidden.java
 * @Prject: exercise
 * @Package: microsoft
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年4月6日 下午7:47:30
 */
package microsoft;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @ClassName: Forbidden
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年4月6日 下午7:47:30
 */
public class Forbidden_prefix {

	public static void main(String[] args) {
		Forbidden_prefix a = new Forbidden_prefix();
		a.start();
	}

	// 由于某种未知原因，使用数组 会 超时，换成 left right 即pass 并且 缩短了 几乎3s
	class IPNode {
		boolean hit;
		// int priority;
		boolean yes;
		// IPNode[] child = new IPNode[2];
		IPNode left;// 0
		IPNode right;// 1
	}

	private IPNode root = new IPNode();

	private void start() {
		// Scanner cin = new Scanner(System.in);
		Scanner cin = null;
		try {
			cin = new Scanner(new File("ms//in"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String[] info = cin.nextLine().split(" ");
		int N = Integer.parseInt(info[0]);
		int M = Integer.parseInt(info[1]);

		while (N-- != 0) {
			String[] rule = cin.nextLine().split(" ", 2);
			boolean yes = false;
			if (rule[0].equals("allow")) {
				yes = true;
			}
			String path = ipTo32Bits(rule[1]);
			// insertPreTree(root, path, yes, N);
			insertPreTree(root, path, yes);
		}

		while (M-- != 0) {
			String target = ipTo32Bits(cin.nextLine());
			boolean yes = serachPreTree(target, root);
			if (yes) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	private boolean serachPreTree(String target, IPNode root) {
		// int priority = -1;
		boolean yes = true;
		IPNode node = root;
		for (char ch : target.toCharArray()) {
			if (node.hit) {
				// if (node.priority > priority) {
				// priority = node.priority;
				// yes = node.yes;
				// }
				yes = node.yes;
			}
			if (ch == '0') {
				if (node.left == null) {
					return yes;
				} else {
					node = node.left;
				}
			} else {
				if (node.right == null) {
					return yes;
				} else {
					node = node.right;
				}

			}

		}
		if (node.hit) {
			// if (node.priority > priority) {
			// priority = node.priority;
			// yes = node.yes;
			// }
			yes = node.yes;
		}
		return yes;
	}

	// 剪枝操作 如果 短规则 已存在，再来一个长规则 可以舍弃，因为 后来的 优先级一定更低
	// 如此导致 如果一条路径上 存在 多个匹配，深度越大，优先级 越高
	private void insertPreTree(IPNode root, String path, boolean yes) {
		IPNode node = root;
		if (path.length() != 0) {
			for (char ch : path.toCharArray()) {
				if (node.hit) {
					return;
				}

				if (ch == '0') {
					if (node.left == null) {
						node.left = new IPNode();
					}
					node = node.left;
				} else {
					if (node.right == null) {
						node.right = new IPNode();
					}
					node = node.right;
				}
			}
		}
		if (!node.hit) {
			node.hit = true;
			node.yes = yes;
			// node.priority = n;
		}
	}

	private String ipTo32Bits(String ip) {
		String res = "";
		int start = 0, end = 0;
		while ((end = ip.indexOf('.', start)) != -1) {
			int num = Integer.parseInt(ip.substring(start, end));
			res += intTo8bits(num);
			start = end + 1;
		}
		for (int i = start; i < ip.length(); i++) {
			if (ip.charAt(i) == '/') {
				end = i;
				break;
			}
		}
		if (end == -1) {
			end = ip.length();
		}
		int num = Integer.parseInt(ip.substring(start, end));
		res += intTo8bits(num);
		if (end == ip.length()) {
			return res;
		}
		int len = Integer.parseInt(ip.substring(end + 1, ip.length()));
		return (res.substring(0, len));
	}

	private String intTo8bits(int num) {
		String bits = "";
		for (int i = 1; i <= 8; i++) {
			bits = (num & 1) + bits;
			num = num >>> 1;
		}
		return bits;
	}


}
