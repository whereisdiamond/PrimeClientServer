import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                System.out.print("Enter a number (type 'exit' to quit): ");
                String input = userInput.readLine();

                if (input.equalsIgnoreCase("exit")) {
                    break; // Exit the loop if the user types 'exit'
                }

                try {
                    int number = Integer.parseInt(input);

                    out.println(input);

                    String response = in.readLine();
                    System.out.println("Is the number prime? " + response);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
