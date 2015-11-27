package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
 * 默认 nums 中 没有重复
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        boolean[] use=new boolean[nums.length]; 
        permute(nums,use,new LinkedList<Integer>(),res);
        return res;
    }

    //递归 回溯
	public void permute(int[] nums,boolean[] use,LinkedList<Integer> ele,List<List<Integer>> res) {
		if(ele.size()==nums.length){
			res.add(new LinkedList<>(ele));
			return;
		}
		int pre=0;
		boolean start=true;
		for(int i=0;i<nums.length;i++){
			if(use[i]) continue;
			if(!start){
				if(pre==nums[i])
					continue;
			}else{
				pre=nums[i];
				start=false;
			}
			pre=nums[i];
			use[i]=true;
			ele.add(nums[i]);
			permute(nums,use, ele, res);
			use[i]=false;
			ele.remove(ele.size()-1);
		}
	}

	public static void main(String[] args) {
		Permutations aPermutations=new Permutations();
		List<List<Integer>> res=aPermutations.permute(new int[]{1,2,3});
		System.out.println(res.size());
		for(List<Integer> ele:res){
			System.out.println(ele.toString());
		}
	}

}
