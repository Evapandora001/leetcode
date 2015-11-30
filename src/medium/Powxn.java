package medium;
/**
 * 
 * @ClassName: Powxn
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年11月30日 下午11:39:26
 */
public class Powxn {
    public double myPow(double x, int n) {
        double res=1;
        for(int i=1;i<=n;i++){
        	res*=x;
        }
        return res;
    }
	public static void main(String[] args) {
		Powxn a=new Powxn();
		System.out.println(a.myPow(2.2,1));
		System.out.println(a.myPow(2.2,0));
	}
}
