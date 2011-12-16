package org.stuartgunter.demo.guava.concurrent;

import com.google.common.base.Function;
import com.google.common.util.concurrent.*;

import javax.annotation.Nullable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: gunters
 * Created: 05/12/2011 10:35
 */
public class ListenableFutureDemo {

    public static void main(String... args) throws Exception {
        final ExecutorService executorService = Executors.newFixedThreadPool(1);

        new ListenableFutureDemo(executorService).start();
    }
    

    private final ListeningExecutorService listeningExecutorService;

    public ListenableFutureDemo(ExecutorService executorService) {
        this.listeningExecutorService = MoreExecutors.listeningDecorator(executorService);
    }

    public void start() throws Exception {
        // calling addListener directly
        ListenableFuture<String> future1 = listeningExecutorService.submit(new SleepingCallable("Hello", 2000));
        future1.addListener(new Runnable() {
            public void run() {
                System.out.println("Listener: DONE");
            }
        }, listeningExecutorService);
        System.out.println("Future1: " + future1.get());


        // calling addCallback
        ListenableFuture<String> future2 = listeningExecutorService.submit(new SleepingCallable("Hello", 2000));
        Futures.addCallback(future2,
                new FutureCallback<String>() {
                    public void onSuccess(String result) {
                        System.out.println("FutureCallback: SUCCESS - " + result);
                    }

                    public void onFailure(Throwable t) {
                        System.out.println("FutureCallback: FAILURE - " + t.getMessage());
                    }
                });
        System.out.println("Future2: " + future2.get());


        // chaining ListenableFuture
        ListenableFuture<String> future3 = listeningExecutorService.submit(new SleepingCallable("Hello", 2000));
        ListenableFuture<String> future4 = Futures.chain(future3,
                new Function<String, ListenableFuture<? extends String>>() {
                    public ListenableFuture<? extends String> apply(@Nullable String input) {
                        return listeningExecutorService.submit(new SleepingCallable(input + " World", 2000));
                    }
                });
        System.out.println("Future4: " + future4.get());

        listeningExecutorService.shutdown();
    }
}
