package com.noahbutler.me2you.dbutils;

import org.json.JSONArray;

import java.util.concurrent.ExecutionException;

/**
 * Created by Noah Butler on 1/8/2015.
 */
public class Connector {

    private AsyncConnector asyncConnector;
    private JSONArray jsonArray;

    public JSONArray getDBJSONArray() {
        asyncConnector = new AsyncConnector();

        try {
            jsonArray = asyncConnector.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return jsonArray;
    }



}
