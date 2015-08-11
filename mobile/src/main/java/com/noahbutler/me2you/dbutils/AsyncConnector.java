package com.noahbutler.me2you.dbutils;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Noah Butler on 1/11/2015.
 */
public class AsyncConnector extends AsyncTask<Object, Double, JSONArray>{

    private HttpClient httpClient;
    private HttpPost httpPost;
    private HttpResponse httpResponse;
    private HttpEntity httpEntity;

    private InputStream inputStream;
    private String results;
    private JSONArray jsonArray;

    private boolean isDone;

    @Override
    protected JSONArray doInBackground(Object[] params) {
        isDone(false);
        readFromServer();
        return jsonArray;
    }

    /**
     * Contacts the server and assigns the inputStream
     * Used in readFromServer()
     * @throws IOException
     */
    private void signalHttp() throws IOException {
        httpClient = new DefaultHttpClient();
        httpPost = new HttpPost(DBContract.HTTP_POST_ADDRESS);
        httpResponse = httpClient.execute(httpPost);
        httpEntity = httpResponse.getEntity();
        inputStream = httpEntity.getContent();
    }

    private void readFromServer() {
        try {
            //assign inputStream
            signalHttp();
            //read from the inputStream
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line = "";

            while((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }

            inputStream.close();
            results = sb.toString();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void onPostExecute(Double result) {
        /* parse the json */
        try {
            jsonArray = new JSONArray(results);
            isDone(true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void isDone(boolean isDone) {
        this.isDone = isDone;
    }

    public boolean isDone() {
        return isDone;
    }
}
