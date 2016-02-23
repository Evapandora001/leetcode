/**  
 * @Title: UniqueBinarySearchTrees.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月23日 下午6:57:17
 */
package medium;

/**
 * @ClassName: UniqueBinarySearchTrees
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月23日 下午6:57:17
 */
public class UniqueBinarySearchTrees {
	
	
	public int numTrees(int n) {
		if(n==0){
			return 0;
		}
		int[] nums=new int[n+1];
		nums[0]=1;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				nums[i]+=nums[j-1]*nums[i-j];
			}
		}
		return nums[n];
    }
	
	
	public int numTrees_1(int n) {
		if(n==0){
			return 0;
		}
        return numTrees(1, n);//从1作为root开始，到n作为root结束
    }
     
    private int numTrees(int left, int right){
    	if(left>right){
    		return 1;
    	}
    	int count=0;
    	for(int i=left;i<=right;i++){
    		int lefts=numTrees(left, i-1);
    		int rights=numTrees(i+1, right);
    		count+=lefts*rights;
    	}
    	return count;
    }

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		UniqueBinarySearchTrees a=new UniqueBinarySearchTrees();
		System.out.println(a.numTrees(0));
		System.out.println(a.numTrees(1));
		System.out.println(a.numTrees(2));
		System.out.println(a.numTrees(3));
	}

}
