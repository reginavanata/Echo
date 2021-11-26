package server;

import java.net.*;
import java.io.*;
import java.util.*;

public class MathServer {
    public static final int ECHO_PORT = 8250;

    public static void main(String[] args) {

        try(ServerSocket s = new ServerSocket(ECHO_PORT)) {
            System.out.println("Server starting");
            String numbers = "10";
            try{
                String[] items = numbers.split(" ");
                int num1 = Integer.parseInt(items[0]);
                int num2 = Integer.parseInt(items[1]);
                //calculate and send back the results

            }catch (Exception e){
                System.out.println("Math protocol error");
            }
            while(true){
                //wait for client request
                Socket client = s.accept();
                //create PrintWriter
                PrintWriter sendToClient = new PrintWriter(client.getOutputStream(), true);
                Scanner readFromClient = new Scanner(client.getInputStream());
                //while the readFromClient has strings to give us to echo back
                while(readFromClient.hasNextInt()){
                    int a = readFromClient.nextInt();
                    int b = readFromClient.nextInt();
                    if(a != number || b != number){
                        sendToClient.println("Math protocol expects: <num> <num>");
                        readFromClient.hasNextInt();
                    }else{
                        sendToClient.println("echo: " + a + " + " + b + " = " + (a + b));
                        sendToClient.println("echo: " + a + " - " + b + " = " + (a - b));
                        sendToClient.println("echo: " + a + " * " + b + " = " + (a * b));
                        sendToClient.println("echo: " + a + " / " + b + " = " + (a / b));
                        sendToClient.println("echo: " + a + " % " + b + " = " + (a % b));
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
