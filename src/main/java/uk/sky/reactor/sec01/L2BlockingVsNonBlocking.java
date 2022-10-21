package uk.sky.reactor.sec01;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import uk.sky.reactor.util.Util;

public class L2BlockingVsNonBlocking {
    public static void main(String[] args) {
//        Wanted to revisit this concept

//     Blocking code
//        getDownstreamResponseBlocking();


//      Non Blocking code
//        getDownstreamResponseNonBlocking().subscribeOn(Schedulers.boundedElastic()).subscribe(response -> {
//                printThreadName("The response is " + response);
//                Util.sleepSeconds(1);
//            });
//
//        System.out.println("next line");
//        /** This is to block the main thread long enough for the delegated thread to finish its execution.
//         If we don't add it, main thread completes execution of main method and shuts down programme before delegated thread can finish executing */
//        Util.sleepSeconds(5);
    }



    static Mono<String> getDownstreamResponseNonBlocking(){
        printThreadName("calling downstream");
        return Mono.fromSupplier(() -> {
            Util.sleepSeconds(4);
            printThreadName("response from downstream received");
            return "some data";
        });
    }

    static String getDownstreamResponseBlocking(){
        printThreadName("calling downstream");
        Util.sleepSeconds(4);
        printThreadName("response from downstream received");
        return "some data";
    }

    static void printThreadName(String msg){
        System.out.println(msg + " Thread : " + Thread.currentThread().getName());

    }

}
