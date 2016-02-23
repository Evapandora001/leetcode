/**  
 * @Title: RestoreIPAddresses.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月22日 下午6:45:12
 */
package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: RestoreIPAddresses
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月22日 下午6:45:12
 */
public class RestoreIPAddresses {
	
	
	public List<String> restoreIpAddresses(String s) {
		LinkedList<String> res=new LinkedList<String>();
		if(s.length()<4||s.length()>12){
			return res;
		}  
		int start=0, hit=0;
		String ele="";
		ipbacktrack(s, start, hit, ele,res);
        return res;
    }

	/**
	 * @Title: ipbacktrack
	 * @Description: TODO
	 * @param s
	 * @param start
	 * @param hit
	 * @param ele
	 * @param res
	 * @return: void
	 */
	private void ipbacktrack(String s, int start, int hit, String ele, LinkedList<String> res) {
		if(hit==4&&start==s.length()){
			res.add(ele);
		}
		for(int i=1;i<=3;i++){
			if(start+i>s.length()){
				return;
			}
			String seg=s.substring(start, start+i);
			if(isVaild(seg)){
				if(hit==0){
					ipbacktrack(s, start+i, hit+1, seg, res);
				}else{
					ipbacktrack(s, start+i, hit+1, ele+"."+seg, res);
				}
			}else{
				continue;
			}
		}
	}

	/**
	 * @Title: isVaild
	 * @Description: TODO
	 * @param seg
	 * @return
	 * @return: boolean
	 */
	private boolean isVaild(String seg) {
		if(seg.startsWith("0")&&seg.length()>1){//seg 不能是0开头的整数，0本身除外
			return false;
		}
		if(Integer.parseInt(seg)>=0&&Integer.parseInt(seg)<=255){
			return true;
		}
		return false;
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		RestoreIPAddresses a=new RestoreIPAddresses();
		String s="010010";
		System.out.println(a.restoreIpAddresses(s).toString());

	}

}
