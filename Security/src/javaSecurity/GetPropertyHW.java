package javaSecurity;
import java.security.AccessControlException;
/**
 * @author DJS
 * @version 1.0
 */
/**
 * GetPropertyHW - It is to get system properties demanded by the assignment.
 */
public class GetPropertyHW {
	public static void main(String args[]) {
		/*
		 * No security manager is enabled by default. Thus all security checks 
		 * to protected resources and operations are disabled. In order to enable 
		 * security checks, the security manager must be enabled.
		 */
		//As the security manager is disabled,we can read/write all the system properties.
		System.out.println("java.home : "+System.getProperty("java.home"));
		System.out.println("user.name : "+System.getProperty("user.name"));
		System.out.println("user.dir : "+System.getProperty("user.dir"));
		System.out.println("os.name : "+System.getProperty("os.name"));
		System.out.println("os.version : "+System.getProperty("os.version"));
		//Enabling the security manager,as it might throw SecurityException we have a try-catch block surrounding it.
		try{
			//Creating an object of SecurityManager class.
			SecurityManager securityManager=new SecurityManager();
			//Setting the securityManager object to the current system.
			System.setSecurityManager(securityManager);
			//Printing the securityManager's address.
			System.out.println("Security manager is set as "+System.getSecurityManager());
		}catch(SecurityException se) {
			System.out.println("Secuirty Exception :( ");
		}
		//Attempting to change-user name as the securityManager object is set to the current system, user.name property will throw AccessControlException. 
		try {
			//trying to change the user.name to TLG.
			System.setProperty("user.name", "Shah Dhruvalkumar J.");
			System.out.println("New Java User name is : "+System.getProperty("user.name"));
		}catch(AccessControlException ace) {
			System.out.println("Write access to the user.name system property is not allowed! ");
		}
	}
}