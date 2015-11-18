package easy;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
    	if(haystack.length()<needle.length()) return -1;
    	int start=0;
    	for(;start+needle.length()<=haystack.length();start++){
    		String sign=haystack.substring(start,start+needle.length());
    		if(sign.equals(needle)) return start;
    	}
    	return -1;
    }
	public static void main(String[] args) {
		ImplementstrStr a=new ImplementstrStr();
		System.out.println(a.strStr("abcdefg","bcd"));
		System.out.println(a.strStr("abccefcccccddddd","ef"));
		System.out.println(a.strStr("fdadsfasdf","fadsffas"));
	}

}
