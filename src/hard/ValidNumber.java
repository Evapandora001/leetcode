/**  
 * @Title: ValidNumber.java
 * @Prject: leetcode
 * @Package: hard
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月2日 下午10:53:37  
 */
package hard;

/**
 * @ClassName: ValidNumber
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月2日 下午10:53:37
 */
public class ValidNumber {
/**
 * @Title: isNumber
 * @Description: 
 * 题意：判断一个字符串是否是计算机合法数字。
 * 思路：把字符串分三段（小数点前、小数点与e/E之间部分、e/E之后）
 * 这三段都必须为纯数字组成的字符串。
 * 注意，第一部分和第三部分可以带符号（如+12.34e-56），
 * 第一部分和第二部分可以有一部分为空（如“.2"或"2."）。
 * 数字部分 可以以0开头，并且允许多个
 * 
 * 去掉首尾多余的空格；!!!!!!!
 * 去掉开头的正负号；
 * 看有没有e或E，如果有那么e/E后面只能是整数；
 * 第三部分e/E之前必须存在第一 或者 第二部分
 * @param s
 * @return
 * @return: boolean   
 */
    public boolean isNumber(String s) {
    	if(s==null||s.length()==0) return false;
    	s=s.trim();
        if(s==null||s.length()==0) return false;
        int i=0;
        char ele =0;
        //the first portion
		while(i<s.length()&&((ele=s.charAt(i))!='.')&&(ele!='e')&&ele!='E'){
			if(i==0){
				if(ele=='+'||ele=='-'||number(ele)){
					i++;
				}else{
					return false;
				}
			}else{
				if(number(ele)){
					i++;
				}else{
					return false;
				}
			}
        }
		boolean second=false;
		if(i!=s.length()){
			if(ele=='.'){
				//. 前后不能同时 不为为数字
				if((i-1>=0&&number(s.charAt(i-1)))||(i+1<s.length()&&number(s.charAt(i+1)))){
					second=true;
					i++;
				}else{
					return false;
				}
			}

		}else{
			return true;
		}
		
		
		if(second){
			//the second portion
			while(i<s.length()&&(ele=s.charAt(i))!='e'&&ele!='E'){
				if(number(ele)){
					i++;
				}else{
					return false;
				}
			}
		}
		
		if(i<s.length()){
			//ele=e/E
			if(i-1>=0&&(number(s.charAt(i-1))||second)){
				i++;
			}else{
				return false;
			}
		}else{
			return true;
		}
		
		//the third portion    e/E 之后必须有数字
		boolean start=true,thirdNum=false;
		while(i<s.length()){
			ele=s.charAt(i);
			if(start){
				start=false;
				if(ele=='+'||ele=='-'){
					i++;
				}else{
					if(number(ele)){
						thirdNum=true;
					}else{
						return false;
					}
				}
			}else{
				if(number(ele)){
					thirdNum=true;
					i++;
				}else{
					return false;
				}
			}
		}
		if(thirdNum){
			return true;
		}else{
			return false;
		}
    }
    
    private boolean number(char ele) {
    	if(ele>='0'&&ele<='9'){
    		return true;
    	}
    	return false;
    }

	public static void main(String[] args) {
		ValidNumber a=new ValidNumber();
		System.out.println(a.isNumber("+12.34e-56"));
		System.out.println(a.isNumber("+12.3.4e-56"));
		System.out.println(a.isNumber("."));
		System.out.println(a.isNumber(".e1"));
		System.out.println(a.isNumber("1.e1"));
		System.out.println(a.isNumber("e"));
	}

}
