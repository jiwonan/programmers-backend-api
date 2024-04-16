package org.example;

import com.sun.net.httpserver.HttpServer;
import org.example.handler.DefaultHandler;
import org.example.handler.SumHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", 1234), 0);

        server.createContext("/", new DefaultHandler());
        server.createContext("/sum", new SumHandler());

        server.setExecutor(null);
        server.start();
    }
}