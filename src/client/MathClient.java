package client;

import java.net.*;
import java.io.*;
import java.util.*;
import server.*;

public class MathClient {
    public static void main(String[] args) {
        try(Socket s = new Socket("localhost", MathServer.ECHO_PORT);
            Scanner console = new Scanner(System.in)){
            //send to server with a PrintWriter
            PrintWriter sendToServer = new PrintWriter(s.getOutputStream(), true);
            //receive the echo back with Scanner
            Scanner readFromClient = new Scanner(s.getInputStream());
            //prompt user
            System.out.print("> ");
            sendToServer.println(console.nextLine());
            //receive the echo from the server
            while(readFromClient.hasNextLine()){
                System.out.println(readFromClient.nextLine());
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
