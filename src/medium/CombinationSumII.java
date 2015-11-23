package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
		for(int i=start;i<candidates.length;i++){
			if(i>start&&candidates[i]==candidates[i-1]) continue;
			ele.add(candidates[i]);
			cSum(candidates,i+1,res,target-candidates[i],ele);
			ele.remove(ele.size()-1);//remove 最近一次add的元素
		}
	}
	public static void main(String[] args) {
		CombinationSumII a=new CombinationSumII();
		for (List<Integer> ele:a.combinationSum2(new int[]{10,1,2,7,6,1,5},8)) {
			System.out.println(ele.toString());
		}
	}

}
