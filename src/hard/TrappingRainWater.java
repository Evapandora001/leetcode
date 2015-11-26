package hard;

import java.util.Arrays;

public class TrappingRainWater {
	public int trap(int[] A) {
		System.out.println(Arrays.toString(A));
	    if(A==null || A.length==0)
	        return 0;
	    int max = 0;
	    int res = 0;
	    int[] container = new int[A.length];
	    for(int i=0;i<A.length;i++){
	        container[i]=max;
	        max = Math.max(max,A[i]);
	    }
	    System.out.println(Arrays.toString(container));
	    max = 0;
	    for(int i=A.length-1;i>=0;i--){
	    	System.out.println("i="+i);
	    	System.out.println("container[i]="+container[i]+"\tA[i]="+A[i]+"\tmax="+max);
	        container[i] = Math.min(max,container[i]);
	        max = Math.max(max,A[i]);
	        res += container[i]-A[i]>0?container[i]-A[i]:0;
	        System.out.println("container[i]="+container[i]+"\tA[i]="+A[i]+"\tmax="+max);
	        System.out.println(Arrays.toString(container));
	        System.out.println(res);
	    }    
	    return res;
	}

	public static void main(String[] args) {
		TrappingRainWater a=new TrappingRainWater();
		System.out.println(a.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
	}

}
