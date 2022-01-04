package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws Exception {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String s = "What";
                    while (in.ready()) {
                        String str = in.readLine();
                        if (str.contains("Exit")) {
                            s = "Exit";
                            server.close();
                        } else if (str.contains("Hello")) {
                            s = "Hello";
                        }
                    }
                    if (server.isClosed()) {
                        out.write("HTTP/1.1 400 OK\r\n\r\n".getBytes());
                    } else {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write(s.getBytes());
                    }
                    out.flush();
                }
            }
        }
    }
}
