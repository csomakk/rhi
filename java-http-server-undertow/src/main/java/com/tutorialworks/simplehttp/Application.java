package com.tutorialworks.simplehttp;

import io.undertow.Undertow;
import io.undertow.util.Headers;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class Application {

    public static void main(String[] args) {
        Undertow server = Undertow.builder()
                // Set up the listener - you can change the port/host here
                // 0.0.0.0 means "listen on ALL available addresses"
                .addHttpListener(8080, "0.0.0.0")

                .setHandler(exchange -> {
                    

                    // Sets the return Content-Type to text/html
                    exchange.getResponseHeaders()
                            .put(Headers.CONTENT_TYPE, "text/html");

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                    LocalDateTime now = LocalDateTime.now();  
                    System.out.println(dtf.format(now));  

                    if (exchange.getRelativePath().toString().equals("/data")) {
                        exchange.getResponseSender()
                            .send(
                                "{\"data\": \"" + dtf.format(now) + "\"}"
                            );
                    }

                    // Returns a hard-coded HTML document
                    exchange.getResponseSender()
                            .send("<html>" +
                                    "<body>" +
                                    "<h1>Hello, nice progress on the Bally Interview!</h1>" +
                                    "<p>time is " + dtf.format(now) + "</p>" +         
                                    "<p>path is " +  exchange.getRelativePath()  + "</p>" +                                                                 
                                    "</body>" +
                                    "</html>");
                }).build();

        // Boot the web server
        server.start();
        System.out.println("Server Started");  
    }
}
