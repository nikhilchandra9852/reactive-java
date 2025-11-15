package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
//        ReactiveSources.intNumbersFlux().subscribe(
//                ele -> System.out.println(ele),
//                err -> System.out.println(err.getMessage()),
//                () -> System.out.println("Done")
//        );
//
//        ReactiveSources.intNumbersFluxWithException().subscribe(
//                ele -> System.out.println(ele),
//                err -> System.out.println(err.getMessage()),
//                () -> System.out.println("Done")
//        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());


        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {


    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribed");
        request(2);
    }

    public void hookOnNext(T value) {
        System.out.println("Subscribed " + value.toString());
        request(2);
    }
}