/**  
 * @Title: Puke.java
 * @Prject: leetcode
 * @Package: alibaba
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年4月20日 下午8:27:37
 */
package alibaba;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * @ClassName: Puke
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年4月20日 下午8:27:37
 */
public class Puke {
	public BigInteger res = new BigInteger("0");
//	public long res = 0;
	HashMap<String, BigInteger> map = new HashMap<String, BigInteger>();

	public static void main(String[] args) {
		Puke a = new Puke();
		a.puke(27);

	}
	
	public void puke(int max){
		for(int i = max; i >= 0; i--){
			res = res.add(backtarce(i,1));
		}
		System.out.println(res);
		//1946939425648112
	}

	private  BigInteger backtarce(int start, int num) {
		String key = start+"#"+num;
		if(map.containsKey(key)){
			return map.get(key);
		}
		if(num == 27){
			return new BigInteger("1");
		}
		BigInteger ele = new BigInteger("0");
		for(int i = start; i >= 0; i--){
			num++;
			ele = ele.add(backtarce(i, num));
			num--;
		}
		map.put(key, ele);
		return ele;
	}

}
