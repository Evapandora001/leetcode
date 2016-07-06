/**  
 * @Title: MainProblemB.java
 * @Prject: leetcode
 * @Package: baidu
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年5月14日 下午1:33:03
 */
package baidu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName: MainProblemB
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年5月14日 下午1:33:03
 */
public class MainProblemB {

	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		Scanner scan = null;
		try {
			scan = new Scanner(new File("baidu//data"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BigInteger[] dict = new BigInteger[201];
		dict[1] = new BigInteger("1");
		dict[2] = new BigInteger("2");
		for(int i = 3; i <= 200 ; i++){
			dict[i] = dict[i-1].add(dict[i-2]);
		}
		while(scan.hasNext()){
			int N = Integer.parseInt(scan.nextLine().trim());
			System.out.println(dict[N]);
		}
	}
}
