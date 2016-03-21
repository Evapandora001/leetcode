/**  
 * @Title: MaximumGap.java
 * @Prject: leetcode
 * @Package: hard
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年3月8日 下午3:52:12
 */
package hard;

/**
 * @ClassName: MaximumGap
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年3月8日 下午3:52:12
 */
public class MaximumGap {
	
    public class Bucket{
        int size;
        int max;
        int min;
        public Bucket(){
            this.size = 0;
            this.max = 0;
            this.min = Integer.MAX_VALUE;
        }
        public void update(int val){
            this.max = Math.max(this.max, val);
            this.min = Math.min(this.min, val);
            this.size++;
        }
    }
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        int len = nums.length;
        int max = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        if(max == min){
            return 0;
        }
        double gap = (max - min)*1.0/(len - 1);
        Bucket[] bucket = new Bucket[len];
        for(int i = 0; i < len; i++){
        	bucket[i] = new Bucket();
        }
        for(int i = 0; i < len; i++){
            bucket[(int)((nums[i] - min)/gap)].update(nums[i]);
        }
        int emptyBucketNum = 0, maxGap = 0, preMax = 0;
        boolean start = true;
        for(int i = 0; i < len; i++){
            if(bucket[i].size == 0){
                emptyBucketNum++;
                continue;
            }
            if(start){
                preMax = bucket[i].max;
                start = false;
            }else{
                maxGap = Math.max(maxGap, bucket[i].min - preMax);
                preMax = bucket[i].max;
            }
        }
        
        return maxGap;
    }

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		MaximumGap a = new MaximumGap();
		int[] nums = {4,3,2,1,5};
		System.out.println(a.maximumGap(nums));

	}

}
