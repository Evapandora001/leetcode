package game163;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class IDScore {
	int ID;
	int score;

	public IDScore(int ID, int score) {
		this.ID = ID;
		this.score = score;
	}

	public String toString() {
		return ID + ":" + score;
	}
}

class RankIDScore implements Comparator<IDScore> {
	@Override
	public int compare(IDScore o1, IDScore o2) {
		if (o1.score != o2.score)
			return o2.score - o1.score;
		return o1.ID - o2.ID;
	}

}

public class Main {

	public static void main(String[] args) {
		Main a = new Main();
		a.start();
	}

	public void start() {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {

			int K = in.nextInt();
			int L = in.nextInt();
			int M = in.nextInt();
			ArrayList<HashSet<Integer>> item_users = new ArrayList<HashSet<Integer>>();
			ArrayList<ArrayList<Integer>> user_items = new ArrayList<ArrayList<Integer>>();
			int[] itemFre = new int[L];
			// item - item sim list
			ArrayList<ArrayList<IDScore>> itemSim = new ArrayList<ArrayList<IDScore>>();
			for (int i = 0; i < L; i++) {
				item_users.add(new HashSet<Integer>());
				itemSim.add(new ArrayList<IDScore>());
			}
			for (int i = 0; i < M; i++) {
				ArrayList<Integer> eleItem = new ArrayList<Integer>();
				int userID = i;
				for (int j = 0; j < L; j++) {
					int itemID = j;
					int record = in.nextInt();
					if (record == 1) {
						itemFre[itemID]++;
						item_users.get(itemID).add(userID);
						eleItem.add(itemID);
					}
				}
				user_items.add(eleItem);
			}
			if (K <= 0) {
				for (int i = 0; i < M; i++) {
					System.out.println();
				}
				continue;
			}
			ArrayList<IDScore> itemRank = new ArrayList<IDScore>();
			for (int itemID = 0; itemID < itemFre.length; itemID++) {
				itemRank.add(new IDScore(itemID, itemFre[itemID]));
			}
			Collections.sort(itemRank, new RankIDScore());
			int fre_id = 0;
			for (IDScore item_fre : itemRank) {
				itemFre[fre_id++] = item_fre.ID;
			}
			for (int i = 0; i < L; i++) {// itemA
				ArrayList<IDScore> ele = itemSim.get(i);
				for (int j = i + 1; j < L; j++) {// itemB
					int score = sim(item_users.get(i), item_users.get(j));
					if (score != 0) {
						ele.add(new IDScore(j, score));
						itemSim.get(j).add(new IDScore(i, score));
					}
				}
				if (ele.size() != 0)
					Collections.sort(ele, new RankIDScore());
			}
			ArrayList<IDScore> userItemScore = new ArrayList<IDScore>();
			HashMap<Integer, Integer> eleItemScore = new HashMap<Integer, Integer>();
			HashSet<Integer> seedItem = new HashSet<Integer>();
			for (int userID = 0; userID < M; userID++) {
				eleItemScore.clear();
				seedItem.clear();
				userItemScore.clear();
				ArrayList<Integer> items = user_items.get(userID);
				if (items.size() != 0)
					seedItem.addAll(items);
				for (int itemID : items) {
					ArrayList<IDScore> simItems = itemSim.get(itemID);
					int count = 0;
					for (int i = 0; i < simItems.size(); i++) {
						IDScore item_score = simItems.get(i);
						int item_id = item_score.ID;
						int score = item_score.score;
						if (seedItem.contains(item_id))
							continue;
						count++;
						if (eleItemScore.containsKey(item_id)) {
							eleItemScore.put(item_id, score + eleItemScore.get(item_id));
						} else {
							eleItemScore.put(item_id, score);
						}
						if (count == K)
							break;
					}
				} // item sim over
				for (int item_id : eleItemScore.keySet()) {
					int score = eleItemScore.get(item_id);
					userItemScore.add(new IDScore(item_id, score));
				}
				Collections.sort(userItemScore, new RankIDScore());
				int[] recommend = new int[K];
				int cur = 0;
				for (IDScore item_score : userItemScore) {
					int item_id = item_score.ID;
					if (cur == K)
						break;
					recommend[cur++] = item_id;
					seedItem.add(item_id);
				}
				if (cur != K) {
					for (int i = 0; i < itemFre.length; i++) {
						int item_id = itemFre[i];
						if (cur == K)
							break;
						if (seedItem.contains(item_id))
							continue;
						recommend[cur++] = item_id;
					}
				}
				Arrays.sort(recommend);
				System.out.print(recommend[0]);
				for (int i = 1; i < recommend.length; i++) {
					System.out.print(" " + recommend[i]);
				}
				System.out.println();
			}
		}
	}

	private int sim(HashSet<Integer> itemA, HashSet<Integer> itemB) {
		int a = itemA.size();
		int b = itemB.size();
		HashSet<Integer> itemC = new HashSet<Integer>(itemB);
		for (int ele : itemA)
			itemC.add(ele);
		return a + b - itemC.size();
	}
}
