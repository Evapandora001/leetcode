package easy;

public class ZConversation {
	
    public String convert(String s, int numRows) {
    	if(numRows==1){
    		return s;
    	}
    	String[] resArray=new String[numRows];
    	for(int i=0;i<numRows;i++){
    		resArray[i]="";
    	}
    	int flag=0,count=0;
    	for(int i=0;i<s.length();i++){
    		int iT=i%(2*numRows-2);
    		if(iT<=numRows-1){
    			resArray[iT]+=s.charAt(i);
    		}else{
    			resArray[2*numRows-2-iT]+=s.charAt(i);
    		}
    	}
    	String res="";
    	for(String temp:resArray){
    		res+=temp;
    	}
    	return res;
    }
	public static void main(String[] args) {
		ZConversation a=new ZConversation();
		System.out.println(a.convert("ABCDEF",4));//"PAHNAPLSIIGYIR"
	}

}
