/**  
 * @Title: AddBinary.java
 * @Prject: leetcode
 * @Package: easy
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月3日 下午12:18:01
 */
package easy;

/**
 * @ClassName: AddBinary
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月3日 下午12:18:01
 */
public class AddBinary {

    public String addBinary(String a, String b) {
    	if(a.length()==0) return b;
    	if(b.length()==0) return a;
    	int aIndex=a.length()-1,bIndex=b.length()-1,carray=0;
    	int temp=0;
    	String res="";
    	while(aIndex>=0&&bIndex>=0){
    		temp=a.charAt(aIndex)-'0'+b.charAt(bIndex)-'0'+carray;
    		if(temp>=2){
    			res=(temp-2)+res;
    			carray=1;
    		}else{
    			res=temp+res;
    			carray=0;
    		}
    		aIndex--;
    		bIndex--;
    	}
    	while(aIndex>=0){
    		temp=carray+a.charAt(aIndex)-'0';
    		if(temp==2){
    			res=0+res;
    			carray=1;
    		}else{
    			res=temp+res;
    			carray=0;
    		}
    		aIndex--;
    	}
    	while(bIndex>=0){
    		temp=carray+b.charAt(bIndex)-'0';
    		if(temp==2){
    			res=0+res;
    			carray=1;
    		}else{
    			res=temp+res;
    			carray=0;
    		}
    		bIndex--;
    	}
    	if(carray==1){
    		res=1+res;
    	}
        return res;
    }
	public static void main(String[] args) {
		AddBinary a=new AddBinary();
		System.out.println(a.addBinary("100","10"));

	}

}
