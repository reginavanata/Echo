package server;

import java.net.*;
import java.io.*;
import java.util.*;

public class EchoServer {
    public static final int ECHO_PORT = 8250;

    public static void main(String[] args) {

        try(ServerSocket s = new ServerSocket(ECHO_PORT)) {
            System.out.println("Server starting");
            while(true){
                //wait for client request
                Socket client = s.accept();
                //create PrintWriter
                PrintWriter sendToClient = new PrintWriter(client.getOutputStream(), true);
                Scanner readFromClient = new Scanner(client.getInputStream());
                //while the readFromClient has strings to give us to echo back
                while(readFromClient.hasNextLine()){
                    sendToClient.println("echo: " + readFromClient.nextLine());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
