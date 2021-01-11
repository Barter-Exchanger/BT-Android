package com.esprit.barterexchange.Services;

import com.esprit.barterexchange.Entities.Publication;
import com.esprit.barterexchange.Statics.Statics;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PublicationService {

    public ArrayList<Publication> publication = new ArrayList<Publication>();

    public ArrayList<Publication> getPublications() {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(Statics._BASE_URL + "pub")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                Gson gson = new Gson();
                String data = response.body().string();
                Publication[] pubsArray = gson.fromJson(data, Publication[].class);
                Collections.addAll(publication, pubsArray);


            }
        });

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return publication;
    }

    public ArrayList<Publication> getUserPublications(int id){

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(Statics._BASE_URL + "userPubs/"+id)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                Gson gson = new Gson();
                String data = response.body().string();
                Publication[] pubsArray = gson.fromJson(data, Publication[].class);
                Collections.addAll(publication, pubsArray);


            }
        });

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return publication;
    }

}
