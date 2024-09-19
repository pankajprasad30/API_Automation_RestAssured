package sK_03;

class one
{
	int age;
	float salary;
	
	void employee(int age, float salary)
	{
		this.age=age;
		this.salary=salary;
		System.out.println(age +" " + salary);
	}
	
}

public class This_Keyword 
{

	public static void main(String[] args) 
	{
		one obj=new one();
		obj.employee(39, 125000);

	}

}
