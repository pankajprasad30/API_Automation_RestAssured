package payload_data;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cookies_Payload 
{
	public static Map SetCookiesData()
	{
		Map<String, Object> mp=new LinkedHashMap<String, Object>();
		mp.put("UserName", "pankajprasad30");
		mp.put("Password", "Automation@123");
		
		return mp;
	}

}
