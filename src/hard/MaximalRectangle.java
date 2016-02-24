/**  
 * @Title: MaximalRectangle.java
 * @Prject: leetcode
 * @Package: hard
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月21日 下午4:26:11  
 */
package hard;

import java.util.Stack;

/**
 * @ClassName: MaximalRectangle
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月21日 下午4:26:11
 */
public class MaximalRectangle {
	
    public int maximalRectangle_1(char[][] matrix) {
    	if(matrix.length==0){
    		return 0;
    	}
    	int max=0;
    	int[] height=new int[matrix[0].length];
    	for(int i=0; i<matrix.length; i++){
    		for(int j=0; j<matrix[i].length; j++){
    			height[j]=0;
    			int base=i;
    			while(base!=-1){
    				if(matrix[base][j]=='0'){
    					break;
    				}else{
    					height[j]++;
    				}
    				base--;
    			}
    		}
    		max=Integer.max(max, largestRectangleArea(height));
    	}
    	return max;
    }
    
    
    
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
				}
				i--;
			}
		}
		right=height.length-1;
		while(!boundary.isEmpty()){
			currentHeightIndex=boundary.pop();
			left=boundary.isEmpty()? 0:boundary.peek()+1;
			area=height[currentHeightIndex]*(right-left+1);
			if(max<area){
				max=area;
			}
		}
		return max;
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//confused : 合并函数 之后 反而 更慢了
	 public int maximalRectangle(char[][] matrix) {
	    	if(matrix.length==0){
	    		return 0;
	    	}
	    	int maxArea=0;
	    	int[] height=new int[matrix[0].length];
	    	for(int row=0; row<matrix.length; row++){
	    		
	    		int max=0,area=0,left=0,right=0,currentHeightIndex=0;
	    		Stack<Integer> boundary=new Stack<Integer>();
	    		
	    		for(int i=0; i<matrix[0].length; i++){
	    			height[i]=0;
	    			int base=row;
	    			while(base!=-1){
	    				if(matrix[base][i]=='0'){
	    					break;
	    				}else{
	    					height[i]++;
	    				}
	    				base--;
	    			}
	    			
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
	    				}
	    				i--;
	    			}
	    			
	    		}
	    		right=height.length-1;
	    		while(!boundary.isEmpty()){
	    			currentHeightIndex=boundary.pop();
	    			left=boundary.isEmpty()? 0:boundary.peek()+1;
	    			area=height[currentHeightIndex]*(right-left+1);
	    			if(max<area){
	    				max=area;
	    			}
	    		}
	    		maxArea=Integer.max(maxArea, max);
	    	}
	    	return maxArea;
	    }

}
