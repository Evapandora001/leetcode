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
public class Forbidden_integer {

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
		HashMap<Long, Integer> rules = new HashMap<Long, Integer>();// value
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
			Long key = ipTo32_6BitInteger(rule[1]);
//			System.out.println(key+" "+N);
			if (!rules.containsKey(key)) {
				rules.put(key, N);
			}

		}

		while (M-- != 0) {
			Long target = ipTo32_6BitInteger(cin.nextLine());
//			System.out.println(target);
			int value = -1;
			for(int i = 32; i != -1; i--){
				if(rules.containsKey(target)){
//					System.out.println("Match\t"+target);
					if(rules.get(target) > value){
						value = rules.get(target);
					}
				}
				target = ((target>>>7)<<6) + (i-1);
			}
			if(value == -1 || out.get(value) == 1){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}

	}

	private static Long ipTo32_6BitInteger(String ip) {
		Long res = 0L;
		int start = 0, end = 0;
		while ((end = ip.indexOf('.', start)) != -1) {
			int num = Integer.parseInt(ip.substring(start, end));
			res = (res<<8) + num;
			start = end +1;
		}
		for(int i = start; i < ip.length(); i++){
			if(ip.charAt(i) == '/'){
				end = i;
				break;
			}
		}
		if(end == -1){
			end = ip.length();
		}
		int num = Integer.parseInt(ip.substring(start, end));
		res = (res<<8) + num;
		if(end == ip.length()){
			return (res<<6) + 32;
		}
		int len = Integer.parseInt(ip.substring(end+1,ip.length()));
		int right = 32 - len;
		return ((res>>>right)<<6) + len;
	}

}
