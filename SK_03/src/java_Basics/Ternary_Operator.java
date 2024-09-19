package java_Basics;

public class Ternary_Operator {

	public static void main(String[] args) 
	{
		int a=10,b=20,c=40;
		
		int min=(a<b)?a:b;
		System.out.println(min);
		
		int min1= a<b?(a<c?a:c):(b<c?b:c);
		System.out.println(min1);
		
		
		int max= a>b?(a>c?a:c) :(b>c?b:c);
		System.out.println(max);
		

	}

}
