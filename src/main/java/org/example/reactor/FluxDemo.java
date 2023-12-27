package org.example.reactor;

import reactor.core.publisher.Flux;

/**
 * @author walker.dou
 */
public class FluxDemo {
    public static void main(String[] args) {

        Flux.just("Ben", "Michael", "Mark")
                .doOnNext(s -> System.out.println("Hello " + s + "!"))
                .doOnComplete(() -> System.out.println("Completed"))
                .take(2)
                .subscribe();

//        Flux.just("Ben", "Michael", "Mark", "12").subscribe(new Subscriber<String>() {
//            public void onSubscribe(Subscription s) {
//                s.request(3);
//            }
//
//            public void onNext(String s) {
//                System.out.println("Hello " + s + "!");
//            }
//
//            public void onError(Throwable t) {
//
//            }
//
//            public void onComplete() {
//                System.out.println("Completed");
//            }
//        });
    }
}
