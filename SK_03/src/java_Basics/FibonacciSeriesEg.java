package java_Basics;

public class FibonacciSeriesEg {

	public static void main(String[] args) 
	{
		// 0 1 1 2 3 5 8 13............
		
		int n1=0;
		int n2=1;
		int n3;
		int count =10;
		//System.out.println(n1+" "+n2);
		
		for (int i=2;i<count;i++)
		{
			n3=n1+n2;
			System.out.print(" "+n3);
			n1=n2;
			n2=n3;
		}

	}

}

