package com.noahbutler.me2you.ThreadUtils;

/**
 * Created by Noah Butler on 1/8/2015.
 */
public class SingleExecutor {

    public void runTask(Runnable runnable) {

        new Thread(runnable).start();
    }

}
