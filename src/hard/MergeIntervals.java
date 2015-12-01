/**  
 * @Title: MergeIntervals.java
 * @Prject: leetcode
 * @Package: hard
 * @Description: sort
 * @author: Evapandora  
 * @date: 2015年12月1日 下午8:19:31  
 */
package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import hard.InsertInterval.Interval;

/**
 * @ClassName: MergeIntervals
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月1日 下午8:19:31
 */
public class MergeIntervals {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
		public String toString(){
			return("["+start+","+end+"]");
			}
		}
    public List<Interval> merge(List<Interval> intervals) {
    	if(intervals.size()<=1){
    		return intervals;
    	}
    	Collections.sort(intervals,new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start<o2.start){
					return -1;
				}else{
					if(o1.start==o2.start){
						return 0;
					}else{
						return 1;
					}
				}
			}
    		
		});
    	List<Interval> res=new LinkedList<Interval>();
    	Interval pre=intervals.get(0);
    	Iterator<Interval> iterator=intervals.iterator();
    	iterator.next();
    	while(iterator.hasNext()){
    		Interval cur=iterator.next();
    		if(pre.end<cur.start){
    			res.add(new Interval(pre.start,pre.end));
    			pre=cur;
    		}else{
    			pre=new Interval(pre.start,Integer.max(pre.end,cur.end));
    		}
    	}
    	res.add(new Interval(pre.start,pre.end));
    	return res;
    }
	public static void main(String[] args) {
		MergeIntervals aIntervals=new MergeIntervals();
		List<Interval> res=new ArrayList<Interval>();
		res.add(aIntervals.new Interval(1,4));
		res.add(aIntervals.new Interval(4,5));
		res=aIntervals.merge(res);
		for(Interval ele:res){
			System.out.println(ele.toString());
		}
	}

}
