package easy;

public class ReverseInteger {
    public int reverse(int x) {
    	if(x==0) return 0;
    	String in=x+"";
    	String out="";
    	boolean neg=false;
    	boolean start=true;//除去首位的0
    	if(x>0){
    		for(int i=in.length()-1;i>=0;--i){
    			if(start&&in.charAt(i)=='0'){
    				continue;
    			}else{
    				start=false;
    			}
    			out+=in.charAt(i);
    		}
    	}else{
    		neg=true;
    		for(int i=in.length()-1;i>=1;--i){
    			if(start&&in.charAt(i)=='0'){
    				continue;
    			}else{
    				start=false;
    			}
    			out+=in.charAt(i);
    	}
    	}
    	if(neg){
    		try{
        		return(Integer.parseInt("-"+out));//下溢出 则 置0
    		}catch(Exception e){
    			return 0;
    		}

    	}else{
    		try{
        		return(Integer.parseInt(out));//上溢出 则 置0
    		}catch(Exception e){
    			return 0;
    		}
    	}
    }

	public static void main(String[] args) {
		ReverseInteger a=new ReverseInteger();
		System.out.println(a.reverse(1534236469));
		System.out.println(a.reverse(-123));

	}

}
