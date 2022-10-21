package uk.sky.reactor.util;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class CustomSubscriber<T> implements Subscriber<T> {

    private String name = "my custom subscriber";

    public CustomSubscriber(String name) {
        this.name = name + " ";
    }

    public CustomSubscriber() {
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T item) {
        System.out.println(name + "received: " + item);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name + " : Error : " +  throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name + "Completed");
    }

    @Override
    public String toString() {
        return "CustomSubscriber{" +
                "name='" + name + '\'' +
                '}';
    }
}
