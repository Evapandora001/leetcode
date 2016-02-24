/**  
 * @Title: InterleavingString.java
 * @Prject: leetcode
 * @Package: hard
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月24日 下午3:02:14
 */
package hard;

import java.util.Stack;

/**
 * @ClassName: InterleavingString
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月24日 下午3:02:14
 */
public class InterleavingString {
	class Spot{
		int s1Index;
		int s2Index;
		int s3Index;
		
		public Spot(int s1Index, int s2Index, int s3Index) {
			this.s1Index = s1Index;
			this.s2Index = s2Index;
			this.s3Index = s3Index;
		}
		
	}
	/**
	 * 
	 * @Title: isInterleave_1
	 * @Description: Time Limit Exceeded    回溯
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 * @return: boolean
	 */
	public boolean isInterleave_1(String s1, String s2, String s3) {
		if(s3.length()!=s1.length()+s2.length()){
			return false;
		}
        Stack<Spot> spots=new Stack<Spot>();
        int i=0, j=0, k=0;
        boolean hit=false, s1Safe=true, s2Safe=true;
        while(k!=s3.length()){
        	if(i==s1.length()){
        		s1Safe=false;
        	}else{
        		s1Safe=true;
        	}
        	if(j==s2.length()){
        		s2Safe=false;
        	}else{
        		s2Safe=true;
        	}
        	char c=s3.charAt(k);
        	hit=false;
        	if(s1Safe && s1.charAt(i)==c){
        		hit=true;
        		i++;
        		k++;
        	}
        	if(s2Safe && s2.charAt(j)==c){
        		if(hit){
//        			System.out.println((i-1)+"\t"+(j+1)+"\t"+k);
        			spots.push(new Spot(i-1, j+1, k));
        		}else{
        			hit=true;
        			j++;
        			k++;
        		}
        	}
        	if(!hit){
        		if(spots.isEmpty()){
//        			System.out.println(i+"\t"+j+"\t"+k);
        			return false;
        		}else{
        			Spot pre=spots.pop();
        			i=pre.s1Index;
        			j=pre.s2Index;
        			k=pre.s3Index;
        		}
        	}
        }
		return true;
    }

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		InterleavingString a=new InterleavingString();
		String s1 = "aabcc", s2 = "dbbca" ,s3 = "aadbbcbcac";
		System.out.println(a.isInterleave(s1, s2, s3));
		s3="aadbbbaccc";
		System.out.println(a.isInterleave(s1, s2, s3));
	}
	/**
	 * 
	 * @Title: isInterleave
	 * @Description:  事实证明，动态规划 时间复杂度 低于 递归
	 * 
	 * Match[i][j]  =   (s3.lastChar == s1.lastChar) && Match[i-1][j]
      						||(s3.lastChar == s2.lastChar) && Match[i][j-1]
初始条件：
    i=0 && j=0时，Match[0][0] = true;
    
    i=0时， s3[j] = s2[j], Match[0][j] = Match[0][j-1]
           		s3[j] != s2[j], Match[0][j] = false;

    j=0时， s3[i] = s1[i], Match[i][0] = Match[i-1][0]
           		s3[i] != s1[i], Match[i][0] = false;
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 * @return: boolean
	 */
	
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s3.length()!=s1.length()+s2.length()){
			return false;
		}
        boolean match[][]=new boolean[s1.length()+1][s2.length()+1];
        match[0][0]=true;
        for(int j=0; j<s2.length();j++){
        	if(s3.charAt(j)==s2.charAt(j)){
//        		match[0][j+1]=match[0][j];
        		match[0][j+1]=true;
        	}else{
//        		match[0][j+1]=false;
        		break;
        	}
        }
        
        for(int i=0; i<s1.length();i++){
        	if(s3.charAt(i)==s1.charAt(i)){
//        		match[i+1][0]=match[i][0];
        		match[i+1][0]=true;
        	}else{
//        		match[i+1][0]=false;
        		break;
        	}
        }
        
        for(int i=0; i<s1.length(); i++){
        	for(int j=0; j<s2.length(); j++){
        		char a=s1.charAt(i);
        		char b=s2.charAt(j);
        		char c=s3.charAt(i+j+1);
        		match[i+1][j+1]=(a==c && match[i][j+1])
        				||( b==c && match[i+1][j]);
        	}
        }
        return match[s1.length()][s2.length()];
    }

	/**
	 * 
	 * @Title: isInterleave_2
	 * @Description: 递归 依然 超时
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 * @return: boolean
	 */
	public boolean isInterleave_2(String s1, String s2, String s3) {
		if(s3.length()!=s1.length()+s2.length()){
			return false;
		}
		if(s1.length()==0 || s2.length()==0){
			if(s3.equals(s1) || s3.equals(s2)){
				return true;
			}else{
				return false;
			}
		}
		char a=s1.charAt(0);
		char b=s2.charAt(0);
		char c=s3.charAt(0);
		if(a==c || b==c){
			if(a==b){
				return (isInterleave(s1.substring(1), s2, s3.substring(1)) || isInterleave(s1, s2.substring(1), s3.substring(1)));
			}else{
				if(a==c){
					return isInterleave(s1.substring(1), s2, s3.substring(1));
				}else{
					return isInterleave(s1, s2.substring(1), s3.substring(1));
				}
			}
		}
		return false;
    }

}
