package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofPhoneNumber {
	
//	1:empty
//	2:a b c
//	3:d e f
//	4:g h i
//	5:j k l
//	6:m n o 
//	7:pqrs
//	8:tuv
//	9:wxyz
	
//public List<String> letterCombinations(String digits) {
//	String[] letter={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//     List<String> res=new LinkedList<String>();
//     List<String[]> resPart=new LinkedList<String[]>();
//    int dig[]=new int[10];
//    for(int i=0;i<digits.length();i++){
//    	dig[i-'0']++;
//    }
//    for(int i=2;i<=9;i++){
//    	if(dig[i]==0) continue;
//    	List<String> ele=new LinkedList<String>();
//    	String seed=letter[i];
//    	int rep=dig[i];
//    	for()
//    }
//     
//     return res;
//    }

	public static void main(String[] args) {
		LetterCombinationsofPhoneNumber a=new LetterCombinationsofPhoneNumber();
		System.out.println(a.letterCombinations("222").toString());
	}
//	Map<Integer, List<String>> digitMap = new HashMap<Integer, List<String>>();
//  digitMap.put(2, Arrays.asList(new String[] {"a", "b", "c"}));
//  digitMap.put(3, Arrays.asList(new String[] {"d", "e", "f"}));
//  digitMap.put(4, Arrays.asList(new String[] {"g", "h", "i"}));
//  digitMap.put(5, Arrays.asList(new String[] {"j", "k", "l"}));
//  digitMap.put(6, Arrays.asList(new String[] {"m", "n", "o"}));
//  digitMap.put(7, Arrays.asList(new String[] {"p", "q", "r", "s"}));
//  digitMap.put(8, Arrays.asList(new String[] {"t", "u", "v"}));
//  digitMap.put(9, Arrays.asList(new String[] {"w", "x", "y", "z"}));
	
    public List<String> letterCombinations(String digits) {
//    	String[] letter={"","","a b c","d e f","g h i","j k l","m n o","p q r s","t u v","w x y z"};
    	String[] letter={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<String>();
        if(digits.length() == 0)
            return result;
        if(digits.length() == 1)
            return Arrays.asList(letter[digits.charAt(0) - '0'].split(""));//abc-->"" "a" "b" "c" aslist 自动去除第一个空
        List<String> intermediate = letterCombinations(digits.substring(1, digits.length()));
        for(char first :letter[digits.charAt(0) - '0'].toCharArray()){
//        	if(first==' ') continue;
			for(String rest : intermediate)
                result.add(first + rest);//repetition eg ab ba is allowed
        }
        return result;
    }

}
