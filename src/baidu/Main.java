///**  
// * @Title: Main.java
// * @Prject: leetcode
// * @Package: baidu
// * @Description: TODO
// * @author: Evapandora  
// * @date: 2016年4月21日 下午8:22:22  
// */
//package baidu;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//import java.util.Stack;
//
//import hard.MergeIntervals;
//
//
///**
// * @ClassName: Main
// * @Description: TODO
// * @author: Evapandora
// * @date: 2016年4月21日 下午8:22:22
// */
//public class Main {
//
//	/**
//	 * @Title: main
//	 * @Description: TODO
//	 * @param args
//	 * @return: void
//	 */
//	public static void main(String[] args) {
//		// Scanner scan = new Scanner(System.in);
//		Scanner scan = null;
//		try {
//			scan = new Scanner(new File("baidu//data"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String line = "";
//		while (scan.hasNext()) {
//			line=scan.nextLine();
//			System.out.println(line);
//			int m = countLine(line);
//			int[][] cost = new int[m][2];
//			for(int i = 0; i < m; i++){
//				String[] info = scan.nextLine().split(" ");
//				cost[i][0] = Integer.parseInt(info[0]);
//				cost[i][1] = Integer.parseInt(info[1]);
//			}
//			if(line.length() % 2 != 0){
//				System.out.println("-1");
//				continue;
//			}
//			
//			int min = backtrace(cost,line,0,0,0,0,0,m);
//		}
//	}
//
//	private static int backtrace(int[][] cost,String line, int index, int left, int right, int ele, int num, int m) {
//		if(index == line.length()){
//			if(num == m){
//				return ele;
//			}else{
//				return -1;
//			}
//		}
////		if(line.charAt(index) == '(') return backtrace(cost,line, index+1, left+1, right, ele, num);
////		if(line.charAt(index) == ')') return backtrace(cost,line, index+1, left+1, right, ele);
////		int min1 = backtrace(cost, line, index+1, left+1, right, ele+cost[index][0]);
////		int min2 = backtrace(cost, line, index+1, left, right+1, ele+cost[index][1]);
//		if(min1 == -1 && min2==-1){
//			return -1;
//		}
//		if(min1 == -1 || min2==-1){
//			return Math.max(min1, min2);
//		}else{
//			return Math.min(min1, min2);
//		}
//	}
//
//	private static int countLine(String line) {
//		int count = 0;
//		for (char ch : line.toCharArray()) {
//			if (ch == '?')
//				count++;
//		}
//		return count;
//	}
//
//}
