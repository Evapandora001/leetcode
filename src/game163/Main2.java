/**  
 * @Title: Main2.java
 * @Prject: leetcode
 * @Package: game163
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年9月18日 下午9:31:31
 */
package game163;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class HuffmanNode {
	char value;
	HuffmanNode left;
	HuffmanNode right;

	public HuffmanNode(char c) {
		this.value = c;
	}
}

public class Main2 {

	public static void main(String[] args) {
		Main2 a = new Main2();
		a.start();
	}

	private void start() {
		Scanner in = new Scanner(System.in);
		String efiles = in.nextLine();
		int N = Integer.parseInt(in.nextLine());
		HuffmanNode root = new HuffmanNode('.');
		N -= 2;
		HashMap<String, String> codeMap = new HashMap<String, String>();
		while ((N--) > 0) {
			String line = in.nextLine();
			String charv = line.split(" ")[0];
			String code = line.split(" ")[1];
			TreeBuilding(root, charv, code, 0);
			codeMap.put(code, charv);
		}
		ArrayList<String> leaf = new ArrayList<String>();
		ArrayList<String> target = new ArrayList<String>();
		N = 2;
		while ((N--) > 0) {
			String line = in.nextLine();
			target.add(line.split(" ")[0]);
		}
		StringBuilder sb = new StringBuilder();
		preOrderTravese(root, leaf, sb);
		if (leaf.size() == 1) {
			String tString = leaf.get(0);
			leaf.remove(0);
			leaf.add(tString + "0");
			leaf.add(tString + "1");
		}
		codeMap.put(leaf.get(0), target.get(0));
		codeMap.put(leaf.get(1), target.get(1));
		TreeSet<String> result = new TreeSet<String>();
		String temp = solution(efiles, codeMap);
		result.add(temp);
		temp = temp.replace(target.get(0), "*");
		temp = temp.replace(target.get(1), target.get(0));
		temp = temp.replace("*", target.get(1));
		result.add(temp);
		for (String s : result)
			System.out.println(s);

	}

	public String solution(String efiles, Map<String, String> smap) {
		StringBuilder temp = new StringBuilder();
		int i = 0;
		while (i < efiles.length()) {
			for (int j = i + 1; j <= efiles.length(); j++) {
				String s = efiles.substring(i, j);
				if (smap.containsKey(s)) {
					temp.append(smap.get(s));
					i = j;
					break;
				}
			}
		}
		return temp.toString();
	}

	public void preOrderTravese(HuffmanNode root, List<String> leaf, StringBuilder path) {
		if (root.left == null && root.right == null)
			return;
		else if (root.left == null || root.right == null) {
			if (root.left == null)
				leaf.add(path.toString() + "0");
			else
				leaf.add(path.toString() + "1");
		}
		if (root.left != null) {
			path.append("0");
			preOrderTravese(root.left, leaf, path);
			path.deleteCharAt(path.length() - 1);
		}
		if (root.right != null) {
			path.append("1");
			preOrderTravese(root.right, leaf, path);
			path.deleteCharAt(path.length() - 1);
		}
	}

	public void TreeBuilding(HuffmanNode root, String charv, String code, int index) {
		if (index == code.length()) {
			return;
		}
		if (code.charAt(index) == '0') {
			if (root.left == null)
				root.left = new HuffmanNode('.');
			TreeBuilding(root.left, charv, code, index + 1);
		} else {
			if (root.right == null)
				root.right = new HuffmanNode('.');
			TreeBuilding(root.right, charv, code, index + 1);
		}
	}

}