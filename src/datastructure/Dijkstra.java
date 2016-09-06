/**  
 * @Title: Dijkstra.java
 * @Prject: leetcode
 * @Package: datastructure
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年8月9日 下午1:32:15  
 */
package datastructure;

/**
 * @ClassName: Dijkstra
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年8月9日 下午1:32:15
 */
public class Dijkstra {
	private int[][] mMatrix; // 邻接矩阵
	private static final int INF = Integer.MAX_VALUE; // 最大值

	public void dijkstra(int vs, int[] dist) {
		boolean[] visited = new boolean[dist.length];
		visited[vs] = true;
		for (int i = 0; i < dist.length; ++i)
			dist[i] = mMatrix[vs][i];
		int k = -1;
		int interator = dist.length - 1;
		while (interator-- != 0) {
			// get min path
			int min = INF;
			for (int i = 0; i < dist.length; i++) {
				if (visited[i])
					continue;
				if (dist[i] < min) {
					k = i;
					min = dist[i];
				}
			}
			visited[k] = true;
			// update
			for (int i = 0; i < dist.length; ++i) {
				if (visited[i] || mMatrix[k][i] == INF)
					continue;
				dist[i] = Math.min(dist[i], dist[k] + mMatrix[k][i]);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
