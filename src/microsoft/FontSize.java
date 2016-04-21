/**  
 * @Title: FontSize.java
 * @Prject: exercise
 * @Package: microsoft
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年4月6日 下午7:16:32
 */
package microsoft;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FontSize {

	public static void main(String[] args) {
//		Scanner cin = new Scanner(System.in);
		Scanner cin = null;
		try {
			cin = new Scanner(new File("ms//in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int test = cin.nextInt();
		while (test-- != 0) {
			int N = cin.nextInt();
			int P = cin.nextInt();
			int W = cin.nextInt();
			int H = cin.nextInt();
			int[] para = new int[N];
			for (int i = 0; i < N; i++) {
				para[i] = cin.nextInt();
			}
			int max = Math.min(W, H);
			for (int i = max; i >= 1; i--) {
				int colMax = W / i;
				int line = 0;
				for (int j = 0; j < N; j++) {
					if (para[j] % colMax == 0) {
						line += para[j] / colMax;
					} else {
						line += para[j] / colMax + 1;
					}
				}
				int rowMax = H/i;
				if(P * rowMax >= line){
					System.out.println(i);
					break;
				}
			}
		}
	}

}
