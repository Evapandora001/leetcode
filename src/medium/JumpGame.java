package medium;
/**
 * @ClassName: JumpGame
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月1日 下午4:48:10
 */
public class JumpGame {
//    public boolean canJump(int[] nums) {
//        if(nums.length<=1) return true;
//        int start=0;
//        while(start+nums[start]<nums.length-1){
//        	if(nums[start]==0) return false;
//        	int newStart=start;
//        	int max=0;
//        	for(int i=1;i<=nums[start];i++){
//        		if(max<i+nums[start+i]){
//        			max=nums[start+i]+i;
//        			newStart=start+i;
//        		}
//        	}
//        	start=newStart;
//        }
//        return true;
//    }

	public static void main(String[] args) {
		JumpGame a=new JumpGame();
		System.out.println(a.canJump(new int[]{2,3,1,1,4}));
		System.out.println(a.canJump(new int[]{3,2,1,0,4}));
		System.out.println(a.canJump(new int[]{2,0,0}));
	}
	
    public boolean canJump(int[] nums) {
        int max= 0;//能达到的最大位置
        for(int i=0; i < nums.length; i++) {
            if(max<i) return false;//i 位置不可达
            max=nums[i]+i>max?nums[i]+i:max;
            if(max>=nums.length-1) return true;
        }
        return true;
    }

}
