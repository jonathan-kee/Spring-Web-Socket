package com.socket.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// We call the publisher the
// SUBJECT and the subscribers the OBSERVERS.
// According to Head First design pattern, Publish-Subscribe pattern is related to Observer pattern
// The Publish-Subscribe pattern is
// a more complex pattern that allows subscribers to express interest
// in different types of messages and further separates publishers
// from subscribers. It is often used in middle ware systems.
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		// http://localhost:8080/sockjs-stomp.html
		SpringApplication.run(DemoApplication.class, args);
	}
}
