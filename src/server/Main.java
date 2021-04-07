/**
 * Lab 10 Demo: server.Main
 *
 * @author Michael Valdron
 * created at 2021/03/30
 */
package server;

public class Main {

    public static void main(String[] args) {

        try {
            MessageServer.start((args.length > 1) ? Integer.parseInt(args[0]) : 8080);
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }

}
