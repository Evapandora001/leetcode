package medium;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.TableModel;

/**
 * @author lenovo
 * @date 2015-10-19
 * 
 *
 */
public class SumTarget {
//	// O(n^2)
//    public static int[] twoSum(int[] nums, int target) {
//    	int[] res=new int[2];
//        for(int i=0;i<nums.length-1;i++){
////        	if(nums[i]>target) continue;//此句错误，后面数字可以是负数
//        	for(int j=i+1;j<nums.length;j++){
//        		if(nums[i]+nums[j]==target){
//        			res[0]=i+1;
//        			res[1]=j+1;
//        			return res;
//        		}
//        	}
//        }
//        return null;
//    }
    
	// O(n)
    public static int[] twoSum(int[] nums, int target) {
    	int[] res=new int[2];
    	HashMap<Integer,ArrayList<Integer>> data=new HashMap<Integer,ArrayList<Integer>>(); 
        for(int i=0;i<nums.length;i++){
        	if(!data.containsKey(nums[i])){
        		ArrayList<Integer> temp=new ArrayList<Integer>(){};
        		temp.add(i);
        		data.put(nums[i],temp);
        	}else{
        		ArrayList<Integer> temp=data.get(nums[i]);
        		temp.add(i);
        		data.put(nums[i],temp);
        	}
        }
        for(int i=0;i<nums.length-1;i++){
        	if(data.containsKey(target-nums[i])){
        		ArrayList<Integer> temp=data.get(target-nums[i]);
        		if(temp.get(temp.size()-1)>i){
            		res[0]=i+1;
            		res[1]=temp.get(temp.size()-1)+1;
            		return res;
        		}
        	}
        }
        return null;
    }

	public static void main(String[] args) {
		int [] nums={3,4,5,545234,523,4,3434,6};
		int target=9;
		int[] result=twoSum(nums, target);
		if(nums[result[0]-1]+nums[result[1]-1]==target){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
}
