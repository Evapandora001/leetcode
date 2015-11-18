package easy;

public class RomantoInteger {
//	I = 1;
//	V = 5;
//	X = 10;
//	L = 50;
//	C = 100;
//	D = 500;
//	M = 1000;
	
    public int romanToInt(String s) {
    	int num=0;
        String symbol[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};  
        int value[]=         { 1000,900,  500,400,  100,90,   50, 40,  10,  9,    5,   4,    1}; 
        int j=0;
        while(!s.isEmpty()){
        	while(s.startsWith(symbol[j])==false){
        		j++;
        	}
        	num+=value[j];
        	s=s.substring(symbol[j].length());
        }
    	return num;
    }
    
	public static void main(String[] args) {
		RomantoInteger a=new RomantoInteger();
		System.out.println(a.romanToInt("DCCC"));//800
		System.out.println(a.romanToInt("CMXCIX"));//999
		System.out.println(a.romanToInt("MMM"));//3000

	}
	
	
//	The logic here is that, if a current character value is greater than that of the previous,
//	we have to subtract it. We subtract twice, 
//	because previously iteration had blindly added it. :) Hope this helps.
	/*
	 * public int romanToInt(String str) {
    int[] a = new int[26];
    a['I' - 'A'] = 1;
    a['V' - 'A'] = 5;
    a['X' - 'A'] = 10;
    a['L' - 'A'] = 50;
    a['C' - 'A'] = 100;
    a['D' - 'A'] = 500;
    a['M' - 'A'] = 1000;
    char prev = 'A';
    int sum = 0;
    for(char s : str.toCharArray()) {
        if(a[s - 'A'] > a[prev - 'A']) {
            sum = sum - 2 * a[prev - 'A'];
        }
        sum = sum + a[s - 'A'];
        prev = s;
    }
    return sum;
}
	 */

}
