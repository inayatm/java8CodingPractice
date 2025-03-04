package com.inayath.multithreading;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThroughputHttpServer {

    private final static  String INPUT_FILE = "com/inayath/resources/war_and_peace.txt";
    private final static int NUMEBR_THREADS = 1;

    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
        startServer(text);
    }

    private static void startServer(String text) throws IOException {
        HttpServer server =HttpServer.create(new InetSocketAddress(8000),0);
        server.createContext("/search",new WordCountHandler(text));
        Executor executor = Executors.newFixedThreadPool(NUMEBR_THREADS);
        server.setExecutor(executor);
        server.start();
        System.out.println("Server started at 8000");
    }


    private static class WordCountHandler implements HttpHandler {
        private String text;
        WordCountHandler(String text){
            this.text=text;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            System.out.println("Invoking handler method");
            String query = exchange.getRequestURI().getQuery();
            String[] keyvalue= query.split("=");
            System.out.println(Arrays.stream(keyvalue).toList());
            String action = keyvalue[0];
            String word = keyvalue[1];
            System.out.println("Invoking handler method : action "+ action);
            System.out.println("Invoking handler method : word "+ word);
            if(!action.equals("word")){
               exchange.sendResponseHeaders(400,0);
                return;
            }
            System.out.println("I am here now");
            long count = wordCount(word);
            byte[] response = Long.toString(count).getBytes();
            exchange.sendResponseHeaders(200,response.length);
            OutputStream outputStream =exchange.getResponseBody();
            System.out.println("writing output response..");
            outputStream.write(response);
            outputStream.close();
            exchange.close();
        }

        private  long wordCount(String word){
            System.out.println("word to search "+ word);
            int index=0;
            long count=0;
            while (index>=0){
                index = text.indexOf(word,index);
                System.out.println("inside the while loop: "+index);
                if(index>=0){
                    count++;
                    index++;
                    System.out.println("count "+count);
                }

            }
            System.out.println("outside the loop "+ index);
            return count;
        }
    }
}
