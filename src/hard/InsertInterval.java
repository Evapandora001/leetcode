/**  
 * @Title: InsertInterval.java
 * @Prject: leetcode
 * @Package: hard
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月1日 下午10:13:50  
 */
package hard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * @ClassName: InsertInterval
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月1日 下午10:13:50
 */
public class InsertInterval {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
		public String toString(){
			return("["+start+","+end+"]");
			}
		}

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	if(intervals.size()==0){
    		intervals.add(newInterval);
    		return intervals;
    	}
    	if(newInterval.end<intervals.get(0).start){
    		intervals.add(0,newInterval);
    		return intervals;
    	}
    	List<Interval> res=new LinkedList<Interval>();
        Iterator<Interval> it=intervals.iterator();
        boolean insert=false;
        Interval pre = null;
        while(it.hasNext()){
        	Interval cur=it.next();
        	if(!insert){
        		if(cur.end<newInterval.start){
            		res.add(new Interval(cur.start,cur.end));
            	}else{
            		if(cur.start>newInterval.end){
            			res.add(newInterval);
            			pre=cur;
            		}else{
            			pre=new Interval(Integer.min(cur.start,newInterval.start),Integer.max(newInterval.end,cur.end));
            		}
            		insert=true;
            	}
        		
        	}else{
        		if(pre.end<cur.start){
        			res.add(new Interval(pre.start,pre.end));
        			pre=cur;
        		}else{
        			pre=new Interval(pre.start,Integer.max(pre.end,cur.end));
        		}
        	}
        }
        if(insert){
        	res.add(new Interval(pre.start,pre.end));
        }else{
        	res.add(newInterval);
        }
    	return res;
    }
    
	public static void main(String[] args) {
		InsertInterval a=new InsertInterval();
		List<Interval> res=new ArrayList<Interval>();
		res.add(a.new Interval(3,5));
		res.add(a.new Interval(12,15));
		res=a.insert(res,a.new Interval(1,16));
		for(Interval ele:res){
			System.out.println(ele.toString());
		}

	}

}
