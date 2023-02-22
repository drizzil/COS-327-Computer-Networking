import java.io.*;
import java.net.*;

public class WebClient {
  public static void main(String[] args) throws Exception {

    String host = "localhost";
    int portnum = 3000;
    String page = "test.html";
    if (args.length == 1) {
      if (args[0].equals("-?")) {
        System.out.println("Usage: java WebClient <server host ip> <server port> <page>");
      } else {
        System.out.println("Wrong input");
      }
    } else if (args.length == 3) {
      host = args[0];
      portnum = Integer.parseInt(args[1]);
      page = args[2];
    } else {
      System.err.println("Error: wrong amount of inputs. -? for help");
    }

    // Open a socket and connect to the server.
    Socket socket = new Socket(host, portnum);

    // Open input and output streams to the server.
    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());

    String path = inFromServer.readLine();
    // System.out.println("PATH: " + path);
    path = "/" + path + "/" + page;
    // Send a request to the server.
    String request = "GET " + path + " HTTP/1.0\r\n\r\n/";
    outToServer.writeBytes(request);

    // Read the response from the server.
    // String response = "";
    String line = inFromServer.readLine();

    while (line != null) {
      System.out.println(line);
      line = inFromServer.readLine();
    }

    // Print the response to the console.
    // System.out.println(response);

    // Close the socket.
    socket.close();
  }
}
