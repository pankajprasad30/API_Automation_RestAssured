package pojoMapper;

public class CreateUser 
{
	public static Object createUser()
	{
		CreateUserPOJO emp=new CreateUserPOJO();
		emp.setName("Pankaj");
		emp.setJob_ID("QA-1234");
		emp.setJob("QA_Manager");
		emp.setLocation("Dubai");
		return emp;
	}

}
