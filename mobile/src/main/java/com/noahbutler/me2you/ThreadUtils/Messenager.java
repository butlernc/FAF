package com.noahbutler.me2you.ThreadUtils;

import android.os.Bundle;
import android.os.Message;

import com.noahbutler.me2you.Statics.Statics;

/**
 * Created by Noah Butler on 1/8/2015.
 */
public class Messenager {

    public void sendMessage(String message) {
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        Message messageObject = new Message();
        messageObject.setData(bundle);
        Statics.handler.sendMessage(messageObject);
    }

}
