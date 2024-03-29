package demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Web server's main class - entrypoint of the HTTP server
        // Argument can be --port <port number> or --docRoot <colon delimited list of
        // directories>

        int port = 3000; // Initialising default port

        // Initialising default docRoot as Static folder which will be passed to server
        // as argument
        String currentDirectory = new File("").getAbsolutePath();
        List<String> docRoots = new ArrayList<>();
        docRoots.add(currentDirectory + "/Static");

        // Store arguments in a list
        List<String> arguments = Arrays.asList(args);

        // Implementation to read arguments and store their relevant information
        // accordingly
        if (arguments.contains("--port")) {
            // if argument contains --port, reassign port to the user specified port
            int indexPort = arguments.indexOf("--port");

            port = Integer.parseInt(arguments.get(indexPort + 1));

        } else if (arguments.contains("--docRoot")) {
            // if arguments contains --docRoot, reassign docRoot folder
            int indexDocRoot = arguments.indexOf("--docRoot");

            String userInputDocRoot = arguments.get(indexDocRoot + 1); // return the entire String
            if (userInputDocRoot.contains(":")) {
                // if the String contains ":", user has specified multiple docRoots hence split
                // them up and store them into the List<String> docRoots but first clear the
                // default value
                docRoots.clear();
                String[] temp = (userInputDocRoot.split(":"));
                for (String s : temp) {
                    docRoots.add(currentDirectory + s);
                }

            }
        }

        HttpServer myHttpServer = new HttpServer();
        try {
            myHttpServer.createServer(port, docRoots);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}