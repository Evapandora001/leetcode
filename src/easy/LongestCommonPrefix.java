package easy;

public class LongestCommonPrefix {
	//当数组只有一个时，那么自己就是 最大公共子串;给出的是 所有字符串的公共子串
    public String longestCommonPrefix(String[] strs) {
    	if(strs.length==0){
    		return "";
    	}
    	String seed=strs[0];
    	int end=seed.length();
    	for(int i=1;i<strs.length;i++){
    		String a=strs[i];
    		end=Math.min(a.length(),end);
    		while(end>0&&seed.substring(0, end).equals(a.substring(0, end))==false){
    			end--;
    		}
    		if(end==0) return "";
    	}
    	return seed.substring(0, end);
    }

	public static void main(String[] args) {
		LongestCommonPrefix a=new LongestCommonPrefix();
		String strs[]={"aaa","aaaa","a12567","a12345","aaa"};
		System.out.println(a.longestCommonPrefix(strs));
	}

}
