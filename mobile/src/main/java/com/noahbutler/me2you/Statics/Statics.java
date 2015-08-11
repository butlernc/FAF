package com.noahbutler.me2you.Statics;

import android.os.Handler;

import com.noahbutler.me2you.ThreadUtils.Messenager;
import com.noahbutler.me2you.ThreadUtils.SingleExecutor;

import java.util.HashMap;

/**
 * Created by Noah Butler on 1/8/2015.
 */
public class Statics {

    public static SingleExecutor singleExecutor = new SingleExecutor();
    public static Handler handler;
    public static Messenager messenager = new Messenager();
    public static HashMap<String, String> aSyncConnectorParams;

}
