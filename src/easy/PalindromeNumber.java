package easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
    	if(x<0) return false;
    	int len=1;
    	int templen=1;
    	while(x/len>=10){
    		len*=10;
    	}
        while(x>=10){
        	int l=x/len;
        	int r=x%10;
        	if(l!=r){
        		return false;
        	}
        	x=(x%len)/10;
        	len=len/100;
        	System.out.println(x);
        	System.out.println(len);
        	while(len>0&&x%len==x){
        		len/=10;
        		templen*=10;
        	}
        	if(x%templen!=0){
        		return false;
        	}
        	x=x/templen;
        	len=len/templen;
        	templen=1;
        	System.out.println(x);
        	System.out.println(len);
        }
        return true;
    }

	public static void main(String[] args) {
		PalindromeNumber a=new PalindromeNumber();
//		System.out.println(a.isPalindrome(100021));
//		System.out.println(a.isPalindrome(10012001));
//		System.out.println(a.isPalindrome(111));
		System.out.println(a.isPalindrome(1000110001));
	}

}
