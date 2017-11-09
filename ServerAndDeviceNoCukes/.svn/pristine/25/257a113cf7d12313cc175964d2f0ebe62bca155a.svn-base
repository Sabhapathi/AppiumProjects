package com.xora.util;

/**
 * Created by IntelliJ IDEA.
 * User: ranjeet
 * Date: 5/8/13
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */

public class SleepTime {
    public static final Long minWaitTime= Long.valueOf(PropertyLoader.loadProperty("time.minwait"));
    public static final Long maxWaitTime= Long.valueOf(PropertyLoader.loadProperty("time.maxwait"));

    public static void sleepTimeInSecond(long time) {
        sleepTime(time*1000);
    }

    public static void sleepTime(long time) {
      try {
        Thread.sleep(time);
    } catch (InterruptedException e) {
        System.out.println(e.getStackTrace().toString());
    }
    }
}
