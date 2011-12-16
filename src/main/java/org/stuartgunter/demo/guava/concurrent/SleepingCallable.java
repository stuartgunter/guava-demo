package org.stuartgunter.demo.guava.concurrent;

import java.util.concurrent.Callable;

/**
 * User: gunters
 * Created: 05/12/2011 10:37
 */
public class SleepingCallable implements Callable<String> {

    private String response;
    private long sleep;

    public SleepingCallable(String response, long sleep) {
        this.response = response;
        this.sleep = sleep;
    }

    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ": SleepingCallable started");
        Thread.sleep(sleep);
        System.out.println(Thread.currentThread().getName() + ": SleepingCallable complete");
        return response;
    }
}
