/**  
 * @Title: LuckyNum.java
 * @Prject: leetcode
 * @Package: baidu
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年4月21日 下午7:59:23  
 */
package baidu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @ClassName: LuckyNum
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年4月21日 下午7:59:23
 */
public class LuckyNum {

	/*
	 * Time Limit: 2000/1000 MS (Java/Others) Memory Limit: 65536/65536 K
	 * (Java/Others) Problem Description:
	 * 小熊很喜欢只包含'4'、'7'的数，称为幸运数，例如44,47,77,774都是小熊的喜欢的数，而"141871"不是幸运数。
	 * 但是幸运数不是常常出现，于是他认为"141871"其实是包含幸运数"47"的，即去掉非'4','7'的数字后，数变成了"47"是幸运数字，
	 * 称为伪幸运数。 给定数a，以及幸运数b，问第一个满足大于a，且包含幸运数b的数。 输入
	 * 输入两个正整数a、b（<100000），分别表示给定数值和幸运数 输出 输出第一个满足大于a，且包含幸运数b的数
	 */

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		Scanner scan = null;
		try {
			scan = new Scanner(new File("baidu//data"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int a = scan.nextInt();
		int b = scan.nextInt();
		if (b > a) {
			System.out.println(b);
			return;
		}
		long target = a + 1;
		while (!f(target, b)) {
			target++;
		}
		System.out.println(target);
	}

	private static boolean f(long a, int b) {
		String aString = a + "";
		String res="";
		for(char ele : aString.toCharArray()){
			if(ele == '4' || ele == '7'){
				res += ele;
			}
		}
		String bString = b + "";
		return res.contains(bString);
	}

}
