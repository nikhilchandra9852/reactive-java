package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()
        LocalDateTime today = LocalDateTime.now();
        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().subscribe(System.out::println);

        // Print all users in the ReactiveSources.userFlux stream
        // TODO: Write code here
        ReactiveSources.userFlux().subscribe(System.out::println);

        System.out.println(Duration.between(today, LocalDateTime.now()));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
