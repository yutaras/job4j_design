package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    while (in.ready()) {
                        String str = in.readLine();
                        if (str.contains("Exit")) {
                            out.write("Exit".getBytes());
                            server.close();
                        } else if (str.contains("Hello")) {
                            out.write("Hello".getBytes());
                            System.out.println(str);
                        } else {
                            out.write("What".getBytes());
                            System.out.println(str);
                        }
                    }
                    out.flush();
                }
            }
        }
    }
}
