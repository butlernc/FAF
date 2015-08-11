package com.noahbutler.me2you.GPSUtils;

import com.noahbutler.me2you.Statics.Statics;

/**
 * Created by Noah Butler on 1/8/2015.
 */
public class GPS {

    public void findGPSCoord() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                /* TODO: write gps finder */

                Statics.messenager.sendMessage("GPS COORDS");
            }
        };

        Statics.singleExecutor.runTask(runnable);
    }

}
