/**  
 * @Title: LargestRectangleinHistogram.java
 * @Prject: leetcode
 * @Package: hard
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月28日 下午3:14:34
 */
package hard;

import java.util.Stack;

/**
 * @ClassName: LargestRectangleinHistogram
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月28日 下午3:14:34
 */
public class LargestRectangleinHistogram {
/**
 * @Title: largestRectangleArea
 * @Description: O(n^2) 外加 剪枝
 * @param height
 * @return
 * @return: int
 */
	public int largestRectangleArea_1(int[] height) {
		int width=0,ele=0,max=0,left=0,right=0;
		int preLeft=0,preRight=0,preWidth=0;
		for(int i=0;i<height.length;i++){
			ele=height[i];
			width=1;
			left=i-1;
			right=i+1;
			//剪枝
			if(i!=0){
				if(ele==height[i-1]){
					continue;//若ele相同，直接跳过，因为所得矩形面积和上一个一样
				}else{
					if(ele<height[i-1]){//如果ele比上一个小，那么有必要朝 上一个的两侧 进行延伸
						width=preWidth;
						left=preLeft;
						right=preRight;
					}
				}
			}
			//---------------------------
			while(left>=0&&height[left]>=ele){
				width++;
				left--;
			}
			while(right<=height.length-1&&height[right]>=ele){
				width++;
				right++;
			}
			preLeft=left;
			preRight=right;
			preWidth=width;
			if(max<width*ele){
				max=width*ele;
//				System.out.println("i="+i+",left="+(left+1)+",right="+(right-1));
//				System.out.println(max);
			}
		}
		return max;
    }
	
	/**
	 * 
	 * @Title: largestRectangleArea
	 * @Description: stack O(n)
	 * @param height
	 * @return
	 * @return: int
	 */
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int max=0,area=0,left=0,right=0,currentHeightIndex=0;
		Stack<Integer> boundary=new Stack<Integer>();
		for(int i=0;i<height.length;i++){
			if(boundary.isEmpty()){
				boundary.push(i);
				continue;
			}
			int ele=height[i];
			if(ele==height[boundary.peek()]){
				boundary.pop();
				boundary.push(i);
				continue;
			}
			if(ele>height[boundary.peek()]){
				boundary.push(i);
			}else{
				currentHeightIndex=boundary.pop();
				right=i-1;
				left=boundary.isEmpty()? 0:boundary.peek()+1;
				area=height[currentHeightIndex]*(right-left+1);
				if(max<area){
					max=area;
//					System.out.println("height="+height[currentHeightIndex]+",left="+(left)+",right="+(right));
//					System.out.println(max);
				}
				i--;
			}
		}
//		System.out.println(boundary.toString());
		right=height.length-1;
		while(!boundary.isEmpty()){
			currentHeightIndex=boundary.pop();
			left=boundary.isEmpty()? 0:boundary.peek()+1;
			area=height[currentHeightIndex]*(right-left+1);
			if(max<area){
				max=area;
//				System.out.println("height="+height[currentHeightIndex]+",left="+(left)+",right="+(right));
//				System.out.println(max);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		LargestRectangleinHistogram a=new LargestRectangleinHistogram();
		int[] height=new int[]{2,1,5,6,2,3};
		System.out.println(a.largestRectangleArea(height));
	}

}
