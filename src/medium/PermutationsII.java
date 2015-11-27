package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        permute(nums,new LinkedList<Integer>(),new LinkedList<Integer>(),res);
        return res;
    }
    //递归 回溯
	public void permute(int[] nums,LinkedList<Integer> index,LinkedList<Integer> ele,List<List<Integer>> res) {
		if(index.size()==nums.length){
			res.add(new LinkedList<>(ele));
			return;
		}
		int pre=0;
		boolean start=true;
		for(int i=0;i<nums.length;i++){
			if(index.contains(i)) continue;
			if(!start){
				if(pre==nums[i])
					continue;
			}else{
				pre=nums[i];
				start=false;
			}
			pre=nums[i];
			index.add(i);
			ele.add(nums[i]);
			permute(nums, index, ele, res);
			index.remove(index.size()-1);
			ele.remove(ele.size()-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
