package medium;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
    	if(divisor==0) return Integer.MAX_VALUE;
    	if(dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;
    	boolean neg=((dividend^divisor)>>>31==1);//抑或 符号位
    	long divid=Math.abs((long)dividend);
    	long divis=Math.abs((long)divisor);
    	int digit=0,res=0;
    	while(divis<=(divid>>1)){
    		divis=divis<<1;
    		digit++;
    	}
    	while(digit>=0){
    		if(divis<=divid){
    			res+=1<<digit;
    			divid-=divis;
    		}
    		digit--;
			divis=divis>>1;
    	}
        return neg?-res:res;
    }

	public static void main(String[] args) {
		DivideTwoIntegers a=new DivideTwoIntegers();
		System.out.println(a.divide(Integer.MAX_VALUE,Integer.MAX_VALUE));
		System.out.println(a.divide(Integer.MAX_VALUE,1));
		System.out.println(a.divide(Integer.MAX_VALUE,-1));
		System.out.println(a.divide(Integer.MIN_VALUE,1));
		System.out.println(a.divide(Integer.MIN_VALUE,-1));
		System.out.println(a.divide(16,3));
		System.out.println(a.divide(16,4));
		System.out.println(a.divide(16,5));
	}

}
