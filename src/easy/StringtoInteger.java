package easy;

public class StringtoInteger {
	
    public int myAtoi(String str) {
    	String num="";
    	boolean start=true;
    	boolean pos=true;
    	boolean flag=true;
    	str=str.trim();
    	System.out.println(str);
    	for(int i=0;i<str.length();i++){
    		char s=str.charAt(i);
    		if((s+"").matches("[+-0123456789]")){
    			if(start&&s=='0'){
    				System.out.println(s);
    				continue;
    			}
    			if(start&&s=='-'){
    				if(flag){
        				pos=false;
        				flag=false;
    				}else{
    					break;
    				}
    			}else{
    				if(start&&s=='+'){
    					if(flag){
        					pos=true;
        					flag=false;
    					}else {
							break;
						}
    				}else{
    					if(s==' '){
    						if(start)	continue;
    						break;
    					}else{
    						num+=s;
    						if(start)	start=false;
    					}
    				}
    			}
    		}else{
    			break;//遇到非法字符 不跳过 直接退出
    		}
    	}
    	if(num.equals(""))	return 0;
    	num=(pos?"":"-")+num;
    	try{
        	return(Integer.parseInt(num));
    	}catch(Exception e){
    		if(pos){
    			return(2147483647);
    		}else{
    			return(-2147483648);
    		}
    	}

    }

	public static void main(String[] args) {
		StringtoInteger a=new StringtoInteger();
		System.out.println(a.myAtoi("+00 0123"));
	}

}
