/**  
 * @Title: GrayCode.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月22日 上午10:50:50
 */
package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: GrayCode
 * @Description: 格雷码
 * @author: Evapandora
 * @date: 2016年2月22日 上午10:50:50
 */
public class GrayCode {
	/**
	 * @Title: grayCode
	 * @Description:  输出顺序问题  从右到左 再往右
	 * @param n
	 * @return
	 * @return: List<Integer>
	 */
	public List<Integer> grayCode_1(int n) {
        LinkedList<Integer> res=new LinkedList<Integer>();
        if(n==0){
        	res.add(0);
        	return res;
        }
        char[] ele=new char[n];
        int index=n-1,sum=1,len=n;
        boolean left=true;
        while(n!=0){
        	ele[n-1]='0';
        	sum*=2;
        	n--;
        }
//        System.out.println(sum+"\t"+(index+1));
        while(sum!=1){
        	res.add(Integer.parseInt(new String(ele), 2));
        	ele[index]=(char) (49-ele[index]+48); 
        	if(left){
        		if(index!=0){
        			index--;
        		}else{
        			index++;
        			left=false;
        		}
        	}else{
        		if(index!=len-1){
        			index++;
        		}else{
        			index--;
        			left=true;
        		}
        	}
        	sum--;
        }
        res.add(Integer.parseInt(new String(ele), 2));
        return res;
    }

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
//		System.out.println((char)(49-'1'+48));
		GrayCode a=new GrayCode();
		List<Integer> res=a.grayCode(3);
		System.out.println(res.toString());

	}
	
	public List<Integer> grayCode(int n) {
	    LinkedList<Integer> res = new LinkedList<Integer>();
	    if(n<0)
	        return res;
	    if(n==0)
	    {
	        res.add(0);
	        return res;
	    }
	    res.add(0);
	    res.add(1);
	    for(int i=2;i<=n;i++)
	    {
	        int size = res.size();
	        for(int j=size-1;j>=0;j--)
	        {
	            res.add(res.get(j)+(1<<(i-1)));//前半段 首位加0 数字不变，后半段 按前半段倒序首位加1
	        }
	    }
	    return res;
	}

}
