package medium;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
	
    public List<String> generateParenthesis(int n) {
    	List<String> res=new LinkedList<String>();
    	String s="";
    	generate(n,n,s,res);
    	return res;
    }
	public void generate(int leftNum,int rightNum,String s,List<String> res){
		if(leftNum==0&&rightNum==0){
			res.add(s);
			return;
		}
		if(leftNum>0){
			generate(leftNum-1, rightNum, s+"(", res);
		}
		if(rightNum>leftNum){
			generate(leftNum, rightNum-1, s+")", res);
		}
    }

	public static void main(String[] args) {
		GenerateParentheses a=new GenerateParentheses();
		List<String> res=a.generateParenthesis(3);
		for(String ele:res){
			System.out.print(ele+"\t");
		}
	}

}
