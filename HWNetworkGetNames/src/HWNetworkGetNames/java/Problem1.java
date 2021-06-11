package HWNetworkGetNames.java;
import java.net.*;
public class Problem1 {
	public static void main(String args[]) {
		try {
			//get local machines name.
			InetAddress localhost;
			localhost=InetAddress.getLocalHost();
			System.out.println("your IP address is : "+localhost.getHostAddress());
			System.out.println("1) Your system is : "+localhost);
			//List all addresses for host google.com
			InetAddress[] google=InetAddress.getAllByName("www.google.com");
			System.out.println("2) Google's host address list : ");
			for(InetAddress addr:google) {
				System.out.println(addr.getHostAddress());
			}
			//Get host name from address.
			InetAddress address1=InetAddress.getByName("www.charusat.ac.in");
			System.out.println("3) IP address for : "+address1.getHostName());
			System.out.println(address1.getHostAddress());
			//getting IP address from domain.
			InetAddress favAddress=InetAddress.getByName("www.charusat.ac.in");
			System.out.println("4) My favorite address IP Address for "+favAddress.getHostName());
			System.out.println(favAddress.getHostAddress());
		}
		catch(UnknownHostException e) {
			System.out.println("Host Unknown.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
