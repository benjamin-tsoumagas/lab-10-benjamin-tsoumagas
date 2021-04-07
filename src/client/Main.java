package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) {
        try {
            var connection = MessageClient.connect(
                    (args.length > 0) ? args[0] : "localhost",
                    (args.length > 1) ? Integer.parseInt(args[1]) : 8080
            );

            if (connection != null) {
                try {
                    var in = new BufferedReader(new InputStreamReader(System.in));

                    String line = null;
                    while (connection.isAlive() && (line = in.readLine()) != null && !line.equals("\\q")) {
                        System.out.println(connection.sendMessage(line));
                    }
                    if (line != null && line.equals("\\q")) {
                        System.out.println(connection.sendMessage(line));
                    }
                    in.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
                connection.close();
            } else {
                System.err.println("No connection made. ");
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }
}


