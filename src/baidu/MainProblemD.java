/**  
 * @Title: MainProblemD.java
 * @Prject: leetcode
 * @Package: baidu
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年5月14日 下午1:02:39
 */
package baidu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MainProblemD {

	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		Scanner scan = null;
		try {
			scan = new Scanner(new File("baidu//data"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int N = Integer.parseInt(scan.nextLine().trim());
		HashMap<String, Integer> dict = new HashMap<String, Integer>();
		while (N-- != 0) {
			String name = orderArc(scan.nextLine());
			if(dict.containsKey(name)){
				System.out.println(dict.get(name));
				dict.put(name, dict.get(name)+1);
			}else{
				System.out.println("0");
				dict.put(name,1);
			}
		}

	}

	private static String orderArc(String name) {
		char[] chs = name.toCharArray();
		Arrays.sort(chs);
		return new String(chs);
	}

}
