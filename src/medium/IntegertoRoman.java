package medium;

public class IntegertoRoman {
//	I = 1;
//	V = 5;
//	X = 10;
//	L = 50;
//	C = 100;
//	D = 500;
//	M = 1000;
    public String intToRoman(int num) {
    	String str="";  
        String symbol[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};  
        int value[]=         { 1000,900,  500,400,  100,90,   50, 40,  10,  9,    5,   4,    1}; 
        int flag=0;
        while(flag<value.length){
        	if(value[flag]<=num){
        		str+=symbol[flag];
        		num-=value[flag];
        		}else{
        			flag++;
        			}
        	}
        return str;
    }

	public static void main(String[] args) {
		IntegertoRoman a=new IntegertoRoman();
		System.out.println(a.intToRoman(800));
		System.out.println(a.intToRoman(999));
		System.out.println(a.intToRoman(3000));
	}

}
