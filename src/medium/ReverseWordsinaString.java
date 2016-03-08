/**  
 * @Title: ReverseWordsinaString.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年3月3日 下午3:11:05
 */
package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @ClassName: ReverseWordsinaString
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年3月3日 下午3:11:05
 */
public class ReverseWordsinaString {
	
	 public String reverseWords(String s) {
		    String[] words = s.trim().split(" +");
		    System.out.println(Arrays.toString(words));
		    System.out.println(Arrays.asList(words).toString());
		    Collections.reverse(Arrays.asList(words));
		    System.out.println(Arrays.asList(words).toString());
		    System.out.println(Arrays.toString(words));
		    return String.join(" ", words);
		}
	
	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		ReverseWordsinaString a = new ReverseWordsinaString();
		System.out.println(a.reverseWords("   a    b     c     d   e   f         "));
		System.out.println(a.reverseWords("  a  b  "));
		System.out.println(a.reverseWords(""));
		System.out.println(a.reverseWords("a"));
		System.out.println(a.reverseWords(" a "));
	}

}
