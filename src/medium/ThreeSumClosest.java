package medium;

import java.util.Arrays;


public class ThreeSumClosest {
	
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int distance =Integer.MAX_VALUE;
        int closest=0;
        for(int i=0;i<nums.length-2;i++){
        	int j=i+1;
        	int k=nums.length-1;
        	while(j<k){
        		int sum=nums[i]+nums[j]+nums[k];
        		if(distance>abs(sum,target)){
        			distance=abs(sum,target);
        			closest=sum;
        		}
        		if(sum==target) {
        			return sum;
        		}
        		if(sum<target){
        			j++;
        		}else{
        			k--;
        		}
        	}
        }
        return closest;
    }
    
    int abs(int a,int b){
    	if(a<b){
    		return b-a;
    	}else{
    		return a-b;
    	}
    }

	public static void main(String[] args) {
		ThreeSumClosest a=new ThreeSumClosest();
		int nums[]={1,2,4,8,16,32,64,128};
		int target=82;
		System.out.println(a.threeSumClosest(nums, target));
	}

}
