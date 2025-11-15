package io.javabrains.reactiveworkshop;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()
        LocalDateTime today = LocalDateTime.now();
        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        StreamSources.intNumbersStream().forEach(System.out::print);
        System.out.println();

        StreamSources.userStream().forEach(System.out::print);

        System.out.println(Duration.between(today, LocalDateTime.now()));

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        StreamSources.intNumbersStream().filter(num -> num < 5).forEach(System.out::print);
        System.out.println();
        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        StreamSources.intNumbersStream().limit(3).skip(1).forEach(System.out::print);
        System.out.println();

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        StreamSources.intNumbersStream().filter(num -> num > 5).findFirst().ifPresentOrElse(System.out::print, () -> System.out.println("-1"));
        System.out.println();
        // Print first names of all users in userStream
        // TODO: Write code here

        StreamSources.userStream().map(e -> e.getFirstName()).forEach(System.out::print);
        System.out.println();
        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here

        Predicate<User> test = (e) -> StreamSources.intNumbersStream().collect(Collectors.toSet()).contains(e.getId());
        StreamSources.userStream().filter(test).map(e -> e.getFirstName()).forEach(System.out::print);

    }

}
