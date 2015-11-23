package easy;

public class CountandSay {
    public String countAndSay(int n) {
    	String res=interationOfCAS(n);
    	return res;
    }

	public String interationOfCAS(int n) {
		if(n==1) return "1";
		String pre=interationOfCAS(n-1);
		char seed=pre.charAt(0);
		String current="";
		int times=0;
		for(int i=0;i<pre.length();i++){
			if(pre.charAt(i)==seed) times++;
			else{
				current+=times+""+seed;
				times=1;
				seed=pre.charAt(i);
			}
		}
		current+=times+""+seed;
		return current;
	}

	public static void main(String[] args) {
		CountandSay a=new CountandSay();
		System.out.println(a.countAndSay(1));
		System.out.println(a.countAndSay(2));
		System.out.println(a.countAndSay(3));
		System.out.println(a.countAndSay(4));
		System.out.println(a.countAndSay(5));
		System.out.println(a.countAndSay(6));
		System.out.println(a.countAndSay(7));
		System.out.println(a.countAndSay(8));
		System.out.println(a.countAndSay(9));
		System.out.println(a.countAndSay(10));
	}

}
