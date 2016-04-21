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
import java.util.HashMap;
import java.util.Scanner;


/**
 * @ClassName: Forbidden
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年4月6日 下午7:47:30
 */
public class Forbidden {

	public static void main(String[] args) {
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
		HashMap<String, Integer> rules = new HashMap<String, Integer>();// value
																		// 越大
																		// 优先级
																		// 越高
		HashMap<Integer, Integer> out = new HashMap<Integer, Integer>();// value
																		// 1 yes
																		// 0 no
		while (N-- != 0) {
			String[] rule = cin.nextLine().split(" ", 2);
			int yes = 0;
			if (rule[0].equals("allow")) {
				yes = 1;
			}
			out.put(N, yes);
			String key = ipTo32Bits(rule[1]);
			if (!rules.containsKey(key)) {
				rules.put(key, N);
			}

		}

		while (M-- != 0) {
			String target = ipTo32Bits(cin.nextLine());
			int value = -1;
			for (int i = 0; i <= 32; i++) {
				String ele = target.substring(0, i);
				if (rules.containsKey(ele)) {
					if (rules.get(ele) > value) {
						value = rules.get(ele);
					}
				}
			}
			if (value == -1 || out.get(value) == 1) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	private static String ipTo32Bits(String ip) {
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

	private static String intTo8bits(int num) {
		String bits = "";
		for (int i = 1; i <= 8; i++) {
			bits = (num & 1) + bits;
			num = num >>> 1;
		}
		return bits;
	}

}
