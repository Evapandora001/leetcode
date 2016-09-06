/**  
 * @Title: FMN.java
 * @Prject: leetcode
 * @Package: startOfBaidu
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年7月29日 下午10:38:35  
 */
package startOfBaidu;

/**
 * @ClassName: FMN
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年7月29日 下午10:38:35
 */
public class FMN {
	int count = 0;
	public void fun(int m, int n){
		if(n == 1){
			count++;
			return;
		}
		for(int i = 0; i <= m; i++){
			fun(m-i, n-1);
		}
	}

	public static void main(String[] args) {
		FMN aFmn = new FMN();
		aFmn.fun(7, 4);
		System.out.println(aFmn.count);
		
		aFmn.count = 0;
		aFmn.fun(6, 4);
		System.out.println(aFmn.count);
		
		aFmn.count = 0;
		aFmn.fun(5, 4);
		System.out.println(aFmn.count);
		
		aFmn.count = 0;
		aFmn.fun(4, 4);
		System.out.println(aFmn.count);
		
		aFmn.count = 0;
		aFmn.fun(3, 4);
		System.out.println(aFmn.count);
		
		aFmn.count = 0;
		aFmn.fun(2, 4);
		System.out.println(aFmn.count);
		
		aFmn.count = 0;
		aFmn.fun(1, 4);
		System.out.println(aFmn.count);
		
		aFmn.count = 0;
		aFmn.fun(0, 4);
		System.out.println(aFmn.count);
	}

}
