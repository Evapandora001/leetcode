/**  
 * @Title: EditDistance.java
 * @Prject: leetcode
 * @Package: hard
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月23日 上午10:52:51
 */
package hard;

/**
 * @ClassName: EditDistance
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月23日 上午10:52:51
 */
public class EditDistance {
	
    public int minDistance(String word1, String word2) {
    	if(word1.equals(word2)){
    		return 0;
    	}
        if(word1.length()==0||word2.length()==0){
        	return word1.length()==0? word2.length():word1.length();
        }
        int[][] step=new int[word1.length()+1][word2.length()+1];
        step[0][0]=0;
        for(int i=0;i<=word1.length();i++){
        	step[i][0]=i;
        }
        for(int i=0;i<=word2.length();i++){
        	step[0][i]=i;
        }
        for(int i=1;i<=word1.length();i++){
        	char a=word1.charAt(i-1);
        	for(int j=1;j<=word2.length();j++){
        		char b=word2.charAt(j-1);
        		if(a==b){
        			step[i][j]=step[i-1][j-1];//no change
        		}else{
        			step[i][j]=Integer.min(Integer.min(step[i-1][j-1],step[i-1][j]),step[i][j-1])+1;// replace insert delete
        		}
        	}
        }
        return step[word1.length()][word2.length()];
    }

	public static void main(String[] args) {
		EditDistance a=new EditDistance();
		System.out.println(a.minDistance("ac","bdad"));
		System.out.println(a.minDistance("","bdad"));
		System.out.println(a.minDistance("adfadsfasdfawdf","egwergwr3tg"));
	}

}
