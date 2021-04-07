/**
 * Lab 10 Demo: server.ClientHandler
 *
 * @author Michael Valdron
 * created at 2021/03/30
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            var out = new PrintWriter(socket.getOutputStream(), true);
            var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line;
            while (!socket.isClosed() && (line = in.readLine()) != null) {
                if (line.equals("\\q")) {
                    out.println("Bye.");
                    break;
                }

                //This line is output to the server window
                System.out.println(line);
                //This line is output to the client window
                out.println(line);
            }

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void stop() {
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
