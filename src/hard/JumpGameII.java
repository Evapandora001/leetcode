package hard;

import javax.print.attribute.standard.NumberUpSupported;

public class JumpGameII {
    public int jumpTimeExceeded(int[] nums) {
        if(nums[0]>=nums.length-1) return 1;
        return traversal(nums,0,0,nums.length-1);//回溯 遍历所有情况
    }

	public int traversal(int[] nums, int start, int step, int min) {
		if(nums[start]==0) return min;
		if(nums[start]+start>=nums.length-1){
			step++;
			if(step<min){
				min=step;
			}
			return min;
		}
		for(int i=1;i<=nums[start];i++){
			int temp=traversal(nums, start+i, step+1, min);
			if(temp<min){
				min=temp;
			}
		}
		return min;
	}
	
    public int jump(int[] nums) {
    	//Greedy
    	if(nums.length<=1) return 0;
        if(nums[0]>=nums.length-1) return 1;
        int step=0,start=0;
        while(nums[start]+start<nums.length-1){
        	int max=nums[start+1]+1,newStart=start+1;
        	for(int i=2;i<=nums[start];i++){
        		if(nums[start+i]+i>max){
        			max=nums[start+i]+i;
        			newStart=start+i;
        		}
        	}
        	start=newStart;
        	step++;
        }
        return (step+1);
    }

	public static void main(String[] args) {
		JumpGameII a=new JumpGameII();
		System.out.println(a.jump(new int[]{2,3,1,1,4}));
		System.out.println(a.jump(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
	}

}
