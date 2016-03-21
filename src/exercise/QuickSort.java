/**  
 * @Title: QuickSort.java
 * @Prject: leetcode
 * @Package: exercise
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年3月10日 上午10:30:11
 */
package exercise;

import java.util.Arrays;

/**
 * @ClassName: QuickSort
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年3月10日 上午10:30:11
 */
public class QuickSort {
	int count  = 0;
	
	public void quickSort(int[] a, int low, int high){
		System.out.println("----------"+count+"----------"+low+"----"+high+"----");
		System.out.println(Arrays.toString(a));
		count++;
		if(low >= high){
			return;
		}
//		int  key =low + ((high - low)>>1);
		int key = GetMiddleValue(a, low, high);
		int pivot = a[key];//枢轴
		if( key != low){
			a[key] ^= a[low]; 
			a[low] ^= a[key];
			a[key] ^= a[low];
		}
	    int left = low;
	    int right = high;
       while (low<high) {
    	   while (a[high] >= pivot&&low<high) {
    		   high--; 
    		   }
       	 a[low]=a[high];
       	while (a[low] <= pivot&&low<high) {
       		low++; 
               } 
          a[high]=a[low];
       } 
       a[low]=pivot;
       quickSort(a, left,low-1); 
       quickSort(a,low+1, right);
       System.out.println(Arrays.toString(a));
	}

	/**
	 * @Title: main
	 * @Description: TODO 
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		QuickSort a = new QuickSort();
		int[] nums = {3,5,3,7,8,10,12,6,5,4,3,2,1};
		a.quickSort(nums, 0, nums.length-1);
//		System.out.println(Arrays.toString(nums));

	}
	
	
	//3值取中值
	int GetMiddleValue(int A[],int low,int high){
		int mid=low+(high-low)>>1;
	 //low - mid  low -high
       	//mid - low high -low
       	//low - mid high -low // mid -low low -high
       	int y1=A[low]>A[mid]?low:mid;
       	int y2=A[low]>A[high]?low:high;
       	int y3=A[mid]>A[high]?mid:high;
	 
       	if (y1==y2){
       		return y3;
       	}else{
       		return A[y1]>A[y2] ? y2:y1;
       	}
	}

}
