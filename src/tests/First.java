/**  
 * @Title: First.java
 * @Prject: leetcode
 * @Package: tests
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年9月10日 下午8:07:32
 */
package tests;
import java.util.Scanner;


public class First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String line=in.nextLine();
			String a=in.nextLine();
			String b=in.nextLine();
			boolean flag1=false,flag2=false;
			int index1=line.indexOf(a);
			if((index1!=-1)&&line.indexOf(b, index1+a.length())!=-1)
				flag1=true;
			String line2=reverse1(line);
			int index2=line2.indexOf(a);
			if(index2!=-1&&line2.indexOf(b,index2+a.length())!=-1)
				flag2=true;
			if(flag1&&flag2)
				System.out.println("both");
			else if(flag1&&!flag2)
				System.out.println("forward");
			else if(!flag1&&flag2)
				System.out.println("backward");
			else
				System.out.println("invalid");
		}
	}
	public static String reverse1(String str) {  
	    if (str == null || str.length() <= 1) {  
	        return str;  
	    }  
	    char[] array = str.toCharArray();  
	    char[] reverseArray = new char[array.length];  
	    for (int i = 0; i < array.length; i++) {  
	        reverseArray[array.length - 1 - i] = array[i];  
	    }  
	    return new String(reverseArray);  
	}  

}
