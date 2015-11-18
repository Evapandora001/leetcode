package hard;

public class MediumSortedArray {
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int size=nums1.length+nums2.length;
    	int res[]=new int[size];
    	int i=0,j=0,k=0;
    	for(;i<nums1.length&&j<nums2.length&&k<size;k++){
    		if(nums1[i]<nums2[j]){
    			res[k]=nums1[i];
    			i++;
    		}else{
    			res[k]=nums2[j];
    			j++;
    		}
    	}
    	while(i<nums1.length&&k<size){
    		res[k++]=nums1[i++];
    	}
    	while(j<nums2.length&&k<size){
    		res[k++]=nums2[j++];
    	}
    	if(size%2==0){
    		return (res[size/2-1]+res[size/2])*1.0/2;
    	}else{
    		return res[(size+1)/2-1];
    	}
    }

	public static void main(String[] args) {
		MediumSortedArray a=new MediumSortedArray();
		int[] nums1={1,2};
		int[] nums2={1,2,3};
		System.out.println(a.findMedianSortedArrays(nums1, nums2));
	}

}
