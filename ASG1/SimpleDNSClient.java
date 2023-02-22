
/*
This is a student starting point for the SimpleDNSClient
It is based on:
http://www.avajava.com/tutorials/lessons/how-do-i-use-a-host-name-to-look-up-an-ip-address.html
*/
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SimpleDNSClient {
  public static void main(String[] args) {
    try {
      // start by getting and displaying the local address
      // where you are running the program from
      InetAddress inetAddress = InetAddress.getLocalHost();

      displayStuff("local host", inetAddress);

      // now get the address of the URL passed on the
      // cmd line, and display it's info
      System.out.print("--------------------------");

      inetAddress = InetAddress
          .getByName(args[0]);/* call get by name, passing in the cmd line arg to get the address */
      displayStuff(args[0], inetAddress);

      // finally get the other addresses associated with
      // the one specified and display their info
      System.out.print("--------------------------");
      InetAddress[] inetAddressArray = InetAddress.getAllByName(args[0]);
      for (int i = 0; i < inetAddressArray.length; i++) {
        displayStuff(args[0] + " #" + (i + 1), inetAddressArray[i]);
      }
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }

  // display info from address, where whichHost is the user entered URL
  // and inetAddress is the internet address corresponding to whichHost
  public static void displayStuff(String whichHost, InetAddress inetAddress) {
    System.out.println("--------------------------");
    System.out.println("Which Host: " + whichHost);/* print which host */
    System.out.println("Canonical Host Name: "
        + inetAddress.getCanonicalHostName());/* print the canonical host name from the inetAddress */
    System.out.println("Host Name: " + inetAddress.getHostName());/* print the host name from the inetAddress */
    System.out
        .println("Host Address: " + inetAddress.getHostAddress());/* print the host address from the inetAddress */
  }
}
