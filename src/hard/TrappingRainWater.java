package hard;

import java.util.Arrays;

public class TrappingRainWater {
//	public int trap(int[] A) {
////		System.out.println(Arrays.toString(A));
//	    if(A==null || A.length==0)
//	        return 0;
//	    int max = 0;
//	    int res = 0;
//	    int[] container = new int[A.length];
//	    for(int i=0;i<A.length;i++){
//	        container[i]=max;
//	        max = Math.max(max,A[i]);
//	    }
////	    System.out.println(Arrays.toString(container));
//	    max = 0;
//	    for(int i=A.length-1;i>=0;i--){
////	    	System.out.println("i="+i);
////	    	System.out.println("container[i]="+container[i]+"\tA[i]="+A[i]+"\tmax="+max);
//	        container[i] = Math.min(max,container[i]);
//	        max = Math.max(max,A[i]);
//	        res += container[i]-A[i]>0?container[i]-A[i]:0;
////	        System.out.println("container[i]="+container[i]+"\tA[i]="+A[i]+"\tmax="+max);
////	        System.out.println(Arrays.toString(container));
////	        System.out.println(res);
//	    }    
//	    return res;
//	}

	public static void main(String[] args) {
		TrappingRainWater a=new TrappingRainWater();
		System.out.println(a.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println(a.trap(new int[]{1,2,3,4,5}));
		System.out.println(a.trap(new int[]{5,4,3,2,1}));
		System.out.println(a.trap(new int[]{5,4,0,2,1}));
	}
//	/*
//	 * 时间复杂度 2*n
//	 */
//	public int trap(int[] height) {
//		if(height==null||height.length<=2) return 0;
//		int res=0,maxIndex=0;
//		for(int i=1;i<height.length;i++){
//			if(height[i]>height[maxIndex]){
//				maxIndex=i;
//			}
//		}
//		for(int i=1,left=0;i<maxIndex;i++){
//			if(height[i]<height[left]){
//				res+=height[left]-height[i];
//			}else{
//				left=i;
//			}
//		}
//		
//		for(int i=height.length-1,right=height.length-1;i>maxIndex;--i){
//			if(height[i]<height[right]){
//				res+=height[right]-height[i];
//			}else{
//				right=i;
//			}
//		}
//		
//		return res;
//	}
	/*
	 * 时间复杂度 n
	 * key： 对于left，只要右侧存在一个比自己大的数，比自己低的水位就可以 trap
	 *          对于right，只要左侧存在一个比自己大的数，比自己低的水位就可以trap
	 */
	public int trap(int[] height) {
		if(height==null||height.length<=2) return 0;
		int res=0;
		int left=0,right=height.length-1;
		while(left<right){
			int start=0;
			if(height[left]<height[right]){
				start=left;
				left++;
				while(height[left]<height[start]){
					res+=height[start]-height[left];
					left++;
				}
			}else{
				start=right;
				right--;
				while(height[right]<height[start]){
					res+=height[start]-height[right];
					right--;
				}
			}
		}
		return res;
	}

}
