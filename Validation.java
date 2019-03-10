package project1; 
import java.util.Map; 
import java.util.HashMap;
public class Validation {
	Map<String, String> bankaccounts;
	public Validation() {
		bankaccounts = new HashMap<String, String>();
		bankaccounts.put("ahmed", "1234");
		bankaccounts.put("2200", "3322");		
		bankaccounts.put("3300", "343");
		bankaccounts.put("4400", "2342");
		}
	public boolean validate(String username, String password) {
		boolean vald = false;
		String fetchedusername = bankaccounts.get(username);
		if(fetchedusername != null) {
			vald = fetchedusername.equals(password);
		}
		return vald;
		//validate username and password
	}

}
