package medium;
/**
 * 
 * @ClassName: Powxn
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年11月30日 下午11:39:26
 */
public class Powxn {
//    public double myPow(double x, int n) {
//    	if(x==0) return 0;
//    	if(n==1) return x;
//    	if(n==0) return 1;
//    	if(n<0){//when negative.need to concern boundary
//    		if(n==Integer.MIN_VALUE){
//    			return 1/x/myPow(x,-(n+1));
//    		}else{
//    			return 1/myPow(x, -n);
//    		}
//    	}
//    	double res=1;
//        if(n%2==0){
//        	res=myPow(x*x, n>>1);
//        }else{
//        	res=myPow(x*x,n>>1)*x;
//        }
//        return res;
//    }
	public static void main(String[] args) {
		Powxn a=new Powxn();
		System.out.println(a.myPow(2.2,1));
		System.out.println(a.myPow(1,-2147483648));
	}
	
    public double myPow(double x, int n) {
    	if(x==0) return 0;
    	if(n==1) return x;
    	if(n==0) return 1;
    	if(n<0){
    		if(n==Integer.MIN_VALUE){
    			return 1/x/myPow(x,-(n+1));
    		}else{
    			return 1/myPow(x, -n);
    		}
    	}
    	double ans = 1.0;
    	while (n != 0) {
    		if ((n & 1) == 1){//(m & 1) == 1 means  m%2=1 ====>m is odd number(uneven)
    			ans *= x;
    		}
    		x *= x;//放大底数
    		n >>= 1;//缩小指数
    		}
    	return ans;
    }
}
