package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// Хостом подключения будет localhost - это зарезервированный адрес
// для подключения к текущему компьютеру
// (то есть это ваш компьютер - там, где запущена программа).
// Также можно использовать 127.0.0.1 - это ip адрес,
// соответствующий доменному имени localhost
public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8989;
        Scanner scanner = new Scanner(System.in);
        try (Socket client = new Socket(host, port);
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))
        ) {
            System.out.println("Client started");
            String input = in.readLine();
            System.out.println(input);
            if (!input.isEmpty()) {
                String answer = scanner.nextLine();
                out.println(answer);
            }
            input = in.readLine();
            System.out.println(input);
            if (!input.isEmpty()) {
                String answer = scanner.nextLine();
                out.println(answer);
            }
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
