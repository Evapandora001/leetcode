package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<List<Integer>>();
    	if(candidates==null||target<candidates[0]) return res;
        ArrayList<Integer> ele=new ArrayList<Integer>();
        cSum(candidates,0, res, target, ele);//start 去重 保证ele 是增序填充元素
        return res;
    }

	public void cSum(int[] candidates,int start,List<List<Integer>> res, int target, ArrayList<Integer> ele) {
		if(target<0) return;
		if(target==0){
			res.add(new ArrayList<Integer>(ele));
			return;
		}
		for(;start<candidates.length;start++){
			if(start>0&&candidates[start]==candidates[start-1]) continue;
			ele.add(candidates[start]);
			cSum(candidates,start,res,target-candidates[start],ele);
			ele.remove(ele.size()-1);//remove 最近一次add的元素
		}
	}

	public static void main(String[] args) {
		CombinationSum a=new CombinationSum();
		for (List<Integer> ele:a.combinationSum(new int[]{7,3,9,6},6)) {
			System.out.println(ele.toString());
		}
	}

}