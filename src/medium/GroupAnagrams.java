package medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
    	Arrays.sort(strs);//瞬间解决了 输出ele需要升序的难题
//    	List<List<String>> res=new LinkedList<List<String>>();
    	HashMap<String,List<String>> mapRes=new HashMap<String,List<String>>();
    	for(int i=0;i<strs.length;i++){
    		char[] str=strs[i].toCharArray();
    		Arrays.sort(str);
    		String key=new String(str);
    		if(mapRes.containsKey(key)){
    			List<String> ele=mapRes.get(key);
    			ele.add(strs[i]);
    			mapRes.put(key,ele);
    		}else{
    			List<String>ele=new LinkedList<>();
    			ele.add(strs[i]);
    			mapRes.put(key, ele); 
    		}
    	}
//    	Iterator<List<String>> it=mapRes.values().iterator();
//    	while(it.hasNext()){
//    		res.add(it.next());
//    	}
    	return new LinkedList<List<String>>(mapRes.values());
    }

	public static void main(String[] args) {
		GroupAnagrams a=new GroupAnagrams();
		String[] strs={"eat", "tea", "tan", "ate", "nat", "bat",""};
		List<List<String>> res=a.groupAnagrams(strs);
		System.out.println(res.size());
		for(List<String> ele:res){
			System.out.println(ele.toString());
		}
	}

}
