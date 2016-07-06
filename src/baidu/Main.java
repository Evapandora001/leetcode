/**  
 * @Title: MainProblemC.java
 * @Prject: leetcode
 * @Package: baidu
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年5月14日 下午1:45:50
 */
package baidu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * @ClassName: MainProblemC
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年5月14日 下午1:45:50
 */
public class Main {

	private PreNode root = new PreNode();

	class PreNode {
		boolean isWord;
		PreNode[] child = new PreNode[26];
		
	}

	public static void main(String[] args) {
		Main a = new Main();
		a.start();
	}

	private void start() {
		// Scanner scan = new Scanner(System.in);
		Scanner scan = null;
		try {
			scan = new Scanner(new File("baidu//data"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int N = Integer.parseInt(scan.nextLine().trim());
		while (N-- != 0) {
			String[] info = scan.nextLine().trim().split(" ");
			if(info[0].equals("insert")){
				insert(info[1].trim());
			}else{
				if(info[0].equals("search")){
					search(info[1].trim());
				}else{
					if(info[0].equals("delete")){
						delete(info[1].trim());
					}
				}
			}
		}
	}

	private void delete(String pre) {
		if(pre.length() == 0){
			return;
		}
		PreNode node = root;
		char[] chs = pre.toCharArray();
		for(int i = 0; i < chs.length-1; i++){
			int index = chs[i] - 'a';
			if(node.child[index] == null){
				return;
			}else{
				node = node.child[index];
			}
		}
		node.child[chs[chs.length-1] - 'a'] = null;
	}

	private void search(String pre) {
		PreNode node = root;
		for(char ch : pre.toCharArray()){
			int index = ch - 'a';
			if(node.child[index] == null){
				System.out.println("No");
				return;
			}else{
				node = node.child[index];
			}
		}
		System.out.println("Yes");
	}

	private void insert(String word) {
		PreNode node = root;
		for(char ch : word.toCharArray()){
			int index = ch - 'a';
			if(node.child[index] == null){
				node.child[index] = new PreNode();
			}
			node = node.child[index];
		}
		node.isWord = true;
	}
}
