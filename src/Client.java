import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Enter a number: ");
            String numberStr = userInput.readLine();
            int number = Integer.parseInt(numberStr);

            out.println(numberStr);

            String response = in.readLine();
            System.out.println("Is the number prime? " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
