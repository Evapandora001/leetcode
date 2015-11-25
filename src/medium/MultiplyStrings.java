package medium;


public class MultiplyStrings {
	
    public String multiply(String num1, String num2) {
    	if(num1.equals("0")||num2.equals("0")) return "0";
        int[] res=new int[num1.length()+num2.length()+2];
        for(int i=0;i<num1.length();i++){
        	for(int j=0;j<num2.length();j++){
        		res[num1.length()-1-i+num2.length()-1-j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        	}
        }
        for(int i=0;i<res.length;i++){
        	if(res[i]<10) continue;
        	int mod=res[i]%10;
        	int advance=0;
        	while(res[i]>=10){//132  每一位都要往后进位
        		advance++;
        		res[i]=res[i]/10;
        		res[i+advance]+=res[i]%10;
        	}
        	res[i]=mod;
        }
        String target="";
        boolean flag=true;
        for(int i=res.length-1;i>=0;i--){
        	if(flag&&res[i]==0) continue;
        	flag=false;
        	target+=res[i];
        }
        return target;
    }

	public static void main(String[] args) {
		MultiplyStrings a=new MultiplyStrings();
//		System.out.println(a.multiply("123456","1"));
//		System.out.println(a.multiply("123456","0"));
		System.out.println(a.multiply("123456789","123456789"));
	}

}
